import java.util.*;

interface OperateAble<E>{
	public E operate(E element);
}

interface PredicateAble<E>{
	public boolean predicate(E element);
}

public class CollectionUtils{
	public static <E> List<E> map(List<E> list,OperateAble op){
		List<E> newlist = new ArrayList<E>();
		for(E item: list){
			newlist.add((E)(op.operate(item)));
		}
		return newlist;
	}

	public static <E> List<E> filter(List<E> list,PredicateAble ob){
		List<E> newlist = new ArrayList<E>();
		for(E item: list){
			if(ob.predicate(item))
				newlist.add(item);
		} 
		return newlist;
	}
};
