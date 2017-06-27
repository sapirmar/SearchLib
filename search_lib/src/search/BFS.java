package search;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * BFS algorithm
 * @author Sapir Markel and Roee Sisso
 *
 * @param <T>
 */
public class BFS<T> extends CommonSearcher<T> {
public BFS() {
	super();
}
	@Override
	public Solution search(Searchable<T> s) {

		Queue<State<T>> open=new PriorityQueue<>(new Comparator<State<T>>() {

			@Override
			public int compare(State<T> o1, State<T> o2) {
				return (int)(o1.getCost()-o2.getCost());
			}
		});//staes to be evaluated
		HashSet<State<T>> closed = new HashSet<>(); //states already evaluated
		State<T> state=s.getInitialState();

		open.add(state);
		while(!open.isEmpty()){
			State<T> currstate=open.poll();//remove the best node


			if(s.getGoalStates().contains(currstate))
			{

				return backTrace(currstate);
			}
			if(!closed.contains(currstate)){
			HashMap<Action, State<T>> map=s.getAllPossibleMoves(currstate);
			for (Action a : map.keySet()) {
				State<T> n=map.get(a);

				if((!closed.contains(n)&&(!open.contains(n)))){
					n.setCameFrom(currstate);
					n.setAction(a);
					//System.out.println("the state from bfs "+ n);

					n.setCost(currstate.getCost()+1);///////////////////////////// ichanged

					evaluatedNodes++;
					open.add(n);



				}
				else{//if or open or close
					if(!open.contains(n)){
						//open.add(n);//*************************
						if(n.getCost()>currstate.getCost()+1){
							n.setAction(a);
							n.setCameFrom(currstate);
							n.setCost(currstate.getCost()+1);
													}
					}
					else{//if isnt in close
						open.remove(n);
						n.setAction(a);
						n.setCameFrom(currstate);//////////////////////////////////
						n.setCost(currstate.getCost()+1);
						open.add(n);////////////

					}

				}
			}

		}
			closed.add(currstate);
		}
		System.out.println("no way");
		return null;

	}

}
