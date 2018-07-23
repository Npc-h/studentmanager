package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbCourse;
import cn.lanqiao.service.TbCourseService;
import cn.lanqiao.service.impl.TbCourseServiceImpl;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RemoveCourse extends JFrame {

	static JFrame frame;
	public JTextField textField;
	JOptionPane jOptionPane = new JOptionPane();
	//private static RemoveCourse removeCourse = null;

	public RemoveCourse() {
		
		frame = new JFrame();
		frame.setTitle("课程删除");
		frame.setBounds(100, 100, 570, 460);
		frame.dispose();//只关闭子窗体,不影响其他窗体
		frame.setLocationRelativeTo(null);
	
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("确认删除");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(210, 309, 113, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("请选择要删除的课程：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(121, 160, 175, 18);
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
		comboBox.setBounds(310, 158, 107, 24);
		contentPane.add(comboBox);
		
		frame.getContentPane().add(contentPane);
		
		//删除监听
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 异常判断
				if (comboBox.getSelectedIndex() == 0) {
					jOptionPane.showMessageDialog(null, "请选择班级！", "提 示", jOptionPane.INFORMATION_MESSAGE);
				} else {
					TbCourseService co = new TbCourseServiceImpl();
					List<TbCourse> cos = co.getAllTbCourse();
					for (TbCourse s : cos) {
						if ((s.getCourseName()).equals(String.valueOf(comboBox.getSelectedItem()))) {
							co.removeTbCourse(s);
							System.out.println("删除成功");
							frame.dispose();
							jOptionPane.showMessageDialog(null, "删除成功，请刷新数据","提 示",
									jOptionPane.INFORMATION_MESSAGE);
							break;
	
						}
					}		
				}
			}
		});
	}
	
	
/*	//单例模式
	public static synchronized RemoveCourse getRemoveCourse(){
		if(removeCourse==null){
			removeCourse = new RemoveCourse();
		}
		return removeCourse;
	}*/
}
