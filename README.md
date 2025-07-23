# Double-Dice
A simple dice games that uses OOP principles and data structures such as circularly doubly linked list and arrays.

The rules for the game are as follwing: 

- If a player’s roll includes a 2, increase their score by double the roll amount. 
- If a player’s roll results in a total of 7, their score is decreased by 7 points, unless the roll included a 2 which is treated as above. Note that scores do not go below 0.  
- If a player rolls a pair of 6s, their score is resets to 0 and the turn taking order is reversed. 
- If the player rolls a pair of 1s, they are eliminated from the game.

This continues until a winner is declared: either someone reaches 100 points or there is only one player left in the game.
