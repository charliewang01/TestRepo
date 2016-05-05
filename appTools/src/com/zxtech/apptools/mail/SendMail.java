package com.zxtech.apptools.mail;

import org.apache.commons.mail.HtmlEmail;

import com.zxtech.apptools.ConfigUtil;


public class SendMail {

	
	
	public void sendMail(String userName,String uid,String Subject,String url) throws Exception{
		
		HtmlEmail email = new HtmlEmail();
	  		email.setHostName(ConfigUtil.getValue("emHostName"));          // �ʼ�����������
	  		email.setAuthentication(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emPassword"));    // �˺ź�������֤        1234
	  		email.setCharset("UTF-8"); // ���ñ���
	  		email.setSubject(Subject);
	  			//������
  	  	 email.setFrom(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emFromName"));
	  			//������
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
  	  		  		+ "<body><div class='content'><h1>ѡ������  �ɾ�����</h1>"
  	  		  		+ "<div class='container'><h1><span>"
  	  		  		+ userName.toLowerCase()
  	  		  		+" </span>����ӭ��������</h1>"
  	  		  		+ "<p>Ϊȷ�����ܳ��������Ƶ����й��ܣ��뼤���˺š�</p>"
  	  		  		+ "<a href='"+url +"register/ValidationUID.jsp?u="+uid+"' target=_blank>"
  	  		  		+ "<input type='button' value='���������˺�'></a>"
  	  		  		+ "</div></div></body>");
	  	    	 email.send ( );
		
	}
	
	
	/**
	 * �����������뷢������
	 * @param userName
	 * @param Subject
	 * @param rendString
	 * @param url
	 * @throws Exception
	 */
	public void sendMailPwd(String userName,String Subject,String rendString,String url) throws Exception{
		
		HtmlEmail email = new HtmlEmail();
  		email.setHostName(ConfigUtil.getValue("emHostName"));          // �ʼ�����������
  		email.setAuthentication(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emPassword"));    // �˺ź�������֤        1234
  		email.setCharset("UTF-8"); // ���ñ���
  		email.setSubject(Subject);
  			//������
	  	 email.setFrom(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emFromName"));
	  			//������
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
	  	  		  		+ "<body><div class='content'><h1>ѡ������  �ɾ�����</h1>"
	  	  		  		+ "<div class='container'><h1>�𾴵�<span>"
	  	  		  		+ userName.toLowerCase()
	  	  		  		+" </span></h1>"
	  	  		  		+ "<p>�����յ���������Ʒ����������޸�����,�����·������޸�����,30��������Ч�� </p>"
	  	  		  		+ "<a href='"+url+"register/resetPersonalPwd.jsp?u="+userName.toLowerCase()+"&r="+rendString+"' target=_blank>"
	  	  		  		+ "<input type='button' value='���������˺�'></a>"
	  	  		  		+ "</div></div></body>");
	  	    	 email.send ( );
		
	}
	
	
	/**
	 * ��ҵ�������뷢���ʼ�
	 * @param userName
	 * @param Subject
	 * @param rendString
	 * @param url
	 * @throws Exception
	 */
	public void sendMailPwdEn(String userName,String Subject,String rendString,String url) throws Exception{
		
		HtmlEmail email = new HtmlEmail();
  		email.setHostName(ConfigUtil.getValue("emHostName"));          // �ʼ�����������
  		email.setAuthentication(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emPassword"));    // �˺ź�������֤        1234
  		email.setCharset("UTF-8"); // ���ñ���
  		email.setSubject(Subject);
  			//������
	  	 email.setFrom(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emFromName"));
	  			//������
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
	  	  		  		+ "<body><div class='content'><h1>ѡ������  �ɾ�����</h1>"
	  	  		  		+ "<div class='container'><h1>�𾴵�<span>"+userName.toLowerCase()+""
	  	  		  		+" </span></h1>"
	  	  		  		+ "<p>�����յ���������Ʒ����������޸���,�·������� 30��������Ч�� </p>"
	  	  		  		+ "<a href='"+url+"register/resetCompanyPwd.jsp?u="+userName.toLowerCase()+"&r="+rendString+"' target=_blank>"
	  	  		  		+ "<input type='button' value='���������˺�'></a>"
	  	  		  		+ "</div></div></body>");
	  	    	 email.send ( );
		
	}
	
	
	/* *//**
	  * ��ʾ��ʦ��ֱ���γ�
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
  		email.setHostName(ConfigUtil.getValue("emHostName"));          // �ʼ�����������
  		email.setAuthentication(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emPassword"));    // �˺ź�������֤        1234
  		email.setCharset("UTF-8"); // ���ñ���
  		email.setSubject(Subject);
  			//������
	  	 email.setFrom(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emFromName"));
	  			//������
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
  	  		  		+ "<body><div class='content'><h1>ѡ������  �ɾ�����</h1>"
  	  		  		+ "<div class='container'><h1><span>�𾴵�"
  	  		  		+ username.toLowerCase()
  	  		  		+"��ʦ</span></h1>"
  	  		  		+ "<p>����ֱ����"+couName+"���γ�"+periodName+"����"+liveAddress+","+liveStartTime+"��������ǵ�׼ʱ�ϿΡ�"
  	  		  		+ "��֯�߿���Ϊ"+guestPass+",�α�����Ϊ"+guestPass+"</p>"
  	  		  		+ "	<a href="+organizerJoinUrl+" target=_blank><input type='button' value='��֯��ֱ�����'></a>"
  	  		  		+ " <a href="+panelistJoinUrl+" target=_blank><input type='button' value='�α����'></a>"
  	  		  		+ "</div></div></body>");
	  	    	 email.send ( );
		
	}*/
	
	
	public void sendLiveMail(String emails,String username,String Subject,String couName,
			 String liveStartTime,String liveAddress,String periodName,String organizerJoinUrl,String panelistJoinUrl,
			 String guestPass,String managerPass) throws Exception{
		
		HtmlEmail email = new HtmlEmail();
 		email.setHostName(ConfigUtil.getValue("emHostName"));          // �ʼ�����������
 		email.setAuthentication(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emPassword"));    // �˺ź�������֤        1234
 		email.setCharset("UTF-8"); // ���ñ���
 		email.setSubject(Subject);
 			//������
	  	 email.setFrom(ConfigUtil.getValue("emNameUser"), ConfigUtil.getValue("emFromName"));
	  			//������
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
 	  		  		+ "<body><div class='content'><h1>ѡ������  �ɾ�����</h1>"
 	  		  		+ "<div class='container'><h1><span>�𾴵�"
 	  		  		+  username.toLowerCase()
 	  		  		+"��ʦ</span></h1>"
 	  		  		+ "<p>����ֱ����"+couName+"���γ�"+periodName+"����"+liveAddress+","+liveStartTime+"��������ǵ�׼ʱ�ϿΡ�"
 	  		  		+ "	<p>ֱ��Դ��ַ��Ϣ"+organizerJoinUrl+"</p>"
 	  		  		+ "	<p>������������ϵͳ���ظ�ֱ������:<a href='http://image.zxeyun.com/upload/exe/OBS_0_657b.zip'>windows</a></p>"
 	  		  		+ "</div></div></body>");
	  	    	 email.send ( );
		
	}

	
	
}
