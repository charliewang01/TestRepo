package com.zxtech.apptools.Smessage;

import com.zxtech.apptools.ConfigUtil;




/**
 * �ʼ����Žӿڵ���ʾ��
 */
public class TemplateSMS
{
	// url��20150822֮��Ĳ���
	private static String operation = "/SMS/templateSMS";

	// ����������ο�http://www.qingmayun.com/document.html
	private static String accountSid = Config.ACCOUNT_SID;
	private static String appId = Config.APP_ID;
	private static String templateId = ConfigUtil.getValue("SMtemplateId1");
	private static String tertemplateId = ConfigUtil.getValue("SMtemplateId2");
	private static String HRtemplateId =ConfigUtil.getValue("SMtemplateId3");
	private static String UsertemplateId =ConfigUtil.getValue("SMtemplateId4");
	//private static String to = "13556463631";
	//private static String param = "������,112311,30";

	/**
	 * �ʼ�����
	 */
	public static void templateSMS(String to,String param)
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&appId=" + appId + "&templateId=" + templateId + "&to="
				+ to + "&param=" + param + HttpUtil.createCommonParam();

		// �ύ����
		String result = HttpUtil.post(url, body);
	
	}
	
	
	/**
	 * ����������Դ��Ϣ��ϵ����֤
	 */
	public static void CreateHr(String to,String param){
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&appId=" + appId + "&templateId=" + HRtemplateId + "&to="
				+ to + "&param=" + param + HttpUtil.createCommonParam();
		// �ύ����
		String result = HttpUtil.post(url, body);
//		System.out.println(result);
	}
	
	/**
	 * �ʼ�����֪ͨ�Ͽ�
	 */
	public static void templateSMSs(String to,String param)
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&appId=" + appId + "&templateId=" + tertemplateId + "&to="
				+ to + "&param=" + param + HttpUtil.createCommonParam();

		// �ύ����
		String result = HttpUtil.post(url, body);
//		System.out.println("result:" + System.lineSeparator() + result);
	}
	
	
	
	
	/**
	 * �����û��ʼ�����
	 */
	public static void UserInfo(String to,String param)
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&appId=" + appId + "&templateId=" + UsertemplateId + "&to="
				+ to + "&param=" + param + HttpUtil.createCommonParam();
		// �ύ����
		String result = HttpUtil.post(url, body);
	}
	
}
