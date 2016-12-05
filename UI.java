/*
* author:haohaosong,cx
* date:2016/12/2
* note:The UI window when the admin login in
*/

import java.awt.*;  
import java.awt.event.*;    
import javax.swing.*;  
  
public class UI extends JFrame implements ActionListener  
{   
         //定义组件  
        JButton jb1,jb2,jb3,jb4=null;  
        JPanel jp1,jp2,jp3,jp4=null;  
        JLabel jlb1,jlb3,jlb4=null;  
          
        public static void main(String[] args) {  
            // TODO Auto-generated method stub  
          UI  ui=new UI();  
        }  
          
        //构造函数  
        public  UI()//构造函数
        {  
            //创建组件  
            jb1=new JButton("添加");  
            jb2=new JButton("查询");
            jb3=new JButton("删除"); 
            jb4=new JButton("修改"); 

            jp1=new JPanel();  
            jp2=new JPanel();  
            jp3=new JPanel();                
            jp4=new JPanel();
            
            jlb1=new JLabel("您好，现在是信息管理界面");    
            jlb3=new JLabel("全村公告：");  
            jlb4=new JLabel("村长选举大会正在召开");  
              
            jp1.add(jlb1);  
              
            jp2.add(jb1);  
            jp2.add(jb2);  
            jp2.add(jb3);
            jp2.add(jb4);

            
            jp3.add(jlb3);  
            jp3.add(jlb4);
                       
            this.add(jp1);  
            this.add(jp2);  
            this.add(jp3);      
              
            //设置布局管理器  
            this.setLayout(new GridLayout(3,3,50,50));  
            this.setTitle("村民信息管理系统");  
            this.setSize(400,300);  
            this.setLocation(200, 200);       
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            this.setVisible(true);  
}  
        @Override  
        public void actionPerformed(ActionEvent e) {  
            // TODO Auto-generated method stub  
              
        }  
}  