package jamder.norms;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Before extends NormConstraint {

	private NormAction action=null;
	
	public Before(Calendar date){
		this.date = date;
	}
	
	// Quando não especificar a data.
	
	public Before(NormAction action){
		this.action = action;
	}
	
	/******************gets and sets*****************/
	
	public NormAction getAction() {
		return action;
	}

	public void setAction(NormAction action) {
		this.action = action;
	}
	
	/** Checks whether the constraint is satisfied.
	 * @author Israel
	 * @version 1
	 * @return boolean - If constraint is satisfied return true. Else return false.
	 *  */
	public boolean isTrue(){
		Calendar now=new GregorianCalendar();
		boolean dt=date.compareTo(now)>0;//Antes da data.
		return (action!=null && !action.isRun()) || dt;//NormAction não foi executada e/ou a data ainda não passou.
	}
	
}
