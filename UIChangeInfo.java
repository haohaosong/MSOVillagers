
/*
 * author:haohaosong 
 * date:2016/12/19
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
  
	private String OldName;
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
        // TODO Auto-generated method stub  
	  UIChangeInfo t = new UIChangeInfo();  
  }  
  
    // 构造函数  
    public UIChangeInfo() {  
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
       // jp7=new JPanel();
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
       // jp7.add(jb2);
        
        this.add(jp1);  
        this.add(jp5);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp6);  
        this.add(jp4);  
        //this.add(jp7);
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
    		String name = jtf.getText();
    		if(jtf.getText().isEmpty())
    		{
    			JOptionPane.showMessageDialog(null,"请输入需要查询的姓名！","提示消息",JOptionPane.WARNING_MESSAGE); 
    			return;
    		}
    		else
    		{
    			v = j.SelectMethod(1, "'"+name+"'");
    			if(v == null)
    			{
    				JOptionPane.showMessageDialog(null,"没有该人！","提示消息",JOptionPane.WARNING_MESSAGE); 
    				return ;
    			}
    			OldName = v.getName();
    			
    			table.setValueAt(v.getName(), 0, 0);
    	        table.setValueAt(v.getAge(), 0, 1);
    	        table.setValueAt(v.getSex(), 0, 3);
    	        table.setValueAt(v.getID(), 0, 2);
    	        table.setValueAt(v.getMarrage(), 0, 4);
    	        table.setValueAt(v.getNation(), 0, 5);
    	        table.setValueAt(v.getAddress(), 0, 6);
    		}
        }
    	else if(e.getActionCommand() == "修改")
    	{
    		if(OldName == null)
    		{
    			JOptionPane.showMessageDialog(null,"请输入需要查询的姓名！","提示消息",JOptionPane.WARNING_MESSAGE); 
    			return;
    		}
    		if(OldName.equals(""))
    		{
    			JOptionPane.showMessageDialog(null,"信息已过期，请重新查询！","提示消息",JOptionPane.WARNING_MESSAGE); 
    			return;
    		}
    		UIChangeInfo2 c2 = new UIChangeInfo2(v);
    		OldName = "";
    		/*jdbcSuccess j = new jdbcSuccess();
    		j.UpdateMethod(v, v.getName());*/
    		//调用新的界面，将对象的名字传过去
    	}
    }  
     
}  