import java.util.ArrayList;
public class Game {
	private CircularDoublyLinkedList<Player> playersList;
	private Dice dice;

	public Game(){
		playersList = new CircularDoublyLinkedList<Player>();
		dice = new Dice();
	}
	
	public void addPlayer(String s){
		playersList.addLast(new Player(s));
	}

	public void play() {
		System.out.println("The Dice Game!"+"\n");
		// condition checking whether player list is empty or not before starting the game
		if (playersList.isEmpty()) {
			System.out.println("No players in the game!");
			return;
		}
		
		// instantiating an arrayList to store name of the removed players
		ArrayList<String> removedPlayer = new ArrayList<>();
		
		// while loop that stops when a player has more than 100 score or when only one player is left in the game
		while(playersList.first().getScore()<100 && playersList.size()>1) {
			// instantiating arrayList that has the values of rolled dies
			ArrayList<Integer> diceValues = dice.roll();
			int dice1 = diceValues.get(0);
			int dice2 = diceValues.get(1);

			int totalScore = playersList.first().getScore();
			int turnScore = dice1+dice2;

			System.out.print(playersList.first().getName()+" rolled " + dice1 +" and "+ dice2+". ");
			
			// conditions for different sets of rolled values and logic for what to do next
			if(dice1==2||dice2==2) {
				// doubling the rolled value and adding it to the players total Score
				turnScore *= 2;
				totalScore+=turnScore;
				playersList.first().setScore(totalScore);
				System.out.println("Lucky 2, score is now "+playersList.first().getScore()+".");
			}
			else if(dice1==6 && dice2==6) {
				// setting the total score of the player to 0
				// also reversing the playerList as per the rules of the game
				playersList.first().setScore(0);
				playersList.reverse();
				System.out.println("Unlucky double 6, score is now "+playersList.first().getScore()+". Reverse Direction");
			}
			else if(turnScore==7) {
				// decreasing total score of the player by 7
				// if total score is less than 7, then total score becomes 0
				if(totalScore>=7) {
					totalScore-=turnScore;	
				}
				else {
					totalScore=0;
				}
				playersList.first().setScore(totalScore);
				System.out.println("Unlucky 7, score  is now "+playersList.first().getScore()+".");
			}
			else if(dice1==1 && dice2==1) {
				// removing player from the players list, that is, player got eliminated
				System.out.println("Snake Eyes! Player Eliminated :(");
				removedPlayer.add(playersList.first().getName());
				playersList.removeFirst();
			}
			else {
				// adding the rolled values to the total score of the player under normal rolled values of the dies 
				totalScore+=turnScore;
				playersList.first().setScore(totalScore);
				System.out.println("Score is now " + playersList.first().getScore()+".");
			}
			
			// rotating the players list so that if current player has less than 100 points
			if(playersList.first().getScore()<100){
				playersList.rotate();
			}
		}
		
		System.out.println(playersList.first().getName()+" won the game! :)\n");
		System.out.println("Final scores: ");
		System.out.println(playersList);
		System.out.print("Eliminated: " + removedPlayer);	
	}
}
