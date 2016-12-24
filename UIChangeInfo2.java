/*
 * author:haohaosong 
 * date:2016/12/5
 * note:修改信息时，查询成功后弹出的界面，可以进行信息的修改，不可修改的为灰色 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
public class UIChangeInfo2 extends JFrame implements ActionListener 
{  
    //定义组件  
	JButton jb1,jb2=null;  
    JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jpMain=null;  
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7=null;  
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7,jlbMenu=null;    
    ButtonGroup bg=null;  
    
	//定义一个成员 OldName , 用来存取修改信息人的姓名
    private String OldName;
    
    public static void main(String[] args) 
    {  
    	//UIChangeInfo2  ms=new UIChangeInfo2();  
    }  
    public UIChangeInfo2(Villager v)  
    {  
    	this.OldName = OldName;
         //创建组件  
        jb1=new JButton("确定修改");  
        jb2=new JButton("取消重置");  
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
        
        jlbMenu = new JLabel("现在是信息修改界面");
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
        
		//将获取的内容在文本框上显示出来
        jtf1.setText(v.getName());
        jtf2.setText(v.getage());
        jtf3.setText(v.getID());
        jtf4.setText(v.getSex());
        jtf5.setText(v.getNation());
        jtf6.setText(v.getMarrage());
        jtf7.setText(v.getAddress());
        jpMain.add(jlbMenu);
        
		//设置文本框的内容是不可修改的，显示为灰色
        jtf1.setEditable(false);
        jtf3.setEditable(false);
        jtf4.setEditable(false);
        jtf5.setEditable(false);
        
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
          
        if(e.getActionCommand()=="确定修改")  
        {    
			//生成jdbcSuccess的对象 j ,用来调用该类的方法来对数据库的文件进行操作
        	jdbcSuccess j = new jdbcSuccess();
			
			//根据输入文本框的内容，生成一个村民对象
        	Villager v = new Villager(jtf1.getText(),
        			jtf2.getText(),
        			jtf4.getText(),
        			jtf3.getText(),
        			jtf6.getText(),
        			jtf5.getText(),
        			jtf7.getText());
					
			//调用 jdbcSuccess 里面的方法，对数据进行更新
    		j.UpdateMethod(v,OldName);
			
			//隐藏，关闭窗口即设为不可见
    		this.hide();
        }
        else if(e.getActionCommand()=="取消重置")  
        {  
			//清空可以修改的文本框
            clear();  
        }                  
    }    
    //清空文本框和密码框  
    public  void clear()  
    {  
		//只情况可以修改的文本框
        jtf2.setText("");
        jtf6.setText(""); 
        jtf7.setText(""); 
    } 
}  