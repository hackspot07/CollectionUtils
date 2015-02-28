import java.util.*;

public class CollectionUtils{
	public static <E> List<E> map(List<E> list,OperateAble op){
		List<E> newlist = new ArrayList<E>();
		for(E i: list){
			newlist.add((E)(op.operate(i)));
		}
		return newlist;
	}

	public static <E> List<E> filter(List<E> list,OperateAble op){
		List<E> newlist = new ArrayList<E>();
		for(E i: list){
			newlist.add((E)(op.predicate(i)));
		}
		return newlist;
	}
};
