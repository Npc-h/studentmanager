package cn.lanqiao.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.UserMnager;
import cn.lanqiao.service.UserMnagerService;
import cn.lanqiao.service.impl.UserMnagerServiceImpl;

/**
 * 增加用户
 * 
 * @author NPC一H
 *
 */

public class UserAddFrame extends JFrame {

	private JPanel AddcontentPane;
	public  ImageIcon Addpanelicon;
	private JTextField AdduserTextField;
	private JPasswordField AddUserPasswordField;
	private JPasswordField AddUserPasswordField2;
	JOptionPane jOptionPane1 = new JOptionPane();

	public UserAddFrame() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		
		
		
		this.dispose();
		setUndecorated(true);
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 1100, 660);
		AddcontentPane = new JPanel();
		AddcontentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AddcontentPane);
		AddcontentPane.setLayout(null);
		jOptionPane1.setBounds(new Rectangle(0, 233, 262, 300));
		jOptionPane1.setLayout(null);
		
		JPanel panel = new JPanel();
		setLocationRelativeTo(null);
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 1100, 660);
		AddcontentPane.add(panel);
		AddcontentPane.add(jOptionPane1);
		panel.setLayout(null);
	
		AdduserTextField = new JTextField();
		AdduserTextField.setBounds(530, 269, 180, 30);
		//userTextField.setText("46546");
		AdduserTextField.setForeground(Color.BLACK);
		AdduserTextField.setBackground(Color.WHITE);
		panel.add(AdduserTextField);
		AdduserTextField.setColumns(10);
		
		AddUserPasswordField = new JPasswordField();
		AddUserPasswordField.setBounds(530, 312, 180, 30);
		AddUserPasswordField.setForeground(Color.BLACK);
		AddUserPasswordField.setBackground(Color.WHITE);
		panel.add(AddUserPasswordField);
		
		AddUserPasswordField2 = new JPasswordField();
		AddUserPasswordField2.setBounds(530, 352, 180, 30);
		AddUserPasswordField2.setForeground(Color.BLACK);
		AddUserPasswordField2.setBackground(Color.WHITE);
		panel.add(AddUserPasswordField2);
		
		JButton AddloginButton = new JButton("\u63D0 \u4EA4");
		AddloginButton.setBounds(493, 420, 80, 30);
		AddloginButton.addActionListener(new AddAdminFrame_jButton1_actionAdapter(this));
		AddloginButton.setFont(new Font("宋体", Font.BOLD, 16));
		AddloginButton.setBackground(Color.BLACK);
		AddloginButton.setForeground(Color.BLACK);
		panel.add(AddloginButton);
		
		JButton AddloginButton2 = new JButton("\u91CD \u7F6E");
		AddloginButton2.setBounds(645, 420, 80, 30);
		AddloginButton2.addActionListener(new AddAdminFrame_jButton2_actionAdapter(this));
		AddloginButton2.setFont(new Font("宋体", Font.BOLD, 16));
		AddloginButton2.setBackground(SystemColor.windowText);
		AddloginButton2.setForeground(Color.BLACK);
		panel.add(AddloginButton2);
		
		JButton AddloginButtonExit = new JButton("\u00D7");
		AddloginButtonExit.setBounds(1020, 0, 80, 30);
		AddloginButtonExit.setFont(new Font("宋体", Font.BOLD, 16));
		AddloginButtonExit.setBackground(SystemColor.windowText);
		AddloginButtonExit.setForeground(Color.DARK_GRAY);
		panel.add(AddloginButtonExit);
		
		
		
		JLabel AddbackLabel = new JLabel("");
		AddbackLabel.setFont(new Font("宋体", Font.BOLD, 17));
		AddbackLabel.setBounds(0, 0, 1100, 660);
		AddbackLabel.setIcon(new ImageIcon("src\\back3.jpg"));
		panel.add(AddbackLabel);
		
		//退出按钮的监听   AddloginButtonExit
		AddloginButtonExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		//Register test = new Register();
			UserAddFrame.this.dispose();
					}
				});	
		}
	

	/*// 退出
	public void jButton2_actionPerformed(ActionEvent e) {
		this.dispose();
	}*/

	// 添加用户
	public void jButton1_actionPerformed(ActionEvent e) {
		boolean pd = false;
		// 判断文本框是否符合条件
		if (AdduserTextField.getText().length() == 0) {
			jOptionPane1.showMessageDialog(this, "用户名不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE, null);
		} else if (AddUserPasswordField2.getText().trim().equals(AddUserPasswordField.getText().trim())) {
			pd = true;
		} else {
			jOptionPane1.showMessageDialog(this, "两次密码不一致", "提示", JOptionPane.INFORMATION_MESSAGE, null);
		}
		
		if(pd) {
			try {
				UserMnagerService ss = new UserMnagerServiceImpl();
				UserMnager usermnager = new UserMnager(1, AdduserTextField.getText().trim(), AddUserPasswordField.getText().trim(), 2);
				ss.insertUser(usermnager);
				jOptionPane1.showMessageDialog(this, "注册成功", "提示", JOptionPane.INFORMATION_MESSAGE, null);
				this.dispose();
			} catch (Exception e2) {
				System.out.println("123");
				jOptionPane1.showMessageDialog(this, "用户名已经存在", "提示", JOptionPane.INFORMATION_MESSAGE, null);
			}
		}
	}
	
	//重置
		public void jButton2_chongZhi(ActionEvent e){
			AdduserTextField.setText("");
			AddUserPasswordField.setText("");
			AddUserPasswordField2.setText("");
		}

//监听器
	class AddAdminFrame_jButton1_actionAdapter implements ActionListener {
		private UserAddFrame adaptee;

		AddAdminFrame_jButton1_actionAdapter(UserAddFrame adaptee) {
			this.adaptee = adaptee;
		}

		public void actionPerformed(ActionEvent e) {
			adaptee.jButton1_actionPerformed(e);
		}
	}

	class AddAdminFrame_jButton2_actionAdapter implements ActionListener {
		private UserAddFrame adaptee;

		AddAdminFrame_jButton2_actionAdapter(UserAddFrame adaptee) {
			this.adaptee = adaptee;
		}

		public void actionPerformed(ActionEvent e) {
			adaptee.jButton2_chongZhi(e);
		}
	}

}
