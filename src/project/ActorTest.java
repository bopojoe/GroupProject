package project;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ActorTest {

    private Actor actor1;
    private Actor actorInvalid;


    /**
     * Set up test fixtures
     * <p>
     * Called before every test method
     */

    @Before
    public void setUp() throws Exception {
        actor1 = new Actor("James Soap", 23, "gender2", "nationality2");
        actorInvalid = new Actor("Valid name is 30 chars to hereANYTHINGAFTERTHEREISTOOLONG", 2344, "banana", "nationality321");
    }

    /**
     * Teardown test fixtures
     * <p>
     * Called after each test method
     */

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test the contsructor
     */

    @Test
    public void testConstructor() {
        assertNotNull(actor1);
        assertEquals("Valid name is 30 chars to here", actorInvalid.getName());
        assertEquals(2344, actorInvalid.getAge());
        assertEquals("banana", actorInvalid.getGender());
        assertEquals("nationality321", actorInvalid.getNationality());
    }

    /**
     * Test all getters using valid data
     */

    @Test
    public void testGetters() {
        assertEquals("James Soap", actor1.getName());
        assertEquals(23, actor1.getAge());
        assertEquals("gender2", actor1.getGender());
        assertEquals("nationality2", actor1.getNationality());
    }

    /**
     * Test all setters
     */
    @Test
    public void testSetters() {
        actor1.setName("James Soap");
        assertEquals("James Soap", actor1.getName());
        actor1.setName("This name is far too long for");
        assertEquals("This name is far too long for", actor1.getName());

        assertEquals(23, actor1.getAge());
        actor1.setAge(432);
        assertEquals(432, actor1.getAge());

        assertEquals("gender2", actor1.getGender());
        actor1.setGender("invalidGender");
        assertEquals("invalidGender", actor1.getGender());

        assertEquals("nationality2", actor1.getNationality());
        actor1.setNationality("notThisNationality");
        assertEquals("notThisNationality", actor1.getNationality());
    }

    @Test
    public void testToString() {
        assertEquals(
                "Actor info:[name:" + "James Soap" +
                        ", " + "age:" + 23 + ", " + "gender: " +
                        "gender2" + ", " + "nationality: " +
                        "nationality2" + "] \n"
                ,
                actor1.toString());
    }


}