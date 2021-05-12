package mvc.service;

import java.util.*;

import mvc.models.*;

public class ArticleServiceImpl implements ArticleService {
	private static final ArticleService articleService = new ArticleServiceImpl();
	private ArticleDAO articleDAO = ArticleDAOImpl.getInstance();
	
	private ArticleServiceImpl() {
	}

	public static ArticleService getInstance() {
		return articleService;
	}

	@Override
	public void insertArticle(ArticleDTO articleDTO) throws Exception {
		articleDAO.insertArticle(articleDTO);
	}

	@Override
	public List<ArticleDTO> getArticleList() throws Exception {
		return articleDAO.getArticleList();
	}

	@Override
	public ArticleDTO getDetail(long no) throws Exception {
		return getDetail(no, true);
	}
	
	@Override
	public ArticleDTO getDetail(long no, boolean updateReadcount) throws Exception {
		try {
			if (updateReadcount) articleDAO.updateReadcount(no);
			
			ArticleDTO articleDTO = articleDAO.getDetail(no);
			if (articleDTO == null) {
				throw new RuntimeException("상세보기 실패");
			}
			return articleDTO;
		} finally {}
	}
	
	@Override
	public void updateArticle(ArticleDTO articleDTO) throws Exception {
		if (articleDAO.updateArticle(articleDTO) == 0) {
			throw new RuntimeException("글이 없거나 비밀번호가 틀립니다.");
		}
	}

	@Override
	public void deleteArticle(ArticleDTO articleDTO) throws Exception {
		if (articleDAO.deleteArticle(articleDTO) != 1) {
			throw new RuntimeException("글이 없거나 비밀번호가 틀립니다.");
		}
	}

}