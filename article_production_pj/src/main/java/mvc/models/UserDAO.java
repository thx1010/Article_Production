package mvc.models;

import java.sql.*;

public interface UserDAO {
	void joinUser(UserDTO userDTO) throws SQLException;
	
	int loginUser(UserDTO userDTO) throws SQLException;
}
