package com.demo.billing.enums;

public enum CustomerTypeEnum {

	Employee(30),
	Affiliate(10),
	Regular(5),
	General(0); 
	
	private final int discount;
	
	CustomerTypeEnum(int discount) {
		this.discount = discount;	
	}
	public int getDiscount() {
		return discount;
	}
	/*public abstract double discountedAmount(double amount);
	
	{
		@Override
		public
		double discountedAmount(double amount) {
			return amount;
		}
	};*/

	
	
	
}
