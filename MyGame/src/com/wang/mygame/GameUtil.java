package com.wang.mygame;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * 游戏中常用开发工具类（比如：加载图）
 * @author Administrator
 *
 */
public class GameUtil {
	
	private GameUtil(){}//工具类通常会将方法私有化，外部就直接调用下面的方法就好了
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
