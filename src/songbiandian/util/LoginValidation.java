package songbiandian.util;

import songbiandian.dao.ValidateUser;
import songbiandian.javabean.User;

/**
 * 实现ValidateUser接口的类
 * @author TerenceWu
 *
 */
public class LoginValidation implements ValidateUser {
	public User validateUser(String username, String password) {
		return User.getInstanceOfUser();
	}
}
