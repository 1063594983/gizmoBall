package UI;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import control.OpenAndSaveControl;

public class MyMenu extends JMenuBar {
	
	private JMenuItem open;
	private JMenuItem save;
	private JMenu file;
	private JFrame frame;
	private String filePath;
	
	public MyMenu(JFrame frame) {
		init();
		registHandler();
		this.frame = frame;
		this.add(file);
	}
	
	private void init() {
		file = new JMenu("文件");
		open = new JMenuItem("打开");
		save = new JMenuItem("保存");
		file.add(open);
		file.add(save);
	}
	
	private void registHandler() {
		
		//打开文件事件
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog fd = new FileDialog(frame);
				fd.setMode(FileDialog.LOAD);
				fd.setVisible(true);
				if(fd.getFile() != null) {
					filePath = fd.getDirectory() + fd.getFile();
					OpenAndSaveControl.open(filePath);
				}
			}
		});
		
		//保存文件事件
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog fd = new FileDialog(frame);
				fd.setMode(FileDialog.SAVE);
				fd.setVisible(true);
				if(fd.getFile() != null) {
					filePath = fd.getDirectory() + fd.getFile();
					OpenAndSaveControl.saveShapes(filePath);
				}
			}
		});
		
		
	}
}
