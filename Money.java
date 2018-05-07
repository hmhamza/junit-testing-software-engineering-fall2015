package Part2;

public class Money implements Comparable {
	private int amount;
	private Currency currency;

	/**
	 * New Money
	 * @param amount	The amount of money
	 * @param currency	The currency of the money
	 */
	Money (Integer amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	
	public Integer getAmount() {
            return amount;
		
	}
	
	public Currency getCurrency() {
            return currency;
		
	}
	
	/**
	 * Returns the amount of the money in the string form "(amount) (currencyname)", e.g. "10.5 SEK".
	 * Recall that we represent decimal numbers with integers. This means that the "10.5 SEK" mentioned
	 * above is actually represented as the integer 1050
	 *  @return String representing the amount of Money.
	 */
	public String toString() {
		
		Double d=amount/100.0;
		d.toString();
		
		String str=d.toString();
		str+=" ";
		str+=currency.getName();
		return str;
		
	}
	
	/**
	 * Gets the universal value of the Money, according the rate of its Currency.
	 * @return The value of the Money in the "universal currency".
	 */
	public Integer universalValue() {
		Double d=amount/100.0;
		d*=currency.getRate();
		
		return RoundOF(d);
		
	}
	
	/**
	 * Check to see if the value of this money is equal to the value of another Money of some other Currency.
	 * @param other The other Money that is being compared to this Money.
	 * @return A Boolean indicating if the two monies are equal.
	 */
	public Boolean equals(Money other) {
		
		Double d1=amount/100.0;
		d1*=currency.getRate();
		
		Double d2=other.getAmount()/100.0;
		d2*=other.getCurrency().getRate();
		
		int a1=RoundOF(d1);
		int a2=RoundOF(d2);
		
		if(a1==a2)
            return true;
		else
			return false;
		
	}
	
	/**
	 * Adds a Money to this Money, regardless of the Currency of the other Money.
	 * @param other The Money that is being added to this Money.
	 * @return A new Money with the same Currency as this Money, representing the added value of the two.
	 * (Remember to convert the other Money before adding the amounts)
	 */
	public Money add(Money other) {
		
		Double d1=amount*currency.getRate();
		Double d2=other.getAmount()*other.getCurrency().getRate();
		d1+=d2;
		d1/=currency.getRate();
		
		long a=Math.round(d1);
		Integer i=(int)a;
		Money ret=new Money(i,this.currency);    
		return ret;
		
	}

	/**
	 * Subtracts a Money from this Money, regardless of the Currency of the other Money.
	 * @param other The money that is being subtracted from this Money.
	 * @return A new Money with the same Currency as this Money, representing the subtracted value.
	 * (Again, remember converting the value of the other Money to this Currency)
	 */
	public Money sub(Money other) {		
		
		Double d1=amount*currency.getRate();
		Double d2=other.getAmount()*other.getCurrency().getRate();
		d1-=d2;
		d1/=currency.getRate();
		
		long a=Math.round(d1);
		Integer i=(int)a;
		Money ret=new Money(i,this.currency);    
		return ret;
	
	}
	
	/**
	 * Check to see if the amount of this Money is zero or not
	 * @return True if the amount of this Money is equal to 0.0, False otherwise
	 */
	public Boolean isZero() {
           return amount==0;
		
	}
	/**
	 * Negate the amount of money, i.e. if the amount is 10.0 SEK the negation returns -10.0 SEK
	 * @return A new instance of the money class initialized with the new negated money amount.
	 */
	public Money negate() {
		
		int n=-1*amount ;
		
        Money ret=new Money(n,currency);    
		return ret;
		
	}
	
	/**
	 * Compare two Monies.
	 * compareTo is required because the class implements the Comparable interface.
	 * (Remember the universalValue method, and that Integers already implement Comparable).
	 * Also, since compareTo must take an Object, you will have to explicitly downcast it to a Money.
	 * @return 0 if the values of the monies are equal.
	 * A negative integer if this Money is less valuable than the other Money.
	 * A positive integer if this Money is more valuable than the other Money.
	 */
	public int compareTo(Object other) {
		Money m=(Money)other;
		
		Double d1=amount/100.0;
		d1*=currency.getRate();
		
		Double d2=m.getAmount()/100.0;
		d2*=m.getCurrency().getRate();
		
		Integer a1=RoundOF(d1);
		Integer a2=RoundOF(d2);
		
		if(a1.compareTo(a2)==0)
			return 0;
		else if(a1.compareTo(a2)>0)
			return 1;
		else
			return -1;
           
		
	}
	
	private Integer RoundOF(Double d) {
		d*=100.0;
		
		long l= Math.round(d);
		
		Integer ret=(int)l;
		return ret;
	}
}