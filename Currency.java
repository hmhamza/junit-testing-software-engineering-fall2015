package Part2;

public class Currency {
	private String name;
	private Double rate;
	
	/**
	 * New Currency
	 * The rate argument of each currency indicates that Currency's "universal" exchange rate.
	 * Imagine that we define the rate of each currency in relation to some universal currency.
	 * This means that the rate of each currency defines its value compared to this universal currency.
	 *
	 * @param name The name of this Currency
	 * @param rate The exchange rate of this Currency
	 */
	Currency (String name, Double rate) {
		this.name = name;
		this.rate = rate;
	}

	/** Convert an amount of this Currency to its value in the general "universal currency"
	 * (As mentioned in the documentation of the Currency constructor)
	 * 
	 * @param amount An amount of cash of this currency.
	 * @return The value of amount in the "universal currency"
	 */
	public Integer universalValue(Integer amount) {
			Double val=amount*rate;
            return RoundOF(val);
		
	}

	public String getName() {
            return name;
		
	}
	
	public Double getRate() {
            return rate;
		
	}
	
	public void setRate(Double rate) {
		this.rate=rate;
	}
	
	/** Convert an amount from another Currency to an amount in this Currency
	 * 
	 * @param amount Amount of the other Currency
	 * @param othercurrency The other Currency
	*/
	public Integer valueInThisCurrency(Integer amount, Currency othercurrency) {
			Double amnt=amount*othercurrency.rate;
			Double ret=amnt/this.rate;
			
            return RoundOF(ret);
		
	}
	
	private Integer RoundOF(Double d) {
		d*=100.0;
		
		long l= Math.round(d);
		
		Integer ret=(int)l;
		return ret;
	}
}
