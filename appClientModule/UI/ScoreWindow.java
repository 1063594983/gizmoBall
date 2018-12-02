package UI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class ScoreWindow extends JComponent{
	private String message = "";
	private JLabel jLabel;
	private int grade;
	
	public ScoreWindow() {
		jLabel = new JLabel("hello");
		JButton jb = new JButton("开始");
		jb.setVisible(true);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
				AnimationWindow.getInstance().baffle.startRotate();
			}
		});
		grade = 0;
		//this.add(jLabel);
		this.add(jb);
	}
	
	@Override
	public void paint(Graphics g) {
		//g.drawString("当前分数为" + this.grade, this.getWidth() / 3, this.getHeight() / 2);
	}

	public void setMessage(String msg) {
		this.message = msg;
		this.jLabel.setText(msg);
	}
	
	public void setGrade(int grade) {
		this.grade += grade;
	}
}
