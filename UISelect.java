
/*
* author:haohaosong
* date:2016/12/5
* note:The UISelect window when the admin want to select the information
*/

import java.awt.*;  
import java.awt.event.*;    
import javax.swing.*;  
  
public class UISelect extends JFrame implements ActionListener  
{   
         //�������  
        JButton jb1,jb2,jb3,jb4=null;  
        JPanel jp1,jp2,jp3,jp4=null;  
        JLabel jlb1,jlb3,jlb4=null;  
          
        public static void main(String[] args) {  
            // TODO Auto-generated method stub  
        	UISelect  ui=new UISelect();  
        }  
          
        //���캯��  
        public  UISelect()//���캯��
        {  
            //�������  
            jb1=new JButton("��������ѯ");  
            jb3=new JButton("�����֤��"); 
            jb1.addActionListener(this);
            jb3.addActionListener(this);
            
            jp1=new JPanel();  
            jp2=new JPanel();  
            jp3=new JPanel();                
            jp4=new JPanel();
            
            jlb1=new JLabel("���ã���������Ϣ��ѯ����");    
            jlb3=new JLabel("ȫ�幫�棺");  
            jlb4=new JLabel("�峤ѡ�ٴ�������ٿ�");  
              
            jp1.add(jlb1);  
            jp2.add(jb1);  
            //jp2.add(jb2);  
            jp2.add(jb3);
                        
            jp3.add(jlb3);  
            jp3.add(jlb4);
                       
            this.add(jp1);  
            this.add(jp2);  
            this.add(jp3);      
              
            //���ò��ֹ�����  
            this.setLayout(new GridLayout(4,5,50,50));  
            this.setTitle("������Ϣ����ϵͳ");  
            this.setSize(450,350);  
            this.setLocation(200, 200);       
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
            this.setVisible(true);  
}  
        @Override  
        public void actionPerformed(ActionEvent e) 
        {  
        	if(e.getActionCommand()=="��������ѯ")  
            {    
            	   UISelectByName bn = new UISelectByName();
            }
            else if(e.getActionCommand()=="�����֤��")
            {
            	UISelectByID bn = new UISelectByID();
            }
        }  
}  