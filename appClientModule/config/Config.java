package config;

import java.awt.Dimension;
import java.awt.Point;

public class Config {
	//动画
	public static final int FPS = 60;
	
	//窗口
	public static final Dimension WINSIZE = new Dimension(900, 900);
	public static final Point WINLOCATION = new Point(100, 100);
	
	//小球
	public static final Point BALLLOCATION = new Point(100, 100);
	public static final int BALLRADIUS = 8;
	public static final Point BALLVELOCITY = new Point(10, 10);
	
	//矩形
	public static final Dimension RECTSIZE = new Dimension(50, 50);
	
	//三角
	public static final Dimension TRISIZE = new Dimension(50, 50);
	
	//梯形
	public static final Dimension ECHESIZE = new Dimension(50, 50);
	
	//圆形
	public static final Dimension CIRSIZE = new Dimension(50, 50);
	
	//挡板
	public static final int BAFFLEWIDTH = 10;
	
	//直角管道
	public static final Dimension RIGHTSIZE = new Dimension(50, 50);
	
	//直线管道
	public static final Dimension VERSIZE = new Dimension(50, 50);
	
	//管道厚度
	public static final int PIPEWIDTH = 10;
}
