package Day13_1_Set;

public class Customer {
	private String nameString;
 
	private Integer id ;
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	 
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer(String nameString,  Integer id) {
		super();
		this.nameString = nameString;
	 
		this.id = id;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [nameString=" + nameString +  ", id=" + id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		 result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nameString == null) ? 0 : nameString.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		 
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nameString == null) {
			if (other.nameString != null)
				return false;
		} else if (!nameString.equals(other.nameString))
			return false;
		return true;
	}
	 
	

}
