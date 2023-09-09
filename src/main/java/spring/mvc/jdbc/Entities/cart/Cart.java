package spring.mvc.jdbc.Entities.cart;

public class Cart {
	private int Id;

	private String Name;

	private float Price;

	private float Discount = 0.0f;

	private float Ratings;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public float getDiscount() {
		return Discount;
	}

	public void setDiscount(float discount) {
		Discount = discount;
	}

	public float getRatings() {
		return Ratings;
	}

	public void setRatings(float ratings) {
		Ratings = ratings;
	}

	@Override
	public String toString() {
		return "Product [Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", Discount=" + Discount + ", Ratings="
				+ Ratings + "]";
	}

}
