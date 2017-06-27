package search;


import java.io.Serializable;
import java.util.List;

public class Action implements Serializable {
	private String name;
	private List<Action> history;
	public Action() {
		// TODO Auto-generated constructor stub
	}

	public List<Action> getHistory() {
		return history;
	}

	public void setHistory(List<Action> history) {
		this.history = history;
	

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Action(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Action a = (Action)obj;
		return a.name.equals(name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
