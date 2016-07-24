package songbiandian.dao;

import songbiandian.javabean.User;

/**
 * 用于登录时验证用户
 * @author TerenceWu
 *
 */
public interface ValidateUser {
	/**
	 * 验证登录用户的合法性
	 * @param username 登录用户名
	 * @param password 登录密码
	 * @return User实例
	 */
	User validateUser(String username, String password);
}
