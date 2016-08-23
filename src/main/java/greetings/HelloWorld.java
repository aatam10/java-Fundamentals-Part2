package greetings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import printing.Printer;
import printing.colorCartridge;

public class HelloWorld {

	public static void main(String[] args)  {

		Printer<colorCartridge> printer= new Printer<colorCartridge>(true, "My Printer",colorCartridge.GREEN);
	
//		printer.loadPaper(5);
//		printer.print(3);
//		printer.outputPrintText(3);

		Path path= Paths.get("c:\\temp\\createNewFile.txt");
		
		//create new file
		try {
			Files.createFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//delete file
//		try {
//			Files.deleteIfExists(path);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//Moving a file
			try {
				Files.move(path, Paths.get("c:\\temp\\movedFile.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
		
	}

