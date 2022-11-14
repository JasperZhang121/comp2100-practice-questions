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

		boolean load = false;
		boolean save = false;
		boolean sum = false;
		int count_save = 0;
		var save_value = 0;
		var save_key = "";
		int count_sum = 0;
		var pattern = "";
		var key = "";

		while (tokeniser.hasNext()){
			var temp = tokeniser.current();
			if (temp.getType().equals(Token.Type.LOAD)){
				load = true;
			}
			if (temp.getType().equals(Token.Type.SAVE)){
				save = true;
			}
			if (temp.getType().equals(Token.Type.SUM)){
				sum = true;
			}


			if (temp.getType().equals(Token.Type.PARAMETER)){
				if (load){
					commands.add(new LoadCommand(temp.getValue()));
					load =false;
				}
				if (save){
					if (count_save==0) {
						save_value = Integer.parseInt(temp.getValue());
						count_save+=1;
					}
					else if (count_save==1){
						save_key = temp.getValue();
						commands.add(new SaveCommand(save_key,save_value));
						save=false;
						count_save=0;
					}
				}
				if (sum){
					if (count_sum==0) {
						pattern = temp.getValue();
						count_sum+=1;
					}
					else if (count_sum==1){
						key = temp.getValue();
						commands.add(new SumCommand(pattern,key));
						sum = false;
						count_sum=0;
					}
				}
			}
			tokeniser.next();
		}

		// ########## YOUR CODE ENDS HERE ##########

		return commands;
	}
}
