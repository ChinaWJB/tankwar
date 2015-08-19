package com.wang.mygame;

//import java.awt.Color;
//import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ���Դ���������������Ƕȷ��У�
 * ���ʵ��̨����Ϸ
 * @author Administrator
 *
 */
public class GameFrame05 extends MyFrame {// GUI��̣�AWT��Swing

	Image img=GameUtil.getImage("image/sun.jpg");//���ͼƬ�ķ�������	
	/**
	 * ���ش���
	 */

	private double x=100,y=100;
	private double degree=Math.PI/3;//����0~2*PI
	private double speed=10;
	
	@Override
	public void paint(Graphics g) {

		g.drawImage(img,(int)x,(int)y, null);//Ĭ��Ϊint����������ǿת
		
		if(speed>0){//�����if����speed����0֮������������ᷴ������ٵ�
			speed-=0.05;
		}//else{
			//speed=0;
		//}
		
		x+=speed*Math.cos(degree);//speed��������е��ٶ�
		y+=speed*Math.sin(degree);

		if(y>500-30){//��������ı�ʱ
			degree=-degree;
		}
		if(y<30){//��������ı�
			degree=-degree;
		}
		if(x>500-30){//��������ı�ʱ
			degree=Math.PI-degree;
		}
		if(x<0){//��������Ŀ�
			degree=Math.PI-degree;
		}

	}

	public static void main(String[] args) {
		GameFrame05 gf = new GameFrame05();
		gf.launchFrame();
	}
}
