package spring.mvc.jdbc.Dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.mvc.jdbc.Entities.product.Product;

public class product_Implementation implements product_Interface {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Product product) {
		String query = "insert into Product(p_Id, p_Name,p_Price, p_Rating, p_Discount) values(?,?,?,?,?)";
		int result = this.jdbcTemplate.update(query, product.getId(), product.getName(), product.getPrice(),
				product.getRatings(), product.getDiscount());
		return result;
	}

	@Override
	public boolean isProductExists(int Id) {

		String sql = "SELECT p_Id FROM Product WHERE p_Id = ?";
		try {
			int count = jdbcTemplate.queryForObject(sql, Integer.class, Id);
			return count != 0;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	@Override
	public List<Product> getAllProducts() {
		String sql = "SELECT * FROM Product";
		List<Product> products = jdbcTemplate.query(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
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
		String query = "delete from Product where p_Id=?";
		int result = this.jdbcTemplate.update(query, Id);
		return result;
	}

	@Override
	public Product getProduct(int Id) {
		String query = "select * from Product where p_Id=?";

		RowMapper<Product> rowmapper = new RowMapper_Implementation();

		Product product = this.jdbcTemplate.queryForObject(query, rowmapper, Id);
		return product;
	}

	@Override
	public int update(Product product) {

		String query = "update Product set p_Name=?, p_Price=?,p_Rating=?,p_Discount=? where p_Id=?";
		int result = this.jdbcTemplate.update(query, product.getName(), product.getPrice(), product.getRatings(),
				product.getDiscount(), product.getId());
		return result;
	}
	

	@Override
	public List<Product> getbyPrice() {
		String sql = "SELECT * FROM Product WHERE p_Price > 0 ORDER BY p_Price ASC";
		List<Product> products = jdbcTemplate.query(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
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
	public List<Product> getbyRating() {
		String sql = "SELECT * FROM Product WHERE p_Rating > 0	ORDER BY p_Rating DESC";
		List<Product> products = jdbcTemplate.query(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
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
	public List<Product> getbyDiscount() {
		String sql = "SELECT * FROM Product	WHERE p_Discount > 0 ORDER BY p_Discount DESC";
		List<Product> products = jdbcTemplate.query(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
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
}
