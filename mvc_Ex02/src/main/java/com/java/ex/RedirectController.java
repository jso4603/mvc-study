package com.java.ex;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RedirectController {

	private static final Logger logger = LoggerFactory.getLogger(RedirectController.class);

	@RequestMapping("/studentComfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model) {

		String id = httpServletRequest.getParameter("id");
		System.out.println(id);

		if(id.equals("jso4603")) {
			return "redirect:studentOk";
		}

		return "redirect:studentNg";
	}

	@RequestMapping("/studentOk")
	public String studentOk(Model model) {
		return "student/studentOk";
	}

	@RequestMapping("/studentNg")
	public String studentNg(Model model) {
		return "student/studentNg";
	}

}
