package com.alipay.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088121517793871";
	// 商户的私钥
	//public static String key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANL4D6250ylKzDoxtLaQill/Ibir0YcUXa5x6ThnS2U2c4kvUiQCvL6aJVoSKIPxXgkOlQwvzbs48rPrUBgds7J2EdPlwMwtKHUi0/pZVCCcbRxX1V9T6FXlvLP5cYrgaBLOGZ0SPqHerK0HxFaslwY5h8tJ3E3oxmGVOUSgmwfvAgMBAAECgYBOPwj5oylJcF+M2fCvoa5egUONjdR5qDkSwVcBv3X8RRTW9cEecBF3FA70eDWksjnxXAI18ej5HqcNyiH7v9BsnE6+HvX/y+DBlkB5eEqqZpE7iHy2DHD7BpvaCZQGWN8La9+iqnV5gh3bluoEa7CAYWNvVQ8fXQPUYmdU2RqrMQJBAP0mqsW/7UAgqr/zNzQBjSom+BqVB8rZcrvhlaxVFobArs5Dar3Ou23DrYufrsRURP+cX6LqEFfspcHdUdL1KocCQQDVV93rZSMx/N/kc6ziO45uQ+L8fOJrJam8tEJbqmejpa5t8pXFfv4nG+Q1qDJEvhqs209At+j+K4qo+JkTu4lZAkEA2H1u4bpmvMay/4CRnwoMnRXCa4kzpsgbFI2woDYME6VIWODSsgvPwejry1H99axTbX1fVEVzQJ4Ciy4oQY6klQJBAMO0ue/RNEsL1PsFnideSNcf0V6a1T1DLITduy3JkQ8O0ocrjHbCezS3Ik6Sf6KN3XyKJhaRXtuiZ61/dzUhyOkCQBXCIOhdUN9G33d0rQHAlCIMKZDQVM1FCT1Sfacji34B3tZGfWzAsuba6sn2h7mhn1Xo/hAKQnYmgfeO8c4nXSE=";
    public static String key = "b01mncj9kfj6jxf3b8srm4wa45uuzj2y";
	
	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\alibaba";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "MD5";
	
	//服务器异步通知页面路径
	public static String notify_url = "http://127.0.0.1:8080/refund_fastpay_by_platform_nopwd-JAVA-UTF-8/notify_url.jsp";
    
	
}
