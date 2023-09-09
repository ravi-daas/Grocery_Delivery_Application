package spring.mvc.jdbc.Entities.customer;

public class Customer {
	private String Id;
	private String password;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", password=" + password + "]";
	}

	

}
