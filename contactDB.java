/*
* author:yongfei
* date:2016/12/19
* note：链接数据库的界面
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class connectDb
{
	   Connection con = null;// 创建一个数据库连接
       PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
       
        public void toConnect()
        {
        	try
        	{
        		Class.forName("oracle.jdbc.driver.OracleDriver");
        		String url =  "jdbc:oracle:thin:@localhost:1521:xe";  
        		String user = "system";
        		String password = "123456";
        		con = DriverManager.getConnection(url, user, password); 
        		System.out.println("ok");
        	}
        	catch (Exception e)
        	{
        		System.out.println("connectDb toConnect");
        		e.printStackTrace();
        	}
        }
        
		//链接
        public Connection getCon()
        {
        	return con;
        }
		
		//断开链接
        public void close()
        {
        	try 
        	{
				con.close();
			} 
        	catch (SQLException e) 
        	{
        		e.printStackTrace();
			}
        }
};

