import java.util.*;
import java.io.*;

class Database{
	static Map<String, List<String>> db = new HashMap<String,List<String>>();
	public static Map<String, List<String>> createDbDatabase(){
		List<String> bangalore = new ArrayList<String>();
		bangalore.add("Singapore");
		db.put("Bangalore",bangalore);
		List<String> singapore = new ArrayList<String>();
		singapore.add("Seoul");
		singapore.add("Dubai");
		db.put("Singapore",singapore);
		List<String> seoul = new ArrayList<String>();
		seoul.add("Beijing");
		db.put("Seoul",seoul);
		List<String> beijing = new ArrayList<String>();
		beijing.add("Tokyo");
		db.put("Beijing",beijing);	
		return db;
	}
}

public class Path{
	static Map<String, List<String>> db = Database.createDbDatabase();
	public static boolean path(String source,String destination)throws Exception{
 		if(!isPresentSource(source)){
			throw new Exception("No city Named "+source);
		}
		if(!isPresentDestination(source,destination)){
			throw new Exception("No city Named "+destination);
		}
		return (hasPath(source,destination));
	}

	public static boolean isPresentSource(String src){
		return (db.containsKey(src));
	}

	public static boolean isPresentDestination(String source,String dst){ 
		for(String s : db.keySet()){
			if(db.get(s).contains(dst))
				return true;
		}
		return false;
	}

	public static boolean hasPath(String source,String destination){
		for(String s : db.get(source)) { 
			if(db.get(source).contains(destination))
				return true;
			source = source.replace(source,s);
			return hasPath(source,destination);
		}
		return false;
	}
};