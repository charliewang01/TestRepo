package com.zxtech.apptools.mail;

import org.apache.commons.mail.HtmlEmail;

import com.zxtech.apptools.ConfigUtil;


public class SendMail {

	
	
	public void sendMail(String userName,String uid,String Subject,String url) throws Exception{
		
		HtmlEmail email = new HtmlEmail();
	  		email.setHostName(ConfigUtil.getValue("emHostName"));          // 邮件服务器名称
	  		email.setAuthentication(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emPassword"));    // 账号和密码验证        1234
	  		email.setCharset("UTF-8"); // 设置编码
	  		email.setSubject(Subject);
	  			//发送人
  	  	 email.setFrom(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emFromName"));
	  			//接受人
			 email.addTo (userName,userName);
	  	  	 email.setHtmlMsg("<style type='text/css'>"
  	  		  		+ "h1{font-weight:400;margin: 0;}"
  	  		  		+ ".content{margin:50px auto;width: 550px;text-align: center;}"
  	  		  		+ ".content h1{height: 55px;width: 550px;background: #c70900;color: #fff;line-height:55px;font-size: 26px;}"
  	  		  		+ ".container{width: 528px;overflow: hidden;border: 1px solid #efefef;padding:20px 0 20px 20px;}"
  	  		  		+ ".container h1{font-size: 22px;text-align: left;background: none;color: #333;line-height: 40px;height: 40px;}"
  	  		  		+ ".container p{line-height: 40px;text-align: left;width: 98%;color: #333;font-size: 20px;word-break: break-all;}"
  	  		  		+ ".container input[type='button']{border-radius: 5px;width: 200px;height: 50px;background:#c70900;color: #fff;"
  	  		  		+ "border: 1px solid #c70900;margin-top:25px;cursor: pointer;font-size: 16px;margin-bottom: 20px; }"
  	  		  		+ "</style>"
  	  		  		+ "<body><div class='content'><h1>选择中星  成就梦想</h1>"
  	  		  		+ "<div class='container'><h1><span>"
  	  		  		+ userName.toLowerCase()
  	  		  		+" </span>，欢迎加入中星</h1>"
  	  		  		+ "<p>为确保您能畅享中星云的所有功能，请激活账号。</p>"
  	  		  		+ "<a href='"+url +"register/ValidationUID.jsp?u="+uid+"' target=_blank>"
  	  		  		+ "<input type='button' value='立即激活账号'></a>"
  	  		  		+ "</div></div></body>");
	  	    	 email.send ( );
		
	}
	
	
	/**
	 * 个人忘记密码发送邮箱
	 * @param userName
	 * @param Subject
	 * @param rendString
	 * @param url
	 * @throws Exception
	 */
	public void sendMailPwd(String userName,String Subject,String rendString,String url) throws Exception{
		
		HtmlEmail email = new HtmlEmail();
  		email.setHostName(ConfigUtil.getValue("emHostName"));          // 邮件服务器名称
  		email.setAuthentication(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emPassword"));    // 账号和密码验证        1234
  		email.setCharset("UTF-8"); // 设置编码
  		email.setSubject(Subject);
  			//发送人
	  	 email.setFrom(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emFromName"));
	  			//接受人
			 email.addTo ( userName, userName );
			 email.setHtmlMsg("<style type='text/css'>"
	  	  		  		+ "h1{font-weight:400;margin: 0;}"
	  	  		  		+ ".content{margin:50px auto;width: 550px;text-align: center;}"
	  	  		  		+ ".content h1{height: 55px;width: 550px;background: #c70900;color: #fff;line-height:55px;font-size: 26px;}"
	  	  		  		+ ".container{width: 528px;overflow: hidden;border: 1px solid #efefef;padding:20px 0 20px 20px;}"
	  	  		  		+ ".container h1{font-size: 22px;text-align: left;background: none;color: #333;line-height: 40px;height: 40px;}"
	  	  		  		+ ".container p{line-height: 40px;text-align: left;width: 98%;color: #333;font-size: 20px;word-break: break-all;}"
	  	  		  		+ ".container input[type='button']{border-radius: 5px;width: 200px;height: 50px;background:#c70900;color: #fff;"
	  	  		  		+ "border: 1px solid #c70900;margin-top:25px;cursor: pointer;font-size: 16px;margin-bottom: 20px; }"
	  	  		  		+ "</style>"
	  	  		  		+ "<body><div class='content'><h1>选择中星  成就梦想</h1>"
	  	  		  		+ "<div class='container'><h1>尊敬的<span>"
	  	  		  		+ userName.toLowerCase()
	  	  		  		+" </span></h1>"
	  	  		  		+ "<p>我们收到你的中星云发来的密码修改申请,请点击下方链接修改密码,30分钟内有效。 </p>"
	  	  		  		+ "<a href='"+url+"register/resetPersonalPwd.jsp?u="+userName.toLowerCase()+"&r="+rendString+"' target=_blank>"
	  	  		  		+ "<input type='button' value='立即激活账号'></a>"
	  	  		  		+ "</div></div></body>");
	  	    	 email.send ( );
		
	}
	
	
	/**
	 * 企业忘记密码发送邮件
	 * @param userName
	 * @param Subject
	 * @param rendString
	 * @param url
	 * @throws Exception
	 */
	public void sendMailPwdEn(String userName,String Subject,String rendString,String url) throws Exception{
		
		HtmlEmail email = new HtmlEmail();
  		email.setHostName(ConfigUtil.getValue("emHostName"));          // 邮件服务器名称
  		email.setAuthentication(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emPassword"));    // 账号和密码验证        1234
  		email.setCharset("UTF-8"); // 设置编码
  		email.setSubject(Subject);
  			//发送人
	  	 email.setFrom(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emFromName"));
	  			//接受人
			 email.addTo ( userName, userName );
			 email.setHtmlMsg("<style type='text/css'>"
	  	  		  		+ "h1{font-weight:400;margin: 0;}"
	  	  		  		+ ".content{margin:50px auto;width: 550px;text-align: center;}"
	  	  		  		+ ".content h1{height: 55px;width: 550px;background: #c70900;color: #fff;line-height:55px;font-size: 26px;}"
	  	  		  		+ ".container{width: 528px;overflow: hidden;border: 1px solid #efefef;padding:20px 0 20px 20px;}"
	  	  		  		+ ".container h1{font-size: 22px;text-align: left;background: none;color: #333;line-height: 40px;height: 40px;}"
	  	  		  		+ ".container p{line-height: 40px;text-align: left;width: 98%;color: #333;font-size: 20px;word-break: break-all;}"
	  	  		  		+ ".container input[type='button']{border-radius: 5px;width: 200px;height: 50px;background:#c70900;color: #fff;"
	  	  		  		+ "border: 1px solid #c70900;margin-top:25px;cursor: pointer;font-size: 16px;margin-bottom: 20px; }"
	  	  		  		+ "</style>"
	  	  		  		+ "<body><div class='content'><h1>选择中星  成就梦想</h1>"
	  	  		  		+ "<div class='container'><h1>尊敬的<span>"+userName.toLowerCase()+""
	  	  		  		+" </span></h1>"
	  	  		  		+ "<p>我们收到你的中星云发来的密码修改申,下方链接在 30分钟内有效。 </p>"
	  	  		  		+ "<a href='"+url+"register/resetCompanyPwd.jsp?u="+userName.toLowerCase()+"&r="+rendString+"' target=_blank>"
	  	  		  		+ "<input type='button' value='立即激活账号'></a>"
	  	  		  		+ "</div></div></body>");
	  	    	 email.send ( );
		
	}
	
	
	/* *//**
	  * 提示老师上直播课程
	  * @param userName
	  * @param path
	  * @param uid
	  * @param Subject
	  * @throws Exception
	  *//*
	 public void sendLiveMail(String emails,String username,String Subject,String couName,
			 String liveStartTime,String liveAddress,String periodName,String organizerJoinUrl,String panelistJoinUrl,
			 String guestPass,String managerPass) throws Exception{
		
		HtmlEmail email = new HtmlEmail();
  		email.setHostName(ConfigUtil.getValue("emHostName"));          // 邮件服务器名称
  		email.setAuthentication(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emPassword"));    // 账号和密码验证        1234
  		email.setCharset("UTF-8"); // 设置编码
  		email.setSubject(Subject);
  			//发送人
	  	 email.setFrom(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emFromName"));
	  			//接受人
			 email.addTo ( emails, emails );
	  	  	 email.setHtmlMsg("<style type='text/css'>"
  	  		  		+ "h1{font-weight:400;margin: 0;}"
  	  		  		+ ".content{margin:50px auto;width: 550px;text-align: center;}"
  	  		  		+ ".content h1{height: 55px;width: 550px;background: #c70900;color: #fff;line-height:55px;font-size: 26px;}"
  	  		  		+ ".container{width: 528px;overflow: hidden;border: 1px solid #efefef;padding:20px 0 20px 20px;}"
  	  		  		+ ".container h1{font-size: 22px;text-align: left;background: none;color: #333;line-height: 40px;height: 40px;}"
  	  		  		+ ".container p{line-height: 40px;text-align: left;width: 98%;color: #333;font-size: 20px;word-break: break-all;}"
  	  		  		+ ".container input[type='button']{border-radius: 5px;width: 150px;height: 45px;background:#c70900;color: #fff;"
  	  		  		+ "border: 1px solid #c70900;margin-top:25px;cursor: pointer;font-size: 16px;margin-bottom: 20px; }"
  	  		  		+ " a{text-decoration: none;margin:0 20px;}"
  	  		  		+ "</style>"
  	  		  		+ "<body><div class='content'><h1>选择中星  成就梦想</h1>"
  	  		  		+ "<div class='container'><h1><span>尊敬的"
  	  		  		+ username.toLowerCase()
  	  		  		+"老师</span></h1>"
  	  		  		+ "<p>您的直播《"+couName+"》课程"+periodName+"将于"+liveAddress+","+liveStartTime+"开播，请记得准时上课。"
  	  		  		+ "组织者口令为"+guestPass+",嘉宾口令为"+guestPass+"</p>"
  	  		  		+ "	<a href="+organizerJoinUrl+" target=_blank><input type='button' value='组织者直播入口'></a>"
  	  		  		+ " <a href="+panelistJoinUrl+" target=_blank><input type='button' value='嘉宾入口'></a>"
  	  		  		+ "</div></div></body>");
	  	    	 email.send ( );
		
	}*/
	
	
	public void sendLiveMail(String emails,String username,String Subject,String couName,
			 String liveStartTime,String liveAddress,String periodName,String organizerJoinUrl,String panelistJoinUrl,
			 String guestPass,String managerPass) throws Exception{
		
		HtmlEmail email = new HtmlEmail();
 		email.setHostName(ConfigUtil.getValue("emHostName"));          // 邮件服务器名称
 		email.setAuthentication(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emPassword"));    // 账号和密码验证        1234
 		email.setCharset("UTF-8"); // 设置编码
 		email.setSubject(Subject);
 			//发送人
	  	 email.setFrom(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emFromName"));
	  			//接受人
			 email.addTo ( emails, emails );
	  	  	 email.setHtmlMsg("<style type='text/css'>"
 	  		  		+ "h1{font-weight:400;margin: 0;}"
 	  		  		+ ".content{margin:50px auto;width: 550px;text-align: center;}"
 	  		  		+ ".content h1{height: 55px;width: 550px;background: #c70900;color: #fff;line-height:55px;font-size: 26px;}"
 	  		  		+ ".container{width: 528px;overflow: hidden;border: 1px solid #efefef;padding:20px 0 20px 20px;}"
 	  		  		+ ".container h1{font-size: 22px;text-align: left;background: none;color: #333;line-height: 40px;height: 40px;}"
 	  		  		+ ".container p{line-height: 40px;text-align: left;width: 98%;color: #333;font-size: 20px;word-break: break-all;}"
 	  		  		+ ".container input[type='button']{border-radius: 5px;width: 150px;height: 45px;background:#c70900;color: #fff;"
 	  		  		+ "border: 1px solid #c70900;margin-top:25px;cursor: pointer;font-size: 16px;margin-bottom: 20px; }"
 	  		  		+ " a{text-decoration: none;margin:0 20px;}"
 	  		  		+ "</style>"
 	  		  		+ "<body><div class='content'><h1>选择中星  成就梦想</h1>"
 	  		  		+ "<div class='container'><h1><span>尊敬的"
 	  		  		+  username.toLowerCase()
 	  		  		+"老师</span></h1>"
 	  		  		+ "<p>您的直播《"+couName+"》课程"+periodName+"将于"+liveAddress+","+liveStartTime+"开播，请记得准时上课。"
 	  		  		+ "	<p>直播源地址信息"+organizerJoinUrl+"</p>"
 	  		  		+ "	<p>请点击根据您的系统下载该直播工具:<a href='http://image.zxeyun.com/upload/exe/OBS_0_657b.zip'>windows</a></p>"
 	  		  		+ "</div></div></body>");
	  	    	 email.send ( );
		
	}

	
	
}
