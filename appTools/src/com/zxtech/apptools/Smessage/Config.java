package com.zxtech.apptools.Smessage;

import com.zxtech.apptools.ConfigUtil;


/**
 * 系统常量
 */
public class Config
{
	/**
	 * url前半部分
	 */
	public static final String BASE_URL =ConfigUtil.getValue("SMbase_url") ;

	/**
	 * �?��者注册后系统自动生成的账号，可在官网登录后查�?
	 */
	public static final String ACCOUNT_SID =ConfigUtil.getValue("SMaccount_sid") ;

	/**
	 * �?��者注册后系统自动生成的TOKEN，可在官网登录后查看
	 */
	public static final String AUTH_TOKEN = ConfigUtil.getValue("SMauth_toke") ;

	/**
	 * 应用id
	 */
	public static final String APP_ID = ConfigUtil.getValue("SMapp_id") ;
	
	/**
	 * client账号
	 */
	public static final String CLIENT_NUMBER =ConfigUtil.getValue("SMclient_number") ;
	
	/**
	 * client账号的密�?
	 */
	public static final String CLIENT_PWD =ConfigUtil.getValue("SMclient_pwd") ;
	
	/**
	 * 响应数据类型, JSON或XML
	 */
	public static final String RESP_DATA_TYPE =ConfigUtil.getValue("SMresp_data_type") ;
}