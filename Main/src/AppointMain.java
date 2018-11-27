import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class AppointMain {
	public static AppointMenu info;
	public JFrame frame;
	public JTextField textIndex;
	public JTextField textName;
	public JTextField textDate;
	public JTextField textTime;
	public JTextArea textArea;
	
	public AppointMain() {
		info = AppointManager.getInstance();
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame(); 
		frame.setBounds(100, 100, 510, 639);
		frame.getContentPane().setLayout(null);
		
		JLabel lTitle = new JLabel("3.미팅 관리");
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
		
		JLabel lIndex = new JLabel("인덱스"); 
		lIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lIndex.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lIndex.setFont(new Font("굴림", Font.PLAIN, 14));
		lIndex.setBounds(12, 80, 160, 40);
		frame.getContentPane().add(lIndex);
		
		JLabel lName = new JLabel("이름"); 
		lName.setHorizontalAlignment(SwingConstants.CENTER);
		lName.setFont(new Font("굴림", Font.PLAIN, 14));
		lName.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lName.setBounds(12, 132, 160, 40);
		frame.getContentPane().add(lName);
		
		JLabel lPhone = new JLabel("날짜(YYYY-MM-DD)"); 
		lPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lPhone.setFont(new Font("굴림", Font.PLAIN, 14));
		lPhone.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lPhone.setBounds(12, 182, 160, 40);
		frame.getContentPane().add(lPhone);
		
		JLabel lEmail = new JLabel("시간(HH:MM)");
		lEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lEmail.setFont(new Font("굴림", Font.PLAIN, 14));
		lEmail.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lEmail.setBounds(12, 232, 160, 40);
		frame.getContentPane().add(lEmail);
		
		textIndex = new JTextField();
		textIndex.setBounds(197, 82, 285, 40);
		frame.getContentPane().add(textIndex);
		textIndex.setColumns(10);
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(197, 134, 285, 40);
		frame.getContentPane().add(textName);
		textDate = new JTextField(); 
		textDate.setColumns(10);
		textDate.setBounds(197, 184, 285, 40);
		frame.getContentPane().add(textDate);
		textTime = new JTextField(); 
		textTime.setColumns(10);
		textTime.setBounds(197, 234, 285, 40);
		frame.getContentPane().add(textTime);

		JButton btnInsert = new JButton("등록"); 
		btnInsert.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				insert();
				reset();
			}
		});
		btnInsert.setFont(new Font("굴림", Font.BOLD, 12));
		btnInsert.setBounds(20, 282, 90, 40);
		frame.getContentPane().add(btnInsert);
	
		JButton btnSelect = new JButton("보기"); 
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll(); 
				reset();
			}
		});
		btnSelect.setFont(new Font("굴림", Font.BOLD, 12));
		btnSelect.setBounds(114, 282, 90, 40);
		frame.getContentPane().add(btnSelect);
		
		JButton btnIndexSelect = new JButton("상세 검색"); 
		btnIndexSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select(); 
				reset();
			}
		});
		btnIndexSelect.setFont(new Font("굴림", Font.BOLD, 12));
		btnIndexSelect.setBounds(206, 282, 90, 40);
		frame.getContentPane().add(btnIndexSelect);
		
		JButton btnUpdate = new JButton("수정"); 
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update(); 
				reset();
			}
		});
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 12));
		btnUpdate.setBounds(298, 282, 90, 40);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("삭제"); 
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
		textName.setText("");
		textDate.setText("");
		textTime.setText("");
	}
	

	private void insert() { 
		String name = textName.getText(); 
		String date = textDate.getText(); 
		String time = textTime.getText(); 
		
		AppointInfo contact = new AppointInfo(name, date,time);
		int result = info.insert(contact); 
		
		if (result > 0) {
			System.out.println("미팅 등록 성공");
		} else {
			System.out.println("미팅 등록 실패");
		}
		textArea.setText(contact.toString());
	}

	private void selectAll() {
		ArrayList<AppointInfo> list = info.select();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			buffer.append("[" + i + "] ").append(list.get(i).toString()).append("\n");
		} // end for
		textArea.setText(buffer.toString());
	}

	private void select() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			AppointInfo list = info.select(index);
			textName.setText(list.getName());
			textDate.setText(list.getDate());
			textTime.setText(list.getTime());
		} catch (NumberFormatException e) {
			textArea.setText("인덱스 칸에 검색할 정보의 index를 입력하세요.");
		} catch (NullPointerException e) {
			textArea.setText("해당 정보가 없습니다.");
		}
	}

	private void update() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			String name = textName.getText();
			String date = textDate.getText();
			String time = textTime.getText();
			AppointInfo contact = new AppointInfo(name, date, time);
			int result = info.update(index, contact);
			if (result == 1) {
				textArea.setText(index + "번 미팅 수정 성공");
			} else {
				textArea.setText(index + "번미팅 수정 실패");
			}
		} catch (NumberFormatException e) {
			textArea.setText("인덱스 칸에 수정할 정보의 index를 입력하세요.");
		}
	}

	private void delete() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			int result = info.delete(index);
			if (result > 0) {
				textArea.setText(index + "번 미팅 삭제 성공");
			} else {
				textArea.setText(index + "번 미팅 삭제 실패");
			}
		} catch (NumberFormatException e) {
			textArea.setText("인덱스 칸에 삭제 정보의 index를 입력하세요.");
		}
	}
}
