import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ZipIt.controller.ZipItController;
import ZipIt.view.ZipItView;

public class ZipIt {
	public static void main(String[] args) {
		ZipItView zipView = new ZipItView();
		zipView.render();	
		
		zipView.submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String saveToPath = zipView.getSaveToPath();
				String objToSavePath = zipView.getObjToSavePath();
				String fileName = zipView.getFileName();
				
				ZipItController zipController = new ZipItController(fileName, objToSavePath, saveToPath);
				zipController.createZipFile();
			}
		});	
	}
}
