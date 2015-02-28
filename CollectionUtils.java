import java.util.*;

interface OperateAble<E,K>{
	public K operate(E element);
}

interface PredicateAble<E>{
	public boolean predicate(E element);
}

interface ReduceAble<E,K>{
	public K reducer(K initial,E second);
}

public class CollectionUtils{
	public static <E,K> List<K> map(List<E> list,OperateAble op){
		List<K> newlist = new ArrayList<K>();
		for(E item: list){
			newlist.add((K)(op.operate(item)));
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

	public static <E,K> K reduce(List<E> list,ReduceAble ob, K initial){
		for(E item: list){
			initial = (K)ob.reducer(initial,item);
		}
		return initial;
	}

};
