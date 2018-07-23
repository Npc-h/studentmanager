package cn.lanqiao.ui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/*
 * 程序开始，登陆入口
 * @author 蓝桥第二组
 * 
 */
public class Main {

	public static void main(String[] args) {
		//设置事件调度线程 避免死锁
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//设置平台默认窗口
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 new LoginClass();
			}
		});		
	}
	
	

}
