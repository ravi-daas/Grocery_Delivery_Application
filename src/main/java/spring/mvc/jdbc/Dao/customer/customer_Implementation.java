package spring.mvc.jdbc.Dao.customer;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.mvc.jdbc.Entities.customer.Customer;

public class customer_Implementation implements customer_Interface {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean isUserExists(String Id) {

		String sql = "SELECT username FROM customerInfo WHERE username = ?";
		try {
			String count = jdbcTemplate.queryForObject(sql, String.class, Id);
			return count != null;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	@Override
	public int insert(Customer customer) {
		String query = "insert into customerInfo(username, password) values(?,?)";
		int result = this.jdbcTemplate.update(query, customer.getId(), customer.getPassword());
		return result;
	}

	@Override
	public boolean check(String Id, String password) {
		String sql = "SELECT username FROM customerInfo WHERE username = ? AND password = ?";
		try {
			String count = jdbcTemplate.queryForObject(sql, String.class, Id, password);
			return count != null;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	@Override
	public int update(Customer customer) {
		String query = "update customerInfo set password=? where username=?";
		int result = this.jdbcTemplate.update(query, customer.getPassword(), customer.getId());
		return result;
	}

	@Override
	public Customer getUser(String Username) {
		String query = "select * from customerInfo where username=?";

		RowMapper<Customer> rowmapper = new RowMapper_Implementation();

		Customer customer = this.jdbcTemplate.queryForObject(query, rowmapper, Username);
		return customer;
	}

	@Override
	public void deleteAll() {
		String query = "DELETE FROM customerCart";
		jdbcTemplate.update(query);
	}

}
