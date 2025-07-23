import java.util.Random;
public class Die {
	private int numberFaces;
	private int faceValue;
	
	public Die() {
		this(6);
	}
	public Die(int n) {
		numberFaces = n;
	}
	public int roll() {
		Random rand = new Random();
		return rand.nextInt(numberFaces)+1;
	}
}
