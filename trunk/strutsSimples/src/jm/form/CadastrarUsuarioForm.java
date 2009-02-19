package jm.form;

import jm.action.CadastrarUsuarioAction;

import org.apache.log4j.Logger;
import org.apache.struts.action.*;
import org.apache.struts.validator.*;

public class CadastrarUsuarioForm extends ValidatorForm {
	Logger log = Logger.getLogger(CadastrarUsuarioForm.class);
	private String nome;
    private String endereco;
    private String telefone;
    private String login;
    private String senha;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}