package cn.lanqiao.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbClass;
import cn.lanqiao.model.TbScore;
import cn.lanqiao.service.TbClassService;
import cn.lanqiao.service.impl.TbClassServiceImpl;
import cn.lanqiao.service.impl.TbScoreServiceImpl;

public class LookClass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static LookClass lookClass = null;
	JOptionPane jOptionPane = new JOptionPane();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public LookClass() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 547, 37);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("查找班级");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel.setForeground(Color.BLUE);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("请输入班级编号：");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(92, 196, 139, 37);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(323, 198, 156, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("点击查看");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() == 0) {
					jOptionPane.showMessageDialog(null, "请输入班级编号", "提 示", jOptionPane.INFORMATION_MESSAGE);
				} else {
					// TODO Auto-generated method stub
					TbClassService tbClass = new TbClassServiceImpl();
					List<TbClass> allTbClass = tbClass.getAllTbClass();
					boolean flag = false;
					for (TbClass lookClass : allTbClass) {
						if (String.valueOf(lookClass.getClassId()).equals(textField.getText())) {
							String msg = String.valueOf(lookClass.getClassName());
							jOptionPane.showMessageDialog(null, "班级编号:  " + textField.getText() + "  相对应的班级名称是" + msg,
									"提 示", jOptionPane.INFORMATION_MESSAGE);
							flag = true;
							break;
						}
						
					}
					if (!flag) {
						jOptionPane.showMessageDialog(null, "没有班级编号:  " + textField.getText() + "  的相关消息", "提 示",
								jOptionPane.INFORMATION_MESSAGE);
					}
					
				}
			}
		});

		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(222, 303, 128, 44);
		contentPane.add(btnNewButton);
	}

	public static synchronized LookClass getLookClass() {
		if (lookClass == null) {
			lookClass = new LookClass();
		}
		return lookClass;
	}
}
