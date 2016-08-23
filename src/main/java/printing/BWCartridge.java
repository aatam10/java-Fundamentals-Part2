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
}
