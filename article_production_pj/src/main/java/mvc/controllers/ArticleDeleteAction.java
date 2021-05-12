package mvc.controllers;

import javax.servlet.http.*;

import mvc.fx.*;
import mvc.models.*;
import mvc.service.*;

public class ArticleDeleteAction extends AbstractController{

	ArticleService articleService = ArticleServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));

		ArticleDTO articleDTO = new ArticleDTO();
		articleDTO.setNo(no);
		
		ModelAndView mav = new ModelAndView();
		try {
			articleService.deleteArticle(articleDTO);
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "게시물이 삭제되었습니다.");
			mav.addObject("url", "list?no=" + articleDTO.getNo());
		} catch (Exception e) {
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}
