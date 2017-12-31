package project;


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




    //Kevin Power 20075681
    public void removeMovie(Movie toRemoveMovie){
        LinkedList<Movie> internalList = runtimeHashlist[toRemoveMovie.hashCode()];
        if (internalList != null){
            internalList.remove(toRemoveMovie);
        }
    }

}
































