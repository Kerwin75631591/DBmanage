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
    String from="2450186314@qq.com";
    String password="cyhkmrabycveecgj";
    String to="383250208@qq.com";
    String emailHost="smtp.qq.com";
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
    	new EmailPoster(receiver).sendEmail("outbreak注册验证码", "<p>尊敬的用户您好！</p><p>您在outbreak网上书店注册的验证码为"+check+"</p>");
    }
    public static void sendPwResetCheck(String receiver, int check) {
    	new EmailPoster(receiver).sendEmail("重置密码", "<p>尊敬的用户您好！</p><p>您重置密码的验证码为"+check+"，请不要将验证码泄漏给他人</p>");
    }
    public static void main(String[] args){
        //test();
        //EmailPoster.test();
    	//EmailPoster.testRegCheck();
    	//EmailPoster.sendIfInvited("383250208@qq.com", "加班", false);
    	EmailPoster.sendPwResetCheck("75631591@qq.com", 123456);
    }
}
