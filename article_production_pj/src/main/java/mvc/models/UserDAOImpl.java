package mvc.models;

import java.sql.*;

import javax.naming.*;
import javax.sql.*;

public class UserDAOImpl implements UserDAO{
	
	private DataSource dataSource;
	private static final UserDAO userDAO = new UserDAOImpl();
	private UserDAOImpl() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xcimvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static UserDAO getInstance() {
		return userDAO;
	}
	
	@Override
	public int loginUser(UserDTO userDTO) throws SQLException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT id, password, email from user_board ");
		sql.append("WHERE id=? AND password=? ");

		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			 ps.setString(1, userDTO.getId());
			 ps.setString(2, userDTO.getPassword());
			 try (ResultSet rs = ps.executeQuery()) {
					if(rs.next()) {
						userDTO = new UserDTO();
						userDTO.setId(rs.getString("id"));
						userDTO.setPassword(rs.getString("password"));
						userDTO.setEmail(rs.getString("email"));
					}
				}
			 return ps.executeUpdate();	
		}
		
	}
	
	@Override
	public void joinUser(UserDTO userDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO user_board(id, password, email) ");
		sql.append("VALUES( ?, ?, ?) ");

		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setString(1, userDTO.getId());
			ps.setString(2, userDTO.getPassword());
			ps.setString(3, userDTO.getEmail());
			ps.executeUpdate();			
		}
		
	}

}
