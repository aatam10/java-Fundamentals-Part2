package printing;

public class BWCartridge implements ICartridge {

	@Override
	public String toString(){
		return "BW!";
	}

	public String getFillPercentage() {
		// TODO Auto-generated method stub
		return "70%";
	}

	public String printColor() {
		// TODO Auto-generated method stub
		return null;
	}
}
