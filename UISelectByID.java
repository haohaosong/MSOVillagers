
/*
 * author:haohaosong 
 * date:2016/12/19
 */
  
import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class UISelectByID extends JFrame implements ActionListener {  
  
    // �������  
    JLabel jl2,jl,jl3,jl4 = null;  
    JTextField jtf,jtf2 = null;  
    JButton jb,jb2 = null;  
    JPanel jp1, jp2,jp3,jp4,jp5,jp6 = null;  
  
    DefaultTableModel model,model2 = null;  
    JTable table,table2 = null;  
    JScrollPane jsp,jsp2 = null;  
  
  public static void main(String[] args) {  
        // TODO Auto-generated method stub  
	  UIChangeInfo t = new UIChangeInfo();  
  }  
  
    // ���캯��  
    public UISelectByID() {  
        // �������       
        jl = new JLabel("������������");  
        jl2=new JLabel("���������֤�ţ�");    
          
        jl3=new JLabel("������Ϣ��");  
          
        jtf = new JTextField(10);  
        jtf2 = new JTextField(10);  
        jb = new JButton("��ѯ");  
        // ���ü���  
        jb.addActionListener(this);  
        // ���ñ��1  
        String[] colnames = { "����", "����", "�Ա�", "���֤��", "���","����", "��ַ"};  
        model = new DefaultTableModel(colnames, 3);  
        table = new JTable(model);  
        jsp = new JScrollPane(table);  
        //���ñ��2  
          
        jp1 = new JPanel();  
        jp2 = new JPanel();  
        jp3 = new JPanel();  
        jp4 = new JPanel();  
        jp5 = new JPanel();  
        jp6 = new JPanel();  
        jp5.setLayout(new BorderLayout());  
        jp6.setLayout(new BorderLayout());  
  
        jp1.add(jl);  
        jp1.add(jtf);  
        jp1.add(jb);  
        jp1.setLayout(new FlowLayout(FlowLayout.LEFT));  
        jp1.setPreferredSize(new Dimension(20,20));  
 
        jp2.add(jsp);  
          
        jp5.add(jl3,BorderLayout.SOUTH);  
  
        this.add(jp1);  
        this.add(jp5);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp6);  
        this.add(jp4);  
          
        this.setLayout(new GridLayout(6, 1));  
        this.setTitle("������Ϣ����ϵͳ");  
        this.setSize(500, 500);  
        this.setLocation(150, 150);  
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
        this.setVisible(true);  
        this.setResizable(false);  
         
    }  
  
    @Override  
    public void actionPerformed(ActionEvent e) {  
    	if(e.getActionCommand()=="��ѯ")  
        {    
        	    //�������ݿ⣬��ѯ��Ϣ
    		jdbcSuccess j = new jdbcSuccess();
    		String ID = jtf.getText();
    		if(jtf.getText().isEmpty())
    		{
    			JOptionPane.showMessageDialog(null,"��������Ҫ��ѯ�����֤�ţ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
    			return;
    		}
    		else
    		{
    			Villager v =j.SelectMethod(2, "'"+ID+"'");
    			if(v == null)
    			{
    				JOptionPane.showMessageDialog(null,"û�и��ˣ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
    				return ;
    			}
    			table.setValueAt(v.getName(), 0, 0);
    	        table.setValueAt(v.getAge(), 0, 1);
    	        table.setValueAt(v.getSex(), 0, 2);
    	        table.setValueAt(v.getID(), 0, 3);
    	        table.setValueAt(v.getMarrage(), 0, 4);
    	        table.setValueAt(v.getNation(), 0, 5);
    	        table.setValueAt(v.getAddress(), 0, 6);
    		}
        }
    }  
     
}  