import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class ParcelTest {

	private Sender sender;
	private Recipient recipient;
	private PostOffice po;

	@Before
	public void init() {
		this.sender = new Sender();
		this.recipient = new Recipient();
		this.po = new PostOffice();
	}

	@Test
	public void test1() {

		Parcel parcel = sender.order(20, 1, recipient);
		assertEquals(Status.ORDERED, parcel.getStatus());

		po.registerParcel(parcel);
		assertEquals(Status.REGISTERED, parcel.getStatus());

		Transport transport = TransportOffice.getInstance().transportBy(parcel);
		assertEquals(Status.TRANSFERRING, parcel.getStatus());
		assertEquals(Transport.AIRPLANE, transport);

		recipient.receive(parcel);
		assertEquals(Status.DELIVERED, parcel.getStatus());
	}

	@Test
	public void test2() {

		Parcel parcel = sender.order(70, 4, recipient);
		assertEquals(Status.ORDERED, parcel.getStatus());

		po.registerParcel(parcel);
		assertEquals(Status.REGISTERED, parcel.getStatus());

		Transport transport = TransportOffice.getInstance().transportBy(parcel);
		assertEquals(Status.TRANSFERRING, parcel.getStatus());
		assertEquals(Transport.TRAIN, transport);

		recipient.receive(parcel);
		assertEquals(Status.DELIVERED, parcel.getStatus());
	}
	
	@Test
	public void test3() {
		
		Parcel parcel = sender.order(15, 8, recipient);
		assertEquals(Status.ORDERED, parcel.getStatus());

		po.registerParcel(parcel);
		assertEquals(Status.REGISTERED, parcel.getStatus());

		Transport transport = TransportOffice.getInstance().transportBy(parcel);
		assertEquals(Status.TRANSFERRING, parcel.getStatus());
		assertEquals(Transport.SHIP, transport);

		recipient.receive(parcel);
		assertEquals(Status.DELIVERED, parcel.getStatus());
	}
	
	@Test
	public void test4() {

		Parcel parcel = sender.order(15, 5, recipient);
		assertEquals(Status.ORDERED, parcel.getStatus());

		po.registerParcel(parcel);
		assertEquals(Status.REGISTERED, parcel.getStatus());

		Transport transport = TransportOffice.getInstance().transportBy(parcel);
		assertEquals(Status.TRANSFERRING, parcel.getStatus());
		assertEquals(Transport.TRAIN, transport);

		Recipient fake = new Recipient();
		fake.receive(parcel);
		assertEquals(Status.RETURNED, parcel.getStatus());
	}
	
	@Test
	public void test5() {

		Parcel parcel = sender.order(60, 1, recipient);
		assertEquals(Status.ORDERED, parcel.getStatus());

		po.registerParcel(parcel);
		assertEquals(Status.REGISTERED, parcel.getStatus());

		Transport transport = TransportOffice.getInstance().transportBy(parcel);
		assertEquals(Status.RETURNED, parcel.getStatus());
		assertNull(transport);
	}
	
	@Test
	public void test6() {
		assertSame(TransportOffice.getInstance(), TransportOffice.getInstance());
	}
}
