package estudioPoo;

public class estudioEquals {

	public estudioEquals() {
		persona3 p = new persona3("Pepe", "Garcia", "123");
		persona3 p1 = new persona3("Pepe", "Garcia", "123");
		System.out.println(p.hashCode());
		System.out.println(p1.hashCode());
		System.out.println(p.equals(p1));
	}

}
