package rockPaperScissors;

/*
 * @author -- John Hutchins
 * RPSEnum handles the pictures and numerical representation
 * of a rock, paper, scissor. 
 * Can evaluate Who wins a turn
 * returns specific values and can return a random enum.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public enum RPSEnum{
	
	ROCK (("/RPSImages/Rock.jpg"), (1)),
	PAPER (("/RPSImages/Paper.jpg"), (2)),
	SCISSOR (("/RPSImages/Scissor.jpg"), (3));
	
	private final ImageIcon icon;
	private int numVal;
	private int computerScore;
	private int humanScore;
	private Random rand = new Random();
	private static final List<RPSEnum> enums =
		    Collections.unmodifiableList(Arrays.asList(values()));
	
	/*
	 * Ctor that receives two arguments, 
	 * String -- as the file path,
	 * int -- as the integer represention I have choosen for the enum
	 */
	private RPSEnum(String icon, int numVal) {
		this.icon = new ImageIcon(this.getClass().getResource(icon));
		this.numVal = numVal;
	}
	
	/*
	 * evaluate takes 2 perameters, 
	 * int humanChoice -- which is the numVal of the choosen enum
	 * and int computerChoice which is also the numVal of the choosen enum
	 * sorts through the choices and returns winner, loser, or tie.
	 * also adds 1 to the winner to be displayed on RPSGui
	 */
	public String evaluate(int humanChoice, int computerChoice ) {
        if ((humanChoice == 1 && computerChoice == 2)
                ||(humanChoice == 2 && computerChoice == 3)
                ||(humanChoice == 3 && computerChoice == 1)) {
            computerScore += 1;
            return "You lost to the computer!";
        } else if ((humanChoice == 2 && computerChoice == 1)
                ||(humanChoice == 3 && computerChoice == 2)
                ||(humanChoice == 1 && computerChoice == 3)) {
            humanScore += 1;
            return "You beat the computer!";
        } else {
            return "You Both Tied!";
        }
    }

	/*
	 * returns the icon for the given enum
	 */
	public ImageIcon getIcon() {
		return icon;
	}
	
	/*
	 * returns a random enum from the list enums.
	 */
	public RPSEnum getRandomEnum(){
		return enums.get(rand.nextInt(enums.size()));
	}
	
	/*
	 * returns the number Value of the given enum value.
	 */
	public int getNumVal() {
		return numVal;
	}

	/*
	 * returns the computers score.
	 */
	public int getComputerScore() {
		return computerScore;
	}

	/*
	 * returns the users Score.
	 */
	public int getHumanScore() {
		return humanScore;
	}

}
