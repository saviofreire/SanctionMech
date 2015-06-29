package jamder.norms;
import jamder.structural.Property;

/** Class created to enable the use of Java Generics in Property.
 * @author Israel
 * @version 1
 * */
public class NormResourceProperty<T extends Comparable<T>> extends NormResource{
	private Property<T> property=null;
	
	
	
	/** Creates a resource norm type: Attribute, Goal, Belief or "Relationship".*/
	public NormResourceProperty(Property<T> property){
		setProperty (property);
	}
	
	/******************gets and sets*****************/

	public Property<T> getProperty() {
		return property;
	}


	public void setProperty(Property<T> property) {
		this.property = property;
	}

}	
