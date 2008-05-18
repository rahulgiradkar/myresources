package com.mail.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

public class EmailTracker {





	   private static String EMAIL = "joao.fernandes";
	   private static String PASSWORD = "joao1965";
	   private static String POP3_SERVER = "mail.ifactory.com.br";

//	   private static String EMAIL = "wladelin";
//	   private static String PASSWORD = "19650917@";
//	   private static String POP3_SERVER = "pop.mail.yahoo.com.br";

//      private static String EMAIL = "wladelin";
//      private static String PASSWORD = "19650917@";
//      private static String POP3_SERVER = "pop.hotmail.com";


//      private static String EMAIL = "jpaulo.melo";
//      private static String PASSWORD = "19650917@";
//      private static String POP3_SERVER = "pop.gmail.com";



	public static void listarEmails() throws MessagingException {
		// Session
		Session session = getSession();
		
		// Store
		Store store = session.getStore("pop3");
		store.connect(POP3_SERVER,-1, EMAIL, PASSWORD); // port 995 ,-1
		
		// Folder		
		Folder folder = store.getDefaultFolder();
		folder = folder.getFolder("INBOX");
		System.out.println(folder.getFullName());
		folder.open(Folder.READ_ONLY);

		Message[] msgs = folder.getMessages();
		Address []address;
		Message message;

		// Print all msg from email
		for (int i = folder.getMessageCount()-1; i >0; i--) {
			message = msgs[i];
			address = message.getFrom();
			System.out.println(message.getSentDate()+"  :"+ message.getSubject()+", from "+address[0]+" ");

			try {
				printParts(message);
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			break;

		}
		folder.close(false);

	}

	private static Session getSession() {

		Session session = null;
        Properties props = new Properties();
        props.put("mail.pop3.host", POP3_SERVER);
        props.put("mail.pop3.user", EMAIL);

       // props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL for Gmail
        props.put("mail.pop3.socketFactory.fallback", "false");
        props.put("mail.store.protocol", "pop3");
        session = Session.getDefaultInstance(props, new Autenticador(EMAIL, PASSWORD));
        return session;
    }
	/**
	 *
	 * */
	public static void printParts(Part p) throws MessagingException, IOException {
		Object o = p.getContent();
		if (o instanceof String) {
			System.out.println((String)o);
		} else if (o instanceof Multipart) {
			Multipart mp = (Multipart) o;
			int count = mp.getCount();
			for (int i = 0; i< count; i++) {
				printParts(mp.getBodyPart(i));
			}
		} else if (o instanceof InputStream) {
			InputStream is = (InputStream) o;
			int c;
			StringBuffer buf = new StringBuffer();
			while ((c = is.read()) != -1) {
				buf.append(c);
			}
			System.out.println(buf.toString());
		}
	}

	public static void main(String[] args) {
		System.out.println("Lista de emails de " + EMAIL + ":");
		try {
			listarEmails();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
