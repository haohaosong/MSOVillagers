
/*
 * author:haohaosong 
 * date:2016/12/5
 *  
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
public class UIAddInfo extends JFrame implements ActionListener 
{  
    //�������  
	JButton jb1,jb2=null;  
    JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jpMain=null;  
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7=null;  
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7,jlbMenu=null;    
    ButtonGroup bg=null;  
               
    public static void main(String[] args) 
    {  
    	UIAddInfo  ms=new UIAddInfo();  
    }  
    public UIAddInfo()  
    {  
         //�������  
        jb1=new JButton("ȷ��");  
        jb2=new JButton("����");  
        //���ü���  
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
        
        jlbMenu = new JLabel("��������Ϣ¼�����");
        jlb1=new JLabel("������");  
        jlb2=new JLabel("���䣺");
        jlb3=new JLabel("�Ա�");
        jlb4=new JLabel("���֤�ţ�");
        jlb5=new JLabel("���壺");
        jlb6=new JLabel("���");
        jlb7=new JLabel("סַ��");
          
        jtf1=new JTextField(20);  
        jtf2=new JTextField(20); 
        jtf3=new JTextField(20); 
        jtf4=new JTextField(18); 
        jtf5=new JTextField(20); 
        jtf6=new JTextField(20);
        jtf7=new JTextField(20);
        //���뵽JPanel��  
        
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
       
        //����JFrame��  
        this.add(jpMain);
        this.add(jp1);  
        this.add(jp7);
        this.add(jp2);    
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp8);
        this.add(jp6);
        //���ò��ֹ�����  
        this.setLayout(new GridLayout(10,1));  
        //���������ñ���  
        this.setTitle("������Ϣ����ϵͳ");  
        //���ô����С  
        this.setSize(600,450);  
        //���ô����ʼλ��  
        this.setLocation(400, 300);  
        //���õ��رմ���ʱ����֤JVMҲ�˳�  
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        //��ʾ����  
        this.setVisible(true);  
        this.setResizable(true);            
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
          
        if(e.getActionCommand()=="ȷ��")  
        {    
        	jdbcSuccess j = new jdbcSuccess();
        	Villager v = new Villager(jtf1.getText(),
        			jtf2.getText(),
        			jtf4.getText(),
        			jtf3.getText(),
        			jtf6.getText(),
        			jtf5.getText(),
        			jtf7.getText());
    		j.InsertMethod(v);
    		//���
    		JOptionPane.showMessageDialog(null,"��ӳɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
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
        jtf6.setText(""); 
        jtf7.setText(""); 
    } 
          
}  