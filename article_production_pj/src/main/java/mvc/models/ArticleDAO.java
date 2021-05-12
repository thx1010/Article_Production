package mvc.models;

import java.sql.*;
import java.util.*;

public interface ArticleDAO {

	void insertArticle(ArticleDTO articleDTO) throws SQLException;

	List<ArticleDTO> getArticleList() throws SQLException;

	void updateReadcount(long no) throws SQLException;

	ArticleDTO getDetail(long no) throws SQLException;

	int updateArticle(ArticleDTO articleDTO) throws SQLException;

	int deleteArticle(ArticleDTO articleDTO) throws SQLException;

}