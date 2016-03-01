
public class Wheels {
	
	public String wheel1;
	public String wheel2;
	public char notch;
	public char position;
	
	public Wheels(String str1, String str2, char chr) {
		wheel1 = str1;
		wheel2 = str2;
		notch = chr;
		position = wheel2.charAt(0);
	}
	
	public void setUp(char position, char setNotch) {
		int index = wheel2.indexOf(position);
		wheel2 = wheel2.substring(index) + wheel2.substring(0,index);
		notch = setNotch;
	}
	
	public String rotateWheel() {
		wheel2 = wheel2.charAt(wheel2.length()-1) + wheel2.substring(0,wheel2.length()-1);
		position = wheel2.charAt(0);
		return wheel2;
	}
	
	public char encrypt1(char letter) {
		Functions find = new Functions();
		int index = find.findLetter(letter,wheel1);
		letter = wheel2.charAt(index);
		return letter; 
	}
	
	public char encrypt2(char letter) {
		Functions find = new Functions();
		int index = find.findLetter(letter,wheel2);
		letter = wheel1.charAt(index);
		return letter; 
	}
}
