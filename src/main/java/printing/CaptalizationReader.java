package printing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class CaptalizationReader extends BufferedReader {

	@Override
	public String readLine() throws IOException {
		String line = super.readLine();
		if (line != null)
			return line.toUpperCase();
		return null;
	}

	public CaptalizationReader(Reader in) {
		super(in);
	}

	

}
