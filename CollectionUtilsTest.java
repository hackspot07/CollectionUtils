import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class ListMapper implements OperateAble<Integer>{
	public  Integer operate(Integer ele){
		return ele*2;
	}
};

class ListFilter implements PredicateAble<Integer>{
	public boolean predicate(Integer ele){
		return (ele>2) ? true : false;
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
		PredicateAble<Integer> ob = new ListFilter(); 
		for(int i=0; i<5; i++){
			list.add(i);
		}
		List<Integer> newlist = CollectionUtils.<Integer>filter(list,ob);
		assertEquals(newlist.size(),2);
		int first = newlist.get(0);
		assertEquals(first,3);
	}
};	
