package zookeeper;

public class Bat extends Mammal {
	public int total = 300;
	public int fly() {
		total =total - 50 ;
		System.out.println("Bat energy "+total);
		return total;
		
	}
	public void eatHumans() {
		total += 25;
		System.out.println("Bat energy "+total);
	}
	public void attackTown() {
		total -= 100;
		System.out.println("Bat energy "+total);
	}
	
}
