package search;

import java.util.LinkedList;

public abstract class CommonSearcher<T> implements Searcher<T> {
	protected int evaluatedNodes;

	public CommonSearcher() {
		evaluatedNodes = 0;
	}

	@Override
	public int getNumberOfNodesEvaluated() {
		return evaluatedNodes;
	}

	protected Solution backTrace(State<T> goalState) {
		LinkedList<Action> actions = new LinkedList<Action>();

		State<T> currState = goalState;

		while (currState.getCameFrom() != null) {
			////// if there is history
			if (currState.getAction().getHistory() != null) {



				currState.getAction().getHistory().add(0,currState.getAction());
				for(int i=currState.getAction().getHistory().size()-1;i>=0;i--)
				{

					actions.add(currState.getAction().getHistory().remove(i));

				}


			}
			else
			actions.add(currState.getAction());

			currState = currState.getCameFrom();
		}

		Solution sol = new Solution();
		sol.setActions(actions);
		return sol;
	}

}
