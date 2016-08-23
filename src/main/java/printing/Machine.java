package printing;

public class Machine implements IMachine {

	protected boolean isOn;

	public Machine(boolean isOn) {
		this.isOn = isOn;
	}
	
	public void turnOn(){
		System.out.println("Machine is On");
		isOn = true;
	}
	
	public void turnOff(){
		isOn = false;
		System.out.println("Machine is Off");
	}

	public boolean isOn() {
		return isOn;
	}

}
