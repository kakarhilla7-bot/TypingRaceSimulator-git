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
public class Typist{
	String typistName;
	char typistSymbol;
	int progress;
	boolean burnOutFlag;
	int burnOutTurns;
	double typistAccuracy;
	
	public Typist(char typistSymbol, String typistName, double typistAccuracy){
		this.typistSymbol = typistSymbol;
		this.typistName = typistName;
		if (typistAccuracy>=0.0 && typistAccuracy <= 1.0){
			this.typistAccuracy = typistAccuracy;
		}
	}

	public void burnOut(int turns){
		burnOutFlag = true;
		burnOutTurns = turns;
		return;
	}

	public void recoverFromBurnout(){
		burnOutTurns = burnOutTurns -1;
		if (burnOutTurns==0){
			burnOutFlag = false;
		}
		return;
	}

	public double getAccuracy(){
		return this.typistAccuracy;
	}

	public int getProgress(){
		return progress;
	}

	public String getName(){
		return this.typistName;
	}

	public char getSymbol(){
		return this.typistSymbol;
	}

	public int getBurnoutTurnsRemaining(){
		if (burnOutFlag = true){
			return burnOutTurns;
		}
		return 0;
	}

	public void resetToStart(){
		progress = 0;
		burnOutTurns = 0;
		burnOutFlag = false;
		return;
	}

	public boolean isBurntout(){
		if (burnOutFlag = true){
			return true;
		}
		return false;
	}

	public void typeCharacter(){
		progress++;
		return;
	}

	public void slideBack(int amount){
		if (progress-amount>0){
			progress = progress - amount;
		}
		progress = 0;
	}

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

	public void setSymbol(char newSymbol){
		this.typistSymbol = newSymbol;
	}
	
}