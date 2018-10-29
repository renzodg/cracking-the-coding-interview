package c3__stacks_and_queues.q6_animal_shelter;

public abstract class Animal {
	
	private int order;
	protected String name;

	public Animal(String name) {
		this.name = name;
	}

	public abstract String name();

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return this.order;
	}

	public boolean isOlderThan(Animal animal) {
		return this.order < animal.getOrder();
	}
	
}