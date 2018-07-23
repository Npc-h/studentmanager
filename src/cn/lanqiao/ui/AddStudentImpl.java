package cn.lanqiao.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;

import cn.lanqiao.dao.TbStudentDao;
import cn.lanqiao.dao.impl.TbStudentDaoImpl;
import cn.lanqiao.model.TbClass;
import cn.lanqiao.model.TbStudent;
import cn.lanqiao.service.TbClassService;
import cn.lanqiao.service.TbStudentService;
import cn.lanqiao.service.impl.TbClassServiceImpl;
import cn.lanqiao.service.impl.TbStudentServiceImpl;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class AddStudentImpl extends JFrame {

	private static AddStudentImpl addStudentImpl = null;// 静态私有化一个对象
    JPanel contentPane;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel7 = new JLabel();
	JLabel jLabel8 = new JLabel();
	JTextField jTextField1 = new JTextField();
	JTextField jTextField2 = new JTextField();
	JTextField jTextField3 = new JTextField();
	JComboBox jComboBox4 = new JComboBox();
	JComboBox jComboBox5 = new JComboBox();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	Object clas[] = {};
	JLabel jLabel10 = new JLabel();
	JComboBox jComboBox1 = new JComboBox();
	JOptionPane jOptionPane1 = new JOptionPane();
	JOptionPane jOptionPane_LoginFeedback = new JOptionPane();
	String number, name, sex, birthday, classid;
	private JTextField textField;

	private AddStudentImpl() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	public void jbInit() throws Exception {
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setSize(new Dimension(592, 500));
		setTitle("学生信息录入");
		jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 23));
		jLabel1.setForeground(SystemColor.inactiveCaptionText);
		jLabel1.setText("学  生  信  息  录  入");
		jLabel1.setBounds(new Rectangle(196, 16, 232, 25));
		jLabel2.setFont(new java.awt.Font("Dialog", Font.BOLD, 23));
		jLabel2.setText("学  生  信  息  录  入");
		jLabel2.setBounds(new Rectangle(197, 17, 231, 25));
		jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel4.setText("学       号:");
		jLabel4.setBounds(new Rectangle(50, 59, 90, 22));
		
		jLabel6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel6.setText("姓       名:");
		jLabel6.setBounds(new Rectangle(50, 102, 90, 22));
		
		JLabel bor = new JLabel("生日");
		bor.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		bor.setText("\u751F       \u65E5:");
		bor.setBounds(new Rectangle(50, 142, 90, 22));
		getContentPane().add(bor);
		
		jLabel7.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel7.setText("所属班级:");
		jLabel7.setBounds(new Rectangle(50, 174, 90, 22));
		jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jTextField1.setBorder(BorderFactory.createLoweredBevelBorder());
		jTextField1.setBounds(new Rectangle(150, 52, 195, 23));
		jTextField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jTextField2.setBorder(BorderFactory.createLoweredBevelBorder());
		jTextField2.setText("");
		jTextField2.setBounds(new Rectangle(150, 102, 195, 23));
		
		jTextField3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jTextField3.setBorder(BorderFactory.createLoweredBevelBorder());
		jTextField3.setText("");
		jTextField3.setBounds(new Rectangle(150, 142, 195, 23));
		
		jComboBox4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jComboBox4.setBorder(BorderFactory.createLoweredBevelBorder());
		jComboBox4.setBounds(new Rectangle(150, 174, 125, 25));
		jComboBox4.addActionListener(new StudentInfoAddFrame_jComboBox4_actionAdapter(this));
		/*jComboBox5.setEnabled(false);
		jComboBox5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jComboBox5.setBorder(BorderFactory.createLoweredBevelBorder());
		jComboBox5.setBounds(new Rectangle(390, 174, 125, 25));
		jComboBox5.addActionListener(new StudentInfoAddFrame_jComboBox5_actionAdapter(this));*/
		jButton1.setText("提  交");
		jButton1.setBounds(new Rectangle(147, 274, 90, 27));
		jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
		jButton1.addActionListener(new StudentInfoAddFrame_jButton1_actionAdapter(this));
		jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton2.setText("退  出");
		jButton2.setBounds(new Rectangle(375, 274, 90, 27));
		jButton2.addActionListener(new StudentInfoAddFrame_jButton2_actionAdapter(this));
		jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel10.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel10.setText("性别：");
		jLabel10.setBounds(new Rectangle(50, 224, 93, 29));
		//jComboBox1.setEnabled(false);
		jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jComboBox1.setBounds(new Rectangle(150, 224, 125, 25));
		jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
		jOptionPane_LoginFeedback.setLayout(null);
		contentPane.add(jLabel2);
		contentPane.add(jLabel1);
		contentPane.add(jComboBox5);
		contentPane.add(jLabel7);
		contentPane.add(jComboBox4);
		contentPane.add(jTextField1);
		contentPane.add(jLabel4);
		contentPane.add(jLabel6);
		contentPane.add(jTextField2);
		contentPane.add(jTextField3);
		contentPane.add(jButton1);
		contentPane.add(jButton2);
		contentPane.add(jLabel10);
		contentPane.add(jComboBox1);
		contentPane.add(jOptionPane_LoginFeedback);
		this.jComboBox4.addItem("请选择班级");
		TbClassService tcs = new TbClassServiceImpl();
		List<TbClass> tc = tcs.getAllTbClass();
		for (TbClass tbClass : tc) {
			int banJ = tbClass.getClassId();
			jComboBox4.addItem(banJ);
		}
		this.jComboBox1.addItem("请选择性别");
		jComboBox1.addItem("男");
		jComboBox1.addItem("女");
		
//		JLabel bor = new JLabel("生日");
//		bor.setBounds(65, 149, 54, 15);
//		getContentPane().add(bor);
		
//		textField = new JTextField();
//		textField.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		textField.setBounds(150, 143, 195, 21);
//		getContentPane().add(textField);
//		textField.setColumns(10);

	}


	// 学生信息录入
	public void jButton1_actionPerformed(ActionEvent e) {
		// 异常判断
		if (jTextField1.getText().trim().equals("")) {
			jOptionPane1.showMessageDialog(this, "请输入学生学号！", "提 示", jOptionPane1.INFORMATION_MESSAGE);
		} else if (jTextField2.getText().trim().equals("")) {
			jOptionPane1.showMessageDialog(this, "请输入学生姓名！", "提 示", jOptionPane1.INFORMATION_MESSAGE);
		} else if (jComboBox4.getSelectedIndex() == 0) {
			jOptionPane1.showMessageDialog(this, "请选择学生所在班级！", "提 示", jOptionPane1.INFORMATION_MESSAGE);
		} else if (jComboBox5.getSelectedIndex() == 0) {
			jOptionPane1.showMessageDialog(this, "请选择学生性别", "提 示", jOptionPane1.INFORMATION_MESSAGE);
		} else {
			boolean Num = false;
			TbStudentService tss = new TbStudentServiceImpl();
			List<TbStudent> list = tss.getAllTbStudent();
			for (TbStudent tbStudent : list) {
				if (jTextField1.getText().trim().equals(tbStudent.getStudentNum()+"")){
					Num = true;
				}
			}
			if (Num) {
				jOptionPane1.showMessageDialog(this, "学生学号已存在，请重新输入！", "提示", JOptionPane.INFORMATION_MESSAGE, null);
			} else {
			
				number = jTextField1.getText().trim();
				name = jTextField2.getText().trim();
				birthday = jTextField3.getText().trim();
				classid = String.valueOf(jComboBox4.getSelectedItem()).trim();
				sex = String.valueOf(jComboBox1.getSelectedItem());
//				System.out.println(number);
//				System.out.println(classid);
				TbStudent tbstudent = new TbStudent(Integer.parseInt(number), name, sex, birthday, Integer.parseInt(classid));
				tss.insertTbStudent(tbstudent);
				jOptionPane1.showMessageDialog(this, "注册成功", "提示", JOptionPane.INFORMATION_MESSAGE, null);
				this.dispose();
			}

		}
	}

	// 单例模式获取对象
	public static synchronized AddStudentImpl getAddStudentImpl() {
		if (addStudentImpl == null) {
			addStudentImpl = new AddStudentImpl();
		}
		return addStudentImpl;
	}

//退出
	public void jButton2_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}

class StudentInfoAddFrame_jButton2_actionAdapter implements ActionListener {
	private AddStudentImpl adaptee;

	StudentInfoAddFrame_jButton2_actionAdapter(AddStudentImpl adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton2_actionPerformed(e);
	}
}

class StudentInfoAddFrame_jButton1_actionAdapter implements ActionListener {
	private AddStudentImpl adaptee;

	StudentInfoAddFrame_jButton1_actionAdapter(AddStudentImpl adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}

class StudentInfoAddFrame_jComboBox5_actionAdapter implements ActionListener {
	private AddStudentImpl adaptee;

	StudentInfoAddFrame_jComboBox5_actionAdapter(AddStudentImpl adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}

class StudentInfoAddFrame_jComboBox4_actionAdapter implements ActionListener {
	private AddStudentImpl adaptee;

	StudentInfoAddFrame_jComboBox4_actionAdapter(AddStudentImpl adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {

	}
}