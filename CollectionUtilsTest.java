import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;


class ListMapper implements OperateAble{
	public ListMapper(){
	}
	public int operate(int ele){
		return ele*2;
	}
};

public class CollectionUtilsTest{
	@Test
	public void CollectionUtilsRturnAlist(){
		List<Integer> list = new ArrayList<Integer>();
		OperateAble op = new ListMapper(); 
		for(int i=0; i<5; i++){
			list.add(i);
		}
		List<Integer> newlist = CollectionUtils .map(list,op);
		assertEquals(newlist.size(),5);
	}

} 	
