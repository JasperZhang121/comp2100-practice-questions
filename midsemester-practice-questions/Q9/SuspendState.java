public class SuspendState implements State{

    private static SuspendState instance;

    private SuspendState(){}

    public static SuspendState getInstance(){
        if (instance==null)instance=new SuspendState();
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
