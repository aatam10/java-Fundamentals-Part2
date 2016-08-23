package printing;

public class colorCartridge implements ICartridge {

	
	@Override
	public String toString(){
		return "Color!";
	}

	public String getFillPercentage() {
		// TODO Auto-generated method stub
		return "50%";
	}
}
