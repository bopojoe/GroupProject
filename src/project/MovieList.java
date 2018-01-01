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


public class MovieList implements Iterable<Movie>{
private int index;

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

    protected static LinkedList<Movie> movielist = new LinkedList<>();

    @Override
    public Iterator<Movie> iterator() {
        return movielist.iterator();
    }

    public MovieList() {



    }


/*
    public void add()
    {
       // LinkedList<Movie> innerList = hashlist.header.data;
}
*/


    public static void addMovie(String title, int year, int runningTime, String plot, String imgUrl) {
        // make a movie object of the inputs
        Movie newMovie = new Movie(title, year, runningTime, plot, imgUrl);

        String title1 = title.toLowerCase();
        int rtHash = runningTime % runtimeHashlist.length;
        int yearHash  = year % yearHashlist.length;
        int titleHash  = Math.abs(title1.hashCode()) % titleHashlist.length;

        LinkedList<Movie> yearHashedList = yearHashlist[yearHash];
        LinkedList<Movie> rtHashedList = runtimeHashlist[rtHash];
        LinkedList<Movie> titleHashedList = titleHashlist[titleHash];

        yearHashedList.add(newMovie);
        titleHashedList.add(newMovie);
        rtHashedList.add(newMovie);

        System.out.println("You've just added: " + newMovie.toString());
    }




//code to remove movies
    public static void removeMovie(Movie movie){
        //getting the attributes for hashing
        int runtime = movie.getRunningTime();
        int year = movie.getYear();
        String title = movie.getTitle();
        String title1 = title.toLowerCase();

        System.out.println(title);
        System.out.println(title1);
        System.out.println(runtimeHashlist.length);
        IODriver.test(runtimeHashlist);

        //hash each attribute
        int rtHash = runtime % runtimeHashlist.length;
        int yearHash = year %yearHashlist.length;
        int titleHash =Math.abs(title1.hashCode())%titleHashlist.length;

        System.out.println(titleHash);
        //find the location of the movie
        LinkedList<Movie> runList = runtimeHashlist[rtHash];
        LinkedList<Movie> yearList = yearHashlist[yearHash];
        LinkedList<Movie> titleList = titleHashlist[titleHash];
        //remove the movie from each list
        IODriver.test(titleHashlist);
        runList.remove(movie);
        yearList.remove(movie);
        titleList.remove(movie);
        }


    public static void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out;
        out = xstream.createObjectOutputStream(new FileWriter("runtime.xml"));
        out.writeObject(runtimeHashlist);
        out.close();
        out = xstream.createObjectOutputStream(new FileWriter("title.xml"));
        out.writeObject(titleHashlist);
        out.close();
        out = xstream.createObjectOutputStream(new FileWriter("year.xml"));
        out.writeObject(yearHashlist);
        out.close();
    }

    public static void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is;
        is = xstream.createObjectInputStream(new FileReader("runtime.xml"));
        runtimeHashlist =(LinkedList<Movie>[]) is.readObject();

        is = xstream.createObjectInputStream(new FileReader("title.xml"));
        titleHashlist =(LinkedList<Movie>[]) is.readObject();

        is = xstream.createObjectInputStream(new FileReader("year.xml"));
        yearHashlist =(LinkedList<Movie>[]) is.readObject();
        is.close();
    }
    }


































