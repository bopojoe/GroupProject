package project;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

/**
 * @author James O'Rourke_20074556 on 25/11/2017
 */


public class MovieList {


    protected static LinkedList<Movie> runtimeHashlist[];

    static {
        runtimeHashlist = new LinkedList[50];
    }

    protected static LinkedList<Movie> yearHashlist[];

    static {
        yearHashlist = new LinkedList[50];
    }

    protected static LinkedList<Movie> titleHashlist[];

    static {
        titleHashlist = new LinkedList[50];
    }


    public MovieList() {


    }


    //code to add movies
    public static void addMovie(String title, int year, int runningTime, String plot, String imgUrl) {
        // make a movie object of the inputs
        Movie newMovie = new Movie(title, year, runningTime, plot, imgUrl);
        //change the title to lower case
        String title1 = title.toLowerCase();
        //create the hash index for each list
        int rtHash = runningTime % runtimeHashlist.length;
        int yearHash = year % yearHashlist.length;
        int titleHash = Math.abs(title1.hashCode()) % titleHashlist.length;
        //get the location of the linked list
        LinkedList<Movie> yearHashedList = yearHashlist[yearHash];
        LinkedList<Movie> rtHashedList = runtimeHashlist[rtHash];
        LinkedList<Movie> titleHashedList = titleHashlist[titleHash];
        //add the movie to the linked list at the hashed location
        yearHashedList.add(newMovie);
        titleHashedList.add(newMovie);
        rtHashedList.add(newMovie);

        System.out.println("You've just added: " + newMovie.toString());
    }


    //code to remove movies
    public static void removeMovie(Movie movie) {
        //getting the attributes for hashing
        int runtime = movie.getRunningTime();
        int year = movie.getYear();
        String title = movie.getTitle();
        String title1 = title.toLowerCase();


        //hash each attribute
        int rtHash = runtime % runtimeHashlist.length;
        int yearHash = year % yearHashlist.length;
        int titleHash = Math.abs(title1.hashCode()) % titleHashlist.length;


        //find the location of the movie
        LinkedList<Movie> runList = runtimeHashlist[rtHash];
        LinkedList<Movie> yearList = yearHashlist[yearHash];
        LinkedList<Movie> titleList = titleHashlist[titleHash];
        //remove the movie from each list
        runList.remove(movie);
        yearList.remove(movie);
        titleList.remove(movie);
    }


    public static void save() throws Exception {
        //create the stream
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out;
        //create the xml file
        out = xstream.createObjectOutputStream(new FileWriter("runtime.xml"));
        //write the object to the xml file
        out.writeObject(runtimeHashlist);
        out.close();
        //create the xml file
        out = xstream.createObjectOutputStream(new FileWriter("title.xml"));
        //write the object to the xml file
        out.writeObject(titleHashlist);
        out.close();
        //create the xml file
        out = xstream.createObjectOutputStream(new FileWriter("year.xml"));
        //write the object to the xml file
        out.writeObject(yearHashlist);
        out.close();
    }

    public static void load() throws Exception {
        //create the stream
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is;
        //find the xml file
        is = xstream.createObjectInputStream(new FileReader("runtime.xml"));
        //write the xml file to the object
        runtimeHashlist = (LinkedList<Movie>[]) is.readObject();
        //find the xml file
        is = xstream.createObjectInputStream(new FileReader("title.xml"));
        //write the xml file to the object
        titleHashlist = (LinkedList<Movie>[]) is.readObject();
        //find the xml file
        is = xstream.createObjectInputStream(new FileReader("year.xml"));
        //write the xml file to the object
        yearHashlist = (LinkedList<Movie>[]) is.readObject();
        is.close();
    }
}


































