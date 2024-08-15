import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class InsertQuary /*implements ActionListener*/{
	public String a;
	JTextField jtf1;
	JTextField jtf2;
	JTextField jtf3;
	JTextField jtf;
	//public static void main(String[] args){
	public void insert(){

		JFrame jf=new JFrame("Inser a Record");
		JPanel jp=new JPanel();
		jp.setLayout(null);
		jf.add(jp);

		JLabel jlti=new JLabel("Insert a Record");
		jlti.setFont(new Font("Arial",Font.PLAIN,60));
		jlti.setBounds(500,40,500,50);
		jlti.setForeground(Color.BLUE);
		jp.add(jlti);

		JLabel jl=new JLabel("Enter Your Name:");
		jl.setFont(new Font("Arial",Font.PLAIN,30));
		jl.setBounds(150,150,300,50);
		jl.setForeground(Color.white);
		jp.add(jl);

		jtf=new JTextField(30);
		jtf.setBounds(500,150,400,50);
		jtf.setFont(new Font("Arial",Font.BOLD,30));
		jp.add(jtf);

		JLabel jl1=new JLabel("Enter Your index no:");
		jl1.setBounds(150,250,400,50);
		jl1.setFont(new Font("Arial",Font.PLAIN,30));
		jl1.setForeground(Color.white);
		jp.add(jl1);

		jtf1=new JTextField(30);
		jtf1.setBounds(500,250,400,50);
		jtf1.setFont(new Font("Arial",Font.BOLD,30));
		jp.add(jtf1);

		JLabel jl2=new JLabel("Enter Your T_Marks no:");
		jl2.setBounds(150,350,400,50);
		jl2.setFont(new Font("Arial",Font.PLAIN,30));
		jl2.setForeground(Color.white);
		jp.add(jl2);

		jtf2=new JTextField(30);
		jtf2.setBounds(500,350,400,50);
		jtf2.setFont(new Font("Arial",Font.BOLD,30));
		jp.add(jtf2);

		JLabel jl3=new JLabel("Enter Your P_Marks no:");
		jl3.setBounds(150,450,400,50);
		jl3.setFont(new Font("Arial",Font.PLAIN,30));
		jl3.setForeground(Color.white);
		jp.add(jl3);

		jtf3=new JTextField(30);
		jtf3.setBounds(500,450,400,50);
		jtf3.setFont(new Font("Arial",Font.BOLD,30));
		jp.add(jtf3);
	 
		JButton jb4=new JButton("Submit");
	    jb4.setBounds(720,620,180,70);
	    jb4.setFont(new Font("Arial",Font.BOLD,20));
	   // jb4.addActionListener(new MyListenerInsertSubmit());
	    //jb4.addActionListener(this);  
			jb4.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){  
			            check();
			    }  
			    });
	    jp.add(jb4);
		
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
	public void click(){
			try{
				JOptionPane.showMessageDialog(null,"Correct"); 
				JOptionPane.showMessageDialog(null,jtf.getText()); 
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null,"unCorrect"); 
				System.out.println(e1);
			}
		}
	public void check(){
			try{
			    	int num = Integer.parseInt(jtf1.getText());
			    	int num2 = Integer.parseInt(jtf2.getText());
			    	int num3 = Integer.parseInt(jtf3.getText());
			    	sql();
					}catch(Exception e){
						jtf1.setText("");
						jtf2.setText("");
						jtf3.setText("");
						JOptionPane.showMessageDialog(null,"Please enter correct interger Index or Marks");
					}
				}
	public void sql(){			
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatagui","root","");
			Statement stmt=con.createStatement();
			int i=stmt.executeUpdate("INSERT INTO marks VALUES('"+jtf1.getText()+"','"+jtf.getText()+"','"+jtf2.getText()+"','"+jtf3.getText()+"') ");
			con.close();
			JOptionPane.showMessageDialog(null,"Data Insert Sucessfully");
			jtf.setText("");
			jtf1.setText("");
			jtf2.setText("");
			jtf3.setText("");

		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"You use this index number before"); 
			jtf1.setText("");
		}
	}
	/*public void actionPerformed(ActionEvent e){  
			            //sql();
			    }*/

}
/*class MyListenerInsertSubmit implements ActionListener{
	public void actionPerformed(ActionEvent e){
		JOptionPane.showMessageDialog(null,"Correct");
	}
}*/
