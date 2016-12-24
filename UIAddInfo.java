
/*
 * author:haohaosong 
 * date:2016/12/5
 * note:添加信息的界面
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
public class UIAddInfo extends JFrame implements ActionListener 
{  
    //定义组件  
	JButton jb1,jb2=null; 
    JRadioButton jrb1,jrb2=null;   
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jpMain=null;  
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7=null;  
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7,jlbMenu=null;    
    ButtonGroup bg=null;  
               
    public static void main(String[] args) 
    {  
		//测试添加信息界面，生成一个该界面的对象
    	UIAddInfo  ms=new UIAddInfo();  
    }  
    public UIAddInfo()  
    {  
         //创建组件  
        jb1=new JButton("确定");  
        jb2=new JButton("重置");  
        //设置监听  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
     
        bg=new ButtonGroup();  
          
        jpMain = new JPanel();
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel();  
        jp4=new JPanel();                 
        jp5=new JPanel();  
        jp6=new JPanel();
        jp7=new JPanel();
        jp8=new JPanel();
        
        jlbMenu = new JLabel("现在是信息录入界面");
        jlb1=new JLabel("姓名：");  
        jlb2=new JLabel("年龄：");
        jlb3=new JLabel("性别：");
        jlb4=new JLabel("身份证号：");
        jlb5=new JLabel("民族：");
        jlb6=new JLabel("婚否：");
        jlb7=new JLabel("住址：");
          
        jtf1=new JTextField(20);  
        jtf2=new JTextField(20); 
        jtf3=new JTextField(20); 
        jtf4=new JTextField(18); 
        jtf5=new JTextField(20); 
        jtf6=new JTextField(20);
        jtf7=new JTextField(20);
        //加入到JPanel中  
        
        jpMain.add(jlbMenu);
        
        jp1.add(jlb1);  
        jp1.add(jtf1);  
          
        jp7.add(jlb2);  
        jp7.add(jtf2);
        
        jp2.add(jlb3);  
        jp2.add(jtf3);
        
        jp3.add(jlb4);  
        jp3.add(jtf4);
        
        jp4.add(jlb5);  
        jp4.add(jtf5);  
          
        jp5.add(jlb6); 
        jp5.add(jtf6);
        
        jp8.add(jlb7); 
        jp8.add(jtf7);
        
        jp6.add(jb1);
        jp6.add(jb2);
       
        //加入JFrame中  
        this.add(jpMain);
        this.add(jp1);  
        this.add(jp7);
        this.add(jp2);    
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp8);
        this.add(jp6);
        //设置布局管理器  
        this.setLayout(new GridLayout(10,1));  
        //给窗口设置标题  
        this.setTitle("村民信息管理系统");  
        //设置窗体大小  
        this.setSize(600,450);  
        //设置窗体初始位置  
        this.setLocation(400, 300);  
        //设置当关闭窗口时，保证JVM也退出  
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        //显示窗体  
        this.setVisible(true);  
        this.setResizable(true);            
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
          
        if(e.getActionCommand()=="确定")  
        {    
        	jdbcSuccess j = new jdbcSuccess();
        	Villager v = new Villager(jtf1.getText(),
        			jtf2.getText(),
        			jtf4.getText(),//ID
        			jtf3.getText(),//性别
        			jtf6.getText(),
        			jtf5.getText(),
        			jtf7.getText());
        	//判断能否添加
        	if(CheckPass(v) == false)
        	{
        		return ;
        	}
    		j.InsertMethod(v);
    		//添加
    		JOptionPane.showMessageDialog(null,"添加成功！","提示消息",JOptionPane.WARNING_MESSAGE); 
        }
        else if(e.getActionCommand()=="重置")  
        {  
            clear();  
        }                      
    }    
    //清空文本框和密码框  
    public  void clear()  
    {  
        jtf1.setText("");  
        jtf2.setText("");
        jtf3.setText("");  
        jtf4.setText("");
        jtf5.setText(""); 
        jtf6.setText(""); 
        jtf7.setText(""); 
    } 
	
	//检测信息是否正确，通过调用我们写的Check类提供的方法
    boolean CheckPass(Villager v)
    {
    	if(Check.checkName(v.getName()) == false)
    	{
    		JOptionPane.showMessageDialog(null,"姓名中不能包含字母","提示消息",JOptionPane.WARNING_MESSAGE); 
    		return false;
    	}
    	else if(Check.checkAge(v.getAge()) == false)
    	{
    		JOptionPane.showMessageDialog(null,"请输入正确的年龄！","提示消息",JOptionPane.WARNING_MESSAGE); 
    		return false;
    	}
    	else if(Check.checkSex(v.getSex()) == false)
    	{
    		JOptionPane.showMessageDialog(null,"请输入正确的性别！","提示消息",JOptionPane.WARNING_MESSAGE); 
    		return false;
    	}
    	else if(Check.checkID(v.getID()) == false)
    	{
    		JOptionPane.showMessageDialog(null,"请输入正确的身份证号！","提示消息",JOptionPane.WARNING_MESSAGE); 
    		return false;
    	}
    	else if(Check.checkNation(v.getNation()) == false)
    	{
    		JOptionPane.showMessageDialog(null,"请输入正确的民族信息！","提示消息",JOptionPane.WARNING_MESSAGE); 
    		return false;
    	}
    	else if(Check.checkMarrage(v.getMarrage())==false)
    	{
    		JOptionPane.showMessageDialog(null,"请输入正确的婚姻状况！","提示消息",JOptionPane.WARNING_MESSAGE); 
    		return false;
    	}
    	else if(Check.checkAddress(v.getAddress())==false)
    	{
    		JOptionPane.showMessageDialog(null,"请输入正确的家庭住址！","提示消息",JOptionPane.WARNING_MESSAGE); 
    		return false;
    	}
    	return true;
    }
}  