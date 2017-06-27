package search;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	private LinkedList<Action> actions = new LinkedList<Action>();

	public Solution() {
		// TODO Auto-generated constructor stub
	}
	public List<Action> getActions() {
		return actions;
	}

	public void setActions(LinkedList<Action> actions) {
		//this.actions = actions;
		for (Action action : actions) {
			this.actions.addFirst(action);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Action a : actions) {
			sb.append(a.getName()).append("\n");

		}

		return sb.toString();
	}
}
