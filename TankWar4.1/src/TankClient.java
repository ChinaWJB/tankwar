/*���ܣ�
 *	ʹ��˫����������˸����
 *ԭ��
 *	ˢ���ػ�Ƶ��̫�죬paint������û�����
 *	������ʾ
 *����䷨
 *	�����ж�����������ͼƬ�ϣ�һ������ʾ����
 *	
 * */
import java.awt.*;
import java.awt.event.*;
public class TankClient extends Frame {
	
	int x=50,y=50;
	
	Image offScreenImage=null;//repaint�������Ȼ����update����
	
	public void paint(Graphics g) {//������main�е��ã��÷���Ĭ�ϻᱻ����
		Color c=g.getColor();//�õ�����ԭ������ɫ���浽Color �Ķ���c��
		g.setColor(Color.RED);//����ʵ��Բ����ɫ
		g.fillOval(x, y, 30, 30);//��Բ�ĺ���
		g.setColor(c);//�ٰ�ԭ������ɫ���ȥ�����ı�ԭ������ɫ
		
		y+=5;
	}

	public void update(Graphics g){
		if(offScreenImage==null){
			offScreenImage=this.createImage(800,600);
		}
		Graphics gOffScreen =offScreenImage.getGraphics();
		
		Color c=gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);//������ɫΪ��ɫ������ʵ��Բ�Ĺ켣
		gOffScreen.fillRect(0,0,800,600);//���»�һ������
		gOffScreen.setColor(c);
		
		paint(gOffScreen);//��ͼ���ڱ���ͼƬ��
		g.drawImage(offScreenImage,0,0,null);//�ѱ���ͼƬһ���Ի���ǰ��
	}
	
	public void lauchFrame(){ 
		this.setLocation(400,300);
		this.setSize(800, 600);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter(){//������
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setResizable(false);//ʹ�޷��ı䴰�ڴ�С
		this.setBackground(Color.GREEN);
		setVisible(true);
		
		new Thread(new PaintThread()).start();//����һ�����������������߳�
	}
	
	public static void main(String[] args) {
		TankClient tc=new TankClient();
		tc.lauchFrame();
	}
	
	 private class PaintThread implements Runnable{

		public void run() {
			while(true){
				repaint();//�����ⲿ��װ���repaint()�����������ڲ���ĺô���repaint�ڲ��Զ�����paint����
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		 
	 }

}
