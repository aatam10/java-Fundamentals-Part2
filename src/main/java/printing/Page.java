package printing;

public class Page {
	private String printedText;
	
	public Page(String printedText){
		this.printedText = printedText;
	}
	
	public String getText(){
		return printedText;
	}
}
