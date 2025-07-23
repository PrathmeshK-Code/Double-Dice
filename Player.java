public class Player {
	private String name;
	private int score;

	public Player(String n) {
		this(n,0);
	}
	public Player(String n, int s) {
		name = n;
		score = s;
	}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public int getScore() {return score;}
	public void setScore(int score) {this.score = score;}

	public String toString() {
		return name+": "+score;
	}
}
