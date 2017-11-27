package project;

import java.util.Iterator;

/**
 * @author James O'Rourke_20074556 on 21/11/2017
 */


public class MovieList implements Iterable<Movie> {
private int index;

    protected  static LinkedList<Movie> hashlist[];

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


   /* public void add()
    {
        LinkedList<Movie> innerList = hashlist.header.data;
}


    public void addMovie(String title, int year, int runningTime, String plot, String imgUrl){
    Movie newMovie = new Movie(title,year, runningTime, plot,imgUrl);
    int index = runningTime;
    movielist.addAtIndex(index,newMovie);
    System.out.println("You've just added:" + newMovie.toString());
    this.index ++;
}*/


/*protected void setup(int howMany){

        for(int i =0;i!=howMany;i++){
            hashlist.add(new LinkedList<>());
        }

    }*/

























}
