package project;

import java.util.Scanner;

/**
 * @author James O'Rourke_20074556 on 26/11/2017
 */


public class IODriver {
    MovieList test;
    ActorList testA;
    private Scanner input;

    public IODriver() {
        //fillArray(49);
        input = new Scanner(System.in);
        test = new MovieList();
        testA = new ActorList();
        try {
            MovieList.load();
        } catch (Exception e) {
            System.out.println("Error loading Movie lists");
        }
        try {
            ActorList.load();
        } catch (Exception e) {
            System.out.println("Error loading Actor lists");
        }

        fillArray(49);
        setupAdditions(30);

        //homeMenu();


    }

    //input output driver before javafx
/*

    public static void test(LinkedList<Movie>[] list){
        int i = 0;

        while(i<=49) {
            System.out.println(list[i]);
            LinkedList<Movie> movielist = list[i];

            LinkedList.DataLink head = movielist.header;

            while (head.nextDataLink != null) {
                //Movie movie = (Movie) head.nextDataLink.data;
                System.out.println(head.nextDataLink.data.toString());
                head = head.nextDataLink;}
            i=i+1;
        }



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
        System.out.println("¦  print runtimeSearch(l)    ¦");
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


    private void addActor() {
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


    public void listh() {
        System.out.println(MovieList.runtimeHashlist.length);
    }


    public void runt() {
        System.out.print("enter a runtime to hash: ");
        int hash = input.nextInt();
        runtimeSearch(hash);

    }

*/

    //for first run to fill array with linked lists in case of no xml files
    protected void fillArray(int amount) {

        for (int i = 0; i <= amount; i++) {
            MovieList.runtimeHashlist[i] = new LinkedList<>();
            MovieList.yearHashlist[i] = new LinkedList<>();
            MovieList.titleHashlist[i] = new LinkedList<>();
            ActorList.nameHashlist[i] = new LinkedList<>();
            ActorList.ageHashlist[i] = new LinkedList<>();
            ActorList.genderHashlist[i] = new LinkedList<>();
            ActorList.natHashlist[i] = new LinkedList<>();
        }

    }

    //method for searching the runtime hashed list for movie requested
    public static LinkedList<Movie> runtimeSearch(int runtime) {
        //hashes the input
        int hash = runtime % MovieList.runtimeHashlist.length;
        //finds the location of the movie
        LinkedList<Movie> location = MovieList.runtimeHashlist[hash];
        //sets the head of the list to head of hashed location
        LinkedList.DataLink head = location.header;


        while (head.nextDataLink != null) {
            //runs until next data link is null and gets each movie
            Movie movie = (Movie) head.nextDataLink.data;

            //checks the runtime of the movie to inputted runtime
            if (movie.getRunningTime() == runtime) {
                //if it's the same it returns the movie
                return location;
            }


            //or moves to next link
            head = head.nextDataLink;
        }
        //returns null if the list does not match input
        return null;


    }

    //method for searching the year hashed list for movie requested
    public static LinkedList<Movie> yearSearch(int year) {
        //hashes the input
        int hash = year % MovieList.yearHashlist.length;
        //finds the location of the movie
        LinkedList<Movie> location = MovieList.yearHashlist[hash];
        //sets the head of the list to head of hashed location
        LinkedList.DataLink head = location.header;


        while (head.nextDataLink != null) {
            //runs until next data link is null and gets each movie
            Movie movie = (Movie) head.nextDataLink.data;
            //checks the year of the movie to inputted year
            if (movie.getYear() == year) {
                //if it's the same it returns the movie
                return location;
                //or moves to next link
            } else {
                head = head.nextDataLink;
            }
        }
        //returns null if the list does not match input
        return null;


    }

    //method for searching the title hashed list for movie requested
    public static LinkedList<Movie> titleSearch(String title) {
        //sets title to lower case
        String title1 = title.toLowerCase();
        //hashes lower cased title
        int hash = Math.abs(title1.hashCode()) % MovieList.titleHashlist.length;
        //finds the location of the linked list
        LinkedList<Movie> location = MovieList.titleHashlist[hash];
        //sets the head to the head of the linked list
        LinkedList.DataLink head = location.header;


        while (head.nextDataLink != null) {
            //runs until next data link is null and gets each movie
            Movie movie = (Movie) head.nextDataLink.data;
            //checks the title of the movie to inputted title
            if (movie.getTitle().toLowerCase().equals(title.toLowerCase())) {
                //if it's the same it returns the movie
                return location;
                //or moves to next link
            } else {
                head = head.nextDataLink;
            }
        }
        //returns null if the list does not match input
        return null;

    }


    //method for searching the name hashed list for actor requested
    public static LinkedList<Actor> nameSearch(String name) {
        //sets name to lower case
        String hname = name.toLowerCase();
        //hashes the lower cased name
        int hash = Math.abs(hname.hashCode()) % ActorList.nameHashlist.length;
        //finds the location of the linked list
        LinkedList<Actor> location = ActorList.nameHashlist[hash];
        //sets the head to the head of the linked list
        LinkedList.DataLink head = location.header;


        while (head.nextDataLink != null) {
            //runs until next data link is null and gets each Actor
            Actor actor = (Actor) head.nextDataLink.data;
            //checks the name of the actor to inputted name
            if (actor.getName().toLowerCase().equals(hname)) {
                //if it's the same it returns the actor
                return location;
                //or moves to next link
            } else {
                head = head.nextDataLink;
            }
        }
        //returns null if the list does not match input
        return null;


    }

    //method for searching the age hashed list for actor requested
    public static LinkedList<Actor> ageSearch(int age) {
        //hashes the age
        int hash = age % ActorList.ageHashlist.length;
        //finds the hashed location in the array
        LinkedList<Actor> location = ActorList.ageHashlist[hash];
        //makes head the head of the linked list
        LinkedList.DataLink head = location.header;


        while (head.nextDataLink != null) {
            //runs until next data link is null and gets each Actor
            Actor actor = (Actor) head.nextDataLink.data;
            //checks the age of the actor to inputted age
            if (actor.getAge() == age) {
                //if it's the same it returns the actor list
                return location;
            } else {
                //or it moves on in the list
                head = head.nextDataLink;
            }
        }
        //if none match it returns null
        return null;


    }

    //method for searching the gender hashed list for actor requested
    public static LinkedList<Actor> genderSearch(String gender) {
        //sets gender to lower case
        String hGender = gender.toLowerCase();
        //hashes the gender
        int hash = Math.abs(hGender.hashCode()) % ActorList.genderHashlist.length;
        //finds the location of the actor
        LinkedList<Actor> location = ActorList.genderHashlist[hash];
        //sets head to head of linked list
        LinkedList.DataLink head = location.header;


        while (head.nextDataLink != null) {
            //runs until next data link is null and gets each Actor
            Actor actor = (Actor) head.nextDataLink.data;
            //checks the age of the actor to inputted gender
            if (actor.getGender().toLowerCase().equals(hGender)) {
                //returns the location
                return location;
                //or moves on in the list
            } else {
                head = head.nextDataLink;
            }
        }
        // returns null if none match
        return null;


    }

    //method for searching the Nationality hashed list for actor requested
    public static LinkedList<Actor> natSearch(String nat) {
        //sets nat to lower case
        String hNat = nat.toLowerCase();
        //hashes the lower cased nat
        int hash = Math.abs(hNat.hashCode()) % ActorList.natHashlist.length;
        //finds the location that it should have been hashed to
        LinkedList<Actor> location = ActorList.natHashlist[hash];
        //sets head to head of the linked list
        LinkedList.DataLink head = location.header;


        while (head.nextDataLink != null) {
            //runs until next data link is null and gets each Actor
            Actor actor = (Actor) head.nextDataLink.data;
            //checks for a match
            if (actor.getNationality().toLowerCase().equals(hNat)) {
                //if it matches, return the location
                return location;
                //or else move on
            } else {
                head = head.nextDataLink;
            }
        }
        //if no match return null
        return null;


    }


    /**
     * messy system to add loads of generic stuff
     */

    protected void setupAdditions(int amount) {


        for (int i = 1; i != amount; i++) {
            int runTime = ((i * i) + 90);
            MovieList.addMovie("title " + i, i + 1000, runTime, "Plot " + i, "imgUrl " + i);
            ActorList.addActor("name" + i, i + 10, "gender" + i, "nationality" + i);


        }

    }


}


