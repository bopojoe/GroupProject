package project;

/**
 * @author James O'Rourke_20074556 on 23/11/2017
 */


public class Movie {

private String title;
private int year;
private int runningTime; //minutes
private LinkedList genre;
private String plot;
private String imgUrl;
private LinkedList<Actor> actors;


    public Movie(String title, int year, int runningTime, LinkedList genre, String plot, String imgUrl) {
        this.title = title;
        this.year = year;
        this.runningTime = runningTime;
        this.genre = genre;
        this.plot = plot;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public LinkedList getGenre() {
        return genre;
    }

    public void setGenre(LinkedList genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
