package mvc.service;

import java.util.*;

import mvc.models.*;

public interface ArticleService {

	void insertArticle(ArticleDTO articleDTO) throws Exception;

	List<ArticleDTO> getArticleList() throws Exception;

	ArticleDTO getDetail(long no) throws Exception;

	void updateArticle(ArticleDTO articleDTO) throws Exception;

	void deleteArticle(ArticleDTO articleDTO) throws Exception;

	ArticleDTO getDetail(long no, boolean updateReadcount) throws Exception;
	
}