
/*
 * author:haohaosong 
 * date:2016/12/19
 * note:按照姓名查询的界面
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
  
public class UISelectByName extends JFrame implements ActionListener {  
  
    // 定义组件  
    JLabel jl2,jl,jl3,jl4 = null;  
    JTextField jtf,jtf2 = null;  
    JButton jb,jb2 = null;  
    JPanel jp1, jp2,jp3,jp4,jp5,jp6 = null;  
  
    DefaultTableModel model,model2 = null;  
    JTable table,table2 = null;  
    JScrollPane jsp,jsp2 = null;  
  
  public static void main(String[] args) {  
      //测试该界面
	  UISelectByName t = new UISelectByName();  
  }  
  
    // 构造函数  
    public UISelectByName() {  
        // 创建组件       
        jl = new JLabel("请输入姓名：");  
        jl2=new JLabel("请输入身份证号：");    
          
        jl3=new JLabel("村民信息表：");  
          
        jtf = new JTextField(10);  
        jtf2 = new JTextField(10);  
        jb = new JButton("查询");  
        // 设置监听  
        jb.addActionListener(this);  
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
    	if(e.getActionCommand()=="查询")  
        {    
        	//调用数据库，查询信息
    		jdbcSuccess j = new jdbcSuccess();
    		
			//字符串获取文本框内容
			String name = jtf.getText();
			
			//文本框为空
    		if(jtf.getText().isEmpty())
    		{
    			JOptionPane.showMessageDialog(null,"请输入需要查询的姓名！","提示消息",JOptionPane.WARNING_MESSAGE); 
    			return;
    		}
    		else//不为空
    		{	
				//v接收查询返回结果
    			Villager v =j.SelectMethod(1, "'"+name+"'");
    			if(v == null)
    			{
    				JOptionPane.showMessageDialog(null,"没有该人！","提示消息",JOptionPane.WARNING_MESSAGE); 
    				return ;
    			}
    			
				//设置文本框的内容
    			table.setValueAt(v.getName(), 0, 0);
    	        table.setValueAt(v.getAge(), 0, 1);
    	        table.setValueAt(v.getSex(), 0, 3);
    	        table.setValueAt(v.getID(), 0, 2);
    	        table.setValueAt(v.getMarrage(), 0, 4);
    	        table.setValueAt(v.getNation(), 0, 5);
    	        table.setValueAt(v.getAddress(), 0, 6);
    		}
        }
    }  
     
}  