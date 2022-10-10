/**
 * 
 * 
 * @author nanwang
 *
 */
public class Customer {
	
	public static final String KEY_ROOT = "Customers";
	public static final String KEY_ELEMENT = "Customer";
	
	//The following are column names and the XML element keys
	public static final String KEY_ID = "ID";
	public static final String KEY_NAME = "Name";
	public static final String KEY_ADDRESS = "Address";
	public static final String KEY_CITY = "City";
	public static final String KEY_POSTCODE = "Postcode";
	public static final String KEY_COUNTRY = "Country";
	
	public static final String TABLE_NAME = "Customers";

	private int id;

	private String name;

	private String address;

	private String city;

	private String postCode;

	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Customer() {
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param address
	 * @param city
	 * @param postCode
	 * @param country
	 */
	public Customer(int id, String name, String address, String city, String postCode, String country) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof Customer) {
			Customer c = (Customer) o;

			if (this.id != c.id) {
				return false;
			}

			if ((this.name != null && !this.name.equals(c.name)) || (this.name == null && c.name != null)) {
				return false;
			}

			if ((this.address != null && !this.address.equals(c.address))
					|| (this.address == null && c.address != null)) {
				return false;
			}

			if ((this.city != null && !this.city.equals(c.city)) || (this.city == null && c.city != null)) {
				return false;
			}

			if ((this.postCode != null && !this.postCode.equals(c.postCode))
					|| (this.postCode == null && c.postCode != null)) {
				return false;
			}

			if ((this.country != null && !this.country.equals(c.country))
					|| (this.country == null && c.country != null)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		return this.id + this.name == null ? ""
				: this.name + this.address == null ? ""
						: this.address + this.city == null ? ""
								: this.city + this.postCode == null ? ""
										: this.postCode + this.country == null ? "" : this.country;
	}
}
