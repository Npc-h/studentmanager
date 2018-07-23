package cn.lanqiao.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.UserMnager;
import cn.lanqiao.service.UserMnagerService;
import cn.lanqiao.service.impl.UserMnagerServiceImpl;
import cn.lanqiao.util.JdbcUtil;



public class loginFrame extends JFrame{
	private JPanel contentPane;
	public  ImageIcon panelicon;
	private JTextField userTextField;
	private JPasswordField UserPasswordField;
	JOptionPane jOptionPane_LoginFeedback = new JOptionPane();
	static String name;
	static int level;

	
	public loginFrame() {
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		setUndecorated(true);
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 1100, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		setLocationRelativeTo(null);
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 1100, 660);
		contentPane.add(panel);
		panelicon=new ImageIcon("src/1.jpg");
		panel.setLayout(null);
		jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
		jOptionPane_LoginFeedback.setLayout(null);
		contentPane.add(jOptionPane_LoginFeedback);
		
		
		userTextField = new JTextField();
		userTextField.setBounds(530, 295, 180, 30);
		//userTextField.setText("请输入你的学号");
		userTextField.setForeground(Color.BLACK);
		userTextField.setBackground(Color.WHITE);
		panel.add(userTextField);
		userTextField.setColumns(10);
		
		UserPasswordField = new JPasswordField();
		UserPasswordField.setBounds(530, 340, 180, 30);
		//UserPasswordField.setText("请输入密码");
		UserPasswordField.setForeground(Color.BLACK);
		UserPasswordField.setBackground(Color.WHITE);
		panel.add(UserPasswordField);
		
		JButton loginButton = new JButton("登录");
		loginButton.addActionListener(new loginFrame_jButton_Login_actionAdapter(this));
		loginButton.setBounds(513, 400, 80, 30);
		loginButton.setFont(new Font("宋体", Font.BOLD, 16));
		loginButton.setBackground(SystemColor.windowText);
		loginButton.setForeground(Color.BLACK);
		panel.add(loginButton);
		
		JButton loginButton2 = new JButton("注册");
		loginButton2.addActionListener(new loginFrame_jButton_SignUp_actionAdapter(this));
		loginButton2.setBounds(630, 400, 80, 30);
		loginButton2.setFont(new Font("宋体", Font.BOLD, 16));
		loginButton2.setBackground(Color.BLACK);
		loginButton2.setForeground(Color.BLACK);
		panel.add(loginButton2);
		
		JButton loginButtonexit = new JButton("\u00D7");
		loginButtonexit.setBounds(1020, 0, 80, 30);
		loginButtonexit.setFont(new Font("宋体", Font.BOLD, 16));
		loginButtonexit.setBackground(SystemColor.windowText);
		loginButtonexit.setForeground(Color.BLACK);
		panel.add(loginButtonexit);
		
		JLabel backLabel = new JLabel("");
		backLabel.setForeground(Color.WHITE);
		backLabel.setBounds(0, 0, 1100, 660);
		backLabel.setIcon(new ImageIcon("src\\back2.jpg"));
		panel.add(backLabel);
		
		loginButtonexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Register test = new Register();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				System.exit(0);
			}
		});

		
	}
	
	
	
	//注册
	public void addUser(ActionEvent e) {
			UserAddFrame siadd = new UserAddFrame();
			/*siadd.setLocation(400, 200);
			siadd.setSize(469, 315);*/
			siadd.setVisible(true);
			//siadd.setResizable(false); //不能放大
			siadd.validate();
		}
	
	


	// 登录
	public void jButton_Login_actionPerformed(ActionEvent e) {
		//先假设用户名错误
				boolean Account = true;

				// 异常判断
				if (userTextField.getText().length() == 0) {
					jOptionPane_LoginFeedback.showMessageDialog(this, "用户名不能为空！", "提 示",
							jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
				} else {
					UserMnagerService ss = new UserMnagerServiceImpl();
					List<UserMnager> users = ss.getAllusers();
					for (UserMnager s : users) {
						if (s.getUserName().trim().equals(userTextField.getText())) {
							Account = false;
							if (s.getUserPwd().trim().equals(this.UserPasswordField.getText())) {
								name = s.getUserName().trim();
								level = s.getUserType();
								TotalWindow totalWindow = new TotalWindow(name,level);
								totalWindow.setResizable(false);
								totalWindow.setVisible(true);
								this.dispose();
								break;
							} else {
								jOptionPane_LoginFeedback.showMessageDialog(this, "密码错误", "提 示",
										jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
							}
						}
					}
					if(Account) {
						jOptionPane_LoginFeedback.showMessageDialog(this, "用户名错误", "提 示",
								jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
					}

				}
	
}

class loginFrame_jButton_Login_actionAdapter implements ActionListener 
{
	private loginFrame adaptee;

	loginFrame_jButton_Login_actionAdapter(loginFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton_Login_actionPerformed(e);
	}
}

class loginFrame_jButton_SignUp_actionAdapter implements ActionListener
{
	private loginFrame adaptee;

	loginFrame_jButton_SignUp_actionAdapter(loginFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.addUser(e);
	}
}
}
	

