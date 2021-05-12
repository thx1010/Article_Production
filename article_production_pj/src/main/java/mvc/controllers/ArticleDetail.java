package mvc.controllers;

import javax.servlet.http.*;

import mvc.fx.*;
import mvc.models.*;
import mvc.service.*;

public class ArticleDetail extends AbstractController {
	ArticleService articleService = ArticleServiceImpl.getInstance();

	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		
		try {
			ArticleDTO articleDTO = articleService.getDetail(no);
			return new ModelAndView("/WEB-INF/views/detail.jsp", "articleDTO", articleDTO);
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "list");
			return mav;
		}
	}

}