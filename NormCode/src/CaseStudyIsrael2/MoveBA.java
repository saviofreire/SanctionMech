package CaseStudyIsrael2;

import jamder.behavioural.Action;
import jamder.behavioural.Condition;
import jamder.norms.NormType;

public class MoveBA extends Action {
	
	Table table;

	public MoveBA(String name, Table table) {
		super(name);
		this.table=table;
	}
	
	public void execute() {
		Block ba=table.findBlock("B");
		Block bb=table.findBlock("A");
		if (ba.isClear() && bb.isClear())
			if (ba.getOn().getName().equalsIgnoreCase("table")){
				table.move(ba, table, bb);
				System.out.println("MoveBA");
			}
	}
}