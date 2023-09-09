package spring.mvc.jdbc.Dao.cart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.mvc.jdbc.Entities.cart.Cart;

public class cart_Implementation implements cart_Interface{

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int insert(Cart product) {
		String query = "insert into customerCart(Id, Name,Price, Ratings, Discount) values(?,?,?,?,?)";
		int result = this.jdbcTemplate.update(query, product.getId(), product.getName(), product.getPrice(),
				product.getRatings(), product.getDiscount());
		return result;
	}

	@Override
	public boolean isProductExists(int Id) {

		String sql = "SELECT Id FROM customerCart WHERE Id = ?";
		try {
			int count = jdbcTemplate.queryForObject(sql, Integer.class, Id);
			return count != 0;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	@Override
	public List<Cart> getAllProducts() {
		String sql = "SELECT * FROM customerCart";
		List<Cart> products = jdbcTemplate.query(sql, new RowMapper<Cart>() {
			@Override
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cart product = new Cart();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getFloat(3));
				product.setRatings(rs.getFloat(4));
				product.setDiscount(rs.getFloat(5));
				// map other columns to student object
				return product;
			}
		});
		return products;
	}

	@Override
	public int delete(int Id) {
		String query = "delete from customerCart where Id=?";
		int result = this.jdbcTemplate.update(query, Id);
		return result;
	}
	
}
