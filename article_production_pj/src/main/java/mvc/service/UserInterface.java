package mvc.service;

import mvc.models.*;

public interface UserInterface {
	
	void joinUser(UserDTO userDTO) throws Exception;
	
	void loginUser(UserDTO userDTO) throws Exception;

}
