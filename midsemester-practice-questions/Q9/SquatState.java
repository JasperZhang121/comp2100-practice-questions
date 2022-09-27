public class SquatState implements State {

    private static SquatState instance;

    private SquatState() {
    }

    public static SquatState getInstance(){
        if (instance==null)instance=new SquatState();
        return instance;
    }

    @Override
    public void handle(Character character, Key event) {
        State.super.handle(character, event);
    }

    @Override
    public void handleInput(Character character, Key event) {

    }

    @Override
    public void check(Character character, Key event) {
        State.super.check(character, event);
    }
}
