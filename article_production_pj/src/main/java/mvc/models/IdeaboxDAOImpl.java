package mvc.models;

import java.sql.*;

import javax.naming.*;
import javax.sql.*;

public class IdeaboxDAOImpl implements IdeaboxDAO{
	
	public DataSource dataSource;
	public static final IdeaboxDAO ideaboxDAO = new IdeaboxDAOImpl();
	public IdeaboxDAOImpl() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xcimvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static IdeaboxDAO getInstance() {
		return ideaboxDAO;
	}

	@Override
	public int register(IdeaboxDTO ideaboxDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO ideabox(nickname, idea, memo, email) ");
		sql.append("VALUES(?, ?, ?, ?) ");

		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setString(1, ideaboxDTO.getNickname());
			ps.setString(2, ideaboxDTO.getIdea());
			ps.setString(3, ideaboxDTO.getMemo());
			ps.setString(4, ideaboxDTO.getEmail());
			return ps.executeUpdate();			
		}
		
	}
	
}
