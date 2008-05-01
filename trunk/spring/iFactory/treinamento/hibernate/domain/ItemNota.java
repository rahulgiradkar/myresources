package iFactory.treinamento.hibernate.domain;


public class ItemNota {

	private Product product;
	
	private int quantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product produto) {
		this.product = produto;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantidade) {
		this.quantity = quantidade;
	}
}
