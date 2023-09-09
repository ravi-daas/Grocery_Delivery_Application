package spring.mvc.jdbc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import spring.mvc.jdbc.Entities.admin.Admin;
import spring.mvc.jdbc.Dao.admin.*;

@Controller
@RequestMapping("/admin")
@SessionAttributes("adminId")
public class admin_Controller {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginForm(HttpSession session) {
		if (isAdminLoggedIn(session)) {
			System.out.println("Admin | Showing Home Page to Admin via redirecting /home");
			return "redirect:/admin/home";
		} else {
			System.out.println("No Admin | Showing Login Page to Admin via loginForm.jsp");
			return "Admin/loginForm";
		}
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String adminHome(HttpSession session) {
		if (isAdminLoggedIn(session)) {
			System.out.println("Admin | Showing Home Page to Admin via loginSuccess.jsp");
			return "Admin/loginSuccess";
		} else {
			System.out.println("No Admin | Showing Login Page to Admin via loginForm.jsp");
			return "Admin/loginForm";
		}
	}

	public boolean isAdminLoggedIn(HttpSession session) {
		return session.getAttribute("adminId") != null;
	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("admin") Admin admin, Model model, HttpServletRequest request) {

		System.out.println("No Admin | Processing Input entered from the Web");
		System.out.println("Id => " + admin.getId());
		System.out.println("Password => " + admin.getPassword());

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		admin_Interface adminDao = context.getBean("admin_implementation", admin_Interface.class);

		((ClassPathXmlApplicationContext) context).close();

		boolean check = adminDao.check(admin.getId(), admin.getPassword());

		System.out.println("Admin Milgya K => " + check);

		if (check) {
			System.out.println("Admin | Details Matched in Database");
			System.out.println("Admin | Creating Session for Admin");
			HttpSession session = request.getSession();
			System.out.println("Admin | Session Created | Setting session Attribute for Admin");
			session.setAttribute("adminId", admin.getId());
			System.out.println("Admin | Session Created using adminId: "+admin.getId());
			System.out.println("Admin | Showing Home Page to Admin");
			return "redirect:/admin/home";
		} else {
			System.out.println("No Admin | Setting Error using Model");
			model.addAttribute("error", "Invalid Credentials");
			System.out.println("No Admin | Showing Login Form again");
			return "Admin/loginForm";
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
		System.out.println("Admin | Ending Admin Session | Method Start");
		session.invalidate();
		System.out.println("No Admin | Admin Left");
		System.out.println("No Admin | Admin Session Ended | Method End");
		return "redirect:/";
	}

}
