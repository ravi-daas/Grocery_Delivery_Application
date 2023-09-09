package spring.mvc.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.mvc.jdbc.Dao.cart.cart_Interface;
import spring.mvc.jdbc.Dao.customer.customer_Interface;
import spring.mvc.jdbc.Dao.product.product_Interface;
import spring.mvc.jdbc.Entities.cart.Cart;
import spring.mvc.jdbc.Entities.customer.Customer;
import spring.mvc.jdbc.Entities.product.Product;

@Controller
@RequestMapping("/customer")
public class customer_Controller {

	@RequestMapping(value = "/what", method = RequestMethod.POST)
	public String what() {
		System.out.println("No User | Showing what.jsp Page");
		return "Customer/what";
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup() {
		System.out.println("No User | Showing signup.jsp Page");
		return "Customer/signup";
	}

	@RequestMapping(value = "signup/process", method = RequestMethod.POST)
	public String signupProcess(@ModelAttribute Customer customer, Model model) {

		System.out.println("No User | Processing Data from Web");

		System.out.println("No User | Printing Data from Web");
		
		System.out.println(customer);

		System.out.println("No User | Calling insert() method & passing Data from Web in method & storing the result from method in result variable");
		
		int result = insertData(customer);
		
		System.out.println("No User | Checking the result variable");

		if (result == 2) {
			System.out.println("No User | result==2 & adding error in model(username already taken) & showing again signup.jsp");
			model.addAttribute("error", "Username already taken!!");
			return "Customer/signup";
		} else {
			System.out.println("No User | result==1 & Data Verified & Redirecting to /login");
			return "redirect:../login";
		}
	}

	public int insertData(Customer customer) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		customer_Interface customerDao = context.getBean("customer_implementation", customer_Interface.class);
		((ClassPathXmlApplicationContext) context).close();

		if (customerDao.isUserExists(customer.getId())) {
			return 2;
		} else {
			int result = customerDao.insert(customer);
			return result;
		}
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public String login(HttpSession session) {
		if (isUserLoggedIn(session)) {
			System.out.println("User | Showing Home Page");
			return "redirect:/customer/home";
		} else {
			System.out.println("No User | Showing login.jsp Page");
			return "Customer/login";
		}
	}

	@RequestMapping(value = "login/process", method = { RequestMethod.POST, RequestMethod.GET })
	public String loginProcess(@ModelAttribute Customer customer, Model model, HttpServletRequest request) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		customer_Interface customerDao = context.getBean("customer_implementation", customer_Interface.class);
		((ClassPathXmlApplicationContext) context).close();
		
		System.out.println("Processing Input from the Web");

		boolean check = customerDao.check(customer.getId(), customer.getPassword());

		if (check) {
			
			System.out.println("User Found, Logging In, creating session");
			

			HttpSession session = request.getSession();

			session.setAttribute("userId", customer.getId());

			return "redirect:/customer/home";
		} else {
			model.addAttribute("error", "Invalid Credentials");
			return "Customer/login";
		}
	}

	public boolean isUserLoggedIn(HttpSession session) {
		return session.getAttribute("userId") != null;
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.POST, RequestMethod.GET })
	public String logout(HttpSession session) {

		System.out.println("LOGOUT START");
		session.invalidate();
		System.out.println("Admin has Left");
		System.out.println("LOGOUT , END");

		// Redirect the user to the login page or any other desired page
		return "Customer/what";
	}

	@RequestMapping(value = "/home", method = { RequestMethod.POST, RequestMethod.GET })
	public String home(HttpSession session, Model model) {
		if (isUserLoggedIn(session)) {

			ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

			product_Interface productDao = context.getBean("product_implementation", product_Interface.class);
			((ClassPathXmlApplicationContext) context).close();
			
			System.out.println("Showing All Products to Customer");

			List<Product> products = productDao.getAllProducts();

			model.addAttribute("products", products);

			return "Customer/home";
		} else {
			return "Customer/login";
		}

	}

	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	public String addtoCart(@ModelAttribute Cart product, Model model, RedirectAttributes redirectAttributes,
			HttpSession session) {

		if (isUserLoggedIn(session)) {

			System.out.println("Trying to Insert in Cart");

			System.out.println(product);

			int result = insertData(product);

			if (result == 2) {
				redirectAttributes.addFlashAttribute("error", "Selected Product is already in Cart");
				System.out.println("Item is already in Cart");
				return "redirect:http://localhost:8080/mvc.jdbc/customer/home";
			} else {
				redirectAttributes.addFlashAttribute("added", "Item Added");
				System.out.println("Item Added in Cart");
				return "redirect:http://localhost:8080/mvc.jdbc/customer/home";
			}

		} else {
			return "Customer/login";
		}
	}

	public int insertData(Cart product) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		cart_Interface productDao = context.getBean("cart_implementation", cart_Interface.class);
		((ClassPathXmlApplicationContext) context).close();

		if (productDao.isProductExists(product.getId())) {
			return 2;
		} else {
			int result = productDao.insert(product);
			return result;
		}
	}

	@RequestMapping(value = "/showcart", method = { RequestMethod.GET, RequestMethod.POST })
	public String showCart(Model model, HttpSession session) {

		if (isUserLoggedIn(session)) {

			ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

			cart_Interface productDao = context.getBean("cart_implementation", cart_Interface.class);
			((ClassPathXmlApplicationContext) context).close();
			
			System.out.println("Showing Cart to Customer");

			List<Cart> products = productDao.getAllProducts();

			model.addAttribute("products", products);
			return "Customer/cart";
		} else {
			return "Customer/login";
		}

	}

	@RequestMapping(value = "/removeCart", method = { RequestMethod.GET, RequestMethod.POST })
	public String removeCart(Model model, @RequestParam("Id") int Id, HttpSession session) {

		if (isUserLoggedIn(session)) {

			ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

			cart_Interface productDao = context.getBean("cart_implementation", cart_Interface.class);
			((ClassPathXmlApplicationContext) context).close();

			int result = productDao.delete(Id);
			
			System.out.println("Removing Item with Id: "+Id+", from the cart. Result is:"+result);

			return "redirect:http://localhost:8080/mvc.jdbc/customer/showcart";
		} else {
			return "Customer/login";
		}

	}

	@RequestMapping(value = "/updateProfile", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(Model model, HttpSession session) {

		if (isUserLoggedIn(session)) {

			ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

			customer_Interface userDao = context.getBean("customer_implementation", customer_Interface.class);
			((ClassPathXmlApplicationContext) context).close();
			
			System.out.println("Showing Update Profile Form");

			String username = (String) session.getAttribute("userId");

			Customer customer = userDao.getUser(username);

			model.addAttribute("customer", customer);

			return "Customer/updateProfile";

		} else {
			return "Customer/login";
		}
	}

	@RequestMapping(value = "/updateProfile/process", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateProcess(@ModelAttribute Customer customer, HttpSession session) {
		if (isUserLoggedIn(session)) {
			ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

			customer_Interface userDao = context.getBean("customer_implementation", customer_Interface.class);
			((ClassPathXmlApplicationContext) context).close();
			
			System.out.println("Updating user profile");
			
			int res = userDao.update(customer);
			
			System.out.println("Profile Updated, result "+ res);

			return "Customer/home";
		} else {
			return "Customer/login";
		}
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String checkOut(Model model, HttpSession session) {
		if (isUserLoggedIn(session)) {

			ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

			cart_Interface productDao = context.getBean("cart_implementation", cart_Interface.class);
			((ClassPathXmlApplicationContext) context).close();
			
			System.out.println("Bill Dikha diya customer te");

			List<Cart> products = productDao.getAllProducts();

			double totalPrice = 0.0d;
			for (Cart product : products) {
				double price = product.getPrice();
				System.out.println("Price: " + price);
				totalPrice += price;
			}

			model.addAttribute("total", totalPrice);

			model.addAttribute("products", products);
			return "Customer/checkout";
		} else {
			return "Customer/login";
		}

	}

	@RequestMapping(value = "pay", method = RequestMethod.POST)
	public String pay(Model model, HttpSession session) {
		if (isUserLoggedIn(session)) {

			ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

			customer_Interface productDao = context.getBean("customer_implementation", customer_Interface.class);
			((ClassPathXmlApplicationContext) context).close();

			System.out.println("Customer ne rapiye de diye, deleting all product from cart");
			
			productDao.deleteAll();

			return "redirect:http://localhost:8080/mvc.jdbc/customer/home";
		} else {
			return "Customer/login";
		}

	}

}
