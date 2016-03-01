
public class Functions {
	
	public int findLetter(char letter, String str) {
		int index = -1;
		int i;
		for (i=0;i<str.length();i++) {
			if (str.charAt(i) == letter) { 
				index = i;
				break;
			}
		}
		return index;
	}
	
	public char encrypt(char letter, Wheels wheel1, Wheels wheel2, Wheels wheel3, Reflector reflector, char notch1, char notch2, char notch3) {
		
		if (letter == ' ')
			letter = ' ';
		else if (letter >= 'A' && letter <= 'Z') {
			letter = wheel1.encrypt1(letter);
			letter = wheel2.encrypt1(letter);
			letter = wheel3.encrypt1(letter);
			letter = reflector.reflect(letter);
			letter = wheel3.encrypt2(letter);
			letter = wheel2.encrypt2(letter);
			letter = wheel1.encrypt2(letter);
			wheel1.rotateWheel();
			if (wheel1.position == notch1) {
				wheel2.rotateWheel();
				if (wheel2.position == notch2)
					wheel3.rotateWheel();
			}	
		}
		else if (letter >= 'a' && letter <= 'z') {
			letter = Character.toUpperCase(letter);
			letter = wheel1.encrypt1(letter);
			letter = wheel2.encrypt1(letter);
			letter = wheel3.encrypt1(letter);
			letter = reflector.reflect(letter);
			letter = wheel3.encrypt2(letter);
			letter = wheel2.encrypt2(letter);
			letter = wheel1.encrypt2(letter);
			letter = Character.toLowerCase(letter);
			wheel1.rotateWheel();
			if (wheel1.position == notch1) {
				wheel2.rotateWheel();
				if (wheel2.position == notch2)
					wheel3.rotateWheel();
			}	
		}
		else 
			letter = '?';
		return (letter);
	}
}
