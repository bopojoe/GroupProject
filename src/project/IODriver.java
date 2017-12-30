package project;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Scanner;

/**
 * @author James O'Rourke_20074556 on 26/11/2017
 */


public class IODriver {
    MovieList test;
    ActorList testA;
    private Scanner input;

    public IODriver() {
        input = new Scanner(System.in);
        test = new MovieList();
        testA = new ActorList();
        fillArray(49);
        setupAdditions(30);

        //homeMenu();


    }





    private void homeMenu() {
        String option = home();
        while (!option.equals("e")) {

            switch (option) {
                case "a":
                    addMenu();
                    break;
                case "s":
                    searchMenu();
                    break;
                case "q":
                    fillArray(49);
                    setupAdditions(30);
                    break;
                case "t":
                    //  completeRlist.show();
                    break;

                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

            // pause the program so that the user can read what we just printed
            // to the terminal window
            System.out.println("\nPress Return to continue...");
            input.nextLine();
            input.nextLine();

            option = home();
        }
        exitApp();

    }
    private String home() {
        System.out.println("");
        System.out.println("__________________");
        System.out.println("¦   Add(a)       ¦");
        System.out.println("¦   Search(s)    ¦");
        System.out.println("¦   initilize(q)    ¦");
        System.out.println("__________________");
        System.out.println("     ---------     ");
        System.out.println("   e) Exit");
        System.out.print("==>> ");
        String option = input.next();
        option = option.toLowerCase();
        return option;
    }

    private void exitApp() {

        System.out.println("Exiting App");
        System.exit(0);
    }
    private String add() {
        System.out.println("Addition Menu");
        System.out.println("What do you want to add?");
        System.out.println("___________________");
        System.out.println("¦  Movie(m)          ¦");
        System.out.println("¦  print listm(l)    ¦");
        System.out.println("¦  print listh(h)    ¦");
        System.out.println("¦  show array(b)     ¦");
        System.out.println("¦  Go Back(g)        ¦");
        System.out.println("____________________");
        System.out.println("     ---------     ");
        System.out.println("   e) Exit");
        System.out.print("==>> ");
        String option = input.next();
        option = option.toLowerCase();
        return option;
    }

    private void addMenu() {
        String option = add();
        while (!option.equals("e")) {

            switch (option) {
                case "m":
                   addMovie();
                   break;
                case "a":
                   addActor();
                   break;
                case "l":
                   runt();
                   break;
                case "h":
                   listh();
                   break;
                case "b":
                   showArray(50);
                   break;
                case "g":
                   homeMenu();
                   break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

            // pause the program so that the user can read what was just printed
            // to the terminal window
            System.out.println("\nPress Return to continue...");
            input.nextLine();
            input.nextLine();

            option = add();
        }
        exitApp();

    }
    private void  showArray(int amount){

        for (int i = 1; i!= amount; i++)
             System.out.println(MovieList.runtimeHashlist[i]);


    }

    protected void fillArray(int amount){

        for (int i = 0; i <= amount; i++) {
            MovieList.runtimeHashlist[i] = new LinkedList<>();
            MovieList.yearHashlist[i] = new LinkedList<>();
            MovieList.titleHashlist[i] = new LinkedList<>();
            ActorList.hashlist[i] = new LinkedList<>();
        }

    }

    private void addMovie() {
        input.nextLine();
            System.out.print("what is the title of the movie?");
            String title = input.nextLine();
            System.out.print("Year of Release: ");
            int year = input.nextInt();
            System.out.print("Please enter length of movie: ");
            int runningTime = input.nextInt();
            System.out.print("plot of movie: ");
            String plot = input.nextLine();
            plot = input.nextLine();
            System.out.print("Url of movie img: ");
            String imgUrl = input.nextLine();

            MovieList.addMovie(title, year,runningTime,plot,imgUrl);
    }

    private String search() {
        System.out.println("Search Menu");
        System.out.println("What do you want to Search?");
        System.out.println("___________________");
        System.out.println("¦  Movie(m)          ¦");
        System.out.println("¦  Go Back(g)        ¦");
        System.out.println("____________________");
        System.out.println("     ---------     ");
        System.out.println("   e) Exit");
        System.out.print("==>> ");
        String option = input.next();
        option = option.toLowerCase();
        return option;
    }

    private void searchMenu() {
        String option = search();
        while (!option.equals("e")) {

            switch (option) {
                case "m":
                    runt();
                    break;
                case "g":
                    homeMenu();
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

            // pause the program so that the user can read what was just printed
            // to the terminal window
            System.out.println("\nPress Return to continue...");
            input.nextLine();
            input.nextLine();

            option = search();
        }
        exitApp();

    }


    private void addActor(){
        input.nextLine();
        System.out.print("what is the Actors name?");
        String name = input.nextLine();
        System.out.print("Age of actor: ");
       // int age = input.nextInt();
        System.out.print("Actors gender: ");
        String gender = input.nextLine();
        gender = input.nextLine();
        System.out.print("Url of movie img: ");
        String nationality = input.nextLine();
       // ActorList.addActor(name,age,gender,nationality);

    }






    public void listh(){
        System.out.println(MovieList.runtimeHashlist.length);
        }



        public void runt(){
            System.out.print("enter a runtime to hash: ");
            int hash= input.nextInt();
            listm(hash);

        }
    public static Movie listm(int runtime ){
        int hash = runtime%MovieList.runtimeHashlist.length;
        LinkedList<Movie> location = MovieList.runtimeHashlist[hash];
        LinkedList.DataLink head = location.header;


        while(head.nextDataLink!=null){
            Movie test = (Movie)head.nextDataLink.data;
            if(test.getRunningTime() == runtime)
                return test;
            //System.out.println(head.nextDataLink.data.toString());
            head = head.nextDataLink;
        }
        return null;


    }

    public static void yearSearch(int year ){
        int hash = year%MovieList.yearHashlist.length;
        LinkedList<Movie> location = MovieList.yearHashlist[hash];
        LinkedList.DataLink head = location.header;


        while(head.nextDataLink!=null){
            System.out.println(head.nextDataLink.data.toString());
            head = head.nextDataLink;
        }


    }

    public static void titleSearch(String title){
        int hash = Math.abs(title.hashCode()) %MovieList.titleHashlist.length;
        LinkedList<Movie> location = MovieList.titleHashlist[hash];
        LinkedList.DataLink head = location.header;


        while(head.nextDataLink!=null){
            System.out.println(head.nextDataLink.data.toString());
            head = head.nextDataLink;
        }


    }


    /**
     * messy system to add loads of test stuff
     *
     */
   /* private void addMoviehelper(String title, int year,int runningTime,String plot,String imgUrl){
        LinkedList<Movie> listAtIndex = MovieList.hashlist[runningTime];

        listAtIndex.add(new Movie(title, year,runningTime,plot,imgUrl));

        LinkedList<Movie> hashedList = MovieList.hashlist[hash];
        hashedList.add(newMovie);


    }
*/
    protected void setupAdditions(int amount){


        for (int i = 1; i!= amount; i++){
            int runTime = ((i * i) + 90);
            MovieList.addMovie("title " + i, i + 1000, runTime, "Plot " + i, "imgUrl " + i);
            ActorList.addActor("name" + i, i + 10, "gender" + i, "nationality" + i);


        }

    }



}


