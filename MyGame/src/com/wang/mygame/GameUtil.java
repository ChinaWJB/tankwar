package com.wang.mygame;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * ��Ϸ�г��ÿ��������ࣨ���磺����ͼ��
 * @author Administrator
 *
 */
public class GameUtil {
	
	private GameUtil(){}//������ͨ���Ὣ����˽�л����ⲿ��ֱ�ӵ�������ķ����ͺ���
	public static Image getImage(String path){
		URL u=GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img=null;
		
		try {
			img=ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return img;
	}
}
