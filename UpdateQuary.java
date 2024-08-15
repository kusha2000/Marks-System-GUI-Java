import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class UpdateQuary{
	public static String a;
	
	JPanel jp;
	JTextField jtf;
	ResultSet rs;
	//public static void main(String[] args){
	public void update(){

		JFrame jf=new JFrame("Update a Record");
		jp=new JPanel();
		jp.setLayout(null);
		jf.add(jp);

		JLabel jlti=new JLabel("Update a Record");
		jlti.setFont(new Font("Arial",Font.PLAIN,60));
		jlti.setBounds(500,10,500,55);
		jlti.setForeground(Color.BLUE);
		jp.add(jlti);

		

		JLabel jlold=new JLabel("Enter Your Index Number:");
	    jlold.setBounds(100,90,600,50);
	    jlold.setFont(new Font("Arial",Font.PLAIN,50));
	    jlold.setForeground(Color.white);
	    jp.add(jlold);

	    jtf=new JTextField(20);
	    jtf.setBounds(700,90,600,50);
	    jtf.setFont(new Font("Arial",Font.BOLD,50));
	    jp.add(jtf);

	    emptyTable();

	    JButton jb1=new JButton("Submit");
	    jb1.setBounds(1200,150,100,50);
	    jb1.setFont(new Font("Arial",Font.BOLD,20));
	    jb1.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){  
			    	//SelectQuary sq=new SelectQuary();
			    	//sq.sql();
			        sql();			    
			        }  
			    });
	    jp.add(jb1);


		JLabel jl=new JLabel("Enter Your Name:");
		jl.setFont(new Font("Arial",Font.PLAIN,30));
		jl.setBounds(150,325,400,50);
		jl.setForeground(Color.white);
		jp.add(jl);

		JTextField jtf1=new JTextField(30);
		jtf1.setBounds(500,325,400,50);
		jtf1.setFont(new Font("Arial",Font.BOLD,30));
		jp.add(jtf1);
		a=jtf1.getText();

		JLabel jl1=new JLabel("Enter Your index no:");
		jl1.setBounds(150,400,400,50);
		jl1.setFont(new Font("Arial",Font.PLAIN,30));
		jl1.setForeground(Color.white);
		jp.add(jl1);

		JTextField jtf2=new JTextField(30);
		jtf2.setBounds(500,400,400,50);
		jtf2.setFont(new Font("Arial",Font.BOLD,30));
		jp.add(jtf2);

		JLabel jl2=new JLabel("Enter Your T_Marks no:");
		jl2.setBounds(150,475,400,50);
		jl2.setFont(new Font("Arial",Font.PLAIN,30));
		jl2.setForeground(Color.white);
		jp.add(jl2);

		JTextField jtf3=new JTextField(30);
		jtf3.setBounds(500,475,400,50);
		jtf3.setFont(new Font("Arial",Font.BOLD,30));
		jp.add(jtf3);

		JLabel jl3=new JLabel("Enter Your P_Marks no:");
		jl3.setBounds(150,550,400,50);
		jl3.setFont(new Font("Arial",Font.PLAIN,30));
		jl3.setForeground(Color.white);
		jp.add(jl3);

		JTextField jtf4=new JTextField(30);
		jtf4.setBounds(500,550,400,50);
		jtf4.setFont(new Font("Arial",Font.BOLD,30));
		jp.add(jtf4);
        
        JButton jb4=new JButton("Submit");
	    jb4.setBounds(720,620,180,70);
	    jb4.setFont(new Font("Arial",Font.BOLD,40));
	    jb4.setForeground(Color.blue);
	    jp.add(jb4);
		
	    JButton jb2=new JButton("Clear");
	    jb2.setBounds(1050,640,100,50);
	    jb2.setFont(new Font("Arial",Font.BOLD,20));
	    jb1.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){  
			    	    jtf.setText("");
			            emptyTable();			
			                }  
			    });
	    jp.add(jb1);
	    jp.add(jb2);

	    JButton jb3=new JButton("Exit");
	    jb3.setBounds(1200,640,100,50);
	    jb3.setFont(new Font("Arial",Font.BOLD,20));
	    jb3.addActionListener(new MyListenerExit());
	    jp.add(jb3);

		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jp.setBackground(Color.darkGray);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	}
	public void sql(){		
		System.out.println(jtf.getText());
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatagui","root","");
			Statement stmt=con.createStatement();
			//r=stmt.executeQuery("Select * from marks where st_index="+jtf.getText()+"");
			rs=stmt.executeQuery("Select * from marks where st_index='"+jtf.getText()+"' "); 
			rs.next();
			System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
			//table();
			con.close();	        

	    }catch(Exception e){
	        //JOptionPane.showMessageDialog(null,"Please enter Correct Index");
	        JOptionPane.showMessageDialog(null,e);

		}

	}
	/*public void sql(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatagui","root","");
			Statement stmt=con.createStatement();
			rs=stmt.executeQuery("Select * from marks where st_index='"+jtf.getText()+"'");
			rs.next();
			table();
			con.close();

	    }catch(Exception e){
	       // JOptionPane.showMessageDialog(null,"Please enter Correct Index");
	        JOptionPane.showMessageDialog(null,e);

		}

	}*/
	/*public void table(){
		try{
			String [][] records = {{r.getString(1),r.getString(2),r.getString(3),r.getString(4)}};
		    String [] hedar={"Index no","Name","T_Marks","P_Marks"};
		    JTable jt=new JTable(records,hedar);
		    jt.setRowHeight(40);
		    Font font=new Font("Arial",Font.BOLD,28);
		    jt.setFont(font);
		    JTableHeader tableHeader = jt.getTableHeader();
		    tableHeader.setFont(font);
		    tableHeader.setForeground(Color.green);
		    jt.getColumnModel().getColumn(1).setPreferredWidth(700);


		    JScrollPane jsp=new JScrollPane(jt);
		    jsp.setBounds(40,210,1300,80);
		    jp.add(jsp);
			}catch(Exception e){
				//JOptionPane.showMessageDialog(null,"Please enter Correct Index");
				JOptionPane.showMessageDialog(null,e);
			}
	}*/
	public void table(){
		try{
			String [][] records = {{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)}};
		    String [] hedar={"Index no","Name","T_Marks","P_Marks"};
		    JTable jt=new JTable(records,hedar);
		    jt.setRowHeight(40);
		    Font font=new Font("Arial",Font.BOLD,28);
		    jt.setFont(font);
		    JTableHeader tableHeader = jt.getTableHeader();
		    tableHeader.setFont(font);
		    tableHeader.setForeground(Color.green);
		    jt.getColumnModel().getColumn(1).setPreferredWidth(700);

		    JScrollPane jsp=new JScrollPane(jt);
		    jsp.setBounds(50,210,1300,80);
		    jp.add(jsp);
		}catch(Exception e){
			//JOptionPane.showMessageDialog(null,"Please enter Correct Index");
			//emptyTable();
			JOptionPane.showMessageDialog(null,e);
		}
	}
	public void emptyTable(){
		 try{
			String [][] records = {};
		    String [] hedar={"Index no","Name","T_Marks","P_Marks"};
		    JTable jt=new JTable(records,hedar);
		    jt.setRowHeight(40);
		    Font font=new Font("Arial",Font.BOLD,28);
		    jt.setFont(font);
		    JTableHeader tableHeader = jt.getTableHeader();
		    tableHeader.setFont(font);
		    tableHeader.setForeground(Color.green);
		    jt.getColumnModel().getColumn(1).setPreferredWidth(700);

		    JScrollPane jsp=new JScrollPane(jt);
		    jsp.setBounds(40,210,1300,80);
		    jp.add(jsp);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}

	}
	
}
