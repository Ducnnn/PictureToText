package PictureToText;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PictureToText {

	

	public static void main(String[] args) {
		
		//создание окна с выбором файлов jpeg или png
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG & PNG Images", "jpeg", "png");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new File(".\\testImages"));
		
		//если окно с выбором не закрыто текст считывается и создаётся файл с результатом
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			File file = fileChooser.getSelectedFile();			
			TextFinder tf = new TextFinder(file);			
			tf.createResultFile("PictureToTextResult",fileChooser.getCurrentDirectory().getAbsolutePath() );
		}
		else {
			System.out.println("Canceled");
		}
		
		
	}

}
