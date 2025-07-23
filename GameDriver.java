import java.util.ArrayList;
public class GameDriver {
	public static void main(String[] args) {
		Game g1 = new Game();
		g1.addPlayer("Wade Wilson");
		g1.addPlayer("Bruce Wayne");
		g1.addPlayer("Peter Parker");
		g1.addPlayer("Clark Kent");
		g1.play();		
	}
}