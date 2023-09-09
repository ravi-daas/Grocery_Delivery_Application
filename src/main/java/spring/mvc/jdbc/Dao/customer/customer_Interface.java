package spring.mvc.jdbc.Dao.customer;

import spring.mvc.jdbc.Entities.customer.Customer;

public interface customer_Interface {
	public boolean isUserExists(String Username);
	public int insert(Customer customer);
	public boolean check(String Id, String password);	
    public int update(Customer customer);
    public Customer getUser(String Username);
    public void deleteAll();
}
