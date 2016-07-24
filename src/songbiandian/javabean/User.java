package songbiandian.javabean;

/**
 * 网站用户的JavaBean
 * @author TerenceWu
 *
 */
public class User {
	/**
	 * User的私有成员
	 */
	private int userId;
	private String username;
	private String password;
	private String group;
	private String rank;
	private String phonenumber;
	private String mobilephone;
	private String email;
	private boolean isUsed;
	
	/**
	 * 定义一个私有的构造器，下面将用一个静态的工厂方法产生一个User类的实例
	 */
	private User() {
		/**
		 * 初始化私有成员
		 */
		userId = 0;
		username = null;
		password =null;
		group = null;
		rank = null;
		phonenumber = null;
		mobilephone = null;
		email = null;
		isUsed = false;
	}
	
	/**
	 * 静态的工厂方法用于产生一个User类的实例
	 * @return new User()
	 */
	public static User getInstanceOfUser() {
		return new User();
	}
	
	/**
	 * setter和getter方法
	 */
	
	/**
	 * 
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * 
	 * @param targetUserId 需要设置的用户编号
	 */
	public void setUserId(int targetUserId) {
			this.userId = targetUserId;
	}
	
	/**
	 * 
	 * @return username
	 */
	public String getUsername() {
		synchronized (username) {
			return username;
		}
	}
	
	/**
	 * 设置新的用户名
	 * @param targetUsername 需要设置的用户名
	 */
	public void setUsername(String targetUsername) {
		synchronized (username) {
			this.username = targetUsername;
		}
	}
	
	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		synchronized (password) {
			return password;
		}
	}
	
	/**
	 * 设置新的密码
	 * @param targetPassword
	 */
	public void setPassword(String targetPassword) {
		synchronized (password) {
			this.password = targetPassword;
		}
	}
	
	/**
	 * 获取用户所在的业务组
	 * @return group
	 */
	public String getGroup() {
		synchronized (group) {
			return group;
		}
	}
	
	/**
	 * 为用户设置新的业务组
	 * @param targetGroup 需要设置的新的用户组
	 */
	public void setGroup(String targetGroup) {
		synchronized (group) {
			this.group = targetGroup;
		}
	}
	
	/**
	 * 获取用户的职务
	 * @return rank
	 */
	public String getRank() {
		synchronized (rank) {
			return rank;
		}
	}
	
	/**
	 * 为用户设置新的职务
	 * @param targetRank 用户的新职务
	 */
	public void setRank(String targetRank) {
		synchronized (rank) {
			this.rank = targetRank;
		}
	}
	
	public String getPhonenumber() {
		synchronized (phonenumber) {
			return phonenumber;
		}
	}
	
	public void setPhonenumber(String targetPhonenumber) {
		synchronized (phonenumber) {
			this.phonenumber = targetPhonenumber;
		}
	}
	
	public String getMobilephone() {
		synchronized (mobilephone) {
			return mobilephone;
		}
	}
	
	public void setMobilephone(String targetMobilephone) {
		synchronized (mobilephone) {
			this.mobilephone = targetMobilephone;
		}
	}
	
	public String getEmail() {
		synchronized (email) {
			return email;
		}
	}
	
	public void setEmail(String targetEmail) {
		synchronized (email) {
			this.email = targetEmail;
		}
	}
	
	public boolean getIsUsed() {
			return isUsed;
	}
	
	public void setIsUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
}
