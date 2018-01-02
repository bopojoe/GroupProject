package project;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTest {

    private Movie movie1;
    private Movie movieInvalid;

    /**
     * Set up test fixtures
     * <p>
     * Called before every test method
     */

    @Before
    public void setUp() throws Exception {
        movie1 = new Movie("title1", 1001, 234, "plot1", "www.image.com");
        movieInvalid = new Movie("Title is invalid, Invalid Title", 2344, 234564, "plotinvalid", "ddwa.dadwa.image");
    }

    /**
     * Test the contsructor
     */

    @Test
    public void testConstructor() {
        assertNotNull(movie1);
        assertEquals("Title is invalid, Invalid Title", movieInvalid.getTitle());
        assertEquals(2344, movieInvalid.getYear());
        assertEquals(234564, movieInvalid.getRunningTime());
        assertEquals("plotinvalid", movieInvalid.getPlot());
        assertEquals("ddwa.dadwa.image", movieInvalid.getImgUrl());
    }

    /**
     * Test all getters using valid data
     */

    @Test
    public void testGetters() {
        assertEquals("title1", movie1.getTitle());
        assertEquals(1001, movie1.getYear());
        assertEquals(234, movie1.getRunningTime());
        assertEquals("plot1", movie1.getPlot());
        assertEquals("www.image.com", movie1.getImgUrl());
    }

    /**
     * Test all setters
     */
    @Test
    public void testSetters() {
        movie1.setTitle("title1");
        assertEquals("title1", movie1.getTitle());
        movie1.setTitle("this is a bad title");
        assertEquals("this is a bad title", movie1.getTitle());

        assertEquals(1001, movie1.getYear());
        movie1.setYear(2454);
        assertEquals(2454, movie1.getYear());

        assertEquals(234, movie1.getRunningTime());
        movie1.setRunningTime(4245);
        assertEquals(4245, movie1.getRunningTime());

        assertEquals("plot1", movie1.getPlot());
        movie1.setPlot("plot32144");
        assertEquals("plot32144", movie1.getPlot());

        assertEquals("www.image.com", movie1.getImgUrl());
        movie1.setImgUrl("dsjahio.oijd.sdoih");
        assertEquals("dsjahio.oijd.sdoih", movie1.getImgUrl());
    }

    @Test
    public void testToString() {
        assertEquals(
                "Movie info: [name:" + "title1" +
                        ", " + "Year:" + 1001 +
                        ", " + "Film Length: " + 234 +
                        ", " + "Plot: " + "plot1" +
                        ", " + "Film Img Url: " + "www.image.com" + "] \n"
                ,
                movie1.toString());
    }

}