package iFactory.treinamento.hibernate.domain;

public class SimpleProduct extends Product {

	private double weight;

	public double getWeight() {
		return weight;
	}

	public void setWeight(double peso) {
		this.weight = peso;
	}

	@Override
	public String toString() {
		return super.toString() + ", weight:" + getWeight() + "}";
	}
}
