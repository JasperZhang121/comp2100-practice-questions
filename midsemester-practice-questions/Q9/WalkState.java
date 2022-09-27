public class WalkState implements State{

    private static WalkState instance;

    private WalkState(){}

    public static WalkState getInstance(){
        if (instance==null)instance=new WalkState();
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
