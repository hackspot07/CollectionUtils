import java.util.*;
import java.io.*;

class Source {
	private String name;
	Source(String name) {
		this.name = name;
	}

	public String toString(){
		return name;
	}
	public boolean equals(Object other) {
		return name.equals(((Source) other).name);
	}
}

class Destination {
	private String name;
	Destination(String name) {
		this.name = name;
	}
	public String toString(){
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
	public static boolean path(String source,String destination)throws Exception{
		Source src = new Source(source);
 		if(!isPresentSource(src)){
			throw new Exception("No city Named "+source);
		}

		if(!isPresentDestination(destination)){
			throw new Exception("No city Named "+destination);
		}

		for(Source s : db.keySet()){
			if(s.toString().equals(source) && db.get(s).toString().equals(destination))
				return true;
		}
		return false;
	}

	public static boolean isPresentSource(Source src){
		for(Source s : db.keySet()){
			if(s.toString().equals(src.toString()))
				return true;
		}
		return false;
	}

	public static boolean isPresentDestination(String dst){
		for(Source s : db.keySet()){
			if(db.get(s).toString().equals(dst))
				return true;
		}
		return false;
	}
	
};