package printing;

public enum colorCartridge implements ICartridge {
RED("Red"),
GREEN("green"),
BLUE("Blue"),
YELLOW("Yellow");
	
	private String textColor;

	private colorCartridge(String textColor){
		this.textColor = textColor; 
	}
	
	@Override
	public String toString(){
		return "Color!";
	}

	public String getFillPercentage() {
		// TODO Auto-generated method stub
		return "50%";
	}

	public String printColor() {
		// TODO Auto-generated method stub
		return textColor;
	}
}
