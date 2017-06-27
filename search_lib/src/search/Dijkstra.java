package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
/**
 * dijkstra algorithm
 * @author Sapir Markel and Roee Sisso
 *
 * @param <T>
 */
public class Dijkstra<T> extends CommonSearcher<T>
{


	private PriorityQueue<State<T>> open;
	private HashSet<State<T>> close;
	private HashMap<Action, State<T>> successors;

	public Dijkstra()
	{//initialized
		init();
	}

	public void init()
	{
		this.evaluatedNodes=0;
		this.open=new PriorityQueue<>();
		this.close=new HashSet<>();
	}

	@Override
	public Solution search(Searchable<T> s)
	{

		State<T>init=s.getInitialState();
		init.setCameFrom(null);
		open.add(init);

		while(!this.open.isEmpty())
		{


			State<T>currState=this.open.poll();

			this.evaluatedNodes++;

			this.close.add(currState);

			this.successors=s.getAllPossibleMoves(currState);
			for(Action a: this.successors.keySet())
			{
				State<T> n=this.successors.get(a);

				if(!this.close.contains(n))
				{

					if(!this.open.contains(n))
					{
						n.setCameFrom(currState);
						n.setAction(a);
						this.open.add(n);
					}

					else{

						State<T> sameState=null;
						for(State<T> st:this.open)
						{
							if(st.equals(n))
							{
								sameState=st;
								break;
							}
						}

						if(sameState!=null)
						{

							if(n.getCost()<sameState.getCost()){
								this.open.remove(sameState);
								n.setCameFrom(currState);
								n.setAction(a);
								this.open.add(n);
							}
						}
					}

				}


			}

		}

			for(State<T> node : close)
			{
				if(s.getGoalStates().contains(node))
					return backTrace(node);
			}

		return null;
	}


}