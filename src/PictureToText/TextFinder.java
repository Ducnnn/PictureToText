package PictureToText;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TextFinder {
	
	private File imageFile;
	
	public TextFinder(File image) {
		imageFile = image;		
	}
	
	private String findText() {
		Tesseract tes = new Tesseract();
		tes.setDatapath("tessdata");
		tes.setOcrEngineMode(1);
		tes.setLanguage("rus+eng");		
		
		try {
			String text = tes.doOCR(imageFile);
			return text;
			
		} catch (TesseractException e) {
			
			System.out.println("exception " + e.getMessage());
			return "";
		}
		
	}
	
	private ArrayList<String> splitText(){
		String[] messages = findText().split(" ");
		ArrayList<String> result = new ArrayList<String>();
		for(int k =0;k<messages.length;k++) {
			result.add(messages[k]);
		}
		return result;
	}
	
	public String toString() {
		String result = "";
		for(String s : splitText()) {
			result += "\n" + s;
		}
		return result;
	}
	
	public void createResultFile(String filename) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(".\\results\\" + filename + ".txt"));
			ArrayList<String> lines = splitText();
			for(String s : lines) {
				writer.write("\n" + s);
			}
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
