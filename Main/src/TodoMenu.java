import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class TodoMenu {
	public static TodoInterface info;
	public JFrame frame;
	public JTextField textIndex;
	public JTextField textDate;
	public JTextField textDue;
	public JTextField textDescription;
	public JTextArea textArea;
	
	public TodoMenu() {
		info = TodoManager.getInstance();
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame(); 
		frame.setBounds(100, 100, 510, 639);
		frame.getContentPane().setLayout(null);
		
		JLabel lTitle = new JLabel("2. �� �� ����");
		lTitle.setBorder(new LineBorder(Color.BLUE, 2, true));
		lTitle.setFont(new Font("����", Font.BOLD, 21));
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lTitle.setBounds(12, 10, 380, 60);
		frame.getContentPane().add(lTitle);
		
		JButton btnMainMenu = new JButton("MAIN"); 
		btnMainMenu.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnMainMenu.setFont(new Font("����", Font.BOLD, 12));
		btnMainMenu.setBounds(400, 10, 80, 60);
		frame.getContentPane().add(btnMainMenu);
		
		JLabel lIndex = new JLabel("�ε���"); 
		lIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lIndex.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lIndex.setFont(new Font("����", Font.PLAIN, 14));
		lIndex.setBounds(12, 80, 160, 40);
		frame.getContentPane().add(lIndex);
		
		JLabel lDate = new JLabel("���� ��¥"); 
		lDate.setHorizontalAlignment(SwingConstants.CENTER);
		lDate.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lDate.setFont(new Font("����", Font.PLAIN, 14));
		lDate.setBounds(12, 132, 160, 40);
		frame.getContentPane().add(lDate);
		
		JLabel lDue = new JLabel("���� ����"); 
		lDue.setHorizontalAlignment(SwingConstants.CENTER);
		lDue.setFont(new Font("����", Font.PLAIN, 14));
		lDue.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lDue.setBounds(12, 182, 160, 40); 
		frame.getContentPane().add(lDue);
		
		JLabel lDescription = new JLabel("����"); 
		lDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lDescription.setFont(new Font("����", Font.PLAIN, 14));
		lDescription.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lDescription.setBounds(12, 232, 160, 40);
		frame.getContentPane().add(lDescription);
		
		textIndex = new JTextField();
		textIndex.setBounds(197, 82, 285, 40);
		frame.getContentPane().add(textIndex);
		textIndex.setColumns(10);
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(197, 134, 285, 40);
		frame.getContentPane().add(textDate);
		textDue = new JTextField(); 
		textDue.setColumns(10);
		textDue.setBounds(197, 184, 285, 40);
		frame.getContentPane().add(textDue);
		textDescription = new JTextField(); 
		textDescription.setColumns(10);
		textDescription.setBounds(197, 234, 285, 40);
		frame.getContentPane().add(textDescription);

		JButton btnInsert = new JButton("���ϵ��"); 
		btnInsert.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "�� ���� ����Ͻðڽ��ϱ�?", "�� �� ���", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					insert();
					reset();
				} else if (result == JOptionPane.NO_OPTION) {
					reset();	
				} else {
					reset();	
				}
			}
		});
		btnInsert.setFont(new Font("����", Font.BOLD, 12));
		btnInsert.setBounds(20, 282, 90, 40);
		frame.getContentPane().add(btnInsert);
	
		JButton btnSelect = new JButton("���Ϻ���"); 
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll(); 
				reset();
			}
		});
		btnSelect.setFont(new Font("����", Font.BOLD, 12));
		btnSelect.setBounds(114, 282, 90, 40);
		frame.getContentPane().add(btnSelect);
		
		JButton btnIndexSelect = new JButton("�󼼰˻�"); 
		btnIndexSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select(); 
				reset();
			}
		});
		btnIndexSelect.setFont(new Font("����", Font.BOLD, 12));
		btnIndexSelect.setBounds(206, 282, 90, 40);
		frame.getContentPane().add(btnIndexSelect);
		
		JButton btnUpdate = new JButton("���ϼ���"); 
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "�� �� ����", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					update();
					reset();
				} else if (result == JOptionPane.NO_OPTION) {
					reset();	
				} else {
					reset();	
				}
			}
		});
		btnUpdate.setFont(new Font("����", Font.BOLD, 12));
		btnUpdate.setBounds(298, 282, 90, 40);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("���ϻ���"); 
		btnDelete.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "�� �� ����", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					delete();
					reset();
				} else if (result == JOptionPane.NO_OPTION) {
					reset();	
				} else {
					reset();	
				}
			}
		});

		btnDelete.setFont(new Font("����", Font.BOLD, 12));
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
		
		if (date.length() > 0 && due.length() > 0 && description.length() > 0) {
			TodoInfo contact = new TodoInfo(date, due, description);
			int result = info.insert(contact);
			System.out.println("date input success");
			textArea.setText(contact.toString());
		} else {
			int result = 0;
			System.out.println("date input fail");
			textArea.setText("����ó ��� ����");
		}
	}

	private void selectAll() {
		ArrayList<TodoInfo> list = info.select();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			buffer.append("[" + i + "] ").append(list.get(i).toString()).append("\n");
		} // end for
		textArea.setText(buffer.toString());
	}
	
	/*private void select() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			TodoInfo list = info.select(index);
			textDate.setText(list.getDate());
			textDue.setText(list.getDue());
			textDescription.setText(list.getDescription());
			textArea.setText(list.toString());
		} catch (NumberFormatException e) {
			textArea.setText("���ڸ� �Է��ϼ���");
		} catch (NullPointerException e) {
			textArea.setText("�ش� �ε����� �����ϴ�");
		}
	}*/
	
	 private void select() {
	      try {
	         String searchDate = textDate.getText();
	         System.out.println("search_date: "+ searchDate);
	         if(searchDate.trim().length() > 0) {
	            StringBuffer buffer = new StringBuffer();
	            ArrayList<TodoInfo> list = info.select(searchDate);
	            ArrayList<TodoInfo> listALL = info.select();
	            System.out.println("listALL size: "+listALL.size());
	            
	            for (int i = 0; i < list.size(); i++) {
	               for(int j = 0; j < listALL.size(); j++) {
	                  if(list.get(i).getDate() == listALL.get(j).getDate())
	                  {   
	                     buffer.append("[" + j + "] ").append(list.get(i).toString());
	                     break;
	                  }
	               } 
	            }      
	            textArea.setText(buffer.toString());
	         }
	         else {
	            int index = Integer.parseInt(textIndex.getText());
	            TodoInfo list = info.select(index);
	            StringBuffer buffer = new StringBuffer();
	            ArrayList<TodoInfo> listALL = info.select();
	            for(int j=0; j<listALL.size(); j++) {
	               if(list.getDue().equals(listALL.get(j).getDue()))
	               {
	                  buffer.append("[" + j + "] ").append(list.toString());
	               }
	            }         
	            textArea.setText(buffer.toString());
	         }
	      
	      } catch (NumberFormatException e) {
	         textArea.setText("�ε��� ĭ�̳� ��¥ĭ�� �˻��� ������ �ε����� �Է��ϼ���.");
	      } catch (NullPointerException e) {
	         textArea.setText("�ش� ������ �����ϴ�.");
	      }
	   }

	private void update() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			String date = textDate.getText();
			String due = textDue.getText();
			String description = textDescription.getText();
			
			if (date.length() > 0 && due.length() > 0 && description.length() > 0) {
				TodoInfo contact = new TodoInfo(date, due, description);
				int result = info.update(index, contact);
				if (result == 1) {
					textArea.setText(index + " �� �� ���� ����");
				} 
				else {
					textArea.setText(index + " �� �� ���� ����");
				}
			} 
			else {
				textArea.setText("����");
				reset();
			}
		} catch (NumberFormatException e) {
			textArea.setText("���ڸ� �Է��ϼ���");
		}
	}

	private void delete() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			int result = info.delete(index);
			if (result > 0) {
				textArea.setText(index + " �� �� ���� ����");
			} 
			else {
				textArea.setText(index + " �� �� ���� ����");
			}
		} catch (NumberFormatException e) {
			textArea.setText("���ڸ� �Է��ϼ���");
		}
	}
}