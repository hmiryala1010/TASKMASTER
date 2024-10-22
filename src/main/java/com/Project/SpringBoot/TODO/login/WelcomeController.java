package com.Project.SpringBoot.TODO.login;

import org.springframework.security.core.Authentication;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//	private Logger logger = LoggerFactory.getLogger(getClass());

/*private AuthenticationService authenticationservice;

	public LoginController(AuthenticationService authenticationservice) {
		super();
		this.authenticationservice = authenticationservice;
	}
*/
	@RequestMapping(value = "/", method = RequestMethod.GET)

	// public String gotologinpage(@RequestParam String name,ModelMap model) {
	public String gotoWelcomepage(ModelMap model) {
		model.put("name",getLoggedinUsername());		//model.put("name","hasini");
		// model.put("name", name);
		// logger.debug("Request param is {}",name);
		// logger.info("this is info", name);
		// logger.warn("this is warn",name );
		// System.out.println("Request param "+ name);
		return "welcome";
	}

	// http://localhost:8091/login?name=has
/*	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String gotowelcomepage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if (authenticationservice.authenticate(name, password)) {

			model.put("name", name);
			// model.put("password", password);
			// authentication
			// name=hasini
			// password=mani
			return "welcome";
		}
		model.put("errorMessage", "invalid credentials");
		return "login";
	}*/
	private String getLoggedinUsername() {
		 Authentication authentication=
		SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		}
}
