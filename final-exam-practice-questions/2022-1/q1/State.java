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

		// ########## YOUR CODE ENDS HERE ##########
	}
}
