package mvc.controllers;

import javax.servlet.http.*;

import mvc.fx.*;
import mvc.models.*;
import mvc.service.*;

public class UserLoginAction extends AbstractController{
	UserInterface userInterface = UserServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		UserDTO userDTO = new UserDTO();
		userDTO.setId(id);
		userDTO.setPassword(password);
		System.out.println(userDTO);
		
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("user", userDTO);
		
		ModelAndView mav = new ModelAndView();
		try {
			userInterface.loginUser(userDTO);
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg","로그인 성공했습니다.");
			mav.addObject("url", "list?id="+ userDTO.getId()+"&password="+ userDTO.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "로그인 실패했습니다. 다시 한번 시도해주세요.");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
}
