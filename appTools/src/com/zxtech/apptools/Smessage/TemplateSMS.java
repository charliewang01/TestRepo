package com.zxtech.apptools.Smessage;

import com.zxtech.apptools.ConfigUtil;




/**
 * 邮件短信接口调用示例
 */
public class TemplateSMS
{
	// url中20150822之后的部分
	private static String operation = "/SMS/templateSMS";

	// 参数详述请参考http://www.qingmayun.com/document.html
	private static String accountSid = Config.ACCOUNT_SID;
	private static String appId = Config.APP_ID;
	private static String templateId = ConfigUtil.getValue("SMtemplateId1");
	private static String tertemplateId = ConfigUtil.getValue("SMtemplateId2");
	private static String HRtemplateId =ConfigUtil.getValue("SMtemplateId3");
	private static String UsertemplateId =ConfigUtil.getValue("SMtemplateId4");
	//private static String to = "13556463631";
	//private static String param = "中星云,112311,30";

	/**
	 * 邮件短信
	 */
	public static void templateSMS(String to,String param)
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&appId=" + appId + "&templateId=" + templateId + "&to="
				+ to + "&param=" + param + HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
	
	}
	
	
	/**
	 * 创建人力资源信息联系人验证
	 */
	public static void CreateHr(String to,String param){
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&appId=" + appId + "&templateId=" + HRtemplateId + "&to="
				+ to + "&param=" + param + HttpUtil.createCommonParam();
		// 提交请求
		String result = HttpUtil.post(url, body);
//		System.out.println(result);
	}
	
	/**
	 * 邮件短信通知上课
	 */
	public static void templateSMSs(String to,String param)
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&appId=" + appId + "&templateId=" + tertemplateId + "&to="
				+ to + "&param=" + param + HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
//		System.out.println("result:" + System.lineSeparator() + result);
	}
	
	
	
	
	/**
	 * 创建用户邮件短信
	 */
	public static void UserInfo(String to,String param)
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&appId=" + appId + "&templateId=" + UsertemplateId + "&to="
				+ to + "&param=" + param + HttpUtil.createCommonParam();
		// 提交请求
		String result = HttpUtil.post(url, body);
	}
	
}
