package jamder.norms;

import jamder.structural.Property;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class IfConditional<T extends Comparable<T>> extends NormConstraint {
	/*Como queriam comparar Strings? o_O. Queriam ver se uma é lexicograficamente maior que a outra? hehehehehehehehe*/
	private Property<T> firstProperty;
	private Property<T> secondProperty;
	private Operator operator;

	//Contrutor para a seguinte situação: quando uma data definida na cláusula  if  for alcançada 
	public IfConditional(Operator operator, Calendar date){
		this.operator = operator;
		this.date = date;
	}	
	
	//Contrutor para comparação entre os operandos: Objetivos, Crença, Atributo Value;
	public IfConditional(Operator operator, Property<T> first_property , Property<T> second_property){
		this.operator = operator;
		this.firstProperty = first_property;
		this.secondProperty = second_property;
	}
	
	/******************gest and sets*****************/

	public Property<T> getFirst_property() {
		return firstProperty;
	}

	public void setFirst_property(Property<T> first_property) {
		this.firstProperty = first_property;
	}

	public Property<T> getSecond_property() {
		return secondProperty;
	}

	public void setSecond_property(Property<T> second_property) {
		this.secondProperty = second_property;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	/** Checks whether the condition is satisfied.
	 * @author Israel
	 * @version 1
	 * @return boolean - If condition is satisfied return true. Else return false.
	 *  */
	public boolean isTrue(){
		Calendar now=new GregorianCalendar();
		boolean dt=false;
		if (this.date!=null)
			dt=date.compareTo(now)<=0;//A data de ativação da norma já passou.
		switch (this.operator) {
			case EQUAL_TO:{
				return firstProperty.getValue().compareTo((secondProperty.getValue()))==0 || dt;
			}case GREATER_OR_EQUAL_TO:{
				return firstProperty.getValue().compareTo((secondProperty.getValue()))>=0 || dt;
			}case GREATER_THAN:{
				return firstProperty.getValue().compareTo((secondProperty.getValue()))>0 || dt;
			}case LESS_OR_EQUAL_TO:{
				return firstProperty.getValue().compareTo((secondProperty.getValue()))<=0 || dt;
			}case LESS_THAN:{
				return firstProperty.getValue().compareTo((secondProperty.getValue()))<0 || dt;
			}default:
				return  dt;
		}
	}
	
}