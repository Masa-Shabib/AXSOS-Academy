package zookeeper;

public class Gorilla extends Mammal {
	public int total = super.displayEnergy();
	public int throwSomething() {
		total =total - 5 ;
		System.out.println("Gorilla energy "+total);
		return total;
		
	}
	public void eatBananas() {
		total += 10;
		System.out.println("Gorilla energy "+total);
	}
	public void climb() {
		total -= 10;
		System.out.println("Gorilla energy "+total);
	}
}
