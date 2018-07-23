package cn.lanqiao.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
public class LoginClass {
	Boolean packFram = false;

	public LoginClass() {
		loginFrame frame = new loginFrame();
		/*if (packFram) {
			frame.pack();
		} else {
			frame.validate();
		}
		// 调整窗体大小
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		;*/
		frame.setVisible(true);

	}
}
