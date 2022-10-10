public class Character {

	private State state = StandState.getInstance();

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
