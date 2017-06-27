package search;
import java.util.HashMap;
import java.util.List;
/**
 * for using the algorithm need to implements this interface
 * @author Sapir Markel and Roee Sisso
 *
 * @param <T>
 */
public interface Searchable<T> {
	State<T> getInitialState();
	List <State<T>> getGoalStates();

	HashMap<Action, State<T>> getAllPossibleMoves(State<T> state);
}
