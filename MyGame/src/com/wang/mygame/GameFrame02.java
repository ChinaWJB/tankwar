package com.wang.mygame;

//import java.awt.Color;
//import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ���Դ����������Ÿ��ֹ켣�ƶ�
 * @author Administrator
 *
 */
public class GameFrame02 extends Frame {// GUI��̣�AWT��Swing

	Image img=GameUtil.getImage("image/sun.jpg");//���ͼƬ�ķ�������	
	/**
	 * ���ش���
	 */
	public void launchFrame() {
		//������
		setSize(500, 500);
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

	private double x=30.0,y;
	private boolean LEFT;
	private boolean	UP;
	
	@Override
	public void paint(Graphics g) {

		g.drawImage(img,(int)x,(int)y, null);//Ĭ��Ϊint����������ǿת
		
//		if(LEFT){
//			x-=10;
//		}else{
//			x+=10;
//		}	
//		if(x>500-30){
//			LEFT=true;
//		}
//		if(x<0){
//			LEFT=false;
//		}
		
		if(UP){
			y-=10;
		}else{
			y+=10;
		}	
		if(y>500-30){
			UP=true;
		}
		if(y<30){
			UP=false;
		}
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

	public static void main(String[] args) {
		GameFrame02 gf = new GameFrame02();
		gf.launchFrame();
	}
}
