package search;
/**
 * interface for search algorithms
 * @author Sapir Markel and Roee Sisso
 *
 * @param <T>
 */
public interface Searcher<T> {
	Solution search(Searchable<T> s);
	int getNumberOfNodesEvaluated();
}
