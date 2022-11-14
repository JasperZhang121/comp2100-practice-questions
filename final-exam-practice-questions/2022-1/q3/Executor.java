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

		var check = memory.find(c.getKey());
		if (check!=null) copy = new NodeCopy(check);

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

		var inserted_node = new Node(c.getKey(),c.getValue());
		memory.insert(inserted_node);
		copy = new NodeCopy(inserted_node);

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

		var storage = memory.invertedPreOrder();
		var check_string ="";
		var total = 0;
		if (c.getPattern().charAt(c.getPattern().length()-1)=='*'){
			check_string = c.getPattern().substring(0,c.getPattern().length()-1);
			for (var each : storage){
				if (each.key.substring(0, check_string.length()).equals(check_string)){
					total+= each.value;
				}
			}
		}
		if (c.getPattern().charAt(0)=='*'){
			check_string = c.getPattern().substring(1);
			for (var each: storage){
				if (!each.key.substring(0, check_string.length()).equals(check_string) && each.key.contains(check_string)){
					total+=each.value;
				}
			}
		}
		if (c.getPattern().contains("*") && c.getPattern().charAt(0)!= '*' && c.getPattern().charAt(c.getPattern().length()-1)!= '*'){
			int index  = c.getPattern().indexOf('*');
			for (var each: storage){
				var prefix = c.getPattern().substring(0,index);
				var suffix = c.getPattern().substring(index+1);
				if (each.key.contains(prefix) && each.key.substring(each.key.length()-suffix.length()).equals(suffix) && c.getPattern().indexOf(prefix)<c.getPattern().indexOf(suffix)){
					total+=each.value;
				}
			}
		}
		copy = new NodeCopy(c.getKey(),total);
		// ########## YOUR CODE ENDS HERE ##########
		return copy;
	}

	public List<Command> getCommands() {
		return commands;
	}
}
