package songbiandian.jdbc;

import java.sql.*;

/**
 * 这是一个用于进行数据库连接的类
 * @author TerenceWu
 *
 */
public class DBConn {
	/**
	 * 定义私有成员，包括Statement,Connection,ResultSet
	 */
	private Statement statement;
	private Connection connection;
	private ResultSet resultSet;
	
	/**
	 * 静态工厂方法,用于创建一个数据框连接对象
	 * @return new DBConn()
	 */
	public static DBConn getInstanceOfDBConn() {
		return new DBConn();
	}
	
	/**
	 * 私有构造器，在构造器中进行数据库连接
	 */
	private DBConn() {
		/**
		 * 初始化statement和resultSet
		 */
		statement = null;
		resultSet = null;
		
		/**
		 * 数据库连接需要的参数:url,user,password
		 */
		String url = "jdbc:mysql://localhost:3306/electrical_measurement_mis";
		String user = "root";
		String password = "0226";
		
		/**
		 * 创建连接，并且初始化connection
		 */
		try {
			//加载并且注册MySQL5.5的JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			connection = DriverManager.getConnection(url, user, password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return connection
	 */
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * 执行SQL语句
	 * @param sql SQL语句
	 * @return resultSet
	 */
	public ResultSet executeQuery(String sql) {
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//执行查询语句
			resultSet = statement.executeQuery(sql);
		}
		catch (SQLException e) {
			System.err.println("Data.executeQuery: "+e.getMessage());
		}
		
		//返回结果集
		return resultSet;
	}
	
	/**
	 * 关闭statement对象
	 */
	public void closeStatement() {
		try {
			statement.close();
		}
		catch (SQLException e) {
			System.err.println("Data.executeQuery: "+e.getMessage());
		}
	}
		
	/**
	 * 关闭数据库连接
	 */
	public void closeConnection() {
		try {
			connection.close();
		}
		catch (SQLException e) {
			System.err.println("Data.executeQuery: "+e.getMessage());
		}
	}
}