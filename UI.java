/*
* author:haohaosong
* date:2016/12/2
* note:Login�����¼�ɹ����������
*/

import java.awt.*;  
import java.awt.event.*;    
import javax.swing.*;  
  
public class UI extends JFrame implements ActionListener  
{   
         //�������  
        JButton jb1,jb2,jb3,jb4=null;  
        JPanel jp1,jp2,jp3,jp4=null;  
        JLabel jlb1,jlb3,jlb4=null;  
          
        public static void main(String[] args) {  
          //���Ըý���
          UI  ui=new UI();  
        }  
          
        //���캯��  
        public  UI()//���캯��
        {  
            //�������  
            jb1=new JButton("���");  
            jb2=new JButton("��ѯ");
            jb3=new JButton("ɾ��"); 
            jb4=new JButton("�޸�"); 
            
            //���ü���  
            jb1.addActionListener(this);  
            jb2.addActionListener(this);   
            jb3.addActionListener(this);  
            jb4.addActionListener(this);  
            
            jp1=new JPanel();  
            jp2=new JPanel();  
            jp3=new JPanel();                
            jp4=new JPanel();
            
            jlb1=new JLabel("���ã���������Ϣ�������");    
            jlb3=new JLabel("ȫ�幫�棺");  
            jlb4=new JLabel("�峤ѡ�ٴ�������ٿ�");  
              
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
              
            //���ò��ֹ�����  
            this.setLayout(new GridLayout(3,3,50,50));  
            this.setTitle("������Ϣ����ϵͳ");  
            this.setSize(400,300);  
            this.setLocation(200, 200);       
            this.setDefaultCloseOperation(HIDE_ON_CLOSE);  
            this.setVisible(true);  
}  
        @Override  
        public void actionPerformed(ActionEvent e) {  
            
			//������ť��Ҫ������ʵ��
            if(e.getActionCommand()=="���")  
            {    
            	add();
            }
            else if(e.getActionCommand()=="��ѯ")  
            {  
                select();  
            }
            else if(e.getActionCommand()=="ɾ��")  
            {  
                delete();  
            }
            else if(e.getActionCommand()=="�޸�")  
            {  
                change();  
            }
        }  
		
		//���µĽ���
        void select()
        {
        	UISelect sele = new UISelect();
        }
        void change()
        {
        	UIChangeInfo c = new UIChangeInfo();
        }
        void delete()
        {
        	UIDel del = new UIDel();
        }
        void add()
        {
        	UIAddInfo addinfo = new UIAddInfo();
        }
}  