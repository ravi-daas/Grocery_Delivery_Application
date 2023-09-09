package spring.mvc.jdbc.Dao.cart;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import spring.mvc.jdbc.Entities.cart.Cart;

public class RowMapper_Implementation implements RowMapper<Cart> {

    @Override
    @Nullable
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cart product = new Cart();
        product.setId(rs.getInt(1));
        product.setName(rs.getString(2));
        product.setPrice(rs.getFloat(3));
        product.setRatings(rs.getFloat(4));
        product.setDiscount(rs.getFloat(5));
        return product;
    }

}
