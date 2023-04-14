package one.digitalinnovation.gof.singleton;

import one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.strategy.Behavior;
import one.digitalinnovation.gof.strategy.DefenseBehavior;
import one.digitalinnovation.gof.strategy.FightBehavior;
import one.digitalinnovation.gof.strategy.NormalBehavior;
import one.digitalinnovation.gof.strategy.Robot;

public class Test {

	public static void main(String[] args) {
		// Singleton
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
		
		//Strategy
		Behavior normal = new NormalBehavior();
		Behavior fight = new FightBehavior();
		Behavior defense = new DefenseBehavior();
		
		Robot robot = new Robot();
		robot.setBehavior(normal);
		robot.move();
		robot.setBehavior(fight);
		robot.move();
		robot.setBehavior(defense);
		robot.move();
		
		//Facade
		
		Facade facade = new Facade();
		facade.changeClient("Weslley", "19145620");
		
	}
}
