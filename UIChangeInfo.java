
/*
 * author:haohaosong 
 * date:2016/12/19
 * note:信息修改的界面
 */
  
import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class UIChangeInfo extends JFrame implements ActionListener {  
  
	//定义私有成员  旧的名字
	private String OldName;
	
	//定义一个村民类，方便进行参数传递
	private Villager v;
	
    // 定义组件  
    JLabel jl2,jl,jl3,jl4 = null;  
    JTextField jtf = null;
    JButton jb,jb2 = null;  
    JPanel jp1, jp2,jp3,jp4,jp5,jp6,jp7 = null;  
  
    DefaultTableModel model,model2 = null;  
    JTable table,table2 = null;  
    JScrollPane jsp,jsp2 = null;  
  
  public static void main(String[] args) {  
        //测试该界面
	  UIChangeInfo t = new UIChangeInfo();  
  }  
  
    // 构造函数  
    public UIChangeInfo() 
	{  
        // 创建组件       
        jl = new JLabel("请输入姓名：");  
        jl2=new JLabel("请输入身份证号：");    
          
        jl3=new JLabel("村民信息表：");  
          
        jtf = new JTextField(10);  
       // jtf2 = new JTextField(10);  
        jb = new JButton("查询");  
        jb2 = new JButton("修改");
        // 设置监听  
        jb.addActionListener(this);  
        jb2.addActionListener(this);
        // 设置表格1  
        String[] colnames = { "姓名", "年龄", "性别", "身份证号", "婚否","民族", "地址"};  
        model = new DefaultTableModel(colnames, 3);  
        table = new JTable(model);  
        jsp = new JScrollPane(table);  
        //设置表格2  
          
        jp1 = new JPanel();  
        jp2 = new JPanel();  
        jp3 = new JPanel();  
        jp4 = new JPanel();  
        jp5 = new JPanel();  
        jp6 = new JPanel();  
      
        jp5.setLayout(new BorderLayout());  
        jp6.setLayout(new BorderLayout());  
        jp3.add(jb2);
        jp1.add(jl);  
        jp1.add(jtf);  
        jp1.add(jb);  
        jp1.setLayout(new FlowLayout(FlowLayout.LEFT));  
        jp1.setPreferredSize(new Dimension(20,20));  
 
        jp2.add(jsp);  
          
        jp5.add(jl3,BorderLayout.SOUTH);  
       
        
        this.add(jp1);  
        this.add(jp5);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp6);  
        this.add(jp4);  
       
        this.setLayout(new GridLayout(6, 1));  
        this.setTitle("村民信息管理系统");  
        this.setSize(500, 500);  
        this.setLocation(150, 150);  
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
        this.setVisible(true);  
        this.setResizable(false);  
         
    }  
  
    @Override  
    public void actionPerformed(ActionEvent e) {  
    	if(e.getActionCommand()=="查询")  //单击查询后
        {    
        	//调用数据库，查询信息
    		jdbcSuccess j = new jdbcSuccess();
			
			//从文本框获取姓名
    		String name = jtf.getText();
			
			//如果该文本框为空
    		if(jtf.getText().isEmpty())
    		{
				//提示消息	
    			JOptionPane.showMessageDialog(null,"请输入需要查询的姓名！","提示消息",JOptionPane.WARNING_MESSAGE); 
    			return;
    		}
    		else//不为空则进行查询
    		{
				//v作为查询成功后的对象进行返回，没查询到为空
    			v = j.SelectMethod(1, "'"+name+"'");
				
				//没有查询到
    			if(v == null)
    			{
    				JOptionPane.showMessageDialog(null,"没有该人！","提示消息",JOptionPane.WARNING_MESSAGE); 
    				return ;
    			}
				
				//查询到后
    			OldName = v.getName();
    			
				//将表格中的元素设置为查询到的内容，通过调用获取村民内部属性的方法
    			table.setValueAt(v.getName(), 0, 0);
    	        table.setValueAt(v.getAge(), 0, 1);
    	        table.setValueAt(v.getSex(), 0, 3);
    	        table.setValueAt(v.getID(), 0, 2);
    	        table.setValueAt(v.getMarrage(), 0, 4);
    	        table.setValueAt(v.getNation(), 0, 5);
    	        table.setValueAt(v.getAddress(), 0, 6);
    		}
        }
    	else if(e.getActionCommand() == "修改")//单击修改后
    	{
			//如果oldname 没有被赋值，说明没有查询
    		if(OldName == null)
    		{	
				//提示请先查询
    			JOptionPane.showMessageDialog(null,"请输入需要查询的姓名！","提示消息",JOptionPane.WARNING_MESSAGE); 
    			return;
    		}
			//如果查询了，但是为空，说明信息过期
    		if(OldName.equals(""))
    		{
    			JOptionPane.showMessageDialog(null,"信息已过期，请重新查询！","提示消息",JOptionPane.WARNING_MESSAGE); 
    			return;
    		}
			
			//进行查询
    		UIChangeInfo2 c2 = new UIChangeInfo2(v);
    		OldName = "";//将oldname置为空
    	}
    }  
     
}  