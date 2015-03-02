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
		int keyCount = 0,valCount = 0;
		for(Source s : db.keySet()){
			if(s.getName().equals(source) && db.get(s).getName().equals(destination))
				return "true";
			keyCount = checkForCount(s.getName(),source,keyCount);
			valCount = checkForCount(db.get(s).getName(),destination,valCount);
		}
		return (keyCount==db.keySet().size()) ? "No City Named "+source : 
				(valCount==db.keySet().size()) ? "No City Named "+destination  : "false";
	}

	private static int checkForCount(String first,String second,int count){
		return (!first.equals(second)) ? ++count : count;
	}	
};