package one.digitalinnovation.gof;

/**
 * 
 * Instance faster
 *
 */

public class SingletonEager {
private static SingletonEager instanceofItself = new SingletonEager();
	
	private SingletonEager() {
		super();
	}
	
	public static SingletonEager getInstance() {
		return instanceofItself;
	}
 
}
