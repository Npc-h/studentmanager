package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbCourse;
import cn.lanqiao.model.TbScore;
import cn.lanqiao.model.TbStudent;
import cn.lanqiao.service.TbCourseService;
import cn.lanqiao.service.TbScoreService;
import cn.lanqiao.service.TbStudentService;
import cn.lanqiao.service.impl.TbClassServiceImpl;
import cn.lanqiao.service.impl.TbCourseServiceImpl;
import cn.lanqiao.service.impl.TbScoreServiceImpl;
import cn.lanqiao.service.impl.TbStudentServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddScore extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static AddScore addScore = null;
	JOptionPane jOptionPane = new JOptionPane();
	TbStudentService student = new TbStudentServiceImpl();
	TbCourseService course = new TbCourseServiceImpl();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private AddScore() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBounds(5, 5, 547, 37);
		contentPane.add(panelNorth);
		
		JLabel label = new JLabel("成绩录入");
		label.setFont(new Font("宋体", Font.BOLD, 23));
		label.setForeground(Color.BLUE);
		panelNorth.add(label);
		
		JLabel lblNewLabel = new JLabel("\u6210\u7EE9\u7F16\u53F7\uFF1A");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(148, 84, 96, 30);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\u6210\u7EE9\u5206\u6570\uFF1A");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("宋体", Font.BOLD, 16));
		label_1.setBounds(148, 148, 96, 30);
		contentPane.add(label_1);
		
		textField = new JTextField();//成绩号
		textField.setBounds(300, 86, 154, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();//成绩分数
		textField_1.setColumns(10);
		textField_1.setBounds(300, 148, 154, 30);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("学生编号");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 16));
		label_2.setBounds(148, 221, 96, 30);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("课程编号");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("宋体", Font.BOLD, 16));
		label_3.setBounds(148, 284, 96, 30);
		contentPane.add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"请选择学生编号"}));
		 List<TbStudent> allTbStudent = student.getAllTbStudent();
		for (TbStudent tbStudent : allTbStudent) {
			comboBox.addItem(tbStudent.getStudentNum());
		}
		comboBox.setBounds(300, 227, 154, 21);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"请选择课程编号"}));
		List<TbCourse> allTbCourse = course.getAllTbCourse();
		for (TbCourse tbCourse : allTbCourse) {
			comboBox_1.addItem(tbCourse.getCourseNum());
		}
		comboBox_1.setBounds(300, 284, 154, 21);
		contentPane.add(comboBox_1);
		
		JButton button = new JButton("确定录入");
		button.addActionListener(new ActionListener() {//录入成绩实现
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取文本框
				TbScoreService scores = new TbScoreServiceImpl();
				int scoreId = Integer.parseInt(textField.getText());
				int scoreGrade = Integer.parseInt(textField_1.getText());
				int studentNum =Integer.parseInt(String.valueOf(comboBox.getSelectedItem()));
				int courseNum = Integer.parseInt(String.valueOf(comboBox_1.getSelectedItem()));
				TbScore newScores = new TbScore(scoreId, scoreGrade, studentNum, courseNum);
				scores.insertTbScore(newScores);
				ImageIcon icon = new ImageIcon();
				jOptionPane.showMessageDialog(null, "录入成功!","提 示",
						jOptionPane.INFORMATION_MESSAGE,icon);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 18));
		button.setForeground(Color.BLUE);
		button.setBounds(223, 353, 137, 39);
		contentPane.add(button);
		
		
	}
	public static synchronized AddScore getAddScore(){
		if(addScore==null){
			addScore = new AddScore();
		}
		return addScore;
	}
}
