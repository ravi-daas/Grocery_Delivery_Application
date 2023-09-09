package spring.mvc.jdbc.Dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import spring.mvc.jdbc.Entities.product.Product;

public class RowMapper_Implementation implements RowMapper<Product> {

    @Override
    @Nullable
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt(1));
        product.setName(rs.getString(2));
        product.setPrice(rs.getFloat(3));
        product.setRatings(rs.getFloat(4));
        product.setDiscount(rs.getFloat(5));
        return product;
    }

}
