package cn.lanqiao.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CourseWindow extends JInternalFrame {

	
	private JPanel CourseWindowPane;
	private static CourseWindow courseWindow = null;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CourseWindow() {
		setVisible(true);
		setBounds(0, -28, 870, 627);
		//设计容器
		CourseWindowPane = new JPanel();
		CourseWindowPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(CourseWindowPane);
		CourseWindowPane.setLayout(null);
		
		//标题的框
		JPanel CoursepanelNorth = new JPanel();
		CoursepanelNorth.setBounds(5, 5, 844, 31);
		CourseWindowPane.add(CoursepanelNorth);
		CoursepanelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("课程管理");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 18));
		CoursepanelNorth.add(label);
		
		JButton AddCoursebutton = new JButton("新开课程");
		AddCoursebutton.setBounds(58, 496, 111, 37);
		CourseWindowPane.add(AddCoursebutton);
		
		JButton RemoveCourseButton = new JButton("删除课程");
		RemoveCourseButton.setBounds(246, 496, 111, 37);
		CourseWindowPane.add(RemoveCourseButton);
		
		JButton SelectCourseButton = new JButton("查看课程");
		SelectCourseButton.setBounds(665, 496, 111, 37);
		CourseWindowPane.add(SelectCourseButton);
		
		
		
		JButton UpdateCourseButton = new JButton("修改课程");
		UpdateCourseButton.setBounds(454, 496, 111, 37);
		CourseWindowPane.add(UpdateCourseButton);
		
		if(TotalWindow.level==2) {
			AddCoursebutton.setVisible(false);
			RemoveCourseButton.setVisible(false);
			UpdateCourseButton.setVisible(false);
		}
		
		JButton btnNewButton = new JButton("课程管理");
	/*	btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddScore addScore = AddScore.getAddScore();
				addScore.setVisible(true);
				addScore.setLocationRelativeTo(null);
			}
			
		});*/
		
		JLabel backLabelclassCourse = new JLabel("");
		backLabelclassCourse.setForeground(Color.WHITE);
		backLabelclassCourse.setBounds(0, 0, 855, 600);
		backLabelclassCourse.setIcon(new ImageIcon("src\\截图4.jpg"));
		CourseWindowPane.add(backLabelclassCourse);	
		
		//增加监听
		AddCoursebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse addcourse = AddCourse.getaddcourse();
				addcourse.setVisible(true);
				addcourse.setLocationRelativeTo(null);
			}
		});
		//删除监听
		RemoveCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveCourse removeCourse =  new RemoveCourse();//弹出新窗体
				removeCourse.frame.setVisible(true);
			}//
		});
		
		
		//修改监听
		UpdateCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCourse updateCourse = new UpdateCourse();
				updateCourse.frame.setVisible(true);
			}
		});
		//查看监听
		SelectCourseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LookCourse lookCourse = LookCourse.getLookcourse();
				lookCourse.setVisible(true);
				lookCourse.setLocationRelativeTo(null);
				
			}
			
		});
		
	}
	
		
		// 单例模式
	public static synchronized CourseWindow getCourseWindow() {
		if (courseWindow == null) {
			courseWindow = new CourseWindow();
		}
		return courseWindow;

	}

}
