package com.mail.reader;

import javax.mail.PasswordAuthentication;

public class Autenticador extends javax.mail.Authenticator {
	
    private String user;
    private String senha;
    
    public Autenticador() {}
    
    public Autenticador(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, senha);        
    }
}
