package generic_Lib;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikuli {
	
	public void sikuli_Click(String ImagePath) throws FindFailed{
		
		Screen s = new Screen();
		Pattern p = new Pattern(ImagePath);
		s.wait(p,2000);
		s.click();
	}

}
