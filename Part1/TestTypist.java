class TestTypist {
    public static void main(String[] args) {

        Typist t = new Typist('A', "Test", 0.8);

        t.burnOut(2);

        System.out.println("Burnouts remaining: " + t.getBurnoutTurnsRemaining());
        System.out.println("Is burnt out: " + t.isBurntout());

        t.recoverFromBurnout();
        System.out.println("Burnouts remaining: " + t.getBurnoutTurnsRemaining());
        System.out.println("Is burnt out: " + t.isBurntout());

        t.recoverFromBurnout();
        System.out.println("Burnouts remaining: " + t.getBurnoutTurnsRemaining());
        System.out.println("Is burnt out: " + t.isBurntout());
    }
}