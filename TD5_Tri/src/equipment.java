
public class equipment {
	private int value;
	private int durability;
	
	public equipment(int val, int dur) {
		value = val;
		durability=dur;
	}
	
	public int getValue() {
		if(durability==0) return 0;
		else return value;
	}
	
	public int getDurability() {
		return durability;
	}
	
	public void decreaseDurability() {
		if (durability==0) {
			value=0;
		}
		durability=durability-1;
	}
	
	public void increaseValue(int val) {
		System.out.println(val+" value ");
		value = value + val;
	}
}
