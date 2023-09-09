package spring.mvc.jdbc.controller;

import java.util.List;

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

import spring.mvc.jdbc.Dao.product.product_Interface;

import spring.mvc.jdbc.Entities.product.Product;


@Controller
@RequestMapping("product")
public class product_Controller {
	admin_Controller admin = new admin_Controller();

	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public String detailsForm(HttpSession session, RedirectAttributes redirectAttributes) {
		if (admin.isAdminLoggedIn(session)) {
			System.out.println("Product Insert Details Form");
			return "Product/detailsForm";
		} else {
			return "Admin/loginForm";
		}

	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String insertDetails(HttpSession session, RedirectAttributes redirectAttributes,
			@ModelAttribute Product product, Model model) {
		if (admin.isAdminLoggedIn(session)) {

			System.out.println("Trying to Insert Product");

			System.out.println(product);

			int result = insertData(product);

			if (result == 2) {
				model.addAttribute("error", "Entered Id is already present");
				return "Product/detailsForm";
			} else {
				return "redirect:show";
			}

		} else {
			return "Admin/loginForm";
		}
	}

	public int insertData(Product product) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		product_Interface productDao = context.getBean("product_implementation", product_Interface.class);
		((ClassPathXmlApplicationContext) context).close();

		if (productDao.isProductExists(product.getId())) {
			return 2;
		} else {

			int result = productDao.insert(product);

			return result;
		}
	}

	@RequestMapping(value = "/show", method = { RequestMethod.GET, RequestMethod.POST })
	public String showDetails(Model model, RedirectAttributes redirectAttributes, HttpSession session) {

		if (admin.isAdminLoggedIn(session)) {
			ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

			product_Interface productDao = context.getBean("product_implementation", product_Interface.class);
			((ClassPathXmlApplicationContext) context).close();

			List<Product> products = productDao.getAllProducts();
			
			System.out.println("Showing All Products to Admin");

			model.addAttribute("products", products);
			model.addAttribute("update", "Update");
			model.addAttribute("delete", "Delete");
			return "Product/showDetails";
		} else {
			return "Admin/loginForm";
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteDetails(@RequestParam("Id") int Id, HttpSession session) {

		if (admin.isAdminLoggedIn(session)) {

			System.out.println("Deleting Product with Id => " + Id);

			ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

			product_Interface productDao = context.getBean("product_implementation", product_Interface.class);
			((ClassPathXmlApplicationContext) context).close();

			int result = productDao.delete(Id);

			System.out.println("Result = " + result);

			if (result == 1) {
				return "redirect:show";
			} else {
				return "redirect:show";
			}
		} else {
			return "Admin/loginForm";
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateDetails(@RequestParam("Id") int Id, Model model, HttpSession session) {

		if (admin.isAdminLoggedIn(session)) {

			System.out.println("Updating Product with Id => " + Id + ", Showing Update Form");

			ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

			product_Interface productDao = context.getBean("product_implementation", product_Interface.class);
			((ClassPathXmlApplicationContext) context).close();

			Product product = productDao.getProduct(Id);

			model.addAttribute("product", product);

			System.out.println("Result = " + product);

			return "Product/updateForm";
		} else {
			return "Admin/loginForm";
		}
	}

	@RequestMapping(value = "/update/process", method = RequestMethod.POST)
	public String updateProcess(@ModelAttribute Product product, HttpSession session) {

		if (admin.isAdminLoggedIn(session)) {

			System.out.println("Update is in Progress");

			System.out.println("Updating Product Details entered from the Web " + product);

			ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

			product_Interface productDao = context.getBean("product_implementation", product_Interface.class);
			((ClassPathXmlApplicationContext) context).close();

			int res = productDao.update(product);
			
			System.out.println("Result " + res);

			return "redirect:../show";
		} else {
			return "Admin/loginForm";
		}
	}
	
	@RequestMapping(value="/byPrice", method=RequestMethod.POST)
	public String byPrice(Model model) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		product_Interface productDao = context.getBean("product_implementation", product_Interface.class);
		((ClassPathXmlApplicationContext) context).close();
		
		System.out.println("Filtering Products by Price");
		
		List<Product> products = productDao.getbyPrice();
		
		model.addAttribute("products", products);
		
		return "Customer/home";
	}
	
	@RequestMapping(value="/byRating", method=RequestMethod.POST)
	public String byRating(Model model) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		product_Interface productDao = context.getBean("product_implementation", product_Interface.class);
		((ClassPathXmlApplicationContext) context).close();
		
		System.out.println("Filtering Products by Rating");
		
		List<Product> products = productDao.getbyRating();
		
		model.addAttribute("products", products);
		
		return "Customer/home";
	}
	
	@RequestMapping(value="/byDiscount", method=RequestMethod.POST)
	public String byDiscount(Model model) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		product_Interface productDao = context.getBean("product_implementation", product_Interface.class);
		((ClassPathXmlApplicationContext) context).close();
		
		System.out.println("Filtering Products by Discount");
		
		List<Product> products = productDao.getbyDiscount();
		
		model.addAttribute("products", products);
		
		return "Customer/home";
	}

}
