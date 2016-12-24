/*
 * author:haohaosong 
 * date:2016/12/5
 * note:�޸���Ϣʱ����ѯ�ɹ��󵯳��Ľ��棬���Խ�����Ϣ���޸ģ������޸ĵ�Ϊ��ɫ 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
public class UIChangeInfo2 extends JFrame implements ActionListener 
{  
    //�������  
	JButton jb1,jb2=null;  
    JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jpMain=null;  
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7=null;  
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7,jlbMenu=null;    
    ButtonGroup bg=null;  
    
	//����һ����Ա OldName , ������ȡ�޸���Ϣ�˵�����
    private String OldName;
    
    public static void main(String[] args) 
    {  
    	//UIChangeInfo2  ms=new UIChangeInfo2();  
    }  
    public UIChangeInfo2(Villager v)  
    {  
    	this.OldName = OldName;
         //�������  
        jb1=new JButton("ȷ���޸�");  
        jb2=new JButton("ȡ������");  
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
        
        jlbMenu = new JLabel("��������Ϣ�޸Ľ���");
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
        
		//����ȡ���������ı�������ʾ����
        jtf1.setText(v.getName());
        jtf2.setText(v.getage());
        jtf3.setText(v.getID());
        jtf4.setText(v.getSex());
        jtf5.setText(v.getNation());
        jtf6.setText(v.getMarrage());
        jtf7.setText(v.getAddress());
        jpMain.add(jlbMenu);
        
		//�����ı���������ǲ����޸ĵģ���ʾΪ��ɫ
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
          
        if(e.getActionCommand()=="ȷ���޸�")  
        {    
			//����jdbcSuccess�Ķ��� j ,�������ø���ķ����������ݿ���ļ����в���
        	jdbcSuccess j = new jdbcSuccess();
			
			//���������ı�������ݣ�����һ���������
        	Villager v = new Villager(jtf1.getText(),
        			jtf2.getText(),
        			jtf4.getText(),
        			jtf3.getText(),
        			jtf6.getText(),
        			jtf5.getText(),
        			jtf7.getText());
					
			//���� jdbcSuccess ����ķ����������ݽ��и���
    		j.UpdateMethod(v,OldName);
			
			//���أ��رմ��ڼ���Ϊ���ɼ�
    		this.hide();
        }
        else if(e.getActionCommand()=="ȡ������")  
        {  
			//��տ����޸ĵ��ı���
            clear();  
        }                  
    }    
    //����ı���������  
    public  void clear()  
    {  
		//ֻ��������޸ĵ��ı���
        jtf2.setText("");
        jtf6.setText(""); 
        jtf7.setText(""); 
    } 
}  