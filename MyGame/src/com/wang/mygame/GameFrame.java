package com.wang.mygame;

//import java.awt.Color;
//import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ��Ϸ�ര��
 * 
 * @author Administrator
 *
 */
public class GameFrame extends Frame {// GUI��̣�AWT��Swing

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

	private double x,y;
	
	@Override
	public void paint(Graphics g) {
/*������ͼ�Σ���ɫ
		g.drawLine(100,100, 200, 200);
		g.drawRect(100, 100,200, 200);
		g.drawOval(100, 100, 200, 200);	
		
		Font f=new Font("����",Font.BOLD,100);//BOLD���������
		g.setFont(f);
		g.drawString("sdsdsdsds",200,200);
		
		Color c=g.getColor();
		g.fillRect(100, 100, 20, 20);
		g.setColor(Color.red);//��ðѾɵ���ɫ����һ��
		g.fillOval(300, 300, 20, 20);
		g.setColor(c);
*/		
		g.drawImage(img,(int)x,(int)y, null);//Ĭ��Ϊint����������ǿת
	
		x+=3;
		y+=3;
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
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
}
