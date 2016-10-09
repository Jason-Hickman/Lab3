package pokerExceptions;

public class DeckException extends Exception {
	
	public DeckException(){
		System.out.println("You cannot draw from an empty deck.");
	}
	
}
