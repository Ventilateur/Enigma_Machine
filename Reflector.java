
public class Reflector {
	
	private String str1;
	private String str2;
	
	
	public Reflector(char type) {
		switch (type) {
		case 'B': 
			str1 = "ABCDEFGIJKMTV";
			str2 = "YRUHQSLPXNOZW";
			break;
		case 'C': 
			str1 = "ABCDEGHKLMNTS";
			str2 = "FVPJIOYRZXWQU";
			break;
		default : 
			str1 = "ABCDEFGIJKMTV";
			str2 = "YRUHQSLPXNOZW";
			System.out.println("Reflextor type B by default... ");	
		}
		
	}
	
	public char reflect(char letter) {
		Functions find = new Functions();
		int index = find.findLetter(letter,str1);
		if (index == -1) {
			index = find.findLetter(letter,str2);
			letter = str1.charAt(index);
		} else
			letter = str2.charAt(index);
		return letter;
	}
}
