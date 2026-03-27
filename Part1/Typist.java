class Typist{
	String typistName;
	char typistSymbol;
	int progress;
	boolean burnOutFlag;
	int burnOutTurns;
	double typistAccuracy;
	
	public Typist(char typistSymbol, String typistName, double typistAccuracy){
		this.typistSymbol = typostSymbol;
		this.typistName = typistName;
		if (typistAccuracy>=0.0 && typistAccuracy <= 1.0){
			this.typistAccuracy = typistAcccuracy;
		}
	}

	public static burnOut(int turns){
		burnOutFlag = true;
		burnOutTurns = turns;
	}

	public static recoverFromBurnout(){
		burnOutTurns = burnOutTurns -1;
		if (burnOutTurns==0){
			burnOutFlag = false;
		}
	}

	public getAccuracy(){
		return this.typistAccuracy;
	}

	public static int getProgress(){
		return progress;
	}

	public getName(){
		return this.typistName;
	}

	public getSymbol(){
		return this.typistSymbol;
	}

	public static int getBurnoutTurnsRemaining(){
		if (burnOutFlag = true){
			return burnOutTurns;
		}
		returns 0;
	}

	public static resetToStart(){
		progress = 0;
		burnOutTurns = 0;
		burnOutFlag = false;
	}

	public static boolean isBurntout(){
		if (burnOutFlag = true){
			return true;
		}
		return false;
	}

	public static typeCharacter(){
		progress++;
	}

	public static slideBack(int amount){
		if (progress-amount!=0){
			progress = progress - amount;
		}
	}

	public setAccuracy(double newAccuracy){
		if (newAccuracy<=0.0){
			newAccuracy = 0.0;
		}
		else if (newAccuracy>=1.0){
			newAccuracy = 1.0;
		}
		this.typistAccuracy = newAccuracy;
		
	}

	public setSymbol(char newSymbol){
		this.typistSymbol = newSymbol;
	}
}