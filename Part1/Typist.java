/**
 * This class is the blueprint for a typist that will take part in the typing race
 *
 * Starter code generously abandoned by Ty Posaurus, your predecessor,
 * who typed with two fingers and considered that "good enough".
 * He left a sticky note: "the slide-back thing is optional probably".
 * It is not optional. Good luck.
 *
 * @author Hilla Kakar
 * @version 1
 */
package Part1;

public class Typist{
	String typistName;
	char typistSymbol;
	int progress;
	boolean burnOutFlag;
	int burnOutTurns;
	double typistAccuracy;

	//Constructor
	public Typist(char typistSymbol, String typistName, double typistAccuracy){
		this.typistSymbol = typistSymbol;
		this.typistName = typistName;
		if (typistAccuracy>=0.0 && typistAccuracy <= 1.0){
			this.typistAccuracy = typistAccuracy;
		}
		this.progress = 0;
		this.burnOutFlag = false;
		this.burnOutTurns = 0;
	}
	//Sets a player in burnout mode for given number of turns
	public void burnOut(int turns){
		burnOutFlag = true;
		burnOutTurns = turns;
		return;
	}
	//Reduces burnout turns
	public void recoverFromBurnout(){
    		if (burnOutTurns > 0){
        		burnOutTurns--;
    		}
    		if (burnOutTurns == 0){
        		burnOutFlag = false;
    		}
	}

	//Returns accuracy
	public double getAccuracy(){
		return this.typistAccuracy;
	}

	//Returns progress
	public int getProgress(){
		return progress;
	}

	//Returns name
	public String getName(){
		return this.typistName;
	}

	//Returns symbol
	public char getSymbol(){
		return this.typistSymbol;
	}

	//Returns burnout turns left
	public int getBurnoutTurnsRemaining(){
		return burnOutTurns;
	}

	//Sets everything to 0
	public void resetToStart(){
		progress = 0;
		burnOutTurns = 0;
		burnOutFlag = false;
		return;
	}

	//Checks if player is burnt out
	public boolean isBurntOut(){
		if (burnOutFlag == true){
			return true;
		}
		return false;
	}

	//Increases progress by 1
	public void typeCharacter(){
		progress++;
		return;
	}

	//Pushes typist back by given amount
	public void slideBack(int amount){
		if (progress-amount>0){
			progress = progress - amount;
		}
		else{
			progress = 0;
		}
	}

	//Sets typist accuracy
	public void setAccuracy(double newAccuracy){
		if (newAccuracy<=0.0){
			newAccuracy = 0.0;
		}
		else if (newAccuracy>=1.0){
			newAccuracy = 1.0;
		}
		this.typistAccuracy = newAccuracy;
		return;
		
	}

	//Sets typist symbol
	public void setSymbol(char newSymbol){
		this.typistSymbol = newSymbol;
	}
	
}