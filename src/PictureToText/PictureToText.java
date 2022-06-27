package PictureToText;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PictureToText {

	private static Scanner scanner;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG & PNG Images", "jpeg", "png");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new File(".\\testImages"));
		int response = fileChooser.showOpenDialog(null);
		
		if(response == JFileChooser.APPROVE_OPTION) {
			File file = new File(fileChooser.getSelectedFile().getAbsolutePath());			
			TextFinder tf = new TextFinder(file);
			System.out.println("write filename in the console");
			
			tf.createResultFile(scanner.nextLine());
		}
		else {
			System.out.println("Canceled");
		}
		
		
	}

}
