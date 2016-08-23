package printing;

public class Printer<T> implements IMachine {

	private String modelNumber;
	private PaperTray paperTray = new PaperTray();
	private Machine machine;
	private T cartridge;

	public Printer(boolean isOn, String modelNumber,T cartridge) {
		machine = new Machine(isOn);
		this.modelNumber = modelNumber;
		this.cartridge = cartridge;
	}

	public void turnOn() {
		System.out.println("Warming up printer");
		machine.turnOn();
	}

	public T getCartidge(){
		return cartridge;
	}
	
	public <U extends ICartridge> void printUsingCartridge(U cartridge,String message){
		System.out.println(cartridge.getFillPercentage());
		System.out.println(message);
		System.out.println(cartridge.toString());
	}
	
	public void print(int copies) {
		checkCopies(copies);
		
		System.out.println(cartridge.toString());
		String onStatus = "";
		if (machine.isOn())
			onStatus = " is ON!";
		else
			onStatus = " is OFF!";
		String textToPrint = modelNumber + onStatus;
		while (copies > 0 && paperTray.isEmpty()) {
			System.out.println(textToPrint);
			copies--;
			paperTray.usePage();
		}

		if (!paperTray.isEmpty()) {
			System.out.println("Load More Paper!");
		}
	}

	private void checkCopies(int copies) {
		if(copies < 0)
			throw new IllegalArgumentException("Can't print less than 0 copies!");
	}


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
