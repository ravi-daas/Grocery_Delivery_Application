package spring.mvc.jdbc.Dao.admin;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class admin_Implementation implements admin_Interface{
	
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	public boolean check(int Id, int Password) {
		String sql = "SELECT Id FROM Admin WHERE Id = ? AND Password = ?";
        try {
            int count = jdbcTemplate.queryForObject(sql, Integer.class, Id, Password);
            return count != 0;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
	}
	

}