public class StandState implements State{

    private static StandState instance;

    private StandState(){}

    public static State getInstance() {
        if (instance==null) instance = new StandState();
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
    public String getStateName() {
        return State.super.getStateName();
    }

    @Override
    public void check(Character character, Key event) {
        State.super.check(character, event);
    }
}
