package mvc.controllers;

import javax.servlet.http.*;

import mvc.fx.*;
import mvc.models.*;
import mvc.service.*;

public class UserJoinAction  extends AbstractController{
	UserInterface userInterface = UserServiceImpl.getInstance();

	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		UserDTO userDTO = new UserDTO();
		userDTO.setId(id);
		userDTO.setPassword(password);
		userDTO.setEmail(email);
		System.out.println(userDTO);
		
		
		ModelAndView mav = new ModelAndView();
		try {
			userInterface.joinUser(userDTO);
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg","회원가입 성공했습니다.");
			mav.addObject("url", "userLogin");
			//mav.addObject("url", "list?id=" + articleDTO.getId());
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "회원가입 실패했습니다. 다시 한번 시도해주세요.");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}
