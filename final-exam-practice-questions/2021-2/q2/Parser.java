import java.util.LinkedList;
import java.util.List;

public class Parser {

	private final Tokeniser tokeniser;

	public Parser(Tokeniser tokeniser) {
		this.tokeniser = tokeniser;
	}

	public List<Command> parseCmds() {

		List<Command> commands = new LinkedList<>();

		// ########## YOUR CODE STARTS HERE ##########

		boolean save = false;
		boolean load = false;
		var count_save = 0;
		var save_key = "";
		var save_file ="";
		var count_load = 0;
		var load_key = "";
		var load_file= "";

		while (tokeniser.hasNext()){
			var temp = tokeniser.current();
			if (temp.getType().equals(Token.Type.SAVE)){
				save= true;
			}
			if (temp.getType().equals(Token.Type.LOAD)){
				load= true;
			}
			if (temp.getType().equals(Token.Type.PARAMETER)){
				if (save){
					if (count_save==0){
						save_key = temp.getValue();
						count_save+=1;
					}
					else if (count_save==1){
						save_file = temp.getValue();
						commands.add(new SaveCommand(save_key,save_file));
						count_save = 0;
						save = false;
					}
				}
				if (load){
					if (count_load==0){
						load_key = temp.getValue();
						count_load+=1;
					}
					else if (count_load==1){
						load_file = temp.getValue();
						commands.add(new LoadCommand(load_key,load_file));
						count_load=0;
						load=false;
					}
				}
			}
			tokeniser.next();
		}

		// ########## YOUR CODE ENDS HERE ##########

		return commands;
	}
}
