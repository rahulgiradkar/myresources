package iFactory.treinamento.hibernate.domain;


public abstract class Product {

	private Long id;
	
	private String name;
	
	private double price;
	
	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category categoria) {
		this.category = categoria;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double preco) {
		this.price = preco;
	}
	
	@Override
	public String toString() {
		return "Produto {id:" + getId() + ", nome:" + getName() 
			+ ", preço:" + getPrice() + ", categoria:" + getCategory().getName();
	}
}
