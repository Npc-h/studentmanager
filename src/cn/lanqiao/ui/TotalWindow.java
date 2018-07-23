package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class TotalWindow extends JFrame {
	public static int level;
	static String name;
	private JPanel contentPane;
	JOptionPane jOptionPane = new JOptionPane();
	static OperationWindow operationWindow;// 学生窗体
	static ScoreWindow scoreWindow;// 成绩窗体
	static CourseWindow courseWindow;
	static ClassWindow classWindow;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalWindow frame = new TotalWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */

	public static void setFrameImage(JFrame jf) {
		// 获取工具类对象
		// public static Toolkit getDefaultToolkit():获取默认工具包。
		Toolkit tk = Toolkit.getDefaultToolkit();

		// 根据路径获取图片
		Image i = tk.getImage("src\\12.jpg");

		// 给窗体设置图片
		jf.setIconImage(i);
	}

	public TotalWindow(String name,int level) {
		this.name = name;
		this.level = level;
		System.out.println(level);
		setForeground(new Color(0, 0, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 731);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ImageIcon icon = new ImageIcon("src/Logo.jpg");
		setIconImage(icon.getImage());
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel labelTop = new JLabel("欢迎"+name+"进入蓝桥学生信息管理系统");
		labelTop.setFont(new Font("宋体", Font.BOLD, 18));
		labelTop.setForeground(Color.BLUE);
		panelNorth.add(labelTop);
		// --------分割-------------------------------
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		// ---------------JTree------------------------
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(// 设置树形中节点以及子节点

				new DefaultMutableTreeNode("管理系统") {// 大节点
					{
						DefaultMutableTreeNode node_1;
						node_1 = new DefaultMutableTreeNode("我的管理");
						node_1.add(new DefaultMutableTreeNode("学生管理"));
						node_1.add(new DefaultMutableTreeNode("成绩管理"));
						node_1.add(new DefaultMutableTreeNode("课程管理"));
						node_1.add(new DefaultMutableTreeNode("班级管理"));
						node_1.add(new DefaultMutableTreeNode("关于我们"));
						add(node_1);
					}
				}

		));

		splitPane.setLeftComponent(tree);
		// -----------------右边JPanel---------------------
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(10, 10, 870, 690);
		panel.add(label);
		
		

		JLabel panel2 = new JLabel("");
		panel2.setBounds(15, 16, 855, 555);
		panel2.setFont(new Font("宋体", Font.BOLD, 17));
		panel2.setIcon(new ImageIcon("src\\12.jpg"));
		panel.add(panel2);
		JFrame jf = new JFrame();
		Toolkit tk = Toolkit.getDefaultToolkit();

		// 根据路径获取图片
		Image i = tk.getImage("src\\12.jpg");

		// 给窗体设置图片
		jf.setIconImage(i);

		// -----------------设置tree监听--------------------
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode lastSelectedPathComponent = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();

				if (lastSelectedPathComponent.toString().equals("学生管理")) {
					operationWindow = new OperationWindow();
					label.add(operationWindow);
					operationWindow.setBorder(BorderFactory.createEtchedBorder());// 去掉边框
					operationWindow.setVisible(true);
					try {
						// operationWindow.setVisible(false);
						scoreWindow.setVisible(false);
						courseWindow.setVisible(false);
						classWindow.setVisible(false);
					} catch (Exception show) {

					}

				}
				if (lastSelectedPathComponent.toString().equals("成绩管理")) {
//					System.out.println("成绩管理");
					scoreWindow = ScoreWindow.getScoreWindow();
					label.add(scoreWindow);
					scoreWindow.setBorder(BorderFactory.createEtchedBorder());// 去掉边框
					scoreWindow.setVisible(true);
					try {
						operationWindow.setVisible(false);
						// scoreWindow.setVisible(false);
						courseWindow.setVisible(false);
						classWindow.setVisible(false);
					} catch (Exception show) {

					}

				}
				if (lastSelectedPathComponent.toString().equals("课程管理")) {
//					System.out.println("课程管理");
					courseWindow = CourseWindow.getCourseWindow();
					label.add(courseWindow);
					courseWindow.setBorder(BorderFactory.createEtchedBorder());
					courseWindow.setVisible(true);
					try {
						operationWindow.setVisible(false);
						scoreWindow.setVisible(false);
						classWindow.setVisible(false);
					} catch (Exception show) {

					}

				}

				if (lastSelectedPathComponent.toString().equals("班级管理")) {
//					System.out.println("班级管理");
					classWindow = ClassWindow.getClassWindow();
					label.add(classWindow);
					classWindow.setBorder(BorderFactory.createEtchedBorder());// 去掉边框
					classWindow.setVisible(true);
					try {
						operationWindow.setVisible(false);
						classWindow.setVisible(true);
						scoreWindow.setVisible(false);
						courseWindow.setVisible(false);
//						 classWindow.setVisible(false);
					} catch (Exception show) {

					}
				}
				
				
				if (lastSelectedPathComponent.toString().equals("关于我们")) {
						//System.out.println("关于我们");
						System.out.println("关于我们");
						jOptionPane.showMessageDialog(null, "学生信息管理系统\n版本号：1.0\n作者：蓝桥第二组\n下载地址:https://github.com/Npc-h\n本程序仅供学习使用", "关于", jOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});

	}
}
