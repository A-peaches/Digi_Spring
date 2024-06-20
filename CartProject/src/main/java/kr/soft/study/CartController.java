package kr.soft.study;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.soft.study.service.Constant;
import kr.soft.study.service.Service;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CartController {
	
	Service service = null;
	
	private JdbcTemplate template;

	//�̹� ������ template ��� �ڵ����� �ҷ����Բ� ������̼� �ۼ�.
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping(value = "/list")
	public String home(Model model) {


		return "cookieList";
	}
	
	@RequestMapping(value = "/addCart")
	public String addCart(HttpServletRequest request , Model model) {
		model.addAttribute("request", request);
		service = new AddCartService();
		service.execute(model);
		
		return "redirect:cart";
	}
	
	@RequestMapping(value = "/cart")
	public String cart(HttpServletRequest request , Model model) {
		service = new getCartService();
		service.execute(model);
		
		return "cookieCart";
	}
	
	
	@RequestMapping(value = "/check")
	public String check(Model model) {
		service = new deleteCartService();
		service.execute(model);
		
		return "redirect:list";
	}
	
}
