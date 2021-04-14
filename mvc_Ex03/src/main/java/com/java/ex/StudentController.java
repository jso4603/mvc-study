package com.java.ex;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping("/studentForm")
	public String studentForm() {
		return "createPage";
	}

	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") @Validated Student student, BindingResult result) {

		String page = "createDonePage";

//		StudentValidator studentValidator = new StudentValidator();
//		studentValidator.validate(student, result);

		if(result.hasErrors()) {
			page = "createPage";
		}

		return page;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}


}
