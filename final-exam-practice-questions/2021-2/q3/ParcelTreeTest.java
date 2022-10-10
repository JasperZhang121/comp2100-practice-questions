import org.junit.Before;
import parcel.CartesianCoordinate;
import parcel.Parcel;
import org.junit.Test;
import parcel.Recipient;
import static org.junit.Assert.*;
import parcel.Sender;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ParcelTreeTest {
    CartesianCoordinate warehouseLocation;
    BinarySearchTree<Parcel> parcelTree;
    Sender sender1, sender2, sender3, sender4;
    Recipient recipient1, recipient2, recipient3, recipient4;
    Parcel parcel1, parcel2, parcel3, parcel4, parcel5, parcel6, parcel7, parcel8, parcel9, parcel10;

    private static Recipient getRecipient(double x, double y) {
        return new Recipient(new CartesianCoordinate(x,y));
    }

    private static Sender getSender(double x, double y) {
        return new Sender(new CartesianCoordinate(x,y));
    }


    @Before
    public void initTestVariables() {
        sender1 = new Sender(new CartesianCoordinate(-30,-50));
        sender2 = new Sender(new CartesianCoordinate(-300,-400));
        sender3 = new Sender(new CartesianCoordinate(12,5));
        sender4 = new Sender(new CartesianCoordinate(12,-5));
        recipient1 = new Recipient(new CartesianCoordinate(30,40));
        recipient2 = new Recipient(new CartesianCoordinate(300,400));
        recipient3 = new Recipient(new CartesianCoordinate(-120,-50));
        recipient4 = new Recipient(new CartesianCoordinate(120,50));
        parcel1 = new Parcel(1,23,2,sender1,recipient1);
        parcel2 = new Parcel(2,21,32,sender2,recipient2);
        parcel3 = new Parcel(3,23,34,sender3,recipient3);
        parcel4 = new Parcel(4,23,2,sender4,recipient4);
        parcel5 = new Parcel(5,23,5,getSender(10,30),
                getRecipient(-28,23));
        parcel6 = new Parcel(6,25,8,getSender(150,200),
                getRecipient(-20,-40));
        parcel7 = new Parcel(7,2,3,getSender(200,-20),
                getRecipient(290,-80));
        parcel8 = new Parcel(8,43,9,getSender(10,-5),
                getRecipient(-90,22));
        parcel9 = new Parcel(9,3,4,getSender(100,-50),
                getRecipient(140,-30));
        parcel10 = new Parcel(10,23,6,getSender(-400,200),
                getRecipient(-232,234));
        parcelTree = new ParcelBST(parcel1);
        parcelTree = parcelTree.insert(parcel2);
        parcelTree = parcelTree.insert(parcel3);
        parcelTree = parcelTree.insert(parcel4);
        warehouseLocation = new CartesianCoordinate(20,10);
    }

    // Start of tests for Task 1
    @Test
    public void parcelOrderTest1(){
        Parcel parcel1Copy = new Parcel(parcel1);
        assertEquals("Comparing equivalent parcels should return 0",0,parcel1.compareTo(parcel1Copy));
    }

    @Test
    public void parcelOrderTest2() {
        Parcel parcel1GreaterTravelDistance = new Parcel(parcel1);
        CartesianCoordinate furtherAwayThanSender1 =
                new CartesianCoordinate(2*parcel1.getSender().getLocation().getX()-warehouseLocation.getX(),
                2*parcel1.getSender().getLocation().getY()-warehouseLocation.getY());
        parcel1GreaterTravelDistance.getSender().setLocation(furtherAwayThanSender1);
        CartesianCoordinate furtherAwayThanRecipient1 =
                new CartesianCoordinate(2*parcel1.getRecipient().getLocation().getX()-warehouseLocation.getX(),
                2*parcel1.getRecipient().getLocation().getY()-warehouseLocation.getY());
        parcel1GreaterTravelDistance.getRecipient().setLocation(furtherAwayThanRecipient1);
        assertTrue("Comparing a parcel with another parcel that has greater travel distances should return negative",
                parcel1.compareTo(parcel1GreaterTravelDistance) < 0);
    }

    @Test
    public void parcelOrderTest3() {
        Parcel parcel1LesserTravelDistance = new Parcel(parcel1);
        CartesianCoordinate closerThanSender1 =
                new CartesianCoordinate((parcel1.getSender().getLocation().getX()+warehouseLocation.getX())/2,
                (parcel1.getSender().getLocation().getY()+warehouseLocation.getY())/2);
        parcel1LesserTravelDistance.getSender().setLocation(closerThanSender1);
        CartesianCoordinate closerThanRecipient1 =
                new CartesianCoordinate((parcel1.getRecipient().getLocation().getX()+warehouseLocation.getX())/2,
                (parcel1.getRecipient().getLocation().getY()+warehouseLocation.getY())/2);
        parcel1LesserTravelDistance.getRecipient().setLocation(closerThanRecipient1);
        assertTrue("Comparing a parcel with another parcel that has lesser travel distances should return positive",
                parcel1.compareTo(parcel1LesserTravelDistance) > 0);
    }

    @Test
    public void parcelOrderTest4() {
        Parcel parcel1GreaterTravelDistance = new Parcel(parcel1);
        CartesianCoordinate slightlyFurtherAwayThanSender1 =
                new CartesianCoordinate(1.0001*parcel1.getSender().getLocation().getX()-0.0001*warehouseLocation.getX(),
                1.0001*parcel1.getSender().getLocation().getY()-0.0001*warehouseLocation.getY());
        parcel1GreaterTravelDistance.getSender().setLocation(slightlyFurtherAwayThanSender1);
        CartesianCoordinate slightlyFurtherAwayThanRecipient1 =
                new CartesianCoordinate(1.0001*parcel1.getRecipient().getLocation().getX()-0.0001*warehouseLocation.getX(),
                1.0001*parcel1.getRecipient().getLocation().getY()-0.0001*warehouseLocation.getY());
        parcel1GreaterTravelDistance.getRecipient().setLocation(slightlyFurtherAwayThanRecipient1);
        assertTrue("Comparing a parcel with another parcel that has greater travel distances should return negative" +
                        " (even if the difference is small)", parcel1.compareTo(parcel1GreaterTravelDistance) < 0);
    }

    @Test
    public void parcelOderTest5() {
        assertTrue("The distance from the warehouse to the recipient of parcel 1 should be less than the distance " +
                "from the warehouse to the recipient of parcel 8",parcel1.compareTo(parcel8) < 0);
        assertTrue("The distance from the warehouse to the recipient of parcel 1 should be less than the distance " +
                "from the warehouse to the recipient of parcel 6", parcel1.compareTo(parcel6) < 0);
        assertTrue("The distance from the warehouse to the recipient of parcel 5 should be less than the distance " +
                "from the warehouse to the recipient of parcel 6", parcel6.compareTo(parcel5) > 0);
    }

    @Test
    public void parcelOrderTest6() {
        List<Parcel> unsortedParcels =
                Arrays.asList(parcel5,parcel2,parcel7,parcel4,parcel10,parcel9,parcel1,parcel3,parcel6,parcel8);
        unsortedParcels.sort(null);
        List<Parcel> expectedSortedParcels =
                Arrays.asList(parcel1,parcel5,parcel6,parcel4,parcel8,parcel9,parcel3,parcel7,parcel10,parcel2);
        assertEquals("Implemented ordering incorrect",expectedSortedParcels,unsortedParcels);
    }

    @Test
    public void parcelOrderTest7() {
        List<Parcel> toAddToTree =
                Arrays.asList(parcel1,parcel2,parcel3,parcel4,parcel5,parcel6,parcel7,parcel8,parcel9,parcel10);
        ParcelBST parcelTree = new ParcelBST(BinarySearchTree.listToTree(toAddToTree));
        assertEquals("Minimum value in tree not correct, Hence implemented Parcel ordering is not correct",parcel1,parcelTree.min());
        assertEquals("Maximum value in tree not correct, Hence implemented Parcel ordering is not correct",parcel2,parcelTree.max());
    }
    // End of tests for Task 1

    private String condenseParcelListToString(List<Parcel> parcelList) {
        StringBuilder buildString = new StringBuilder();
        buildString.append("[");
        String prefix = "";
        for (Parcel parcel : parcelList) {
            buildString.append(prefix).append(parcel.getId());
            prefix =",";
        }
        buildString.append("]");
        return buildString.toString();
    }

    private void iteratorTestHelper(List<Parcel> toConvertToTree, List<Parcel> expectedIterationOrder) {
        assert toConvertToTree.size() == expectedIterationOrder.size();
        // artificiallyConstructed ParcelBST below is for testing Task 2 ONLY
        // and therefore tree structure may not be consistent with Parcel.compareTo()
        ParcelBST artificiallyConstructed = new ParcelBST((BinarySearchTree<Parcel>) BinarySearchTree.listToTreeDirectInOrder(toConvertToTree));
        System.out.println("\n\n\nTree to pre-order iterate:\n\n" + artificiallyConstructed.display());
        Iterator<Parcel> iterator = artificiallyConstructed.iterator();
        int index = 0;
        for (Parcel currentExpected : expectedIterationOrder) {
            assertTrue("hasNext() should return true when there are Parcels still remaining in iteration",iterator.hasNext());
            assertEquals("Incorrect order for pre-order walk. Discrepancy at index " + index
                    + "  (index starts at zero). \nExpected Parcel (id) order: " +
                    condenseParcelListToString(expectedIterationOrder),currentExpected,iterator.next());
            index++;
        }
        assertFalse("hasNext() should return false when no Parcels are remaining in iteration",iterator.hasNext());
    }
    // Start of tests for Task 2
    @Test
    public void iteratorTest1() {
        List<Parcel> toConvertToTree =  Arrays.asList(parcel1,parcel2,parcel3,parcel4);
        List<Parcel> expectedIterationOrder =  Arrays.asList(parcel3,parcel2,parcel1,parcel4);
        iteratorTestHelper(toConvertToTree,expectedIterationOrder);
    }

    @Test
    public void iteratorTest2() {
        List<Parcel> toConvertToTree =  Arrays.asList(parcel4,parcel1,parcel3,parcel2);
        List<Parcel> expectedIterationOrder =  Arrays.asList(parcel3,parcel1,parcel4,parcel2);
        iteratorTestHelper(toConvertToTree,expectedIterationOrder);
    }

    @Test
    public void iteratorTest3() {
        List<Parcel> toConvertToTree =
                Arrays.asList(parcel5,parcel2,parcel7,parcel4,parcel10,parcel9,parcel1,parcel3,parcel6,parcel8);
        List<Parcel> expectedIterationOrder =
                Arrays.asList(parcel9,parcel7,parcel2,parcel5,parcel10,parcel4,parcel6,parcel3,parcel1,parcel8);
        iteratorTestHelper(toConvertToTree,expectedIterationOrder);
    }

    @Test
    public void iteratorTest4() {
        List<Parcel> toConvertToTree =
                Arrays.asList(parcel5,parcel7,parcel2,parcel9,parcel10,parcel4,parcel6,parcel3,parcel8,parcel1);
        List<Parcel> expectedIterationOrder =
                Arrays.asList(parcel4,parcel2,parcel7,parcel5,parcel10,parcel9,parcel8,parcel3,parcel6,parcel1);
        iteratorTestHelper(toConvertToTree,expectedIterationOrder);
    }
    // End of tests for Task 2
}
