/*
* author:yongfei
* date:2016/12/19
* note���������ݿ�Ľ���
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class connectDb
{
	   Connection con = null;// ����һ�����ݿ�����
       PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
       
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
        
		//����
        public Connection getCon()
        {
        	return con;
        }
		
		//�Ͽ�����
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

