package UI;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class ScoreWindow extends JComponent{
	private String message = "";
	private JLabel jLabel;
	private int grade;
	
	public ScoreWindow() {
		jLabel = new JLabel("hello");
		grade = 0;
		this.add(jLabel);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString("当前分数为" + this.grade, this.getWidth() / 3, this.getHeight() / 2);
	}

	public void setMessage(String msg) {
		this.message = msg;
		this.jLabel.setText(msg);
	}
	
	public void setGrade(int grade) {
		this.grade += grade;
	}
}
