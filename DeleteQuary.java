import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.JTableHeader;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.sql.*;
	public class DeleteQuary{
	//public static void main(String[] args){
	JTextField jtf;
	ResultSet rs;
	JPanel jp;
	public void delete(){
		JFrame jf=new JFrame("Select a Record");
		jp=new JPanel();
	    jp.setLayout(null);
	    jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    jp.setBackground(Color.darkGray);


	    JLabel jl1=new JLabel("Delete a Record");
	    jl1.setBounds(400,50,800,70);
	    jl1.setFont(new Font("Arial",Font.BOLD,80));
	    jl1.setForeground(Color.blue);
	    jp.add(jl1);

	    JLabel jl2=new JLabel("Enter Your Index Number:");
	    jl2.setBounds(100,230,600,50);
	    jl2.setFont(new Font("Arial",Font.PLAIN,50));
	    jl2.setForeground(Color.white);
	    jp.add(jl2);

	    jtf=new JTextField(20);
	    jtf.setBounds(700,230,600,50);
	    jtf.setFont(new Font("Arial",Font.BOLD,50));
	    jp.add(jtf);

	    emptyTable();

	    JButton jb1=new JButton("Submit");
	    jb1.setBounds(1200,320,100,50);
	    jb1.setFont(new Font("Arial",Font.BOLD,20));
	    jb1.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		sql();
	    	}
	    });
	    jp.add(jb1);

	    JButton jb2=new JButton("Delete");
	    jb2.setBounds(700,580,300,90);
	    jb2.setFont(new Font("Arial",Font.BOLD,80));
	    jb2.setForeground(Color.red);
	    jb2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		delsql();
	    	}
	    });
	    jp.add(jb2);

	    JButton jb4=new JButton("Clear");
	    jb4.setBounds(1050,600,100,50);
	    jb4.setFont(new Font("Arial",Font.BOLD,20));
	    jb4.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		jtf.setText("");
	    		emptyTable();
	    	}
	    });
	    jp.add(jb4);

	    JButton jb3=new JButton("Exit");
	    jb3.setBounds(1200,600,100,50);
	    jb3.setFont(new Font("Arial",Font.BOLD,20));
	    jb3.addActionListener(new MyListenerExit());
	    jp.add(jb3);

	    

	   	jf.add(jp);
	    jf.setVisible(true);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
	public void sql(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatagui","root","");
			Statement stmt=con.createStatement();
			rs=stmt.executeQuery("SELECT * from marks where st_index='"+jtf.getText()+"' "); 
			rs.next();
			table();
		    con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}

	}
	public void table(){
		try{
			String [][] records = {{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)}};
		    String [] hedar={"Index no","Name","T_Marks","P_Marks"};
		    JTable jt=new JTable(records,hedar);
		    jt.setRowHeight(80);
		    Font font=new Font("Arial",Font.BOLD,40);
		    jt.setFont(font);
		    JTableHeader tableHeader = jt.getTableHeader();
		    tableHeader.setFont(font);
		    tableHeader.setForeground(Color.green);
		    jt.getColumnModel().getColumn(1).setPreferredWidth(700);
		    JScrollPane jsp=new JScrollPane(jt);
		    jsp.setBounds(50,420,1300,135);
		    jp.add(jsp);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"You entered wrong index number");
		}
	}
	public void delsql(){
		try{
			int result = JOptionPane.showConfirmDialog(null,"Do you want to delete?", "Delete",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatagui","root","");
				Statement stmt=con.createStatement();
				stmt.executeUpdate("DELETE FROM marks where st_index='"+jtf.getText()+"' "); 
			    con.close();

			    jtf.setText("");
			    emptyTable();
            }else if (result == JOptionPane.NO_OPTION){
               
            }else {
               
            }
			

		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	}
	public void emptyTable(){
		 try{
			String [][] records = {};
		    String [] hedar={"Index no","Name","T_Marks","P_Marks"};
		    JTable jt=new JTable(records,hedar);
		    jt.setRowHeight(80);
		    Font font=new Font("Arial",Font.BOLD,40);
		    jt.setFont(font);
		    JTableHeader tableHeader = jt.getTableHeader();
		    tableHeader.setFont(font);
		    tableHeader.setForeground(Color.green);
		    jt.getColumnModel().getColumn(1).setPreferredWidth(700);

		    JScrollPane jsp=new JScrollPane(jt);
		    jsp.setBounds(50,420,1300,135);
		    jp.add(jsp);
		}catch(Exception e){

		}
	}

}
