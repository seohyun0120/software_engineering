import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class TodoMain {
	public static TodoMenu info;
	public JFrame frame;
	public JTextField textIndex;
	public JTextField textDate;
	public JTextField textDue;
	public JTextField textDescription;
	public JTextArea textArea;
	
	public TodoMain() {
		info = TodoInfoManager.getInstance();
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame(); 
		frame.setBounds(100, 100, 510, 639);
		frame.getContentPane().setLayout(null);
		
		JLabel lTitle = new JLabel("1. To-do List");
		lTitle.setBorder(new LineBorder(Color.BLUE, 2, true));
		lTitle.setFont(new Font("굴림", Font.BOLD, 21));
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lTitle.setBounds(12, 10, 380, 60);
		frame.getContentPane().add(lTitle);
		
		JButton btnMainMenu = new JButton("MAIN"); 
		btnMainMenu.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnMainMenu.setFont(new Font("굴림", Font.BOLD, 12));
		btnMainMenu.setBounds(400, 10, 80, 60);
		frame.getContentPane().add(btnMainMenu);
		
		JLabel lDate = new JLabel("Date"); 
		lDate.setHorizontalAlignment(SwingConstants.CENTER);
		lDate.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lDate.setFont(new Font("굴림", Font.PLAIN, 14));
		lDate.setBounds(12, 97, 160, 40);
		frame.getContentPane().add(lDate);
		
		JLabel lDue = new JLabel("Due"); 
		lDue.setHorizontalAlignment(SwingConstants.CENTER);
		lDue.setFont(new Font("굴림", Font.PLAIN, 14));
		lDue.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lDue.setBounds(12, 166, 160, 40); 
		frame.getContentPane().add(lDue);
		
		JLabel lDescription = new JLabel("Description"); 
		lDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lDescription.setFont(new Font("굴림", Font.PLAIN, 14));
		lDescription.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lDescription.setBounds(12, 232, 160, 40);
		frame.getContentPane().add(lDescription);
		
		textIndex = new JTextField();
		textIndex.setBounds(197, 99, 285, 40);
		frame.getContentPane().add(textIndex);
		textIndex.setColumns(10);
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(197, 168, 285, 40);
		frame.getContentPane().add(textDate);
		textDue = new JTextField(); 
		textDue.setColumns(10);
		textDue.setBounds(197, 234, 285, 40);
		frame.getContentPane().add(textDue);

		JButton btnInsert = new JButton("Create"); 
		btnInsert.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				insert();
				reset();
			}
		});
		btnInsert.setFont(new Font("굴림", Font.BOLD, 12));
		btnInsert.setBounds(20, 282, 90, 40);
		frame.getContentPane().add(btnInsert);
	
		JButton btnSelect = new JButton("View"); 
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll(); 
				reset();
			}
		});
		btnSelect.setFont(new Font("굴림", Font.BOLD, 12));
		btnSelect.setBounds(114, 282, 90, 40);
		frame.getContentPane().add(btnSelect);
		
		JButton btnIndexSelect = new JButton("View all"); 
		btnIndexSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select(); 
				reset();
			}
		});
		btnIndexSelect.setFont(new Font("굴림", Font.BOLD, 12));
		btnIndexSelect.setBounds(206, 282, 90, 40);
		frame.getContentPane().add(btnIndexSelect);
		
		JButton btnUpdate = new JButton("Update"); 
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update(); 
				reset();
			}
		});
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 12));
		btnUpdate.setBounds(298, 282, 90, 40);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("Delete"); 
		btnDelete.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				delete();
				reset();
			}
		});

		btnDelete.setFont(new Font("굴림", Font.BOLD, 12));
		btnDelete.setBounds(388, 282, 90, 40);
		frame.getContentPane().add(btnDelete);

		JScrollPane scrollPane = new JScrollPane(); 
		scrollPane.setBounds(12, 332, 470, 259);
		frame.getContentPane().add(scrollPane);
		textArea = new JTextArea(); 
		scrollPane.setViewportView(textArea);
	} 
	
	private void reset() {
		textIndex.setText("");
		textDate.setText("");
		textDue.setText("");
		textDescription.setText("");
	}
	

	private void insert() { 
		String date = textDate.getText(); 
		String due = textDue.getText(); 
		String description = textDescription.getText(); 
		
		TodoInfo contact = new TodoInfo(date, due, description);
		int result = info.insert(contact); 
		
		if (result > 0) {
			System.out.println("date input success");
		} else {
			System.out.println("date input fail");
		}
		textArea.setText(contact.toString());
	}

	private void selectAll() {
		ArrayList<TodoInfo> list = info.select();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			buffer.append("[" + i + "] ").append(list.get(i).toString()).append("\n");
		} // end for
		textArea.setText(buffer.toString());
	}

	private void select() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			TodoInfo list = info.select(index);
			textDate.setText(list.getDate());
			textDue.setText(list.getDue());
			textDescription.setText(list.getDescription());
		} catch (NumberFormatException e) {
			textArea.setText("숫자를 입력하세요");
		} catch (NullPointerException e) {
			textArea.setText("해당 인덱스가 없습니다");
		}
	}

	private void update() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			String date = textDate.getText();
			String due = textDue.getText();
			String description = textDescription.getText();
			TodoInfo contact = new TodoInfo(date, due, description);
			int result = info.update(index, contact);
			if (result == 1) {
				textArea.setText(index + "To-Do items update SUCCESS");
			} else {
				textArea.setText(index + "To-Do items update FAIL");
			}
		} catch (NumberFormatException e) {
			textArea.setText("숫자를 입력하세요");
		}
	}

	private void delete() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			int result = info.delete(index);
			if (result > 0) {
				textArea.setText(index + "To-Do items delete SUCCESS");
			} else {
				textArea.setText(index + "To-Do items delete FAIL");
			}
		} catch (NumberFormatException e) {
			textArea.setText("숫자를 입력하세요");
		}
	}
}
