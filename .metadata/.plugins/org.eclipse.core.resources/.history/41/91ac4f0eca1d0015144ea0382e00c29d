package jamder.norms;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Between extends NormConstraint {

	private NormAction afterAction=null;
	private NormAction beforeAction=null;
	private Calendar beforeDate;

	public Between(Calendar before_date, Calendar date){
		this.beforeDate = before_date;
		this.date = date;
	}

	public Between(NormAction after_action, NormAction before_action){
		this.afterAction = after_action;
		this.beforeAction = before_action;
	}

	/******************gets and sets*****************/
	
	public NormAction getAfter_action() {
		return afterAction;
	}

	public void setAfter_action(NormAction after_action) {
		this.afterAction = after_action;
	}

	public NormAction getBefore_action() {
		return beforeAction;
	}

	public void setBefore_action(NormAction before_action) {
		this.beforeAction = before_action;
	}

	public Calendar getBefore_date() {
		return beforeDate;
	}

	public void setBefore_date(Calendar before_date) {
		this.beforeDate = before_date;
	}	
	
	/** Checks whether the constraint is satisfied.
	 * @author Israel
	 * @version 1
	 * @return boolean - If constraint is satisfied return true. Else return false.
	 *  */
	public boolean isTrue(){
		Calendar now=new GregorianCalendar();
		boolean bd=false;
		boolean ad=false;
		if (beforeDate!=null && date!=null){
			bd=beforeDate.compareTo(now)<=0;//Antes da data.
			ad=date.compareTo(now)>0;//Depois da data.
		}
		return (bd && ad) || (afterAction!=null && beforeAction!=null && afterAction.isRun() && !beforeAction.isRun());
	}
	
}
