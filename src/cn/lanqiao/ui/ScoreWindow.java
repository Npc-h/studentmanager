package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.junit.Test;

import cn.lanqiao.model.TbStudent;
import cn.lanqiao.model.UserMnager;
import cn.lanqiao.service.TbStudentService;
import cn.lanqiao.service.UserMnagerService;
import cn.lanqiao.service.impl.TbStudentServiceImpl;
import cn.lanqiao.service.impl.UserMnagerServiceImpl;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ScoreWindow extends JInternalFrame {
	private JPanel contentPane;
	private static ScoreWindow scoreWindow = null;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	private ScoreWindow() {
		setVisible(true);

		setBounds(0, -28, 870, 627);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelNorth = new JPanel();
		panelNorth.setBounds(5, 5, 844, 31);
		contentPane.add(panelNorth);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		


		JLabel label = new JLabel("成绩管理");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 18));
		panelNorth.add(label);
		
		JButton btnNewButton = new JButton("新增成绩");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddScore addScore = AddScore.getAddScore();
				addScore.setVisible(true);
				addScore.setLocationRelativeTo(null);
			}
		});
//		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
//		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(58, 496, 111, 37);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("删除成绩");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*RemoveScore removeScore = RemoveScore.getRemoveScore();
				removeScore.setVisible(true);
				removeScore.setLocation(300, 100);
				removeScore.setSize(300, 200);
				removeScore.setLocationRelativeTo(null);*/
			}
		});
//		button.setForeground(Color.BLUE);
//		button.setFont(new Font("宋体", Font.BOLD, 16));
		button.setBounds(246, 496, 111, 37);
		contentPane.add(button);
		
		JButton button_1 = new JButton("修改成绩");
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateScore updateScore = UpdateScore.getUpdateScore();
				updateScore.frame.setVisible(true);
				
			}
		});
		if(TotalWindow.level==2) {
			btnNewButton.setVisible(false);
			button.setVisible(false);
			button_1.setVisible(false);
		}
//		button_1.setForeground(Color.BLUE);
//		button_1.setFont(new Font("宋体", Font.BOLD, 16));
		button_1.setBounds(454, 496, 111, 37);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("查看成绩");
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LookScore ls = LookScore.getLookScore();
				ls.setVisible(true);
				ls.setLocationRelativeTo(null);
				
			}
		});
		
//		button_2.setForeground(Color.BLUE);
//		button_2.setFont(new Font("宋体", Font.BOLD, 16));
		button_2.setBounds(665, 496, 111, 37);
		contentPane.add(button_2);
		
		
		JLabel backLabelclassScores = new JLabel("");
		backLabelclassScores.setForeground(Color.WHITE);
		backLabelclassScores.setBounds(0, 0, 860, 600);
		backLabelclassScores.setIcon(new ImageIcon("src\\截图2.jpg"));
		contentPane.add(backLabelclassScores);	
	}

	// 单例模式
	public static synchronized ScoreWindow getScoreWindow() {
		if (scoreWindow == null) {
			scoreWindow = new ScoreWindow();
		}
		return scoreWindow;
	}
}
