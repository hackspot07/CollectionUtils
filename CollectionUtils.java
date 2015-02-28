import java.util.*;

interface OperateAble{
	int operate(int ele);
}

public class CollectionUtils{
	public CollectionUtils(){
	
	}

	public static List<Integer> map(List<Integer> list,OperateAble op){
		List<Integer> newlist = new ArrayList<Integer>();
		for(int i: list){
			newlist.add(op.operate(i));
			System.out.println(op.operate(i));
		}
		return newlist;
	}
};
