/*
* author:haohaosong
* date:2016/12/9
* note:The UIDelete interface when the admin wants to delete the information
*/

import java.awt.*;  
import java.awt.event.*;    
import javax.swing.*;  
  
public class UIDel extends JFrame implements ActionListener  
{   
         //�������  
        JButton jb1,jb2,jb3,jb4=null;  
        JPanel jp1,jp2,jp3,jp4=null;  
        JLabel jlb1,jlb2,jlb3,jlb4=null;  
        JTextField jf1 = null; 
        
        public static void main(String[] args) {  
            // TODO Auto-generated method stub  
        	UIDel  ui=new UIDel();  
        }  
          
        //���캯��  
        public  UIDel()//���캯��
        {  
            //�������  
        	jb1=new JButton("ȷ��ɾ��");  
            jb2=new JButton("ȡ������");
            jb1.addActionListener(this);  
            jb2.addActionListener(this);  

            jp1=new JPanel();  
            jp2=new JPanel();  
            jp3=new JPanel();                
            jp4=new JPanel();
            
            jlb1=new JLabel("���ã�������ɾ����Ϣ����");    
            jlb2=new JLabel("��������Ҫɾ���˵�������");
            jlb3=new JLabel("ȫ�幫�棺");  
            jlb4=new JLabel("�峤ѡ�ٴ�������ٿ�");  
            
            jf1 = new JTextField(10);
            
            jp1.add(jlb1);  
            jp2.add(jlb2);  
             jp2.add(jf1);
            //jp2.add(jb2);  
           // jp2.add(jb3);
            //jp2.add(jb4);
            
            jp3.add(jb1);
            jp3.add(jb2);
             
            jp4.add(jlb3);  
            jp4.add(jlb4);
                       
            this.add(jp1);  
            this.add(jp2);  
            this.add(jp3);      
            this.add(jp4);  
            //���ò��ֹ�����  
            this.setLayout(new GridLayout(5,5,50,50));  
            this.setTitle("������Ϣ����ϵͳ");  
            this.setSize(600,450);  
            this.setLocation(200, 200);       
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
            this.setVisible(true);  
}  
        @Override  
        public void actionPerformed(ActionEvent e) {  
            // TODO Auto-generated method stub  
        	if(e.getActionCommand()=="ȷ��ɾ��")  
            {    
            	    //�������ݿ⣬ɾ����Ϣ
            }
            else if(e.getActionCommand()=="ȡ������")  
            {  
            	jf1.setText("");  
            }
        }  
}  