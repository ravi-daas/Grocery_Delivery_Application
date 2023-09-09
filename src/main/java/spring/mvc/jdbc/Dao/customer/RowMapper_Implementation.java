package spring.mvc.jdbc.Dao.customer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import spring.mvc.jdbc.Entities.customer.Customer;

public class RowMapper_Implementation implements RowMapper<Customer> {

    @Override
    @Nullable
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer user = new Customer();
        user.setId(rs.getString(1));
        user.setPassword(rs.getString(2));
        return user;
    }

}
