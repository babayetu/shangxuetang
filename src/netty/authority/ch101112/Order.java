package netty.authority.ch101112;

public class Order {
	private long orderNumber;
	private CustomerInfo customer;
	
	private BillingAddress billTo;
	private ShippingAddress shipTo;

	public long getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}
	public CustomerInfo getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}
	public BillingAddress getBillTo() {
		return billTo;
	}
	public void setBillTo(BillingAddress billTo) {
		this.billTo = billTo;
	}
	public ShippingAddress getShipTo() {
		return shipTo;
	}
	public void setShipTo(ShippingAddress shipTo) {
		this.shipTo = shipTo;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Order{" +
				"orderNumber=" + orderNumber +
				", customer=" + customer +
				", billTo=" + billTo +
				", shipTo=" + shipTo +
				'}';
	}
}
