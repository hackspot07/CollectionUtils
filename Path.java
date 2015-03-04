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
		List<String> dubai = new ArrayList<String>();
		dubai.add("Lucknow");
		db.put("Dubai",dubai);
		List<String> beijing = new ArrayList<String>();
		beijing.add("Tokyo");
		db.put("Beijing",beijing);	
		List<String> pak = new ArrayList<String>();
		pak.add("India");
		db.put("Pak",pak);
		return db;
	}
}

public class Path{
	private static Map<String, List<String>> db = Database.createDbDatabase();

	private static ArrayList<String> visitedPath = new ArrayList<String>();
    private static ArrayList<String> root = new ArrayList<String>();

	public static boolean path(String source,String destination)throws Exception{
		boolean result;
 		if(!isPresentCities(source)){
			throw new Exception("No city Named "+source);
		}
		if(!isPresentCities(destination)){
			throw new Exception("No city Named "+destination);
		}
		source = madeKey(source);
		if(hasPath(source,destination)){
			result = true;
		}else{
			destination = madeKey(destination);
			result = hasPath(destination,source);
		} 
		root.clear();
		return result;
	}

	public static boolean isPresentCities(String src){
		for(String s : db.keySet()){
			if(db.get(s).contains(src) || db.containsKey(src))
				return true;
		}
		return false;
	}

	public static boolean hasPath(String source,String destination){
		visitedPath.add(source); 
		List<String> list = db.get(source);
		if(list!=null){
			if(list.contains(destination)){ 
				root.add(destination);
				System.out.println(root);
				return true;
			}
			for(String src : db.get(source)){
				if(!visitedPath.contains(src))
                	root.add(src);
				if(hasPath(src,destination))
					return true;
			}	
		}; 
		return false;
	}

	public static String getKey(String value){
		for(String key: db.keySet()){
			if(db.get(key).contains(value)){
				return key;
			}
		}
		return null;
	}

	public static String madeKey(String source){
		return (db.containsKey(source)) ? source : getKey(source);
	}

};