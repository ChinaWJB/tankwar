package com.wang.mygame;

//import java.awt.Color;
//import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试窗口物体沿着任意角度飞行，
 * 最后实现台球游戏
 * @author Administrator
 *
 */
public class GameFrame03 extends Frame {// GUI编程：AWT，Swing

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

	private double x=100,y=100;
	private double degree=Math.PI/3;//弧度0~2*PI
	private double speed=10;
	
	@Override
	public void paint(Graphics g) {

		g.drawImage(img,(int)x,(int)y, null);//默认为int类型所以需强转
		
		if(speed>0){//必须加if否则speed减到0之后会继续减，球会反方向加速弹
			speed-=0.05;
		}//else{
			//speed=0;
		//}
		
		x+=speed*Math.cos(degree);//speed决定球飞行的速度
		y+=speed*Math.sin(degree);

		if(y>500-30){//碰到下面的边时
			degree=-degree;
		}
		if(y<30){//碰到上面的边
			degree=-degree;
		}
		if(x>500-30){//碰到右面的边时
			degree=Math.PI-degree;
		}
		if(x<0){//碰到左面的框
			degree=Math.PI-degree;
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
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//每隔40毫秒重画一次窗口
				
			}
		}
	}

	public static void main(String[] args) {
		GameFrame03 gf = new GameFrame03();
		gf.launchFrame();
	}
}
