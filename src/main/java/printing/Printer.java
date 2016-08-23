package printing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer<T extends ICartridge> implements IMachine {

	private String modelNumber;
	private PaperTray paperTray = new PaperTray();
	private Machine machine;
	private T cartridge;
	// private List<Page> pages= new ArrayList<Page>();
	private Map<Integer, Page> pagesMap = new HashMap<Integer, Page>();

	public Printer(boolean isOn, String modelNumber, T cartridge) {
		machine = new Machine(isOn);
		this.modelNumber = modelNumber;
		this.cartridge = cartridge;
	}

	public void turnOn() {
		System.out.println("Warming up printer");
		machine.turnOn();
	}

	public T getCartidge() {
		return cartridge;
	}

	public <U extends ICartridge> void printUsingCartridge(U cartridge, String message) {
		System.out.println(cartridge.getFillPercentage());
		System.out.println(message);
		System.out.println(cartridge.toString());
	}

	public void print(int copies) {
		// checkCopies(copies);
		// System.out.println(cartridge.toString());
		String onStatus = "";
		if (machine.isOn())
			onStatus = " is ON!";
		else
			onStatus = " is OFF!";
		int pageNumber = 1;

		String textToPrint = getTextFromFile();

		while (copies > 0 && paperTray.isEmpty()) {
			// System.out.println(textToPrint);
			// pages.add(new Page(textToPrint));
			pagesMap.put(pageNumber, new Page(textToPrint + ":" + pageNumber));
			copies--;
			paperTray.usePage();
			pageNumber++;
		}

		if (!paperTray.isEmpty()) {
			System.out.println("Load More Paper!");
		}
	}

	private String getTextFromFile() {

		FileReader reader = null;
		String allText = "";
		BufferedReader bReader = null;
		CaptalizationReader capReader = null;
		
		

		try {
			reader = new FileReader("c:\\temp\\test.txt");
			bReader = new BufferedReader(reader);
			capReader = new CaptalizationReader(bReader);
			
			String line;

			while ((line = capReader.readLine()) != null) {
				allText += line + "\n";
			}

			return allText;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (capReader != null)
				try {
					capReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return "";
	}

	public void outputPrintText(int pageNumber) {

		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new FileWriter("c:\\temp\\outPutFile.txt"));

			writer.println(pagesMap.get(pageNumber).getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
	}

	/*
	 * private void checkCopies(int copies) { if(copies < 0) throw new
	 * IllegalArgumentException("Can't print less than 0 copies!"); }
	 */

	public void print(String text) {
		System.out.println(text);
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void loadPaper(int count) {
		paperTray.addPaper(count);
	}

	public void turnOff() {
		machine.turnOff();

	}

	public boolean isOn() {
		// TODO Auto-generated method stub
		return machine.isOn();
	}

}
