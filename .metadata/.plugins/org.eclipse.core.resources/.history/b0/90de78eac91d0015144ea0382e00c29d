package jamder.norms;

import java.util.Calendar;
import java.util.Hashtable;


abstract public class NormConstraint {//Agora é abstrato.
	protected Calendar date=null;
	protected Hashtable<String, Norm> norms = new Hashtable<String, Norm>();
	
	
	// Norms
	public Norm getNorm(String key) {
		return norms.get(key);
	}
	public void addNorm(String key, Norm norm) {
		norms.put(key, norm);
	}
	public Norm removeNorm(String key) {
		return norms.remove(key);
	}
	public void removeAllNorms() {
		norms.clear();
	}
	public Hashtable<String, Norm> getAllNorms() {
		return norms;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	/** Checks whether the constraint is satisfied.
	 * @author Israel
	 * @version 1
	 * @return boolean - If constraint is satisfied return true. Else return false.
	 *  */
	abstract public boolean isTrue();
	
}	
