import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class AppointMenu {
	public static AppointInterface info;
	public JFrame frame;
	public JTextField textIndex;
	public JTextField textName;
	public JTextField textDate;
	public JTextField textTime;
	public JTextField textLocation;
	public JTextArea textArea;
	
	public AppointMenu() {
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
		lName.setBounds(12, 132, 80, 40);
		frame.getContentPane().add(lName);
		
		JLabel lTime = new JLabel("시간(HH:MM)");
		lTime.setHorizontalAlignment(SwingConstants.CENTER);
		lTime.setFont(new Font("굴림", Font.PLAIN, 14));
		lTime.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lTime.setBounds(212, 132, 120, 40);
		frame.getContentPane().add(lTime);
		
		JLabel lPhone = new JLabel("날짜(YYYY-MM-DD)"); 
		lPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lPhone.setFont(new Font("굴림", Font.PLAIN, 14));
		lPhone.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lPhone.setBounds(12, 182, 160, 40);
		frame.getContentPane().add(lPhone);
		
		JLabel lLocation = new JLabel("위치");
		lLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lLocation.setFont(new Font("굴림", Font.PLAIN, 14));
		lLocation.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lLocation.setBounds(12, 232, 160, 40);
		frame.getContentPane().add(lLocation);
		
		textIndex = new JTextField();
		textIndex.setBounds(197, 82, 285, 40);
		frame.getContentPane().add(textIndex);
		textIndex.setColumns(10);
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(100, 134, 100, 40);
		frame.getContentPane().add(textName);
		textTime = new JTextField(); 
		textTime.setColumns(10);
		textTime.setBounds(350, 134, 100, 40);
		frame.getContentPane().add(textTime);
		textDate = new JTextField(); 
		textDate.setColumns(10);
		textDate.setBounds(197, 184, 285, 40);
		frame.getContentPane().add(textDate);
		textLocation = new JTextField(); 
		textLocation.setColumns(10);
		textLocation.setBounds(197, 234, 285, 40);
		frame.getContentPane().add(textLocation);
		
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
		textLocation.setText("");
	}
	

	private void insert() { 
		String name = textName.getText(); 
		String date = textDate.getText(); 
		String time = textTime.getText(); 
		String location = textLocation.getText();
		
		AppointInfo appoint = new AppointInfo(name,date,time,location);
	
		int result = info.insert(appoint); 
		
		if (result > 0) {
			System.out.println("미팅 등록 성공");
			textArea.setText(appoint.toString());
		} else {
			textArea.setText("미팅 등록 실패");
		}
		
	}

	private void selectAll() {
		ArrayList<AppointInfo> list = info.select();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			
			buffer.append("[" + i + "] ").append(list.get(i).toString());
		} 
		textArea.setText(buffer.toString());
	}
	
//******************************TODO 수정********************************************* date검색 가능
	private void select() {
		try {
			String searchDate = textDate.getText();
			System.out.println("search_date :: "+ searchDate);
			if(searchDate.trim().length()>0) {
				StringBuffer buffer = new StringBuffer();
				ArrayList<AppointInfo> list = info.select(searchDate);
				ArrayList<AppointInfo> listALL = info.select();
				System.out.println("listALL size: "+listALL.size());
				
				for (int i = 0; i < list.size(); i++) {
					for(int j=0; j<listALL.size(); j++) {
						if(list.get(i).getDate()==listALL.get(j).getDate())
						{	
							buffer.append("[" + j + "] ").append(list.get(i).toString());
							break;
						}
					} 
				}
				
				textArea.setText(buffer.toString());
			}
			else{
				int index = Integer.parseInt(textIndex.getText());
				AppointInfo list = info.select(index);
				StringBuffer buffer = new StringBuffer();
				ArrayList<AppointInfo> listALL = info.select();
				for(int j=0; j<listALL.size(); j++) {
					if(list.getName().equals(listALL.get(j).getName()))
					{
						buffer.append("[" + j + "] ").append(list.toString());
					}
				}
			
				textArea.setText(buffer.toString());
			}
		
		} catch (NumberFormatException e) {
			textArea.setText("인덱스 칸이나 날짜칸에 검색할 정보의 index를 입력하세요.");
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
			String location = textLocation.getText();
			AppointInfo contact = new AppointInfo(name, date, time, location);
			
			int result = info.update(index, contact);
			if (result == 1) {
				textArea.setText(index + "번 미팅 수정에 성공하였습니다");
			} else if(result == -1){
				textArea.setText(index + "번 미팅 수정에 실패하였습니다\n모든 빈칸을 채워주세요.");
			}else {
				textArea.setText(index + "번 미팅 수정에 실패하였습니다");
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
				textArea.setText(index + "번 미팅 삭제에 성공하였습니다");
			} else {
				textArea.setText(index + "번 미팅 삭제에 실패하였습니다");
			}
		} catch (NumberFormatException e) {
			textArea.setText("인덱스 칸에 삭제 정보의 index를 입력하세요.");
		}
	}
	
	

	private boolean testFlag = false;
	public void setTesting() {this.testFlag = true;}
	private boolean isTesting() {return this.testFlag;}
	
	public void removeAll() {
		if(!this.isTesting()) return;
		
		ArrayList<AppointInfo> list = info.select();
		for (int i = 0; i < list.size(); i++) {
			int result = info.delete(i);
			if (result > 0) {
				System.out.println(i + "번 미팅 삭제 성공");
			} else {
				System.out.println(i + "번 미팅 삭제 실패");
			}
		} 
	}
	

}