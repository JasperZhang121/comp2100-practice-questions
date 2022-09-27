public interface State {

	default void handle(Character character, Key event) {

		check(character, event);
		this.handleInput(character,event);

	}

	public void handleInput(Character character, Key event);

	default void check(Character character, Key event) {

		// TODO
		// START YOUR CODE
		// END YOUR CODE


		if (character.getState()==StandState.getInstance()){
			if (event== Key.RIGHT) character.setState(WalkState.getInstance());
			if (event==Key.DOWN) character.setState(SquatState.getInstance());
			if (event==Key.UP) character.setState(SuspendState.getInstance());
		}

		if (character.getState()==WalkState.getInstance()){
			if (event==Key.LEFT) character.setState(StandState.getInstance());
		}

		if (character.getState()==SquatState.getInstance()){
			if (event==Key.UP)character.setState(StandState.getInstance());
		}

		if (character.getState()==SuspendState.getInstance()){
			if (event==Key.DOWN)character.setState(StandState.getInstance());
		}

	}
}
