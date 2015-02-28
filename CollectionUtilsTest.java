import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

interface OperateAble <E>{
	public E operate(E ele);
}

interface PredicateAble <E>{
	public E predicate(E ele);
}

class ListMapper implements OperateAble <Integer>{
	public  Integer operate(Integer ele){
		return ele*2;
	}
};

class ListFilter implements PredicateAble <Integer>{
	public  Integer predicate(Integer ele){
		if(ele>2)
			return ele;
	}
};

public class CollectionUtilsTest{
	@Test
	public void CollectionUtilsListMApperRturnAlist(){
		List<Integer> list = new ArrayList<Integer>();
		OperateAble<Integer> op = new ListMapper(); 
		for(int i=0; i<5; i++){
			list.add(i);
		}
		List<Integer> newlist = CollectionUtils.<Integer>map(list,op);
		assertEquals(newlist.size(),5);
	}

	@Test
	public void CollectionUtilsListFilterRturnAlist(){
		List<Integer> list = new ArrayList<Integer>();
		PredicateAble<Integer> op = new ListFilter(); 
		for(int i=0; i<5; i++){
			list.add(i);
		}
		List<Integer> newlist = CollectionUtils.<Integer>filter(list,op);
		assertEquals(newlist.size(),2);
	}
} 	
