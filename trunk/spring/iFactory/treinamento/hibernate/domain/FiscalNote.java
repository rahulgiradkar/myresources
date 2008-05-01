package iFactory.treinamento.hibernate.domain;

import java.util.Set;

public class FiscalNote {

	private Long id;

	private String number;

	private Set itemNota;

	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client cliente) {
		this.client = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String numero) {
		this.number = numero;
	}

	public Set getItemNota() {
		return itemNota;
	}

	public void setItemNota(Set itn) {
		this.itemNota = itn;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "NotaFiscal {id:" + getId() + ", número:" + getNumber() + "}";
	}
}
