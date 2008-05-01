package iFactory.treinamento.hibernate.domain;

public class ClientVip extends Client {

	private float offPrice;

	public float getOffPrice() {
		return offPrice;
	}

	public void setOffPrice(float desconto) {
		this.offPrice = desconto;
	}

	@Override
	public String toString() {
		return "ClientVip {id:" + getId() + ", name: " + getName() + ", offPrice:" + "}";
	}

}
