package com.alipay.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.alipay.config.AlipayConfig;
import com.alipay.util.httpClient.HttpProtocolHandler;
import com.alipay.util.httpClient.HttpRequest;
import com.alipay.util.httpClient.HttpResponse;
import com.alipay.util.httpClient.HttpResultType;
import com.sun.beans.decoder.DocumentHandler;
import com.alipay.sign.MD5;

/* *
 *类名：AlipaySubmit
 *功能：支付宝各接口请求提交类
 *详细：构造支付宝各接口表单HTML文本，获取远程HTTP数据
 *版本：3.3
 *日期：2012-08-13
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipaySubmit {
    
    /**
     * 支付宝提供给商户的服务接入网关URL(新)
     */
    private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
    /**
     * 生成签名结果
     * @param sPara 要签名的数组
     * @return 签名结果字符串
     */
	public static String buildRequestMysign(Map<String, String> sPara) {
    	String prestr = AlipayCore.createLinkString(sPara); //把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
        String mysign = "";
        if(AlipayConfig.sign_type.equals("MD5") ) {
        	mysign = MD5.sign(prestr, AlipayConfig.key, AlipayConfig.input_charset);
        }
        return mysign;
    }
	
    /**
     * 生成要请求给支付宝的参数数组
     * @param sParaTemp 请求前的参数数组
     * @return 要请求的参数数组
     */
    private static Map<String, String> buildRequestPara(Map<String, String> sParaTemp) {
        //除去数组中的空值和签名参数
        Map<String, String> sPara = AlipayCore.paraFilter(sParaTemp);
        //生成签名结果
        String mysign = buildRequestMysign(sPara);

        //签名结果与签名方式加入请求提交参数组中
        sPara.put("sign", mysign);
        sPara.put("sign_type", AlipayConfig.sign_type);
        return sPara;
    }

    /**
     * 建立请求，以表单HTML形式构造（默认）
     * @param sParaTemp 请求参数数组
     * @param strMethod 提交方式。两个值可选：post、get
     * @param strButtonName 确认按钮显示文字
     * @return 提交表单HTML文本
     */
    public static String buildRequest(Map<String, String> sParaTemp, String strMethod, String strButtonName) {
        //待请求参数数组
        Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + ALIPAY_GATEWAY_NEW
                      + "_input_charset=" + AlipayConfig.input_charset + "\" method=\"" + strMethod
                      + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        //submit按钮控件请不要含有name属性
        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

        return sbHtml.toString();
    }
    
    /**
     * 建立请求，以表单HTML形式构造，带文件上传功能
     * @param sParaTemp 请求参数数组
     * @param strMethod 提交方式。两个值可选：post、get
     * @param strButtonName 确认按钮显示文字
     * @param strParaFileName 文件上传的参数名
     * @return 提交表单HTML文本
     */
    public static String buildRequest(Map<String, String> sParaTemp, String strMethod, String strButtonName, String strParaFileName) {
        //待请求参数数组
        Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\"  enctype=\"multipart/form-data\" action=\"" + ALIPAY_GATEWAY_NEW
                      + "_input_charset=" + AlipayConfig.input_charset + "\" method=\"" + strMethod
                      + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }
        
        sbHtml.append("<input type=\"file\" name=\"" + strParaFileName + "\" />");

        //submit按钮控件请不要含有name属性
        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");

        return sbHtml.toString();
    }
    
    /**
     * 建立请求，以模拟远程HTTP的POST请求方式构造并获取支付宝的处理结果
     * 如果接口中没有上传文件参数，那么strParaFileName与strFilePath设置为空值
     * 如：buildRequest("", "",sParaTemp)
     * @param strParaFileName 文件类型的参数名
     * @param strFilePath 文件路径
     * @param sParaTemp 请求参数数组
     * @return 支付宝处理结果
     * @throws Exception
     */
    public static String buildRequest(String strParaFileName, String strFilePath,Map<String, String> sParaTemp) throws Exception {
    	System.out.println("传进来的参数是：" + sParaTemp.get("partner")+"|"+sParaTemp.get("_input_charset")+"|"+sParaTemp.get("batch_no")+"|"+sParaTemp.get("refund_date")+"|"+sParaTemp.get("batch_num")+"|"+sParaTemp.get("detail_data")+"|"+sParaTemp.get("service")+"|"+sParaTemp.get("notify_url"));
        
    	//待请求参数数组
        Map<String, String> sPara = buildRequestPara(sParaTemp);

        HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();

        HttpRequest request = new HttpRequest(HttpResultType.BYTES);
        //设置编码集
        request.setCharset(AlipayConfig.input_charset);

        request.setParameters(generatNameValuePair(sPara));
        request.setUrl(ALIPAY_GATEWAY_NEW+"_input_charset="+AlipayConfig.input_charset);
        //request.setUrl(ALIPAY_GATEWAY_NEW);

        HttpResponse response = httpProtocolHandler.execute(request,strParaFileName,strFilePath);
        if (response == null) {
            return null;
        }
        
        String strResult = response.getStringResult();
        return strResult;
    }

    /**
     * MAP类型数组转换成NameValuePair类型
     * @param properties  MAP类型数组
     * @return NameValuePair类型数组
     */
    private static NameValuePair[] generatNameValuePair(Map<String, String> properties) {
        NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            nameValuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());
        }

        return nameValuePair;
    }
    
    /**
     * 用于防钓鱼，调用接口query_timestamp来获取时间戳的处理函数
     * 注意：远程解析XML出错，与服务器是否支持SSL等配置有关
     * @return 时间戳字符串
     * @throws IOException
     * @throws DocumentException
     * @throws MalformedURLException
     */
	public static String query_timestamp() throws MalformedURLException,
                                                        DocumentException, IOException {

        //构造访问query_timestamp接口的URL串
        String strUrl = ALIPAY_GATEWAY_NEW + "service=query_timestamp&partner=" + AlipayConfig.partner + "&_input_charset" +AlipayConfig.input_charset;
        StringBuffer result = new StringBuffer();

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new URL(strUrl).openStream());

        List<Node> nodeList = doc.selectNodes("//alipay/*");

        for (Node node : nodeList) {
            // 截取部分不需要解析的信息
            if (node.getName().equals("is_success") && node.getText().equals("T")) {
                // 判断是否有成功标示
                List<Node> nodeList1 = doc.selectNodes("//response/timestamp/*");
                for (Node node1 : nodeList1) {
                    result.append(node1.getText());
                }
            }
        }

        return result.toString();
    }
	
	//支付宝即时到账批量退款无密接口
	public String reFundFastPay(String dbFare, String trade_no, String syOrderId){
		String result = null;
		AlipaySubmit alis = new AlipaySubmit();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");
		Date date=new Date(); 
		String dfcontent = df1.format(date) + syOrderId;   //退款批次号      格式为：退款日期（ 8 位）+流水号（ 3～24 位）
		StringBuffer detailData = new StringBuffer();        //单笔数据集
	    detailData.append(trade_no);   //交易号
	    detailData.append("^");
	    detailData.append(dbFare);                           //退款金额
	    detailData.append("^");
	    detailData.append("出票失败");                        //退款原因
	    

		Map<String,String> sParaTemp = new HashMap<String,String>();
		sParaTemp.put("service", "refund_fastpay_by_platform_nopwd");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);     
		sParaTemp.put("notify_url", AlipayConfig.notify_url);            //服务器异步通知页面路径
		sParaTemp.put("batch_no", dfcontent);                            //退款批次号      格式为：退款日期（ 8 位）+流水号（ 3～24 位）
		sParaTemp.put("refund_date", df.format(new Date()));             //退款请求时间
		sParaTemp.put("batch_num", "1");                                 //退款笔数
		sParaTemp.put("detail_data", detailData.toString());             //退款数据 (易流水号^退款金额^退款备注)多个用#号隔开
		try {
			 result = alis.buildRequest("", "", sParaTemp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		Document doc = null;
		try {
			doc =  DocumentHelper.parseText(result);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = doc.getRootElement();
		Element is_success = root.element("is_success");
		String success_content = is_success.getText();
		*/
		return result;
	}
	
	
	
	public static void main(String[] args) {
		AlipaySubmit alis = new AlipaySubmit();
		String result = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");
		Date date=new Date(); 
		String dfcontent = df1.format(date) + "2016011221001004280055331466";   //退款批次号      格式为：退款日期（ 8 位）+流水号（ 3～24 位）
		StringBuffer detailData = new StringBuffer();        //单笔数据集
	    detailData.append("2016011221001004280055331466");   //交易号
	    detailData.append("^");
	    detailData.append("0.01");                           //退款金额
	    detailData.append("^");
	    detailData.append("出票失败");                        //退款原因
	    

		Map<String,String> sParaTemp = new HashMap<String,String>();
		sParaTemp.put("service", "refund_fastpay_by_platform_nopwd");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("notify_url", "http://127.0.0.1:8080/refund_fastpay_by_platform_nopwd-JAVA-UTF-8/notify_url.jsp");
		sParaTemp.put("batch_no", "201601134645415315345112");   //退款批次号      格式为：退款日期（ 8 位）+流水号（ 3～24 位）
		sParaTemp.put("refund_date", df.format(new Date()));
		sParaTemp.put("batch_num", "1");                      //退款笔数
		sParaTemp.put("detail_data", detailData.toString()); //退款数据 (易流水号^退款金额^退款备注)多个用#号隔开
		try {
			 result = alis.buildRequest("", "", sParaTemp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("结果是：" + result);
	}
	
	
}
