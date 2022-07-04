package PictureToText;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PictureToText {

	

	public static void main(String[] args) {
		
		
		JFileChooser fileChooser = new JFileChooser(); //выбиратель файлов

		fileChooser.setCurrentDirectory(new File(".\\testImages"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Traineddata", "traineddata");//филтр для языков
		fileChooser.setFileFilter(filter);
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {  //окно с выбором папки с языками
			String path = fileChooser.getCurrentDirectory().getAbsolutePath();
			filter = new FileNameExtensionFilter("JPEG & PNG Images", "jpeg", "png", "jpg");//фильтр для картинок
			fileChooser.setFileFilter(filter);
			if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //окно выбора картинки
				File file = fileChooser.getSelectedFile();  //выбранная картинка
				TextFinder tf = new TextFinder(file,path);			
				tf.createResultFile("PictureToTextResult",fileChooser.getCurrentDirectory().getAbsolutePath());  // создание txt файла
			}
		}
		else {
			System.out.println("Canceled");
		}
		
		
	}

}
