/*功能：
 *	使用双缓冲消除闪烁现象
 *原因
 *	刷新重画频率太快，paint方法还没有完成
 *	逐条显示
 *解决变法
 *	将所有东西华仔虚拟图片上，一次性显示出来
 *	
 * */
import java.awt.*;
import java.awt.event.*;
public class TankClient extends Frame {
	
	int x=50,y=50;
	
	Image offScreenImage=null;//repaint方法首先会调用update方法
	
	public void paint(Graphics g) {//不用在main中调用，该方法默认会被调用
		Color c=g.getColor();//得到画笔原来的颜色，存到Color 的对象c中
		g.setColor(Color.RED);//设置实心圆的颜色
		g.fillOval(x, y, 30, 30);//画圆的函数
		g.setColor(c);//再把原来的颜色设回去，不改变原来的颜色
		
		y+=5;
	}

	public void update(Graphics g){
		if(offScreenImage==null){
			offScreenImage=this.createImage(800,600);
		}
		Graphics gOffScreen =offScreenImage.getGraphics();
		
		Color c=gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);//背景颜色为绿色，消除实心圆的轨迹
		gOffScreen.fillRect(0,0,800,600);//重新画一个矩形
		gOffScreen.setColor(c);
		
		paint(gOffScreen);//把图画在背面图片上
		g.drawImage(offScreenImage,0,0,null);//把背景图片一次性画到前面
	}
	
	public void lauchFrame(){ 
		this.setLocation(400,300);
		this.setSize(800, 600);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter(){//匿名类
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setResizable(false);//使无法改变窗口大小
		this.setBackground(Color.GREEN);
		setVisible(true);
		
		new Thread(new PaintThread()).start();//窗口一建立起来，就启动线程
	}
	
	public static void main(String[] args) {
		TankClient tc=new TankClient();
		tc.lauchFrame();
	}
	
	 private class PaintThread implements Runnable{

		public void run() {
			while(true){
				repaint();//调用外部包装类的repaint()方法，这是内部类的好处，repaint内部自动调用paint方法
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		 
	 }

}
