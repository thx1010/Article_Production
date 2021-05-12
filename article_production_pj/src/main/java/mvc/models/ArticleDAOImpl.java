package mvc.models;

import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

public class ArticleDAOImpl implements ArticleDAO {

	private DataSource dataSource;
	private static final ArticleDAO memberDAO = new ArticleDAOImpl();
	private ArticleDAOImpl() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xcimvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArticleDAO getInstance() {
		return memberDAO;
	}

	@Override
	public void insertArticle(ArticleDTO articleDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO article(no, title, subtitle, leadsentence, divide, content, photo) ");
		sql.append("VALUES(seq_article.nextval, ?, ?, ?, ?, ?, ?) ");

		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setString(1, articleDTO.getTitle());
			ps.setString(2, articleDTO.getSubtitle());
			ps.setString(3, articleDTO.getLeadsentence());
			ps.setString(4, articleDTO.getDivide());
			ps.setString(5, articleDTO.getContent());
			ps.setString(6, articleDTO.getPhoto());
			ps.executeUpdate();			
		}
	}

	@Override
	public List<ArticleDTO> getArticleList() throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select B.* ");
		sql.append("from  (select rownum as rnum, A.* ");
		sql.append("       from  (select no, title, regdate, divide, subtitle from article ");
		sql.append("              order by no desc) A) B ");
		sql.append("where rnum between 1 and 10 ");

		List<ArticleDTO> list = new ArrayList<>();
		
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			
			try (ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					ArticleDTO articleDTO = new ArticleDTO();
					articleDTO.setNo(rs.getLong("no"));
					articleDTO.setTitle(rs.getString("title"));
					articleDTO.setRegdate(rs.getDate("regdate"));
					articleDTO.setDivide(rs.getString("divide"));
					articleDTO.setSubtitle(rs.getString("subtitle"));
					list.add(articleDTO);
				}
			}
		} 
		return list;
	}

	
	@Override
	public ArticleDTO getDetail(long no) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select no, title, subtitle, leadsentence, regdate, content, id, divide, photo ");
		sql.append("from   article ");
		sql.append("where  no=? ");

		ArticleDTO articleDTO = null;
		
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setLong(1, no);
			try (ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					articleDTO = new ArticleDTO();
					articleDTO.setNo(rs.getLong("no"));
					articleDTO.setTitle(rs.getString("title"));
					articleDTO.setSubtitle(rs.getString("subtitle"));
					articleDTO.setLeadsentence(rs.getString("leadsentence"));
					articleDTO.setRegdate(rs.getDate("regdate"));
					articleDTO.setContent(rs.getString("content"));
					articleDTO.setDivide(rs.getString("divide"));
					articleDTO.setPhoto(rs.getString("photo"));
				}
			}
		} 
		return articleDTO;
	}
	
	@Override
	public void updateReadcount(long no) throws SQLException {
		
	}
	
	@Override
	public int updateArticle(ArticleDTO articleDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE article SET ");
		sql.append("       title=?     ");
		sql.append("      ,subtitle=?     ");
		sql.append("      ,leadsentence=?      ");
		sql.append("      ,content=?   ");
		sql.append("WHERE  no=? ");

		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, articleDTO.getTitle());
			pstmt.setString(2, articleDTO.getSubtitle());
			pstmt.setString(3, articleDTO.getLeadsentence());
			pstmt.setString(4, articleDTO.getContent());
			pstmt.setLong(5, articleDTO.getNo());
			return pstmt.executeUpdate();
		}		
	}
	
	@Override
	public int deleteArticle(ArticleDTO articleDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE from article ");
		sql.append("WHERE  no=?");

		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setLong(1, articleDTO.getNo());
			return pstmt.executeUpdate();
		}	
	}
	
}