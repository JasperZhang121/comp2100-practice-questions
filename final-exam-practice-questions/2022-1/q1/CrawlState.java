public class CrawlState implements State{


    private static CrawlState instance;

    private CrawlState() {
    }

    public static CrawlState getInstance(){
        if (instance==null)instance=new CrawlState();
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
