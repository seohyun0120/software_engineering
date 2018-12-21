import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class Main {
	private JFrame MainFrame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.MainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main() {
		MainFrame = new JFrame(); 
		MainFrame.setBounds(100, 100, 500, 590);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(null);
		
		JButton btnContact = new JButton("1.Contacts"); 
		btnContact.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				ContactMenu window2 = new ContactMenu();
				window2.frame.setVisible(true);
			}
		});
		btnContact.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnContact.setBounds(20, 20, 420, 150);
		MainFrame.getContentPane().add(btnContact);
		
		JButton btnTodo = new JButton("2. To-Do list"); 
		btnTodo.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				//
				
			}
		});
		btnTodo.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnTodo.setBounds(20, 190, 420, 150);
		MainFrame.getContentPane().add(btnTodo);
		
		JButton btnMeeting = new JButton("3. Appointments"); 
		btnMeeting.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				//
				AppointMenu AppointWindow = new AppointMenu();
				AppointWindow.frame.setVisible(true);
			}
		});
		btnMeeting.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnMeeting.setBounds(20, 360, 420, 150);
		MainFrame.getContentPane().add(btnMeeting);
	}
}