package cn.lanqiao.ui;

import java.awt.Color;
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

public class ClassWindow extends JInternalFrame {

	private JPanel ClasscontentPane;
	private static ClassWindow classWindow = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private ClassWindow() {
		setVisible(true);

		setBounds(0, -28, 870, 627);

		ClasscontentPane = new JPanel();
		ClasscontentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ClasscontentPane);
		ClasscontentPane.setLayout(null);

		JPanel panelNorth = new JPanel();
		panelNorth.setBounds(5, 5, 844, 31);
		ClasscontentPane.add(panelNorth);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		


		JLabel label = new JLabel("班级管理");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 18));
		panelNorth.add(label);
		
		JButton AddClassbutton = new JButton("新增班级");
		AddClassbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//新增班级监听
				AddClass addClass = AddClass.getAddClass();
				addClass.setVisible(true);
				addClass.setLocationRelativeTo(null);
			}
		});
		AddClassbutton.setBounds(58, 496, 111, 37);
		ClasscontentPane.add(AddClassbutton);
		
		JButton RemoveClassButton = new JButton("删除班级");
		RemoveClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveClass removeClass = RemoveClass.getRemoveClass();
				removeClass.setVisible(true);
				removeClass.setLocationRelativeTo(null);
			}
		});
		RemoveClassButton.setBounds(246, 496, 111, 37);
		ClasscontentPane.add(RemoveClassButton);
		
		JButton SelectClassButton = new JButton("查询班级");
		SelectClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println("是否绑定成功");
				LookClass lookClass =  LookClass.getLookClass();
				lookClass.setVisible(true);
				lookClass.setLocationRelativeTo(null);
			}
		});
		SelectClassButton.setBounds(665, 496, 111, 37);
		ClasscontentPane.add(SelectClassButton);
		
		JButton UpdateClassButton = new JButton("修改班级");
		UpdateClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		UpdateClassButton.setBounds(454, 496, 111, 37);
		ClasscontentPane.add(UpdateClassButton);
		
		JButton btnNewButton = new JButton("班级管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddScore addScore = AddScore.getAddScore();
				addScore.setVisible(true);
				addScore.setLocationRelativeTo(null);
			}
			
		});
		
		if(TotalWindow.level==2) {
			AddClassbutton.setVisible(false);
			RemoveClassButton.setVisible(false);
			UpdateClassButton.setVisible(false);
		}
		
		
		JLabel backLabelclass = new JLabel("");
		backLabelclass.setForeground(Color.WHITE);
		backLabelclass.setBounds(0, 0, 860, 600);
		backLabelclass.setIcon(new ImageIcon("src\\截图1.jpg"));
		ClasscontentPane.add(backLabelclass);	
		
	
	}
		
		// 单例模式
		public static synchronized ClassWindow getClassWindow() {
			if (classWindow == null) {
				classWindow = new ClassWindow();
			}
			return classWindow;
		
		
}
	
	
	
	}
