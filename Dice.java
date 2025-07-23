import java.util.ArrayList;
public class Dice {
	private Die die1;
	private Die die2;
	
	public Dice() {
		this(6);
	}
	public Dice(int n) {
		die1 = new Die(n);
		die2 = new Die(n);
	}
	public ArrayList<Integer> roll(){
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(die1.roll());
		arr.add(die2.roll());
		return arr;
	}
}
