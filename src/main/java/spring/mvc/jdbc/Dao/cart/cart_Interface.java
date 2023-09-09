package spring.mvc.jdbc.Dao.cart;

import java.util.List;

import spring.mvc.jdbc.Entities.cart.Cart;

public interface cart_Interface {
	public int insert(Cart product);
    public int delete(int Id);
    public List<Cart> getAllProducts();
    public boolean isProductExists(int Id);
}
