package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbCourse;
import cn.lanqiao.model.TbStudent;
import cn.lanqiao.service.TbCourseService;
import cn.lanqiao.service.TbStudentService;
import cn.lanqiao.service.impl.TbCourseServiceImpl;
import cn.lanqiao.service.impl.TbStudentServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UpdateCourse extends JFrame {

	static JFrame frame;
	JOptionPane jOptionPane = new JOptionPane();
	//private static UpdateCourse updateCourse = null;
	TbCourse tbCourse = null;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateCourse frame = new UpdateCourse();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UpdateCourse() {
		
		frame = new JFrame();
		frame.setTitle("课程修改");
		frame.setBounds(100, 100, 570, 460);
		frame.dispose();//只关闭子窗体,不影响其他窗体
		frame.setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("更新课程：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		
		lblNewLabel.setBounds(108, 78, 86, 18);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLUE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"选择课程"}));
		TbCourseService co = new TbCourseServiceImpl();
		List<TbCourse> cos = co.getAllTbCourse();
		for (TbCourse tbClass : cos) {
			String banJ = tbClass.getCourseName();
			comboBox.addItem(banJ);
		}
		comboBox.setBounds(208, 76, 113, 24);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(358, 73, 86, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("课程名字：");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(186, 151, 92, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("课程学时：");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_2.setBounds(186, 199, 92, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("课程学分：");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_3.setBounds(186, 252, 92, 18);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(292, 149, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(292, 197, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(292, 250, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("确认更新");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(208, 318, 113, 27);
		contentPane.add(btnNewButton_1);
		
		frame.getContentPane().add(contentPane);
		
		//隐藏控件
		lblNewLabel_1.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_3.setVisible(false);
		textField.setVisible(false);
		textField_1.setVisible(false);
		textField_2.setVisible(false);
		btnNewButton_1.setVisible(false);
		
		//确认要修改的课程
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 异常判断
				if (comboBox.getSelectedIndex() == 0) {
					jOptionPane.showMessageDialog(null, "请选择课程！", "提 示", jOptionPane.INFORMATION_MESSAGE);
				} else {
					TbCourseService co = new TbCourseServiceImpl();
					List<TbCourse> cos = co.getAllTbCourse();
					for (TbCourse s : cos) {
						if ((s.getCourseName()).equals(String.valueOf(comboBox.getSelectedItem()))) {
							tbCourse = s;
							//显示隐藏的控件
							lblNewLabel_1.setVisible(true);
							lblNewLabel_2.setVisible(true);
							lblNewLabel_3.setVisible(true);
							textField.setVisible(true);
							textField_1.setVisible(true);
							textField_2.setVisible(true);
							btnNewButton_1.setVisible(true);
							jOptionPane.showMessageDialog(null, "请开始修改，请刷新数据","提 示",
									jOptionPane.INFORMATION_MESSAGE);
							break;
	
						}
					}		
				}
			}
		});
		
		//修改操作
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 异常判断
				if (textField.getText().trim().equals("")) {
					jOptionPane.showMessageDialog(null, "请输入课程名字！", "提 示", jOptionPane.INFORMATION_MESSAGE);
				} else if (textField_1.getText().trim().equals("")) {
					jOptionPane.showMessageDialog(null, "请输入课程学时！", "提 示", jOptionPane.INFORMATION_MESSAGE);
				} else if (textField_2.getText().trim().equals("")) {
					jOptionPane.showMessageDialog(null, "请选择课程学分！", "提 示", jOptionPane.INFORMATION_MESSAGE);
				} else {
					TbCourseService co = new TbCourseServiceImpl();
					tbCourse.setCourseName(textField.getText());
					tbCourse.setCourseHour(Integer.parseInt(textField_1.getText()));
					tbCourse.setCourseScore(textField_2.getText());
					co.updateTbCourse(tbCourse);
					frame.dispose();
					jOptionPane.showMessageDialog(null, "修改成功，请刷新数据","提 示",jOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
	}
	
	/*public static synchronized UpdateCourse getUpdateCourse(){
		if(updateCourse==null){
			 updateCourse = new UpdateCourse();
		}
		return updateCourse;
	}*/
}
