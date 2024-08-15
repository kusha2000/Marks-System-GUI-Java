import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class Pro1{
	public static void main(String[] args){
		Menu menu=new Menu();
		menu.list();
	}
}
class Menu{
	//Scanner sc=new Scanner(System.in);
	public void list(){
		JPanel jp=new JPanel();
	    jp.setLayout(null);
		JFrame jf=new JFrame("Marks Programme");
		Font font=new Font("Arial", Font.PLAIN, 20);
		//Add a Record
		Icon icon = new ImageIcon("icons\\AddAdmin.png");
		JButton jb=new JButton("Add a Record",icon);
		jb.setVerticalTextPosition(SwingConstants.CENTER);
		jb.setVerticalAlignment(SwingConstants.TOP);
		jb.setBounds(100,200,350,150);
		jb.setFont(font);
		jb.addActionListener(new MyListenerInsert());
		jp.add(jb);
		//Dispaly a Record
		Icon icon1 = new ImageIcon("icons\\AddStudent.png");
		JButton jb1=new JButton("Display a Record",icon1);
		jb1.setVerticalTextPosition(SwingConstants.CENTER);
		jb1.setVerticalAlignment(SwingConstants.TOP);
		jb1.setBounds(500,200,350,150);
		jb1.setFont(font);
		jb1.addActionListener(new MyListener1Select());
		jp.add(jb1);
		//Dispaly all Records
		Icon icon2 = new ImageIcon("icons\\showStudent.png");
		JButton jb2=new JButton("Display all Records",icon2);
		jb2.setVerticalTextPosition(SwingConstants.CENTER);
		jb2.setVerticalAlignment(SwingConstants.TOP);
		jb2.setBounds(900, 200,350,150);
		jb2.setFont(font);
		jb2.addActionListener(new MyListenerSelectAll());
		jp.add(jb2);
		//Edit a Record
		Icon icon3 = new ImageIcon("icons\\configuration.png");
		JButton jb3=new JButton("Edit a Record",icon3);
		jb3.setVerticalTextPosition(SwingConstants.CENTER);
		jb3.setVerticalAlignment(SwingConstants.TOP);
		jb3.setBounds(100, 400,350,150);
		jb3.setFont(font);
		jb3.addActionListener(new MyListenerUpdate());
		jp.add(jb3);
		//Delete a Record
		Icon icon4 = new ImageIcon("icons\\configuration1.png");
		JButton jb4=new JButton("Delete a Record",icon4);
		jb4.setVerticalTextPosition(SwingConstants.CENTER);
		jb4.setVerticalAlignment(SwingConstants.TOP);
		jb4.setBounds(500, 400,350,150);
		jb4.setFont(font);
		jb4.addActionListener(new MyListenerDelete());
		jp.add(jb4);
		//Exit
		Icon icon5 = new ImageIcon("icons\\exits.jpg");
		JButton jb5=new JButton("Exit",icon5);
		jb5.setVerticalTextPosition(SwingConstants.CENTER);
		jb5.setVerticalAlignment(SwingConstants.TOP);
		jb5.setBounds(900, 400,350,150);
		jb5.setFont(font);
		jb5.addActionListener(new MyListenerFullExit());
		jp.add(jb5);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//jf.setSize(500,600);
		//jf.setLocation(0,0);
		jp.setBackground(Color.darkGray);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
}
class MyListenerInsert implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//iq.setVisible(false);
		InsertQuary iq=new InsertQuary();
		iq.insert();
		//iq.setVisible(true);

	}
}
class MyListener1Select implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//iq.setVisible(false);
		SelectQuary sq=new SelectQuary();
		sq.select();
		//iq.setVisible(true);

	}
}
class MyListenerSelectAll implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//iq.setVisible(false);
		SelectAllQuary saq=new SelectAllQuary();
		saq.selectall();
		//iq.setVisible(true);

	}
}
class MyListenerUpdate implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//iq.setVisible(false);
		//UpdateQuary uq=new UpdateQuary();
		//uq.update();
		EditQuary eq=new EditQuary();
		eq.update();
		//iq.setVisible(true);

	}
}
class MyListenerDelete implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//iq.setVisible(false);
		DeleteQuary dq=new DeleteQuary();
		dq.delete();
		//iq.setVisible(true);

	}
}
class MyListenerFullExit implements ActionListener{
	public void actionPerformed(ActionEvent e){
		int result = JOptionPane.showConfirmDialog(null,"Do you want to exit?", "Exit",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
               System.exit(0);
            }else if (result == JOptionPane.NO_OPTION){
               
            }else {
               
            }

	}
}
