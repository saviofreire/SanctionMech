package jamder.norms;

import java.util.ArrayList;
import java.util.List;

public class CompositeAction extends NormAction {

	private CompositeActionType type;
	private List<NormAction> actions = new ArrayList<NormAction>();
	
	public CompositeAction(CompositeActionType type, NormResource normResource) {
		super(normResource);
		this.type = type;
	}

	//Gerar Get e Set.
	
	public void add(NormAction n) {
		actions.add(n);
	}

	public void remove(NormAction n) {
		actions.remove(n);
	}


	/******************gest and sets*****************/
	
	public NormAction get(int index) {
		return actions.get(index);
	}

	public CompositeActionType getType() {
		return type;
	}

	public void setType(CompositeActionType type) {
		this.type = type;
	}

	public List<NormAction> getActions() {
		return actions;
	}

	public void setActions(List<NormAction> actions) {
		this.actions = actions;
	}


	
}
