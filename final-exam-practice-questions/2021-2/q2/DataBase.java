import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {

	private Map<String, List<Person>> storage = new HashMap<>();

	private static final DataBase INSTANCE = new DataBase();

	public static DataBase getInstance() {
		return INSTANCE;
	}

	public void save(String key, List<Person> persons) {
		if (persons != null) {
			this.storage.put(key, persons);
		}
	}

	public List<Person> load(String key) {
		return this.storage.get(key);
	}
	
	public void clear() {
		this.storage.clear();
	}
}
