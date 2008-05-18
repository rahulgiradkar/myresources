package com.mail.reader;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender
{

	public static final String SMTP_HOST_NAME = "smtp.gmail.com";
	public static final String SMTP_PORT = "465";
	public static final String emailMsgTxt = "Test Message Contents";
	public static final String emailSubjectTxt = "A test from gmail";
	public static final String emailFromAddress = "jpaulo.melo@gmail.com";
	public static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	public static final String[] sendTo = { "joao.fernandes@ifactory.com.br" };
	public static final String SENDER_PASS = "19650917@";
	public static final String SENDER_USER = "jpaulo.melo";
	
	
	public static void main(String args[]) throws Exception
	{

		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		new MailSender().sendSSLMessage(sendTo, emailSubjectTxt, emailMsgTxt,
				emailFromAddress);
		System.out.println("Sucessfully Sent mail to All Users");
	}

	public void sendSSLMessage(String recipients[], String subject,
			Object message, String from) throws MessagingException
	{
		boolean debug = true;

		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getDefaultInstance(props,new Autenticador(SENDER_USER, SENDER_PASS));

		session.setDebug(debug);

		Message msg = new MimeMessage(session);
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		// Setting the Subject and Content Type
		msg.setSubject(subject);
		
		if(message instanceof Multipart){
			msg.setContent((Multipart)message);
		}else{
			msg.setContent(message, "text/plain");
		}
		
		Transport.send(msg);
	}
}
