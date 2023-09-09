package spring.mvc.jdbc.Entities.admin;

public class Admin {

	private int Id;
	
	private int Password;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getPassword() {
		return Password;
	}

	public void setPassword(int password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Admin [Id=" + Id + ", Password=" + Password + "]";
	}
}
