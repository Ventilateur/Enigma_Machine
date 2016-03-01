import java.util.Scanner;

public class Enigma {
	
	private static final String str0 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
	public static void main(String[] args) {
		
		char notch1 = 'A', notch2 = 'A', notch3 = 'A', position1 = 'A', position2 = 'A', position3 = 'A', ref = 'B';
		
		//	    	   ABCDEFGHIJKLMNOPQRSTUVWXYZ
		String str1 = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
		//		       ABCDEFGHIJKLMNOPQRSTUVWXYZ
		String str2 = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
		//	  	       ABCDEFGHIJKLMNOPQRSTUVWXYZ
		String str3 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";

		Wheels wheel1 = new Wheels(str0,str1,notch1);
		Wheels wheel2 = new Wheels(str0,str2,notch2);
		Wheels wheel3 = new Wheels(str0,str3,notch3);
		
		Functions F = new Functions();
		
		System.out.println("Enter encryption mode: (3 letters of positions + 3 letter of notchs + 1 letter of reflector's type, all in uppercase)");
		Scanner keyboard = new Scanner(System.in);
		StringBuilder setup = new StringBuilder(keyboard.nextLine());
		position1 = setup.charAt(0);
		position2 = setup.charAt(1);
		position3 = setup.charAt(2);
		notch1 = setup.charAt(3);
		notch2 = setup.charAt(4);
		notch3 = setup.charAt(5);
		ref = setup.charAt(6);
		
		//Encrypt
		wheel1.setUp(position1,notch1);
		wheel2.setUp(position2,notch2);
		wheel3.setUp(position3,notch3);
		Reflector reflector = new Reflector(ref);
		
		System.out.println("Enter a message: ");	
		StringBuilder phrase = new StringBuilder(keyboard.nextLine());
		keyboard.close();
		
		System.out.println();
		char letter;
		
		for (int i=0;i<phrase.length();i++) {
			letter = F.encrypt(phrase.charAt(i), wheel1, wheel2, wheel3, reflector, notch1, notch2, notch3);
			phrase.setCharAt(i, letter);
		}
		System.out.print("Message encrypted: ");
		System.out.println(phrase);
		System.out.println();
			
		//Decrypt 
		wheel1.setUp(position1,notch1);
		wheel2.setUp(position2,notch2);
		wheel3.setUp(position3,notch3);
		
		for (int i=0;i<phrase.length();i++) {
			letter = F.encrypt(phrase.charAt(i), wheel1, wheel2, wheel3, reflector, notch1, notch2, notch3);
			phrase.setCharAt(i, letter);
		}
		System.out.print("Message decrypted: ");
		System.out.println(phrase);
		
	}	
}
