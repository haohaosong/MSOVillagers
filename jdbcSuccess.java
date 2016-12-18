
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcSuccess
{
	public static void main(String[] argv) 
	{
		connectDb db = new connectDb();
		db.toConnect();
		Connection con = db.getCon();

		alter alt = new alter();
		alt.toChose(con, 1);

		query que = new query();
		ResultSet result = que.toChoose(con, 1);
		
        try 
        {
			while (result.next())   
			    System.out.println(result.getString("name")+result.getString("age"));
		} 
        catch (SQLException e)
        {
        	System.out.println("print wrong");
			e.printStackTrace();
		}
		db.close();	
	}
};

class query 
{
	public ResultSet toChoose(Connection con, int chose)//三个表格，一个连接查询
	{
		String sql = null;
		if(chose == 1)
		{
			sql = "select * from worker_main";
		}
		else if(chose == 2)
		{
			sql = "select * from worker_detail";//进行连接查询###
		}
		else if(chose == 3)
		{
			sql = "select * from product_info";
		}
		sql = "select * from student";
		return queryAll(con, sql);
	}
	
	private static ResultSet queryAll(Connection con, String sql)
	{
		PreparedStatement pre = null;
		ResultSet result = null;
		try 
		{
			pre = con.prepareStatement(sql);
			result = pre.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;//返回结果进行选择输出
	}
}

class QueryByTerms
{
	int MAX_NUM = 0; //##get from database
	int workerId = 41;//get workId from the window##########
	int index = 1;
	String workerName = "zhang";
	String productName = "辣条";
	int productId = 1002;

	public ResultSet toChoose(Connection con, int chose, String var)
	{
		String sql = null;
		switch(chose)
		{
		case 1:
			sql = "select * from worker_main where worker_id = ?";
			var = String.valueOf(workerId);
			break;
		case 2:
			sql = "select * from worker_main where name = ?";
			var = workerName;
			break;
		case 3:
			sql = "select * from product_info where product_id = ?";
			var = String.valueOf(productId);
			break;
		case 4:
			sql = "select * from product_info where product_name = ?";
			var = productName;
			break;
		}
		sql = "select * from student where age = ?";
		return queryByTerms(con, sql, index, var);
	}

	private static ResultSet queryByTerms(Connection con, String sql, int index, String var)//调用时候进行判断
	{
		PreparedStatement pre = null;
		ResultSet result = null;
		try 
		{
			pre = con.prepareStatement(sql);
			pre.setString(index, var);
			result = pre.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;//返回结果进行选择输出
	}
};


//
 class QueryStronger
 {
	int MAX_NUM = 0; //##get from database
	int workerId = 41;//get workId from the window##########
	int index = 1;
	String workerName = "zhang";
	String productName = "辣条";
	int productId = 1002;

	public ResultSet toChoose(Connection con, int chose, String var)
	{
		int tag = 0;
		String sql = null;
		switch(chose)
		{
		case 1:
			sql = "select * from worker_main where worker_id = ?";
			var = String.valueOf(workerId);
			tag = 1;
			break;
		case 2:
			sql = "select * from worker_main where name = ?";
			var = workerName;
			tag = 2;
			break;
		case 3:
			sql = "select * from product_info where product_id = ?";
			var = String.valueOf(productId);
			tag = 3;
			break;
		case 4:
			sql = "select * from product_info where product_name = ?";
			var = productName;
			tag = 4;
			break;
		case 5:
			sql = "select * from worker_main";
			tag = 5;
			break;
		case 6:
			sql = "select * from worker_detail";
			tag = 6;
			break;
		case 7:
			sql = "select * from product_info";
			tag = 8;
			break;
		}
		
		sql = "select * from student where age = ?";
		
		return queryByTerms(con, sql, index, var, tag);
	}

	
	private static ResultSet queryByTerms(Connection con, String sql, int index, String var, int tag)//调用时候进行判断
	{
		PreparedStatement pre = null;
		ResultSet result = null;
		try 
		{
			pre = con.prepareStatement(sql);
			if (tag >= 4)//如果大于等于四进行的是条件查询，否则进行的全部查询
			{
				pre.setString(index, var);
			}
			result = pre.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;//返回结果进行选择输出
	}
};
class alter
{
	int workerId = 18;//get those from window
	String name = null;
	int age = 0;
	String sex = null;
	String position = null;
	String sql = null;
	String str = "zhangxin";
	int index = 1;
	String var = String.valueOf(workerId);
	
	public int toChose(Connection con, int chose)
	{
		if (chose == 1)
		{
			str = " name="+name+ " age="+String.valueOf(age)+" sex="+sex + " position="+position;
			sql = "update worker_main set "+str +" where  workerid = ?";
		}
		else if (chose == 2)
		{
			str = " name="+name+ " age="+String.valueOf(age)+" sex="+sex + " position="+position;
			sql = "update worker_detail set "+ str + "where workerid = ?";
		}
		else if (chose == 3)
		{
			str = " name="+name+ " age="+String.valueOf(age)+" sex="+sex + " position="+position;
			sql = "update product_info set name "+ str +" where age = ?";
		}
		str = "wang";
		sql = "update student set name ='"+ str +"' where age=?";//注意在sql语句中如果是字符串的要加单引号
		return alterData(con ,sql, index, var);
	}
	
	private int alterData(Connection con ,String sql, int index, String var)
	{
		PreparedStatement pre = null;
		int result = 0;
		try 
		{
			pre = con.prepareStatement(sql);
			pre.setString(index, var);
			result = pre.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println("alter wrong");
			e.printStackTrace();
		}
		return result;
	}
}