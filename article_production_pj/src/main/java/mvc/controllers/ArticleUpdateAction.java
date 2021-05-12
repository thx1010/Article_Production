package mvc.controllers;

import javax.servlet.http.*;

import mvc.fx.*;
import mvc.models.*;
import mvc.service.*;

public class ArticleUpdateAction extends AbstractController {

	ArticleService articleService = ArticleServiceImpl.getInstance();

	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String leadsentence = request.getParameter("leadsentence");
		String content = request.getParameter("content");

		ArticleDTO articleDTO = new ArticleDTO();
		articleDTO.setNo(no);
		articleDTO.setTitle(title);
		articleDTO.setSubtitle(subtitle);
		articleDTO.setLeadsentence(leadsentence);
		articleDTO.setContent(content);
		
		ModelAndView mav = new ModelAndView();
		try {
			articleService.updateArticle(articleDTO);
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "게시물이 수정되었습니다.");
			mav.addObject("url", "detail?no="+ articleDTO.getNo());
		} catch (Exception e) {
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}
