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
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class OperationWindow extends JInternalFrame {
	private JPanel contentPane;
	private JTable table;// 表
	JScrollPane scrollPane = new JScrollPane();// 滚动条
	// private static OperationWindow studentWindow = null;
	private JTextField textField;
	private JTextField textField_1;
	String TableHead[];
	Object student[][];
	Object[][] student1;
	int i;
	int j;
	JOptionPane jOptionPane_LoginFeedback;
	JTable newTable;
	String TableHead2[];
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public OperationWindow() {
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

		JLabel label = new JLabel("学生管理");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 18));
		panelNorth.add(label);

		JLabel label_1 = new JLabel("请选择查询方式:");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("宋体", Font.BOLD, 16));
		label_1.setBounds(255, 61, 132, 31);
		contentPane.add(label_1);

		String choose[] = { "-请选择-", "学号查询", "姓名查询" };
		JComboBox comboBox = new JComboBox(choose);
		comboBox.setFont(new Font("宋体", Font.PLAIN, 14));
		comboBox.setBounds(437, 67, 152, 21);
		contentPane.add(comboBox);
		// -----------------------------表数据显示---------------------------
		TbStudentService studentService = new TbStudentServiceImpl();
		List<TbStudent> students = studentService.getAllTbStudent();
		// 将数据转化成二维数组存入
		TableHead = new String[] { "学号", "姓名", "性别", "出生日期", "班级编号" };// 表头字段
		student = new Object[students.size()][TableHead.length];// 数据
		// 表头

		for (i = 0; i < students.size(); i++) {
			for (j = 0; j < TableHead.length; j++) {
				switch (j) {
				case 0:
					student[i][j] = students.get(i).getStudentNum();
					break;
				case 1:
					student[i][j] = students.get(i).getStudentName();
					break;
				case 2:
					student[i][j] = students.get(i).getStudentSex();
					break;
				case 3:
					student[i][j] = students.get(i).getStudentBirthday();
					break;
				case 4:
					student[i][j] = students.get(i).getClassId();
					break;

				}
			}
		}
		getTable();
//		table = null;
//		table = new JTable(student, TableHead);
//		table.setEnabled(false);
//		table.setBounds(0, 0, 529, 407);
//		table.setFont(new Font("宋体", Font.BOLD, 14));
//
//		scrollPane.setBounds(5, 200, 839, 344);
//		getContentPane().add(scrollPane);
//		scrollPane.setViewportView(table);
		// ----------------------------------------------
		JButton button_1 = new JButton("新增学生");
		button_1.setFont(new Font("宋体", Font.BOLD, 14));
		button_1.setForeground(Color.BLUE);
		button_1.setBounds(98, 554, 104, 39);
		contentPane.add(button_1);

		JButton button_2 = new JButton("删除学生");
		button_2.setForeground(Color.BLUE);
		button_2.setFont(new Font("宋体", Font.BOLD, 14));
		button_2.setBounds(295, 554, 104, 39);
		contentPane.add(button_2);

		JButton button_3 = new JButton("更新学生");
		button_3.setForeground(Color.BLUE);
		button_3.setFont(new Font("宋体", Font.BOLD, 14));
		button_3.setBounds(495, 554, 104, 39);
		contentPane.add(button_3);
		if (TotalWindow.level == 2) {
			button_1.setVisible(false);
			button_2.setVisible(false);
			button_3.setVisible(false);
		}

		JButton button_4 = new JButton("刷新数据");
		button_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TbStudentService studentService = new TbStudentServiceImpl();
				List<TbStudent> students = studentService.getAllTbStudent();
				// 将数据转化成二维数组存入
				TableHead = new String[] { "学号", "姓名", "性别", "出生日期", "班级编号" };// 表头字段
				student = new Object[students.size()][TableHead.length];// 数据
				// 表头

				for (i = 0; i < students.size(); i++) {
					for (j = 0; j < TableHead.length; j++) {
						switch (j) {
						case 0:
							student[i][j] = students.get(i).getStudentNum();
							break;
						case 1:
							student[i][j] = students.get(i).getStudentName();
							break;
						case 2:
							student[i][j] = students.get(i).getStudentSex();
							break;
						case 3:
							student[i][j] = students.get(i).getStudentBirthday();
							break;
						case 4:
							student[i][j] = students.get(i).getClassId();
							break;

						}
					}
				}
				getTable();
			}
		});
		button_4.setForeground(Color.BLUE);
		button_4.setFont(new Font("宋体", Font.BOLD, 14));
		button_4.setBounds(695, 554, 104, 39);
		contentPane.add(button_4);
		// --------------------------
		JLabel label_2 = new JLabel("请输入学生学号:");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 14));
		label_2.setBounds(255, 102, 132, 31);
		contentPane.add(label_2);

		textField = new JTextField();// 学号输入框
		textField.setBounds(437, 98, 152, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label_3 = new JLabel("请输入学生姓名:");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("宋体", Font.BOLD, 14));
		label_3.setBounds(255, 102, 132, 31);
		contentPane.add(label_3);

		textField_1 = new JTextField();// 姓名输入框
		textField_1.setColumns(10);
		textField_1.setBounds(437, 98, 152, 30);
		contentPane.add(textField_1);

		JButton button = new JButton("查询");// 第一个查询学号
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(639, 98, 93, 27);
		contentPane.add(button);

		JButton button_5 = new JButton("查询");// 第二个查询姓名
		button_5.setFont(new Font("宋体", Font.PLAIN, 16));
		button_5.setBounds(639, 98, 93, 27);
		contentPane.add(button_5);

		// 监听3:新增学生
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("是否绑定成功");//测试绑定成功
				AddStudentImpl addStudentImpl = AddStudentImpl.getAddStudentImpl();// 弹出新窗体
				addStudentImpl.setLocation(400, 200);
				addStudentImpl.setSize(592, 350);
				addStudentImpl.setVisible(true);
				addStudentImpl.setResizable(false);
				addStudentImpl.validate();

			}
		});
		// 监听4:更新学生
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStudent updatestudent = UpdateStudent.getUpdateStudent();
				updatestudent.frame.setVisible(true);
			}
		});

		// ---监听1.模糊查询监听设置
		// 第一步:先隐藏
		label_2.setVisible(false);
		textField.setVisible(false);
		button.setVisible(false);

		label_3.setVisible(false);
		textField_1.setVisible(false);
		button_5.setVisible(false);
		// 第二步触发下拉监听后显示出来
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedIndex() == 1) {
					label_2.setVisible(true);
					textField.setVisible(true);
					button.setVisible(true);
					label_3.setVisible(false);
					textField_1.setVisible(false);
					button_5.setVisible(false);

				} else if (comboBox.getSelectedIndex() == 2) {
					label_3.setVisible(true);
					textField_1.setVisible(true);
					button_5.setVisible(true);
					label_2.setVisible(false);
					textField.setVisible(false);
					button.setVisible(false);
				}

			}
		});

		// 删除按钮监听设置
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RemoveStuendt removeStuendt = RemoveStuendt.getRemoveStuendt();// 弹出新窗体
				removeStuendt.frame.setVisible(true);
				// --------------------

			}
		});
		// ---监听2:点击查询》对学生的学号进行查询
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("测试是否绑定成功");
				// 获取输入框数据 进行判断是否存在数据库中》如果不存在弹出dialog,存在就覆盖表格中信息显示出来//为空给出提示框

				String input_number = textField.getText();// 输入的学号
				if (input_number.length() == 0) {
					jOptionPane_LoginFeedback = new JOptionPane();
					jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
					jOptionPane_LoginFeedback.setLayout(null);
					// jOptionPane_LoginFeedback.setVisible(false);
					contentPane.add(jOptionPane_LoginFeedback);
					jOptionPane_LoginFeedback.setVisible(true);
					jOptionPane_LoginFeedback.showMessageDialog(contentPane, "请输入查询学号", "错误提示",
							OperationWindow.this.jOptionPane_LoginFeedback.ERROR_MESSAGE);

				} else {

					TbStudentService studentService = new TbStudentServiceImpl();
					List<TbStudent> students = studentService.getAllTbStudent();
					Boolean flag = false;
					for (TbStudent msg : students) {
						if ((String.valueOf(msg.getStudentNum()).trim().equals(input_number))) {
							// 有账号登陆就显示出来
							// 将查询数据更新显示到表格中
							TableHead = new String[] { "学号", "姓名", "性别", "出生日期", "班级编号" };// 表头字段
							student = new Object[1][5];
							student[0][0] = msg.getStudentNum();
							student[0][1] = msg.getStudentName();
							student[0][2] = msg.getStudentSex();
							student[0][3] = msg.getStudentBirthday();
							student[0][4] = msg.getClassId();
							// table.repaint();
							getTable();
//							table = null;
//							table = new JTable(student1, TableHead2);
//							table.setEnabled(false);
//							// System.out.println(table.getColumnCount());
//							table.setBounds(0, 0, 529, 407);
//							table.setFont(new Font("宋体", Font.BOLD, 14));
//							scrollPane = new JScrollPane();// 滚动条
//							scrollPane.setBounds(5, 200, 839, 344);
//							getContentPane().add(scrollPane);
//							scrollPane.setViewportView(table);
							// 表头
							flag = true;
						}
					}
					if (!flag) {// 弹框
						jOptionPane_LoginFeedback = new JOptionPane();
						jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
						jOptionPane_LoginFeedback.setLayout(null);
						// jOptionPane_LoginFeedback.setVisible(false);
						contentPane.add(jOptionPane_LoginFeedback);
						jOptionPane_LoginFeedback.setVisible(true);
						jOptionPane_LoginFeedback.showMessageDialog(contentPane, "没有该学号学生", "错误提示",
								OperationWindow.this.jOptionPane_LoginFeedback.ERROR_MESSAGE);

					}
				}
			}
		});

		// ---监听3:点击查询》对学生的姓名进行查询 输入一个或者多个汉字来查询
		button_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input_name = textField_1.getText();// 拿到输入框数据
				if (input_name.length() == 0) {// 没有输入姓名
					jOptionPane_LoginFeedback = new JOptionPane();
					jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
					jOptionPane_LoginFeedback.setLayout(null);
					contentPane.add(jOptionPane_LoginFeedback);
					jOptionPane_LoginFeedback.setVisible(true);
					jOptionPane_LoginFeedback.showMessageDialog(contentPane, "请输入查询姓名", "错误提示",
							OperationWindow.this.jOptionPane_LoginFeedback.ERROR_MESSAGE);
				} else {
					TbStudentService tss = new TbStudentServiceImpl();
					List<TbStudent> stus = tss.getvaguaSearch(input_name.trim());
					for (TbStudent names : stus) {
						// System.out.println(names);
						 TableHead = new String[] { "学号", "姓名", "性别", "出生日期", "班级编号" };// 模糊表头字段

						 student = new Object[stus.size()][TableHead.length];
						for (i = 0; i < stus.size(); i++) {
							for (j = 0; j < TableHead.length; j++) {
								switch (j) {
								case 0:
									student[i][j] = stus.get(i).getStudentNum();
									break;
								case 1:
									student[i][j] = stus.get(i).getStudentName();
									break;
								case 2:
									student[i][j] = stus.get(i).getStudentSex();
									break;
								case 3:
									student[i][j] = stus.get(i).getStudentBirthday();
									break;
								case 4:
									student[i][j] = stus.get(i).getClassId();
									break;

								}
							}
						}
						getTable();
					}
				}

			}
		});

	}
	public void getTable(){
		table = null;
		table = new JTable(student, TableHead);
		table.setEnabled(false);
		table.setBounds(0, 0, 529, 407);
		table.setFont(new Font("宋体", Font.BOLD, 14));

		scrollPane.setBounds(5, 200, 839, 344);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
	}
}
