import java.util.*;

class Source {
	private String name;
	Source(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}
}

class Destination {
	private String name;
	Destination(String name) {
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
class Database{
	static Map<Source, Destination> db = new HashMap<Source,Destination>();

	public static Map<Source, Destination> createDbDatabase(){
		db.put(new Source("Bangalore"), new Destination("Singapore"));
		db.put(new Source("Singapore"), new Destination("Seoul"));
		db.put(new Source("Singapore"), new Destination("Dubai"));
		db.put(new Source("Seoul"), new Destination("Beijing"));
		db.put(new Source("Beijing"), new Destination("Tokyo"));	
		return db;
	}
}

public class Directpath{
	static Map<Source, Destination> db = Database.createDbDatabase();
	public static String path(String source,String destination){
		int count = 0;
		for(Source s : db.keySet()){
			if(s.getName()==source && db.get(s).getName()==destination)
				return "true";
		}
		return "false";
	}	
};