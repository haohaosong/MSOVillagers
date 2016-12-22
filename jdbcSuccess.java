
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class jdbcSuccess
{
	public Villager SelectMethod(int chose ,String selectmethod) 
	{
		connectDb db = new connectDb();
		db.toConnect();
		Connection con = db.getCon();

		alter alt = new alter();
		alt.toChose(con, 1);

		query que = new query();
		ResultSet result = que.toSelect(con, chose,selectmethod);
        
		try 
        {
        	if(result.next())   
			{    
				//����һ�����������
        		Villager v = new Villager(result.getString("name"),result.getString("age"),
        				result.getString("sex"),result.getString("ID"),result.getString("marrage"),
        				result.getString("nation"),result.getString("address"));
				//��ӡ�ô������
					return v;
			}
        }
        catch (SQLException e)
        {
        	System.out.println("print wrong");
			e.printStackTrace();
		}
		db.close();	
		return null;
	}
	
	public Villager DeleteMethod(String selectmethod) 
	{
		connectDb db = new connectDb();
		db.toConnect();
		Connection con = db.getCon();

		alter alt = new alter();
		alt.toChose(con, 1);

		query que = new query();
		que.toDel(con, selectmethod);
        
		db.close();	
		return null;
	}
	public Villager InsertMethod(Villager v) 
	{
		connectDb db = new connectDb();
		db.toConnect();
		Connection con = db.getCon();

		alter alt = new alter();
		alt.toChose(con, 1);

		query que = new query();
		que.toInsert(con, v);
        
		db.close();	
		return null;
	}
	public Villager UpdateMethod(Villager v,String OldName) 
	{
		connectDb db = new connectDb();
		db.toConnect();
		Connection con = db.getCon();

		alter alt = new alter();
		alt.toChose(con, 1);

		query que = new query();
        que.toUpdate(con,v,OldName);
		db.close();	
		return null;
	}
};

class query 
{
	public ResultSet toUpdate(Connection con, Villager v,String name)
	{
		String sql = null;
		name = "'"+v.getName()+"'";
		System.out.println("hello");
		/*if(!v.getName().equals(""))
		{
			if(Check.checkName(v.getName()) == false)
	    	{
	    		JOptionPane.showMessageDialog(null,"�����в��ܰ�����ĸ","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
	    		return null;
	    	}
			sql = "update villager set name = '"+v.getName()+ "'where name = " + name;//����������ѯ
			name = "'"+v.getName()+"'";
			System.out.println(sql);
			queryAll(con, sql);
		}*/
		if(!v.getMarrage().equals(""))
		{
			if(Check.checkMarrage(v.getMarrage())==false)
	    	{
	    		JOptionPane.showMessageDialog(null,"��������ȷ�Ļ���״����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
	    		return null;
	    	}
			sql = "update villager set marrage ='"+v.getMarrage()+ "'where name = " + name;//����������ѯ
			queryAll(con, sql);
		}
		if(v.getAge()!=0)
		{
			if(Check.checkAge(v.getAge()) == false)
	    	{
	    		JOptionPane.showMessageDialog(null,"��������ȷ�����䣡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
	    		return null;
	    	}
			sql = "update villager set age = "+v.getAge()+ "where name = " + name;//����������ѯ
			queryAll(con, sql);
		}
		/*if(!v.getSex().equals(""))
		{
			 if(Check.checkSex(v.getSex()) == false)
		    {
		    		JOptionPane.showMessageDialog(null,"��������ȷ���Ա�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
		    		return null;
		    }
			sql = "update villager set sex = '"+v.getSex()+ "'where name = " + name;//����������ѯ
			queryAll(con, sql);
		}
		if(!v.getNation().equals(""))
		{
			if(Check.checkNation(v.getNation()) == false)
	    	{
	    		JOptionPane.showMessageDialog(null,"��������ȷ��������Ϣ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
	    		return null;
	    	}
			sql = "update villager set nation = '"+v.getNation()+ "'where name = " + name;//����������ѯ
			queryAll(con, sql);
		}
		if(!v.getID().equals(""))
		{
			if(Check.checkID(v.getID()) == false)
	    	{
	    		JOptionPane.showMessageDialog(null,"��������ȷ�����֤�ţ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
	    		return null;
	    	}
			sql = "update villager set ID = '"+v.getID()+ "'where name = " + name;//����������ѯ
			queryAll(con, sql);
		}*/
		if(!v.getAddress().equals(""))
		{
			if(Check.checkAddress(v.getAddress())==false)
	    	{
	    		JOptionPane.showMessageDialog(null,"��������ȷ�ļ�ͥסַ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
	    		return null;
	    	}
			sql = "update villager set address = '"+v.getAddress()+ "'where name = " + name;//����������ѯ
			queryAll(con, sql);
		}
		JOptionPane.showMessageDialog(null,"�޸ĳɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
		return queryAll(con, sql);
	}
	
	public ResultSet toSelect(Connection con, int chose,String selectmethod)
	{
		String sql = null;
		switch(chose)
		{
		case 1:
			sql = "select * from villager where name = "+selectmethod;//����������ѯ
			break;
		case 2:
			sql = "select * from villager where ID =  "+selectmethod;//�������֤�Ų�ѯ
			break;
		case 3:
			sql = "select * from villager where address =  "+selectmethod;//���յ�ַ��ѯ
			break;
		}
		System.out.println(sql);
		return queryAll(con, sql);
	}
	public void toDel(Connection con, String name)
	{
		String sql = null;
		sql = "delete from villager where name = "+name;//��������ɾ��
		System.out.println(sql);
		queryAll(con, sql);
	}
	public void toInsert(Connection con, Villager v)
	{
		String sql = null;
		
		String name = "'"+v.getName()+"'";
		String age = "'"+String.valueOf(v.getAge())+"'";
		String sex = "'"+v.getSex()+"'";
		String marrage ="'"+ v.getMarrage()+"'";
		String address = "'"+v.getAddress()+"'";
		String ID = "'"+v.getID()+"'";
		String nation = "'"+v.getNation()+"'";
		sql = "insert into villager values ("+name+","+age+","
				+sex+","+ID+","+marrage+","+nation+","+address+")";
		System.out.println(sql);
		queryAll(con, sql);
	}
	
	private static ResultSet queryAll(Connection con, String sql)
	{
		System.out.println(sql);
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
		return result;//���ؽ������ѡ�����
	}
}
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
		sql = "update student set name ='"+ str +"' where age=?";//ע����sql�����������ַ�����Ҫ�ӵ�����
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