package one.digitalinnovation.gof;

public class Test {

	public static void main(String[] args) {
		// Test Singleton
		SingletonLazy lazy = SingletonLazy.getInstance();
		System.out.println(lazy);
		lazy = SingletonLazy.getInstance();
		System.out.println(lazy);

		SingletonEager eager = SingletonEager.getInstance();
		System.out.println(eager);
		eager = SingletonEager.getInstance();
		System.out.println(eager);
		
		SingletonLazyHolder holder = SingletonLazyHolder.getInstance();
		System.out.println(holder);
		holder = SingletonLazyHolder.getInstance();
		System.out.println(holder);
	}
}
