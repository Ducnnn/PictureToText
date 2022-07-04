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
	String tessdataPath;
	
	// конструктор
	public TextFinder(File image, String languagesDataPath) {
		imageFile = image;
		tessdataPath = languagesDataPath;
	}
	
	// библиотека тессеракт находит текст из картинки
	private String findText() { 
		Tesseract tes = new Tesseract();
		
		tes.setDatapath(tessdataPath);// установка пути к языками
		tes.setLanguage("eng+rus"); // установка языков	
		
		try {
			String text = tes.doOCR(imageFile); //получение текста
			return text;
			
		} catch (TesseractException e) {
			
			System.out.println("exception " + e.getMessage());
			return e.getMessage(); // возвращение вместо текста с ошибкой вместо текста с картинки в случае ошибки
		}
		
	}
	
	//текст делится пробелами и записывается в лист
	private ArrayList<String> splitText(){ 
		String[] messages = findText().split(" ");
		ArrayList<String> result = new ArrayList<String>();
		for(int k =0;k<messages.length;k++) {
			result.add(messages[k]);
		}
		return result;
	}
	
	//массив переделывается в одну строчку, каждое слово с новой строки
	public String toString() { 
		String result = "";
		for(String s : splitText()) {
			result += s + "\n";
		}
		return result;
	}
	//создание текстового файла с результатомв той же папке где и находится картинка
	public void createResultFile(String filename, String outputPath) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath +"\\" + filename + ".txt" ));
			writer.write(toString());;			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
	}
	
}
