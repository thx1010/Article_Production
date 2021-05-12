package mvc.controllers;

import java.util.*;

import javax.servlet.http.*;

import mvc.fx.*;
import mvc.models.*;
import mvc.service.*;

public class ArticleList extends AbstractController {
	private ArticleService articleService = ArticleServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		try {
			List<ArticleDTO> list = articleService.getArticleList();
			for(ArticleDTO dto : list) {
				System.out.println(dto);
				break;
			}
			mav.setViewName("/WEB-INF/views/list.jsp");
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}