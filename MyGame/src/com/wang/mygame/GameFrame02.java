package com.wang.mygame;

//import java.awt.Color;
//import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试窗口物体沿着各种轨迹移动
 * @author Administrator
 *
 */
public class GameFrame02 extends Frame {// GUI编程：AWT，Swing

	Image img=GameUtil.getImage("image/sun.jpg");//添加图片的方法加载	
	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		//画窗口
		setSize(500, 500);
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

	private double x=30.0,y;
	private boolean LEFT;
	private boolean	UP;
	
	@Override
	public void paint(Graphics g) {

		g.drawImage(img,(int)x,(int)y, null);//默认为int类型所以需强转
		
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

	public static void main(String[] args) {
		GameFrame02 gf = new GameFrame02();
		gf.launchFrame();
	}
}
