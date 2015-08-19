package com.wang.mygame;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame{
	

	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		//画窗口
		setSize(Constant.GAME_HIGHT, Constant.GAME_WIDTH);
		setLocation(100, 100);
		setVisible(true);// 窗口可见
		
		new PaintThread().start();//启动线程类
		
		//退出窗口方法重载
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	/**
	 * 定义一个重画窗口的线程类，是一个内部类，方便访问外部类的属性
	 * 需启动线程
	 * @author Administrator
	 *
	 */
	class PaintThread extends Thread{
		public void run(){
			while(true){//循环，实现重画画pain()中的内容，就是窗口里面的东西
				repaint();//重新画窗口中的内容
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//每隔40毫秒重画一次窗口
				
			}
		}
	}
}