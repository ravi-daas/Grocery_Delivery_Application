package spring.mvc.jdbc.Dao.product;

import java.util.List;

import spring.mvc.jdbc.Entities.product.Product;

public interface product_Interface {
    public int insert(Product product);
    public int update(Product product);
    public int delete(int Id);
    public Product getProduct(int Id);
    public List<Product> getAllProducts();
    public boolean isProductExists(int Id);
    public List<Product> getbyPrice();
    public List<Product> getbyRating();
    public List<Product> getbyDiscount();

}
