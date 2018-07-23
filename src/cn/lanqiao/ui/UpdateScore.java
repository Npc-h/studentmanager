package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbScore;
import cn.lanqiao.model.TbScore;
import cn.lanqiao.service.TbScoreService;
import cn.lanqiao.service.TbScoreService;
import cn.lanqiao.service.impl.TbScoreServiceImpl;
import cn.lanqiao.service.impl.TbScoreServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class UpdateScore extends JFrame {

	private JPanel contentPane;
	static JFrame frame;
	JOptionPane jOptionPane = new JOptionPane();
	private static UpdateScore updateScore = null;
	private JTextField textField_1;
	//储存要修改的成绩对象
	TbScore tbScore = null;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	private UpdateScore() {
		
		frame = new JFrame();
		frame.setTitle("成绩修改");
		frame.setBounds(100, 100, 570, 460);
		frame.dispose();//只关闭子窗体,不影响其他窗体
		frame.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("请输入新的成绩：");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(130, 172, 139, 37);
		contentPane.add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(283, 174, 108, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确定修改");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(222, 303, 128, 44);
		contentPane.add(btnNewButton);
			
		JLabel lblNewLabel = new JLabel("请输入成绩编号：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(107, 46, 139, 33);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(240, 45, 108, 33);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("确认");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(362, 44, 113, 34);
		contentPane.add(btnNewButton_1);
		
		jOptionPane.setBounds(new Rectangle(28, 316, 260, 110));
		jOptionPane.setLayout(null);
		contentPane.add(jOptionPane);
		
		frame.getContentPane().add(contentPane);
		
		//隐藏控件
		textField.setVisible(false);
		lblNewLabel_1.setVisible(false);
		btnNewButton.setVisible(false);
		
		
		
		//确认成绩编号
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//先假设成绩编号错误
				boolean cheng=true;
				// 异常判断
				if (textField_1.getText().length() == 0) {
					jOptionPane.showMessageDialog(null, "成绩编号不能为空！", "提 示",jOptionPane.INFORMATION_MESSAGE);
				} else {
					TbScoreService se = new TbScoreServiceImpl();
					List<TbScore> ses = se.getAllTbScore();
					for (TbScore s : ses) {
						if ((s.getScoreId()+ "").equals(textField_1.getText())) {
							cheng = false;
							tbScore = s;
							//显示隐藏的控件
							textField.setVisible(true);
							lblNewLabel_1.setVisible(true);
							btnNewButton.setVisible(true);
							
//							textField_2.setText(s.getScoreName());
//							textField_4.setText(s.getScoreBirthday());
							jOptionPane.showMessageDialog(null, "请输入要更新的信息","提 示",jOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}
					if(cheng) {
						jOptionPane.showMessageDialog(null, "没有该成绩编号","提 示",jOptionPane.INFORMATION_MESSAGE);
					}	
				}
			}
		});
		
		//修改 成绩
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 异常判断
				if (textField.getText().trim().equals("")) {
					jOptionPane.showMessageDialog(null, "请输入成绩！", "提 示", jOptionPane.INFORMATION_MESSAGE);
				} else  {
					
					TbScoreService se = new TbScoreServiceImpl();
					tbScore.setScoreGrade(Integer.parseInt(textField.getText()));
					se.updateTbScore(tbScore);
					System.out.println("修改成功");
					frame.dispose();
					jOptionPane.showMessageDialog(null, "修改成功，请刷新数据","提 示",jOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
	}
	public static synchronized UpdateScore getUpdateScore(){
		if(updateScore==null){
			 updateScore = new UpdateScore();
		}
		return updateScore;
	}

}
