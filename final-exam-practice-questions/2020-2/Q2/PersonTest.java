import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonTest {
     // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########
    //To test the `calcInsurancePrice()` method, which returns void, you can use the `getHealthInsurancePrice()` method, for example:
    //Person p = new Person("XYZ", 10, "XYZ", true, true);
    //assertEquals(0, p.getHealthInsurancePrice().intValue());

    Person p = new Person("XYZ", 10, "XYZ", true, true);

    // test all methods in person

    @Test
    public void test_getID(){
        assertEquals(p.id,p.getId());
    }
    @Test
    public void test_setID(){
        p.setId(10);
        assertEquals(10, (int) p.id);
    }
    @Test
    public void test_getName(){
        assertEquals(p.name,p.getName());
    }
    @Test
    public void test_getAge(){
        assertEquals(p.age,p.getAge());
    }

    @Test
    public void test_getOccupation(){
        assertEquals(p.occupation,p.getOccupation());
    }

    @Test
    public void test_getDiabetes(){
        assertEquals(p.diabetes,p.getDiabetes());
    }
    @Test
    public void test_getHeartDisease(){
        assertEquals(p.heartDisease,p.getHeartDisease());
    }
    @Test
    public void test_getHealthInsurancePrice(){
        assertEquals(p.healthInsurancePrice,p.getHealthInsurancePrice());
    }

    @Test
    public void test_calcInsurancePrice(){

        Person p1 = new Person("XYZ", 10, "XYZ", true, true);
        p1.calcInsurancePrice();
        assertEquals(350,(int)p1.healthInsurancePrice);

        Person p2 = new Person("XYZ", 10, "", true, true);
        p2.calcInsurancePrice();
        assertEquals(200,(int)p2.healthInsurancePrice);

        Person p3 = new Person("XYZ", 50, "", true, true);
        p3.calcInsurancePrice();
        assertEquals(1100,(int)p3.healthInsurancePrice);

        Person p4 = new Person("XYZ", 50, "", false, false);
        p4.calcInsurancePrice();
        assertEquals(360,(int)p4.healthInsurancePrice);

        Person p5 = new Person("XYZ", 50, "", false, true);
        p5.calcInsurancePrice();
        assertEquals(500,(int)p5.healthInsurancePrice);

        Person p6 = new Person("XYZ", 50, "", true, false);
        p6.calcInsurancePrice();
        assertEquals(400,(int)p6.healthInsurancePrice);

    }

    // ########## YOUR CODE ENDS HERE ##########

}
