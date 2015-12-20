package ZipIt.controller;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipItController {
	ZipFile zipFile = null;
	String objToSavePath = null;
	String fileName = null;
	
	public ZipItController(String fileName, String objToSavePath, String saveToPath) {
		this.objToSavePath = objToSavePath;
		this.fileName = fileName;
		
		try {
			this.zipFile = new ZipFile(saveToPath + fileName + ".zip");
		} catch (Exception error) {
			error.printStackTrace();
		}
	}
	
	public void createZipFile() {
		try {
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			parameters.setIncludeRootFolder(false);
			
			zipFile.addFolder(objToSavePath, parameters);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}
}
