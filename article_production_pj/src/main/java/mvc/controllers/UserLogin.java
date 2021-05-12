package mvc.controllers;

import javax.servlet.http.*;

import mvc.fx.*;

public class UserLogin extends AbstractController{
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/WEB-INF/views/userLogin.jsp");
	}
}
