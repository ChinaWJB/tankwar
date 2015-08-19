package com.wang.mygame;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame{
	

	/**
	 * ���ش���
	 */
	public void launchFrame() {
		//������
		setSize(Constant.GAME_HIGHT, Constant.GAME_WIDTH);
		setLocation(100, 100);
		setVisible(true);// ���ڿɼ�
		
		new PaintThread().start();//�����߳���
		
		//�˳����ڷ�������
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	/**
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ��࣬��������ⲿ�������
	 * �������߳�
	 * @author Administrator
	 *
	 */
	class PaintThread extends Thread{
		public void run(){
			while(true){//ѭ����ʵ���ػ���pain()�е����ݣ����Ǵ�������Ķ���
				repaint();//���»������е�����
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//ÿ��40�����ػ�һ�δ���
				
			}
		}
	}
}