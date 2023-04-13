package one.digitalinnovation.gof;

/**
 * 
 * In this pattern, anyone can to instance the class Singleton, only itself;
 *
 */

public class SingletonLazy {
	
	private static SingletonLazy instanceofItself;
	
	private SingletonLazy() {
		super();
	}
	
	public static SingletonLazy getInstance() {
		if(instanceofItself == null) {
			instanceofItself = new SingletonLazy();
		}
		return instanceofItself;
	}
}
