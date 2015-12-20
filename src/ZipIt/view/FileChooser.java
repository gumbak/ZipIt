package ZipIt.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ZipIt.Configuration;

public class FileChooser extends JPanel implements ActionListener {
	private Configuration config;
	private JFileChooser chooser;
	private JButton directoryButton;
	private JTextField textField;
	
	private String path = null;
		
	public FileChooser(String buttonTitle) {
		Configuration config = new Configuration();
		
		directoryButton = new JButton(buttonTitle);
		directoryButton.setFont(config.FONT);
		directoryButton.addActionListener(this);
		
		textField = new JTextField(config.TEXT_LENGTH);
		textField.setEnabled(false);
		textField.setFont(config.FONT);
	}
	
	public JButton getDirectoryButton() {
		return directoryButton;
	}
	
	public JTextField getTextField() {
		return textField;
	}
	
	public void actionPerformed(ActionEvent event) {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File(path != null ? path : "."));
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);	
		
		if (this.chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().toString();
			if(path.charAt(path.length()-1) != '\\') {
				path += '\\';
			}		
			textField.setText(path);
		}
	}
	
	public Dimension getPrefferedSize() {
		return new Dimension(5000, 5000);
	}
	
	public String getPath() {		
		return path;
	}
}
