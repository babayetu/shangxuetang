package netty.authority.ch101112;

public class BillingAddress {
	private String nation;
	private String province;
	private String city;
	private String street;
	private String postCode;
	
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	@Override
	public String toString() {
		return "BillingAddress [nation=" + nation + ", province=" + province + ", city=" + city + ", street=" + street
				+ ", postCode=" + postCode + "]";
	}

	
}
