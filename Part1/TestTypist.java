class TestTypist {
    public static void main(String[] args) {
	
	Typist t = new Typist('A', "Test", 0.8);
	
	System.out.println("Progress: " + t.getProgress());
	t.typeCharacter();
	t.typeCharacter();
	System.out.println("Progress: " + t.getProgress());
	

    }
}