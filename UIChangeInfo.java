
/*
 * author:haohaosong 
 * date:2016/12/5
 *  
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
public class UIChangeInfo extends JFrame implements ActionListener 
{  
    //�������  
	JButton jb1,jb2=null;  
    JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4,jp5,jp6=null;  
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5=null;  
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5=null;    
    ButtonGroup bg=null;  
               
    public static void main(String[] args) 
    {  
    	UIAddInfo  ms=new UIAddInfo();  
    }  
    public UIChangeInfo()  
    {  
         //�������  
        jb1=new JButton("ȷ��");  
        jb2=new JButton("����");  
        //���ü���  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
     
        bg=new ButtonGroup();  
          
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel();  
        jp4=new JPanel();                 
        jp5=new JPanel();  
        jp6=new JPanel();
        
        jlb1=new JLabel("������");  
        jlb2=new JLabel("���䣺");
        jlb3=new JLabel("סַ��");
        jlb4=new JLabel("���֤�ţ�");
        jlb5=new JLabel("ְ��");
          
        jtf1=new JTextField(10);  
        jtf2=new JTextField(10); 
        jtf3=new JTextField(10); 
        jtf4=new JTextField(10); 
        jtf5=new JTextField(10); 
        //���뵽JPanel��  
        jp1.add(jlb1);  
        jp1.add(jtf1);  
          
        jp1.add(jlb2);  
        jp1.add(jtf2);
        
        jp1.add(jlb3);  
        jp1.add(jtf3);
        
        jp1.add(jlb4);  
        jp1.add(jtf4);
        
        jp1.add(jlb5);  
        jp1.add(jtf5);  
          
        jp6.add(jb1);
        jp6.add(jb2);
        //����JFrame��  
        this.add(jp1);  
        //this.add(jp2);    
        //this.add(jp3);
        //this.add(jp4);
        //this.add(jp5);
        this.add(jp6);
        //���ò��ֹ�����  
        this.setLayout(new GridLayout(3,1));  
        //���������ñ���  
        this.setTitle("������Ϣ����ϵͳ");  
        //���ô����С  
        this.setSize(600,450);  
        //���ô����ʼλ��  
        this.setLocation(400, 300);  
        //���õ��رմ���ʱ����֤JVMҲ�˳�  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //��ʾ����  
        this.setVisible(true);  
        this.setResizable(true);            
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
          
        if(e.getActionCommand()=="ȷ��")  
        {    
        	    UI u = new UI();
        }
        else if(e.getActionCommand()=="����")  
        {  
            clear();  
        }                      
    }    
    //����ı���������  
    public  void clear()  
    {  
        jtf1.setText("");  
        jtf2.setText("");
        jtf3.setText("");  
        jtf4.setText("");
        jtf5.setText(""); 
    } 
          
}  