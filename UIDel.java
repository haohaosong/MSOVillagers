/*
* author:haohaosong
* date:2016/12/9
* note:信息删除的界面
*/

import java.awt.*;  
import java.awt.event.*;    
import javax.swing.*;  
  
public class UIDel extends JFrame implements ActionListener  
{   
         //定义组件  
        JButton jb1,jb2,jb3,jb4=null;  
        JPanel jp1,jp2,jp3,jp4=null;  
        JLabel jlb1,jlb2,jlb3,jlb4=null;  
        JTextField jf1 = null; 
        
        public static void main(String[] args) {  
            // TODO Auto-generated method stub  
        	UIDel  ui=new UIDel();  
        }  
          
        //构造函数  
        public  UIDel()//构造函数
        {  
            //创建组件  
        	jb1=new JButton("确认删除");  
            jb2=new JButton("取消重置");
            jb1.addActionListener(this);  
            jb2.addActionListener(this);  

            jp1=new JPanel();  
            jp2=new JPanel();  
            jp3=new JPanel();                
            jp4=new JPanel();
            
            jlb1=new JLabel("您好，现在是删除信息界面");    
            jlb2=new JLabel("请输入您要删除人的姓名：");
            jlb3=new JLabel("全村公告：");  
            jlb4=new JLabel("村长选举大会正在召开");  
            
            jf1 = new JTextField(10);
            
            jp1.add(jlb1);  
            jp2.add(jlb2);  
             jp2.add(jf1);
            
            jp3.add(jb1);
            jp3.add(jb2);
             
            jp4.add(jlb3);  
            jp4.add(jlb4);
                       
            this.add(jp1);  
            this.add(jp2);  
            this.add(jp3);      
            this.add(jp4);  
            //设置布局管理器  
            this.setLayout(new GridLayout(5,5,50,50));  
            this.setTitle("村民信息管理系统");  
            this.setSize(600,450);  
            this.setLocation(200, 200);       
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
            this.setVisible(true);  
}  
        @Override  
        public void actionPerformed(ActionEvent e) {  
            
			//单击不同按钮触发的事件
        	if(e.getActionCommand()=="确认删除")  
            {    
				//生成数据库链接成功的对象，对数据库进行操作
        		jdbcSuccess j = new jdbcSuccess();
				
				//获取文本框的姓名
        		String name = jf1.getText();
				
				//如果为空
        		if(jf1.getText().isEmpty())
        		{
        			JOptionPane.showMessageDialog(null,"请输入需要删除的姓名！","提示消息",JOptionPane.WARNING_MESSAGE); 
        			return;
        		}
        		else
        		{
					//v为查询成功后对象的返回值
        			Villager v =j.SelectMethod(1, "'"+name+"'");
					
					//没有查询到
        			if(v == null)
        			{
        				JOptionPane.showMessageDialog(null,"该人不存在！","提示消息",JOptionPane.WARNING_MESSAGE); 
        				return ;
        			}
					
					//查询到了
        			 j.DeleteMethod("'"+name+"'");
					 
					 //提示
        			 JOptionPane.showMessageDialog(null,"删除成功！","提示消息",JOptionPane.WARNING_MESSAGE); 
        			 this.hide();//隐藏该界面
        		}
            }
            else if(e.getActionCommand()=="取消重置")  
            {  
				//清空文本框的内容
            	jf1.setText("");  
            }
        }  
}  