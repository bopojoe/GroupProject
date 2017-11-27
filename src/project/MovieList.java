package project;

import java.util.Iterator;

/**
 * @author James O'Rourke_20074556 on 25/11/2017
 */


public class MovieList implements Iterable<Movie> {
private int index;

    protected static LinkedList<Movie> hashlist[];

    static {
        hashlist = new LinkedList[50];
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
        int index = runningTime;
        int hash = index % hashlist.length;
        LinkedList<Movie> hashedList = hashlist[hash];
        hashedList.add(newMovie);
        System.out.println("You've just added:" + newMovie.toString() + "at Location: " + hash);
    }
    //Kevin Power 20075681
    public void removeMovie(Movie toRemoveMovie){
        LinkedList<Movie> internalList = hashlist[toRemoveMovie.hashCode()];
        if (internalList != null){
            internalList.remove(toRemoveMovie);
        }
    }


protected void setup(int howMany){

        for(int i =0;i!=howMany;i++){
            hashlist.add(new LinkedList<>());
        }

    }


}
























