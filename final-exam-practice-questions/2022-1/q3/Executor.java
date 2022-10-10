import java.util.LinkedList;
import java.util.List;

public class Executor {

	private final List<Command> commands;

	private final BST memory = new BST();

	public Executor(List<Command> commands) {
		this.commands = commands;
	}

	public List<NodeCopy> execute() {
		List<NodeCopy> results = new LinkedList<>();
		for (Command c : this.commands) {
			if (c instanceof LoadCommand) {
				results.add(load((LoadCommand) c));
			} else if (c instanceof SaveCommand) {
				results.add(save((SaveCommand) c));
			} else if (c instanceof SumCommand) {
				results.add(sum((SumCommand) c));
			}
		}

		return results;
	}

	private NodeCopy load(LoadCommand c) {

		NodeCopy copy = null;

		// TODO
		// ########## YOUR CODE STARTS HERE ##########

		// ########## YOUR CODE ENDS HERE ##########

		return copy;
	}

	/**
	 * return the nodecopy of the save command key to be saved into memory
	 * 
	 * @param c
	 * @return
	 */
	private NodeCopy save(SaveCommand c) {

		NodeCopy copy = null;
		// TODO
		// ########## YOUR CODE STARTS HERE ##########

		// ########## YOUR CODE ENDS HERE ##########

		return copy;
	}

	/**
	 * return the nodecopy of the sum command key to be saved into memory
	 * 
	 * @param c
	 * @return
	 */
	private NodeCopy sum(SumCommand c) {

		NodeCopy copy = null;

		// TODO
		// ########## YOUR CODE STARTS HERE ##########

		// ########## YOUR CODE ENDS HERE ##########

		return copy;
	}

	public List<Command> getCommands() {
		return commands;
	}
}
