package one.digitalinnovation.gof.singleton;

public class SingletonLazyHolder {

	private static class InstanceHolder{
		public static SingletonLazyHolder instanceofItself = new SingletonLazyHolder();
	}

	private SingletonLazyHolder() {
		super();
	}

	public static SingletonLazyHolder getInstance() {
		return InstanceHolder.instanceofItself;
	}

}
