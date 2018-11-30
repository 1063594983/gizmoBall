package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

public class RectangleCollisionBody extends AbstractShape implements ICollisionBody {
	
	public RectangleCollisionBody() {
		this.size = new Dimension(50, 50);
		this.name = "rectangle";
		this.color = new Color(248, 206, 204);
	}
	
	public RectangleCollisionBody(Point location, Color color) {
		this.location = location;
		this.size = new Dimension(50, 50);
		this.color = color;
		this.name = "rectangle";
	}
	
	public RectangleCollisionBody(Point location, Color color, Dimension dimension) {
		this.location = location;
		this.size = dimension;
		this.color = color;
		this.name = "rectangle";
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillRect(location.x, location.y, size.width, size.height);
	}

	@Override
	public boolean isCollision(Ball ball) {
		int[] x = {location.x, location.x + size.width, location.x + size.width, location.x};
		int[] y = {location.y, location.y, location.y + size.height, location.y + size.height};
		int X = ball.location.x;
		int Y = ball.location.y;
		int vx = ball.velocity.x;
		int vy = ball.velocity.y;
		Line top = new Line(new Point(x[0], y[0]), new Point(x[1], y[1]));
		Line right = new Line(new Point(x[1], y[1]), new Point(x[2], y[2]));
		Line buttom = new Line(new Point(x[2], y[2]), new Point(x[3], y[3]));
		Line left = new Line(new Point(x[3], y[3]), new Point(x[0], y[0]));
		Line ballLine = new Line(new Point(X, Y), new Point(X + vx, Y + vy));
		
		Point[] points = {null, null, null, null};
		
		int minIndex = 5;
		double minDist = 100;
		
		if(top.isIntersect(ballLine)) {
			points[0] = top.getIntersectPoint(ballLine);
		}
		if(buttom.isIntersect(ballLine)) {
			points[1] = buttom.getIntersectPoint(ballLine);
		}
		if(right.isIntersect(ballLine)) {
			points[2] = right.getIntersectPoint(ballLine);
		}
		if(left.isIntersect(ballLine)) {
			points[3] = left.getIntersectPoint(ballLine);
		}
		boolean flag = false;
		
		for(int i = 0; i < 4; i++) {
			if(points[i] != null) {
				if(minDist > ball.location.distance(points[i])) {
					minDist = ball.location.distance(points[i]);
					minIndex = i;
				}
				flag = true;
			}
		}
		if(flag) {
			int[][] arr = {{0, -1, 1, -1}, {0, 1, 1, -1}, {1, 0, -1, 1}, {-1, 0, -1, 1}};
			
			ball.location.x = points[minIndex].x + ball.radius * arr[minIndex][0];
			ball.location.y = points[minIndex].y + ball.radius * arr[minIndex][1];
			
			ball.velocity.x *= arr[minIndex][2];
			ball.velocity.y *= arr[minIndex][3];
		}
		
		
		/*
		if(top.isIntersect(ballLine)) {
			ball.location.x = top.getIntersectPoint(ballLine).x;
			ball.location.y = top.getIntersectPoint(ballLine).y - ball.radius;
			
			ball.velocity.y *= -1;
			return true;
		} else if(buttom.isIntersect(ballLine)) {
			ball.location.x = buttom.getIntersectPoint(ballLine).x;
			ball.location.y = buttom.getIntersectPoint(ballLine).y + ball.radius;

			ball.velocity.y *= -1;
			return true;
		} else if(left.isIntersect(ballLine)) {
			ball.location.y = left.getIntersectPoint(ballLine).y;
			ball.location.x = left.getIntersectPoint(ballLine).x - ball.radius;

			ball.velocity.x *= -1;
			return true;
		} else if(right.isIntersect(ballLine)) {
			ball.location.y = right.getIntersectPoint(ballLine).y;
			ball.location.x = right.getIntersectPoint(ballLine).x + ball.radius;

			ball.velocity.x *= -1;
			return true;
		}
		*/
		
		return flag;
	}
	
	//VerticalPipe管道中运用矩形，碰撞后改变方向
	public boolean isCollisionInVerticalPipe(Ball ball) {
//		System.out.println("Before, ball.v:   "+ball.velocity.x+"   "+ball.velocity.y);
		int[] x = {location.x, location.x + size.width, location.x + size.width, location.x};
		int[] y = {location.y, location.y, location.y + size.height, location.y + size.height};
		int X = ball.location.x;
		int Y = ball.location.y;
		int vx = ball.velocity.x;
		int vy = ball.velocity.y;
		
		Line top = new Line(new Point(x[0], y[0]), new Point(x[1], y[1]));
		Line right = new Line(new Point(x[1], y[1]), new Point(x[2], y[2]));
		Line buttom = new Line(new Point(x[2], y[2]), new Point(x[3], y[3]));
		Line left = new Line(new Point(x[3], y[3]), new Point(x[0], y[0]));
		Line ballLine = new Line(new Point(X, Y), new Point(X + vx, Y + vy));
		
		if(top.isIntersect(ballLine)) {
			ball.location.x = top.getIntersectPoint(ballLine).x;
			ball.location.y = top.getIntersectPoint(ballLine).y - ball.radius;
			
			if(ball.velocity.y > 0) {
				ball.velocity.y++;
			} else if(ball.velocity.y < 0) {
				ball.velocity.y--;
			}
			ball.velocity.x *= -1;
			if(ball.velocity.x > 0) {
				ball.velocity.x++;
			} else if(ball.velocity.x < 0) {
				ball.velocity.x--;
			}
			return true;
		} else if(buttom.isIntersect(ballLine)) {
			ball.location.x = buttom.getIntersectPoint(ballLine).x;
			ball.location.y = buttom.getIntersectPoint(ballLine).y + ball.radius;

			if(ball.velocity.y > 0) {
				ball.velocity.y++;
			} else if(ball.velocity.y < 0) {
				ball.velocity.y--;
			}
			ball.velocity.x *= -1;
			if(ball.velocity.x > 0) {
				ball.velocity.x++;
			} else if(ball.velocity.x < 0) {
				ball.velocity.x--;
			}
			return true;
		} else if(left.isIntersect(ballLine)) {
			ball.location.y = left.getIntersectPoint(ballLine).y;
			ball.location.x = left.getIntersectPoint(ballLine).x - ball.radius;
			
			if(ball.velocity.y > 0) {
				ball.velocity.y++;
			} else if(ball.velocity.y < 0) {
				ball.velocity.y--;
			}
			ball.velocity.x *= -1;
			if(ball.velocity.x > 0) {
				ball.velocity.x++;
			} else if(ball.velocity.x < 0) {
				ball.velocity.x--;
			}
//			System.out.println("left!!!After, ball.v:   "+ball.velocity.x+"   "+ball.velocity.y);
			return true;
		} else if(right.isIntersect(ballLine)) {
//			System.out.println("ball.v: " + ball.velocity.x + "   " + ball.velocity.y);
//			System.out.println("right");
			ball.location.y = right.getIntersectPoint(ballLine).y;
			ball.location.x = right.getIntersectPoint(ballLine).x + ball.radius;

			if(ball.velocity.y > 0) {
				ball.velocity.y++;
			} else if(ball.velocity.y < 0) {
				ball.velocity.y--;
			}
			ball.velocity.x *= -1;
			if(ball.velocity.x > 0) {
				ball.velocity.x++;
			} else if(ball.velocity.x < 0) {
				ball.velocity.x--;
			}
//			System.out.println("right!!!After, ball.v:   "+ball.velocity.x+"   "+ball.velocity.y);
			return true;
		}

//		System.out.println("After, ball.v:   "+ball.velocity.x+"   "+ball.velocity.y);
		return false;
	}
	
	//RightPipe管道中运用矩形，碰撞后改变方向
	public boolean isCollisionInRightPipe(Ball ball) {
//		System.out.println("Before, ball.v:   "+ball.velocity.x+"   "+ball.velocity.y);
		int[] x = {location.x, location.x + size.width, location.x + size.width, location.x};
		int[] y = {location.y, location.y, location.y + size.height, location.y + size.height};
		int X = ball.location.x;
		int Y = ball.location.y;
		int vx = ball.velocity.x;
		int vy = ball.velocity.y;
		
		Line top = new Line(new Point(x[0], y[0]), new Point(x[1], y[1]));
		Line right = new Line(new Point(x[1], y[1]), new Point(x[2], y[2]));
		Line buttom = new Line(new Point(x[2], y[2]), new Point(x[3], y[3]));
		Line left = new Line(new Point(x[3], y[3]), new Point(x[0], y[0]));
		Line ballLine = new Line(new Point(X, Y), new Point(X + vx, Y + vy));
		
		if(top.isIntersect(ballLine)) {
			ball.location.x = top.getIntersectPoint(ballLine).x;
			ball.location.y = top.getIntersectPoint(ballLine).y - ball.radius;
			
			ball.velocity.y *= -1;
			if(ball.velocity.y > 0) {
				ball.velocity.y++;
			} else if(ball.velocity.y < 0) {
				ball.velocity.y--;
			}
			
			if(ball.velocity.x > 0) {
				ball.velocity.x++;
			} else if(ball.velocity.x < 0) {
				ball.velocity.x--;
			}
			return true;
		} else if(buttom.isIntersect(ballLine)) {
			ball.location.x = buttom.getIntersectPoint(ballLine).x;
			ball.location.y = buttom.getIntersectPoint(ballLine).y + ball.radius;

			ball.velocity.y *= -1;
			if(ball.velocity.y > 0) {
				ball.velocity.y++;
			} else if(ball.velocity.y < 0) {
				ball.velocity.y--;
			}
			
			if(ball.velocity.x > 0) {
				ball.velocity.x++;
			} else if(ball.velocity.x < 0) {
				ball.velocity.x--;
			}
			return true;
		} else if(left.isIntersect(ballLine)) {
			ball.location.y = left.getIntersectPoint(ballLine).y;
			ball.location.x = left.getIntersectPoint(ballLine).x - ball.radius;

			ball.velocity.x *= -1;
			if(ball.velocity.y > 0) {
				ball.velocity.y++;
			} else if(ball.velocity.y < 0) {
				ball.velocity.y--;
			}
			
			if(ball.velocity.x > 0) {
				ball.velocity.x++;
			} else if(ball.velocity.x < 0) {
				ball.velocity.x--;
			}
			return true;
		} else if(right.isIntersect(ballLine)) {
			System.out.println("ball.v: " + ball.velocity.x + "   " + ball.velocity.y);
			System.out.println("right");
			ball.location.y = right.getIntersectPoint(ballLine).y;
			ball.location.x = right.getIntersectPoint(ballLine).x + ball.radius;

			ball.velocity.x *= -1;
			if(ball.velocity.y > 0) {
				ball.velocity.y++;
			} else if(ball.velocity.y < 0) {
				ball.velocity.y--;
			}
			
			if(ball.velocity.x > 0) {
				ball.velocity.x++;
			} else if(ball.velocity.x < 0) {
				ball.velocity.x--;
			}
			return true;
		}

//		System.out.println("After, ball.v:   "+ball.velocity.x+"   "+ball.velocity.y);
		return false;
	}
	
	//旋转
	public void rotate() {
		location.x = location.x + size.width/2 - size.height/2;
		location.y = location.y + size.height/2 - size.width/2;
		int temp = size.width;
		size.width = size.height;
		size.height = temp;
	}

	@Override
	public boolean contains(Point p) {
		if(new Rectangle(location.x, location.y, size.width, size.height).contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public RectangleCollisionBody getNewInstance() {
		return new RectangleCollisionBody();
	}
}
