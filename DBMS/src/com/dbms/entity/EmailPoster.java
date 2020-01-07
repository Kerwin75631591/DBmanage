package com.dbms.entity;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailPoster {
	String from="15008181891@163.com";
    String password="mky999729mzz";
    String to="383250208@qq.com";
    String emailHost="smtp.163.com";
    String smtpPort="25";
    public EmailPoster(String receiver){
    	to=receiver;
    }
    public void sendEmail(String title, String content){
        Properties p=new Properties();
        p.setProperty("mail.smtp.host", emailHost);
        p.setProperty("mail.smtp.port", smtpPort);
        p.setProperty("mail.smtp.socketFactory.port", smtpPort);
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.socketFactory.class", "SSL_FACTORY");

        Session session=Session.getInstance(p, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,password);
            }
        });
        session.setDebug(true);

        MimeMessage message=new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,to);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            message.setSubject(title);
            message.setContent(content,"text/html;charset=GBK");
            message.setSentDate(new Date());
            message.saveChanges();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void sendRegCheck(String receiver, int check) {
    	new EmailPoster(receiver).sendEmail("outbreak娉ㄥ唽楠岃瘉鐮�", "<p>灏婃暚鐨勭敤鎴锋偍濂斤紒</p><p>鎮ㄥ湪outbreak浼氳绠＄悊绯荤粺娉ㄥ唽鐨勯獙璇佺爜涓�"+check+"</p>");
    }
    public static void sendPwResetCheck(String receiver, int check) {
    	new EmailPoster(receiver).sendEmail("閲嶇疆瀵嗙爜", "<p>灏婃暚鐨勭敤鎴锋偍濂斤紒</p><p>鎮ㄩ噸缃瘑鐮佺殑楠岃瘉鐮佷负"+check+"锛岃涓嶈灏嗛獙璇佺爜娉勬紡缁欎粬浜�</p>");
    }
    public static void sendIfInvited(String receiver, String topic, boolean hasRegistered) {
    	String content="<p>灏婃暚鐨勭敤鎴锋偍濂斤紝</p><p>鎮ㄥ湪outbreak浼氳绠＄悊绯荤粺涓彈閭�鍙傚姞"+topic+"浼氳</p>";
    	if(hasRegistered) {
    		content+="<p>鎮ㄥ彲浠ュ湪寰俊灏忕▼搴忎腑鏌ョ湅浼氳鐨勮缁嗕俊鎭�</p>";
    	}else {
    		content+="<p>鎮ㄥ彲浠ュ湪寰俊灏忕▼搴忎腑鏌ョ湅浼氳鐨勮缁嗕俊鎭紝甯愬彿涓烘偍鐨勯偖绠憋紝榛樿瀵嗙爜涓簅utbreak123</p>";
    	}
    	new EmailPoster(receiver).sendEmail("浼氳鍙楅個", content);
    }
    public static void test(){
        EmailPoster emailPoster=new EmailPoster("383250208@qq.com");
        emailPoster.sendEmail("浼氳鎻愰啋","OUTBREAK浼氳绠＄悊绯荤粺鎻愰啋鎮細\n鎮ㄦ槑澶╁湪231鏈変竴涓細璁弬鍔�");
    }
    public static void testRegCheck() {
    	EmailPoster.sendRegCheck("383250208@qq.com", 154396);
    }
    public static void main(String[] args){
        //test();
        //EmailPoster.test();
    	//EmailPoster.testRegCheck();
    	//EmailPoster.sendIfInvited("383250208@qq.com", "鍔犵彮", false);
    	EmailPoster.sendPwResetCheck("383250208@qq.com", 123456);
    }
}
