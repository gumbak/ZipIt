package ZipIt.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ZipIt.Configuration;

public class ZipItView {
	private Configuration config;	
	private JTextField inputFileName;
	private FileChooser objToSaveChooser;
	private FileChooser saveToChooser;
	public JButton submitButton;	

	private class BooleanConstraints {
		public boolean isCenter = false;
		public boolean isFill = false;
	}
	
	public void render(){
		Configuration config = new Configuration();
		
		JFrame frame = new JFrame("ZipIt");
		frame.setMinimumSize(new Dimension(config.FRAME_DIMENSION_X, config.FRAME_DIMENSION_Y));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addComponentsToPane(frame.getContentPane());
		
		//frame.pack();
		frame.setVisible(true);
	}
	
	private void addComponentsToPane(Container pane) {
		pane.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		JLabel titleZipIt = new JLabel(config.TITLE_ZIP_IT);
		titleZipIt.setFont(config.FONT);
		addToPaneWithConstraint(pane, 0, 0, titleZipIt, true, false);
		
		JLabel titleFileName = new JLabel(config.TITLE_FILE_NAME);
		inputFileName = new JTextField(config.TEXT_LENGTH);
		titleFileName.setFont(config.FONT);
		inputFileName.setFont(config.FONT);
		addToPaneWithConstraint(pane, 0, 1, titleFileName);
		addToPaneWithConstraint(pane, 1, 1, inputFileName);
		
		objToSaveChooser = new FileChooser(config.TITLE_OBJ_TO_SAVE);
		addToPaneWithConstraint(pane, 0, 2, objToSaveChooser.getDirectoryButton(), false, true);
		addToPaneWithConstraint(pane, 1, 2, objToSaveChooser.getTextField());
		
		saveToChooser = new FileChooser(config.TITLE_SAVE_TO);
		addToPaneWithConstraint(pane, 0, 3, saveToChooser.getDirectoryButton(), false, true);
		addToPaneWithConstraint(pane, 1, 3, saveToChooser.getTextField());	
		
		submitButton = new JButton(config.TITLE_SUBMIT);
		submitButton.setFont(config.FONT);
		addToPaneWithConstraint(pane, 0, 4, submitButton, true, false);
		
	}
	
	public String getFileName() {
		return inputFileName.getText();
	}
	
	public String getSaveToPath() {
		return saveToChooser.getPath();
	}
	
	public String getObjToSavePath() {
		return objToSaveChooser.getPath();
	}
	
	private void addToPaneWithConstraint(Container pane, int x, int y, Component component) {
		addToPaneWithConstraint(pane, x, y, component, false, false);
	}
	
	private void addToPaneWithConstraint(Container pane, int x, int y, Component component, boolean isCenter, boolean isFill) {
		GridBagConstraints constraints = new GridBagConstraints();
		if (isCenter) {
			constraints.gridwidth = GridBagConstraints.REMAINDER;
		}
		if (isFill) {
			constraints.fill = GridBagConstraints.BOTH;
		}
		constraints.insets = new Insets(config.INSET_SIZE, config.INSET_SIZE, config.INSET_SIZE, config.INSET_SIZE);
		constraints.gridx = x;
		constraints.gridy = y;
		pane.add(component, constraints);
	}
}
