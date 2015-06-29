package jamder.norms;


public class AtomicAction extends NormAction {

	private AtomicActionType type;
	
	public AtomicAction(AtomicActionType type, NormResource normResource) {
		super(normResource);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	/******************gest and sets*****************/
	
	public AtomicActionType getType() {
		return type;
	}

	public void setType(AtomicActionType type) {
		this.type = type;
	}
	
	
	
}
	
