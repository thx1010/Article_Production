package mvc.service;

import mvc.models.*;

public class UserServiceImpl implements UserInterface{
	private static final UserInterface userService = new UserServiceImpl();
	private UserDAO userDAO = UserDAOImpl.getInstance();
	
	private UserServiceImpl() {
	}
	
	public static UserInterface getInstance() {
		return userService;
	}
	
	@Override
	public void joinUser(UserDTO userDTO) throws Exception {
		userDAO.joinUser(userDTO);
	}


	@Override
	public void loginUser(UserDTO userDTO) throws Exception {
		if (userDAO.loginUser(userDTO) == 0) {
			throw new RuntimeException("아이디나 비밀번호가 틀립니다.");
		}
		
	}

}
