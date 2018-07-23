package cn.lanqiao.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbCourse;
import cn.lanqiao.model.TbScore;
import cn.lanqiao.service.TbCourseService;
import cn.lanqiao.service.TbScoreService;
import cn.lanqiao.service.impl.TbCourseServiceImpl;
import cn.lanqiao.service.impl.TbScoreServiceImpl;

public class AddCourse  extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static AddCourse addcourse = null;
	JOptionPane jOptionPane = new JOptionPane();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private AddCourse() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBounds(5, 5, 547, 37);
		contentPane.add(panelNorth);
		
		JLabel label = new JLabel("课程录入");
		label.setFont(new Font("宋体", Font.BOLD, 23));
		label.setForeground(Color.BLUE);
		panelNorth.add(label);
		
		JLabel lblNewLabel = new JLabel("课程编号");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(148, 84, 96, 30);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("课程名");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("宋体", Font.BOLD, 16));
		label_1.setBounds(148, 148, 96, 30);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("学时");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 16));
		label_2.setBounds(148, 214, 96, 30);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("学分");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("宋体", Font.BOLD, 16));
		label_3.setBounds(148, 285, 96, 30);
		contentPane.add(label_3);
		
		textField = new JTextField();//课程编号
		textField.setBounds(300, 86, 154, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();//课程名
		textField_1.setColumns(10);
		textField_1.setBounds(300, 148, 154, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();//学时
		textField_2.setColumns(10);
		textField_2.setBounds(300, 214, 154, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();//学分
		textField_3.setColumns(10);
		textField_3.setBounds(300, 285, 154, 30);
		contentPane.add(textField_3);
		
		JButton button = new JButton("确定录入");
		button.addActionListener(new ActionListener() {//录入成绩实现
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取文本框
				
				TbCourseService tcs = new TbCourseServiceImpl();
				int courseNum = Integer.parseInt(textField.getText());
				String courseName = textField_1.getText().trim();
				int courseHour = Integer.parseInt(textField_2.getText());
				String courseScore = textField_3.getText().trim();
				TbCourse tbcourse = new TbCourse(courseNum, courseName, courseHour, courseScore);
				tcs.insertTbCourse(tbcourse);
				ImageIcon icon = new ImageIcon("src/YES.jpg");
				jOptionPane.showMessageDialog(null, "录入成功!","提 示",
						jOptionPane.INFORMATION_MESSAGE,icon);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 18));
		button.setForeground(Color.BLUE);
		button.setBounds(223, 353, 137, 39);
		contentPane.add(button);
	}
	public static synchronized AddCourse getaddcourse(){
		if(addcourse==null){
			addcourse = new AddCourse();
		}
		return addcourse;
	}
}
