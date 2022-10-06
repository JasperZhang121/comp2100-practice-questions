import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ParcelTest {

	private ExpressCompany companyA;
	private ExpressCompany companyB;

	@Before
	public void init() {
		this.companyA = new CompanyA(new Point(5, 15), 5,
				Arrays.asList(ItemType.GUNS, ItemType.FIREWORKS, ItemType.ALCOHOL, ItemType.PERFUME));
		this.companyB = new CompanyB(new Point(20, 0), 6,
				Arrays.asList(ItemType.GUNS, ItemType.FIREWORKS, ItemType.ALCOHOL, ItemType.KNIFES));
	}

	@Test(timeout = 1000)
	public void testBestQuote1() throws IllegalParcelItemException {
		Parcel parcel = new Parcel(Arrays.asList(ItemType.BOOKS, ItemType.CLOTHES), 23, new Point(12, 12));

		assertEquals(new Quote(this.companyA, 39.1), QuoteCalculator.bestQuote(parcel, this.companyA, this.companyB));
	}
	
	@Test(timeout = 1000)
	public void testBestQuote2() throws IllegalParcelItemException {
		Parcel parcel = new Parcel(Arrays.asList(ItemType.BOOKS, ItemType.CLOTHES), 30, new Point(5, 14));

		assertEquals(new Quote(this.companyA, 43), QuoteCalculator.bestQuote(parcel, this.companyA, this.companyB));
	}
	
	@Test(timeout = 1000)
	public void testBestQuote3() throws IllegalParcelItemException {
		Parcel parcel = new Parcel(Arrays.asList(ItemType.BOOKS, ItemType.CLOTHES), 47, new Point(21, 1));

		assertEquals(new Quote(this.companyB, 75.7), QuoteCalculator.bestQuote(parcel, this.companyA, this.companyB));
	}
	
	@Test(timeout = 1000, expected = IllegalParcelItemException.class)
	public void testIllegalParcelItemException() throws IllegalParcelItemException {
		Parcel parcel = new Parcel(Arrays.asList(ItemType.GUNS), 100, new Point(12, 12));
		QuoteCalculator.bestQuote(parcel, this.companyA, this.companyB);
	}
}
