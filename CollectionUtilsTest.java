import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class ListMapper implements OperateAble<Integer,String>{
	public  String operate(Integer ele){
		return ele+"";
	}
};

class ListFilter implements PredicateAble<Integer>{
	public boolean predicate(Integer ele){
		return (ele>2) ? true : false;
	}
};

class ListReducer implements ReduceAble<Integer,Integer>{
	public Integer reducer(Integer intial,Integer item){
		return intial + item;
	}
}

public class CollectionUtilsTest{
	@Test
	public void CollectionUtilsListMApperRturnAlist(){
		List<Integer> list = new ArrayList<Integer>();
		OperateAble<Integer,String> op = new ListMapper(); 
		for(int i=0; i<5; i++){
			list.add(i);
		}
		List<String> newlist = CollectionUtils.<Integer,String>map(list,op);
		assertEquals(newlist.size(),5);
	}

	@Test
	public void CollectionUtilsListFilterRturnAlist(){
		List<Integer> list = new ArrayList<Integer>();
		PredicateAble<Integer> ob = new ListFilter(); 
		for(int i=0; i<5; i++){
			list.add(i);
		}
		List<Integer> newlist = CollectionUtils.<Integer>filter(list,ob);
		assertEquals(newlist.size(),2);
		int first = newlist.get(0);
		assertEquals(first,3);
	}

	@Test
	public void CollectionUtilsListReducerRturnA10(){
		List<Integer> list = new ArrayList<Integer>();
		ReduceAble<Integer,Integer> op = new ListReducer(); 
		for(int i=0; i<5; i++){
			list.add(i);
		}
		Integer intial = 5;
		int finalValue = CollectionUtils.<Integer,Integer>reduce(list,op,intial);
		assertEquals(finalValue,15);
	}
};	
