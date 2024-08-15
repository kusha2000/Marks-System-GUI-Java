import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class SelectAllQuary{
	//public static void main(String[] args){
	ResultSet r;
	JTable jt;
	public void selectall(){
		JFrame jf=new JFrame("Display all Record");
		JPanel jp=new JPanel();
	    jp.setLayout(null);
	    jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    jp.setBackground(Color.darkGray);


	    JLabel jl1=new JLabel("Select All Record");
	    jl1.setBounds(400,20,800,40);
	    jl1.setFont(new Font("Arial",Font.BOLD,50));
	    jl1.setForeground(Color.blue);
	    jp.add(jl1);

	    JButton jb3=new JButton("Exit");
	    jb3.setBounds(1200,640,100,50);
	    jb3.setFont(new Font("Arial",Font.BOLD,20));
	    jb3.addActionListener(new MyListenerExit());
	    jp.add(jb3);

	    try{
                String [][] records = {};
			    String [] hedar={"Index no","Name","T_Marks","P_Marks"};
			    jt=new JTable(records,hedar);
			    jt.setRowHeight(20);
			    Font font=new Font("Arial",Font.BOLD,20);
			    jt.setFont(font);
			    JTableHeader tableHeader = jt.getTableHeader();
			    tableHeader.setFont(font);
			    tableHeader.setForeground(Color.green);
			    jt.getColumnModel().getColumn(1).setPreferredWidth(700);
			    JScrollPane jsp=new JScrollPane(jt);
			    jsp.setBounds(40,80,1300,540);
			    jp.add(jsp);

				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"Please enter Correct Index");
				}

	    try{
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatagui","root","");
			Statement stmt=con.createStatement();
	    	r=stmt.executeQuery("select * from marks");
	    	jt.setModel(DbUtils.resultSetToTableModel(r));


	    }catch(Exception e){
	    	JOptionPane.showMessageDialog(null,e);
	    }

	   	jf.add(jp);
	    jf.setVisible(true);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
}

