package greetings;

import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;

import printing.BWCartridge;
import printing.ICartridge;
import printing.IMachine;
import printing.Printer;
import printing.colorCartridge;

public class HelloWorld {

	public static void main(String[] args)  {

		Printer<colorCartridge> printer= new Printer<colorCartridge>(true, "My Printer",new colorCartridge());
		
		File file = new File("c:\\test.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		try{
			printer.print(1);
		}
		catch(IllegalArgumentException exception)
		{
			System.out.println(exception.getMessage());
			return;
		}
		finally
		{
			printer.turnOff();
		}
	}


}
