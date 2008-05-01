package iFactory.treinamento.hibernate.domain;

public class Category {

	private Long id;

	private String name;

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

	public int hashCode() {
	    final int PRIME = 31;
	    int result = 1;
	    result = PRIME * result + ((id == null) ? 0 : id.hashCode());
	    return result;
	}

	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    final Category other = (Category) obj;
	    if (id == null) {
		if (other.id != null)
		    return false;
	    } else if (!id.equals(other.id))
		return false;
	    return true;
	}

	@Override
	public String toString() {
		return "Category {id:" + getId() + ", name: " + getName() + "}";
	}
}
