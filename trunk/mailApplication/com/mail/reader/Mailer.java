package com.mail.reader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

abstract public class Mailer {

	private String EMAIL;

	private String PASSWORD;

	private String POP3_SERVER;
	
	private static int COUNT_MSG;
	
	private static List LAST_MSGS;
	
	public Mailer(String email, String password, String server) throws  NoSuchProviderException, MessagingException{
		this.EMAIL = email;
		this.PASSWORD = password;
		this.POP3_SERVER = server;
		this.COUNT_MSG = checkMessagesCount();
		LAST_MSGS = new LinkedList();
	}
	
	public abstract Session getSession();
	public abstract void connect( Store store );// store.connect(POP3_SERVER, -1, EMAIL, PASSWORD); // port 995
	
	
	public Folder returnInbox() throws NoSuchProviderException, MessagingException{
		Session session = getSession();
		Store store = session.getStore("pop3");
		connect(store);
		
		Folder folder = store.getDefaultFolder();
		folder = folder.getFolder("INBOX");
		folder.open(1);
		
		return folder;
	}
	
	public int checkMessagesCount() throws NoSuchProviderException, MessagingException{
		// Checa se o número atual de msgs é diferente do atual.		
		
		Folder folder = returnInbox();
				
		return folder.getMessageCount();		
	} 
	
	
	public void getNewMessages( int qts_total, int qtd_msg_new ) throws NoSuchProviderException, MessagingException{
			
		Folder folder = returnInbox(); // Return messages from inbox		

		Message[] msgs = folder.getMessages( (qts_total -qtd_msg_new), qts_total-1 );// Return the last messages
		
		LAST_MSGS.addAll(Arrays.asList( msgs )); // Add last messages to the actual list of last messages 
		
		COUNT_MSG = qts_total; // Update the number of messages
		
		folder.close(false);
			
	}
	
	
	public void checkMessagesChange() throws NoSuchProviderException, MessagingException{
		
		int msgs_qtd = checkMessagesCount();
		if(COUNT_MSG != msgs_qtd)
		{
			if(msgs_qtd>COUNT_MSG)
			{
				int msgs_new = msgs_qtd - COUNT_MSG;
				getNewMessages(msgs_qtd, msgs_new);
			}
		}		
	}
}
