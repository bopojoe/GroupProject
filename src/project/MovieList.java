package project;

import java.util.Iterator;

/**
 * @author James O'Rourke_20074556 on 25/11/2017
 */


public class MovieList implements Iterable<Movie> {
private int index;

    protected static LinkedList<Movie> movieList = new LinkedList<>();

    @Override
    public Iterator<Movie> iterator() {
        return movieList.iterator();
    }

    public MovieList() {
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);
        movieList.add(null);

    }

    public void addMovie(String title, int year, int runningTime, String plot, String imgUrl){
    Movie newMovie = new Movie(title,year, runningTime, plot,imgUrl);
    movieList.addAtIndex(index,newMovie);
    System.out.println("You've just added:" + newMovie.toString());
    this.index ++;
}






























}
