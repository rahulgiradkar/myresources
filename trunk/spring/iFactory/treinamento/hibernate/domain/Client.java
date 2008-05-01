package iFactory.treinamento.hibernate.domain;

import iFactory.treinamento.hibernate.domain.vo.Address;

public class Client {

	private Long id;
	private String name;
	private String cidade;
	private String estado;
	private String logradouro;
	private String cep;

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEstado()
	{
		return estado;
	}
	public void setEstado(String estado)
	{
		this.estado = estado;
	}
	public String getLogradouro()
	{
		return logradouro;
	}
	public void setLogradouro(String logradouro)
	{
		this.logradouro = logradouro;
	}
	public String getCep()
	{
		return cep;
	}
	public void setCep(String cep)
	{
		this.cep = cep;
	}

}
