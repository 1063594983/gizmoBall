package control;

import java.awt.Dimension;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import UI.AnimationWindow;
import gizmo.AbstractShape;
import gizmo.CircleCollisionBody;
import gizmo.DarkholeCollisionBody;
import gizmo.EchelonCollisionBody;
import gizmo.RectangleCollisionBody;
import gizmo.RightPipe;
import gizmo.TriangleCollisionBody;
import gizmo.VerticalPipe;

public class OpenAndSaveControl {
	
	//保存当前图案
	public static void saveShapes(String fileName) {
		try {
			File file = new File(fileName);
			if(!file.exists()) {
				file.createNewFile();
			}
			
			Writer out = new FileWriter(file);
			String str = "";
			Iterator<AbstractShape> i = AnimationWindow.getInstance().getShapes().iterator();
			while(i.hasNext()) {
				str += i.next().getString();
			}
			str += AnimationWindow.getInstance().baffle.getString();
			str += "ball " + AnimationWindow.getInstance().ball.location.x + " " + AnimationWindow.getInstance().ball.location.y 
					+ " 8 8 0";
			out.write(str);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//打开新地图
	public static void open(String fileName) {
		
		//以.map结尾
		String regEx = ".*map$";
		if(Pattern.matches(regEx, fileName)) {
			AnimationWindow.getInstance().setMessage("");
		} else {
			AnimationWindow.getInstance().setMessage("文件格式错误！");
			return;
		}
		ArrayList <AbstractShape> shapes = new ArrayList<>();
		BufferedReader reader = null;
		
		try {
			File file = new File(fileName);
			reader = new BufferedReader(new FileReader(file));
			String tmpStr = null;
			while((tmpStr = reader.readLine()) != null) {
				String[] strs = tmpStr.split(" ");
				String name = strs[0];
				int x = Integer.parseInt(strs[1]);
				int y = Integer.parseInt(strs[2]);
				int width = Integer.parseInt(strs[3]);
				int height = Integer.parseInt(strs[4]);
				int mode = Integer.parseInt(strs[5]);
				Point p = new Point(x, y);
				Dimension d = new Dimension(width, height); 
				switch (name) {
				case "circle" : {
					AbstractShape shape = new CircleCollisionBody();
					shape.setPosition(p);
					shape.setSize(d);
					shape.setMode(mode);
					shapes.add(shape);
					break;
				}
				case "echelon" : {
					AbstractShape shape = new EchelonCollisionBody();
					shape.setPosition(p);
					shape.setSize(d);
					shape.setMode(mode);
					shapes.add(shape);
					break;
				}
				case "triangle" : {
					AbstractShape shape = new TriangleCollisionBody();
					shape.setPosition(p);
					shape.setSize(d);
					shape.setMode(mode);
					shapes.add(shape);
					break;
				}
				case "rectangle" : {
					AbstractShape shape = new RectangleCollisionBody();
					shape.setPosition(p);
					shape.setSize(d);
					shape.setMode(mode);
					shapes.add(shape);
					break;
				}
				case "darkhole" : {
					AbstractShape shape = new DarkholeCollisionBody();
					shape.setPosition(p);
					shape.setSize(d);
					shape.setMode(mode);
					shapes.add(shape);
					break;
				}
				case "RightPipe" : {
					AbstractShape shape = new RightPipe();
					shape.setPosition(p);
					shape.setSize(d);
					shape.setMode(mode);
					shapes.add(shape);
					break;
				}
				case "VerticalPipe" : {
					AbstractShape shape = new VerticalPipe();
					shape.setPosition(p);
					shape.setSize(d);
					shape.setMode(mode);
					shapes.add(shape);
					break;
				}
				case "baffle" : {
					AnimationWindow.getInstance().baffle.setPosition(p);
					AnimationWindow.getInstance().baffle.setSize(d);
					break;
				}
				case "ball" : {
					AnimationWindow.getInstance().ball.location = p;
					AnimationWindow.getInstance().ball.radius = d.width;
					break;
				}
				default : {
					
				}
				}
			}
			AnimationWindow.getInstance().setShapes(shapes);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                	e1.printStackTrace();
                }
            }
		}
	}
}
