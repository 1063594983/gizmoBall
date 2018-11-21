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
		file = new JMenu("�ļ�");
		open = new JMenuItem("��");
		save = new JMenuItem("����");
		file.add(open);
		file.add(save);
	}
	
	private void registHandler() {
		
		//���ļ��¼�
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
		
		//�����ļ��¼�
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
