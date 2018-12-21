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
		
		JButton btnContact = new JButton("1.연락처 관리"); 
		btnContact.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				ContactMain window2 = new ContactMain();
				window2.frame.setVisible(true);
			}
		});
		btnContact.setFont(new Font("굴림", Font.BOLD, 12));
		btnContact.setBounds(20, 20, 420, 150);
		MainFrame.getContentPane().add(btnContact);
		
		JButton btnTodo = new JButton("2. 할 일 관리"); 
		btnTodo.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				//
				
			}
		});
		btnTodo.setFont(new Font("굴림", Font.BOLD, 12));
		btnTodo.setBounds(20, 190, 420, 150);
		MainFrame.getContentPane().add(btnTodo);
		
		JButton btnMeeting = new JButton("3. 미팅 관리"); 
		btnMeeting.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				//
				AppointMenu AppointWindow = new AppointMenu();
				AppointWindow.frame.setVisible(true);
			}
		});
		btnMeeting.setFont(new Font("굴림", Font.BOLD, 12));
		btnMeeting.setBounds(20, 360, 420, 150);
		MainFrame.getContentPane().add(btnMeeting);
	}
}