import exceptions.NullCharacterException;
import exceptions.NullKeyEventException;

public interface State {

	default void handle(Character character, Key event) {

		check(character, event);

		this.handleInput(character, event);
	}

	public void handleInput(Character character, Key event);

	default String getStateName() {
		return this.getClass().getTypeName();
	}

	default void check(Character character, Key event) {

		// TODO
		// ########## YOUR CODE STARTS HERE ##########

		if (event==null) throw new NullKeyEventException();
		if (character==null) throw new NullCharacterException();

		if (event.equals(Key.RESET)) character.setState(StandState.getInstance());

		else if (character.getState() == StandState.getInstance()) {
			if (event.equals(Key.DOWN)) character.setState(LieProneState.getInstance());
			if (event.equals(Key.RIGHT)) character.setState(RunState.getInstance());
		}
		else if (character.getState() ==  RunState.getInstance()){
			if (event.equals(Key.LEFT)) character.setState(StandState.getInstance());
		}
		else if (character.getState() == LieProneState.getInstance()){
			if (event.equals(Key.S)) character.setState(ShootState.getInstance());
			if (event.equals(Key.RIGHT)) character.setState(CrawlState.getInstance());
		}
		else if (character.getState() == CrawlState.getInstance()){
			if (event.equals(Key.LEFT)) character.setState(LieProneState.getInstance());
		}
		else if (character.getState() ==  ShootState.getInstance()){
			if (event.equals(Key.L)) character.setState(LieProneState.getInstance());
		}

		// ########## YOUR CODE ENDS HERE ##########
	}
}
