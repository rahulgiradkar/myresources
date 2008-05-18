package com.mail.reader;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

public class MailSenderMultiContent extends MailSender
{
	public void sendMultiPart(String recipients[], String subject, String from) throws MessagingException
	{
		Multipart mp = new MimeMultipart();
		MimeBodyPart textPart = new MimeBodyPart();
		MimeBodyPart attachFilePart = new MimeBodyPart();

		textPart.setContent("<h1>Check attachment</h1>", "text/html");

		FileDataSource fds = new FileDataSource("C:\\Desenvolvimento\\workspace\\myresources\\mailApplication\\com\\mail\\reader\\MailSenderMultiContent.java");
		attachFilePart.setDataHandler(new DataHandler(fds));
		attachFilePart.setFileName(fds.getName());

		mp.addBodyPart(textPart);
		mp.addBodyPart(attachFilePart);
		
		sendSSLMessage(recipients, subject, mp, from);
	}
	
	public static void main(String[] args) throws MessagingException
	{
		new MailSenderMultiContent().sendMultiPart(MailSender.sendTo, MailSender.emailSubjectTxt, MailSender.emailFromAddress);
	}
}
