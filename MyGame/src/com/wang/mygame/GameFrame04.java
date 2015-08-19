package com.wang.mygame;

//import java.awt.Color;
//import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ���Դ�������������Բ�������
 * @author Administrator
 *
 */
public class GameFrame04 extends MyFrame {// GUI��̣�AWT��Swing

	Image img=GameUtil.getImage("image/sun.jpg");//���ͼƬ�ķ�������	
	
	private double x=100,y=100;
	private double degree=Math.PI/3;//����0~2*PI
	
	@Override
	public void paint(Graphics g) {

		g.drawImage(img,(int)x,(int)y, null);//Ĭ��Ϊint����������ǿת
		
		x=130+100*Math.cos(degree);
		y=200+50*Math.sin(degree);

		degree +=0.1;
	}

	public static void main(String[] args) {
		GameFrame04 gf = new GameFrame04();
		gf.launchFrame();
	}
}
