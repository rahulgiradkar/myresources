package iFactory.treinamento.hibernate.domain.vo;

public class Address {
	
	private String city;
	
	private String state;
	
	private String street;
	
	private String poBox;

	public String getPoBox() {
		return poBox;
	}

	public void setPoBox(String cep) {
		this.poBox = cep;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String cidade) {
		this.city = cidade;
	}

	public String getState() {
		return state;
	}

	public void setState(String estado) {
		this.state = estado;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String logradouro) {
		this.street = logradouro;
	}
}
