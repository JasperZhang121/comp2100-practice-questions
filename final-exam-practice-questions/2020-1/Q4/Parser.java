import java.util.ArrayList;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * Implement a parser to extract the columns and values from tokens and execute
 * the SQL command to insert new customers. Do not insert customers if the
 * following errors are found: 
 * 1 - some brackets are missing 
 * 2 - some columnnames are wrong
 * 
 * Please see the columns names in Customer.java file. Please see test cases in
 * ParserTest.java
 */
public class Parser {

	Tokeniser tokeniser;
	XMLTable table;

	public Parser(Tokeniser tokeniser, XMLTable table) {
		this.tokeniser = tokeniser;
		this.table = table;
	}

	/**
	 * Extract the columns and values from tokens and execute the SQL command to insert new customers
	 */
	public void parseExp() {

		// TODO: Complete this method
		// START YOUR CODE



		int count=0;
		var attributes = new ArrayList<String>();
		var values = new ArrayList<String>();
		var table_name = "";
		var customers = new ArrayList<Customer>();

		while (tokeniser.hasNext()){
			var current = tokeniser.takeNext();
			if (current.type.equals(Token.Type.INSERT_INTO)){
				if (count==0){
					count+=1;

					int table_index = current.value.indexOf(' ');
					table_name = current.value.substring(0,table_index);
					String in_bra = current.value.substring(table_index+2,current.value.length()-1);

					var attribute  = "";
					for (int i = 0; i < in_bra.length(); i++) {
						if (Character.isLetter(in_bra.charAt(i))){
							attribute+=in_bra.charAt(i);
							if (i==in_bra.length()-1 && attribute!=""){
								attributes.add(attribute);
								attribute = "";
							}

						}else{
							attributes.add(attribute);
							attribute = "";
						}
					}

				}
			}
			if (current.type.equals(Token.Type.VALUES)){
				if (count==1){
					count=0;
					var temp = "";
					var string_values = current.value;
					for (int i = 0; i < string_values.length(); i++) {
						if (Character.isLetter(string_values.charAt(i)) || Character.isDigit(string_values.charAt(i)) || string_values.charAt(i)==' '){
							temp+=string_values.charAt(i);
						}
						if (string_values.charAt(i)==','){
							temp = temp.trim();
							values.add(temp);
							temp = "";
						}
						if (i==string_values.length()-1&&temp!=""){
							temp = temp.trim();
							values.add(temp);
							temp = "";
						}
					}
				}
			}

			int id = 0;
			String name = null;
			String address = null;
			String city = null;
			String postcode = null;
			String country = null;

			if (attributes.size()!=0 && values.size()!=0 && attributes.size()==values.size()){
				for (int i = 0; i < attributes.size(); i++) {
					if (attributes.get(i).equals(Customer.KEY_ID)) id = Integer.parseInt(values.get(i));
					if (attributes.get(i).equals(Customer.KEY_NAME)) name = values.get(i);
					if (attributes.get(i).equals(Customer.KEY_ADDRESS)) address = values.get(i);
					if (attributes.get(i).equals(Customer.KEY_CITY)) city = values.get(i);
					if (attributes.get(i).equals(Customer.KEY_POSTCODE)) postcode = values.get(i);
					if (attributes.get(i).equals(Customer.KEY_COUNTRY)) country = values.get(i);
				}

				Customer customer = new Customer(id,name,address,city,postcode,country);
				customers.add(customer);

				attributes.clear();
				values.clear();
			}
		}
		if (table.load(table_name).size()==0){
			table.save(table_name,customers);
		} else {
			for (int i = 0; i < customers.size(); i++) {
				table.insert(table_name,customers.get(i));
			}
		}

		// END YOUR CODE
	}
}
