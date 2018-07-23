package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbStudent;
import cn.lanqiao.model.UserMnager;
import cn.lanqiao.service.TbStudentService;
import cn.lanqiao.service.UserMnagerService;
import cn.lanqiao.service.impl.TbScoreServiceImpl;
import cn.lanqiao.service.impl.TbStudentServiceImpl;
import cn.lanqiao.service.impl.UserMnagerServiceImpl;

import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class RemoveStuendt extends JFrame {
	
	private JTextField textField;
	JOptionPane jOptionPane = new JOptionPane();
	static JFrame frame;
	private static RemoveStuendt removeStuendt = null;   //静态私有化一个对象

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private RemoveStuendt() {
		
		frame = new JFrame();
		frame.setTitle("删除学生");
		frame.setBounds(100, 100, 570, 460);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//全部关闭
//		frame.DISPOSE_ON_CLOSE
		frame.dispose();//只关闭子窗体,不影响其他窗体
		frame.setLocationRelativeTo(null);
			
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(339, 126, 100, 30);
		textField.setColumns(10);
		panel.add(textField);
		
		JButton button = new JButton("确认删除");
		button.setForeground(Color.BLUE);
		button.setBounds(215, 316, 110, 35);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("请输入要删除学生的学号：");
		lblNewLabel.setBounds(94, 130, 231, 18);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		jOptionPane.setBounds(new Rectangle(28, 316, 262, 107));
		jOptionPane.setLayout(null);
		panel.add(jOptionPane);
		
		frame.getContentPane().add(panel);
		
		//---按钮监听设置
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//先假设学号错误
				boolean cheng=true;
				// 异常判断
				if (textField.getText().length() == 0) {
					
					jOptionPane.showMessageDialog(null, "学号不能为空！", "提 示",
							jOptionPane.INFORMATION_MESSAGE);
				} else {
					TbStudentService st = new TbStudentServiceImpl();
					List<TbStudent> sts = st.getAllTbStudent();
					for (TbStudent s : sts) {
						if ((s.getStudentNum() + "").equals(textField.getText())) {
							cheng = false;
							st.removeTbStudent(s);
							System.out.println("删除成功");
							frame.dispose();
							jOptionPane.showMessageDialog(null, "删除成功，请刷新数据","提 示",
									jOptionPane.INFORMATION_MESSAGE);
							break;
	
						}
					}
					if(cheng) {
						jOptionPane.showMessageDialog(null, "没有该学号","提 示",
								jOptionPane.INFORMATION_MESSAGE);

					}
					
				}
			}
		});
	}
	
	//单例模式获取对象
	public static synchronized RemoveStuendt getRemoveStuendt(){
		if(removeStuendt==null){
			removeStuendt = new RemoveStuendt();
		}
		return removeStuendt;
	}
}
