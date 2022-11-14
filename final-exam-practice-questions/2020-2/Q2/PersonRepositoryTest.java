
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PersonRepositoryTest {

    SequenceGenerator sequenceGenerator;
    PersonRepository personRepository;

    @Before
    public void before() {
        sequenceGenerator = new SequenceGenerator();
        personRepository = new PersonRepository();
        personRepository.setSequenceGenerator(sequenceGenerator);
    }

    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########

    @Test(timeout = 1000, expected =RuntimeException.class)
    public void test_save1() throws RuntimeException{
        Person p1 = new Person("XYZ", 10, "XYZ", true, true);
        p1.setId(10);
        personRepository.save(p1);
    }
    @Test
    public void test_save2() {
        Person p1 = new Person("XYZ", 10, "XYZ", true, true);
        personRepository.save(p1);
        assertEquals(1,(int)p1.id);
    }
    @Test
    public void test_findById(){
        Person p1 = new Person("XYZ", 10, "XYZ", true, true);
        p1.setId(1);
        personRepository.personMap.put(1,p1);
        assertEquals(p1,personRepository.findById(1));
    }
    @Test
    public void test_setSequenceGenerator(){
        Person p1 = new Person("XYZ", 10, "XYZ", true, true);
        SequenceGenerator sequenceGenerator =new SequenceGenerator();
        personRepository.setSequenceGenerator(sequenceGenerator);
        assertEquals(sequenceGenerator,personRepository.sequenceGenerator);
    }

    // ########## YOUR CODE ENDS HERE ##########


}
