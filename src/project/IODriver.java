package project;

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

        homeMenu();


    }





    private void homeMenu() {
        String option = home();
        while (!option.equals("e")) {

            switch (option) {
                case "a":
                    addMenu();
                    break;
                case "s":
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
        System.out.println("¦  Fill MovieArray(f)¦");
        System.out.println("¦  Fill ActorArray(l)¦");
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
                case "f":
                   fillArray(49);
                   setupAdditions(30);
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
             System.out.println(MovieList.hashlist[i]);


    }

    private void fillArray(int amount){

        for (int i = 0; i <= amount; i++)
            MovieList.hashlist[i] = new LinkedList<>();
        for (int j = 0; j <= amount; j++)
            ActorList.hashlist[j] = new LinkedList<>();
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

    private void addActor(){
        input.nextLine();
        System.out.print("what is the title of the movie?");
        String name = input.nextLine();
        System.out.print("Year of Release: ");
        int age = input.nextInt();
        System.out.print("Please enter length of movie: ");
        String gender = input.nextLine();
        gender = input.nextLine();
        System.out.print("Url of movie img: ");
        String nationality = input.nextLine();
        //System.out.print("What is the genre: ");
        //LinkedList<> genre = input.nextLine();
    }






    public void listh(){
        System.out.println(MovieList.hashlist.length);
        }



        public void runt(){
            System.out.print("enter a runtime to hash: ");
            int hash= input.nextInt();
            listm(hash);

        }
    public void listm(int runtime){
        int hash = runtime%MovieList.hashlist.length;
        LinkedList<Movie> test = MovieList.hashlist[hash];
        LinkedList.DataLink head = test.header;


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
    private void setupAdditions(int amount){


        for (int i = 1; i!= amount; i++){
            int runTime = ((i * i) + 90);
            MovieList.addMovie("title " + i, i + 1000, runTime, "Plot " + i, "imgUrl " + i);
            ActorList.addActor("name" + i, i + 10, "gender" + i, "nationality" + i, new LinkedList());


        }

    }



}


