class TestTypist {
    public static void main(String[] args) {

        Typist t = new Typist('A', "Test", 0.8);

        t.typeCharacter(); // progress = 1
        t.typeCharacter(); // progress = 2

        t.slideBack(7); // should go back to 0 (not negative)

        System.out.println("Progress: " + t.getProgress());
    }
}