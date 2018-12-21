import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class ContactMenu {
	public static ContactInterface info;
	public JFrame frame;
	public JTextField textIndex;
	public JTextField textName;
	public JTextField textPhone;
	public JTextField textEmail;
	public JTextArea textArea;
	
	public ContactMenu() {
		info = ContactManager.getInstance();
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame(); 
		frame.setBounds(100, 100, 510, 639);
		frame.getContentPane().setLayout(null);
		
		JLabel lTitle = new JLabel("1. Contact");
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
		
		JLabel lIndex = new JLabel("INDEX"); 
		lIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lIndex.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lIndex.setFont(new Font("굴림", Font.PLAIN, 14));
		lIndex.setBounds(12, 80, 160, 40);
		frame.getContentPane().add(lIndex);
		
		JLabel lName = new JLabel("NAME"); 
		lName.setHorizontalAlignment(SwingConstants.CENTER);
		lName.setFont(new Font("굴림", Font.PLAIN, 14));
		lName.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lName.setBounds(12, 132, 160, 40);
		frame.getContentPane().add(lName);
		
		JLabel lPhone = new JLabel("PHONE"); 
		lPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lPhone.setFont(new Font("굴림", Font.PLAIN, 14));
		lPhone.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0)), null));
		lPhone.setBounds(12, 182, 160, 40);
		frame.getContentPane().add(lPhone);
		
		JLabel lEmail = new JLabel("EMAIL");
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
		textPhone = new JTextField(); 
		textPhone.setColumns(10);
		textPhone.setBounds(197, 184, 285, 40);
		frame.getContentPane().add(textPhone);
		textEmail = new JTextField(); 
		textEmail.setColumns(10);
		textEmail.setBounds(197, 234, 285, 40);
		frame.getContentPane().add(textEmail);

		JButton btnInsert = new JButton("CREATE"); 
		btnInsert.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Will you create Contact?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					insert();
					reset();
				} else if (result == JOptionPane.YES_OPTION) {
					reset();	
				} else {
					reset();	
				}
			}
		});
		btnInsert.setFont(new Font("굴림", Font.BOLD, 12));
		btnInsert.setBounds(20, 282, 90, 40);
		frame.getContentPane().add(btnInsert);
	
		JButton btnSelect = new JButton("VIEW"); 
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll();
				reset();
			}
		});
		btnSelect.setFont(new Font("굴림", Font.BOLD, 12));
		btnSelect.setBounds(114, 282, 90, 40);
		frame.getContentPane().add(btnSelect);
		
		JButton btnIndexSelect = new JButton("DETAIL"); 
		btnIndexSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select(); 
				reset();
			}
		});
		btnIndexSelect.setFont(new Font("굴림", Font.BOLD, 12));
		btnIndexSelect.setBounds(206, 282, 90, 40);
		frame.getContentPane().add(btnIndexSelect);
		
		JButton btnUpdate = new JButton("UPDATE"); 
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Will you update Contact?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					update();
					reset();
				} else if (result == JOptionPane.YES_OPTION) {
					reset();	
				} else {
					reset();	
				}
			}
		});
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 12));
		btnUpdate.setBounds(298, 282, 90, 40);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("DELETE"); 
		btnDelete.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Will you delete Contact?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					delete();
					reset();
				} else if (result == JOptionPane.YES_OPTION) {
					reset();	
				} else {
					reset();	
				}
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
		textPhone.setText("");
		textEmail.setText("");
	}
	

	private void insert() { 
		String name = textName.getText(); 
		String phone = textPhone.getText(); 
		String email = textEmail.getText(); 
		
		if (name.length() > 0 && phone.length() > 0 && email.length() > 0) {
			ContactInfo contact = new ContactInfo(name, phone, email);
			int result = info.insert(contact);
			System.out.println("Contact Create Success");
			textArea.setText(contact.toString());
		} else {
			int result = 0;
			System.out.println("Contact Create Fail");
			textArea.setText("Cannot Insert NULL into Data");
		}
	}

	private void selectAll() {
		ArrayList<ContactInfo> list = info.select();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			buffer.append("[" + i + "] ").append(list.get(i).toString()).append("\n");
		}
		textArea.setText(buffer.toString());
	}

	private void select() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			ContactInfo list = info.select(index);
			textName.setText(list.getName());
			textPhone.setText(list.getPhone());
			textEmail.setText(list.getEmail());
			textArea.setText(list.toString());
		} catch (NumberFormatException e) {
			textArea.setText("Please input the index or date you want to search");
		} catch (NullPointerException e) {
			textArea.setText("There is no data you want to search");
		}
	}

	private void update() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			String name = textName.getText();
			String phone = textPhone.getText();
			String email = textEmail.getText();
			
			if (name.length() > 0 && phone.length() > 0 && email.length() > 0) {
				ContactInfo contact = new ContactInfo(name, phone, email);
				int result = info.update(index, contact);
				if (result == 1) {
					textArea.setText("No. " +index + " contact is updated.");
				} else {
					textArea.setText("No. " +index + " contact cannot be updated.");
				}
			} else {
				textArea.setText("Cannot Insert NULL into Data");
				reset();
			}
		} catch (NumberFormatException e) {
			textArea.setText("Please input the index or date you want to search");
		}
	}

	private void delete() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			int result = info.delete(index);
			if (result > 0) {
				textArea.setText("No. " +index + " contact is deleted.");
			} else {
				textArea.setText("No. " +index + " does not exists. Faile to delete.");
			}
		} catch (NumberFormatException e) {
			textArea.setText("Please input the index or date you want to search");
		}
	}
}
