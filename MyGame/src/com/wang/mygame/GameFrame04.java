package com.wang.mygame;

//import java.awt.Color;
//import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试窗口物体沿着椭圆轨道飞行
 * @author Administrator
 *
 */
public class GameFrame04 extends MyFrame {// GUI编程：AWT，Swing

	Image img=GameUtil.getImage("image/sun.jpg");//添加图片的方法加载	
	
	private double x=100,y=100;
	private double degree=Math.PI/3;//弧度0~2*PI
	
	@Override
	public void paint(Graphics g) {

		g.drawImage(img,(int)x,(int)y, null);//默认为int类型所以需强转
		
		x=130+100*Math.cos(degree);
		y=200+50*Math.sin(degree);

		degree +=0.1;
	}

	public static void main(String[] args) {
		GameFrame04 gf = new GameFrame04();
		gf.launchFrame();
	}
}
