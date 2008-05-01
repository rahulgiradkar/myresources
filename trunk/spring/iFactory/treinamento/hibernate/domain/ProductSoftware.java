package iFactory.treinamento.hibernate.domain;

public class ProductSoftware extends Product {

	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String versao) {
		this.version = versao;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", versão:" + getVersion() + "}";
	}
}
