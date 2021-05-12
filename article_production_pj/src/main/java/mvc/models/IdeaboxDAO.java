package mvc.models;

import java.sql.*;

public interface IdeaboxDAO {
	int register(IdeaboxDTO ideaboxDTO) throws SQLException;
}
