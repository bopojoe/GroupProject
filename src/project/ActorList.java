package project;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

public class ActorList implements Iterable<Actor> {


    protected static LinkedList<Actor> nameHashlist[];

    static {
        nameHashlist = new LinkedList[50];
    }

    protected static LinkedList<Actor> ageHashlist[];

    static {
        ageHashlist = new LinkedList[50];
    }

    protected static LinkedList<Actor> genderHashlist[];

    static {
        genderHashlist = new LinkedList[50];
    }

    protected static LinkedList<Actor> natHashlist[];

    static {
        natHashlist = new LinkedList[50];
    }

    protected static LinkedList<Actor> actorlist = new LinkedList<>();

    @Override
    public Iterator<Actor> iterator() {
        return actorlist.iterator();
    }

    /**
     * add actor method,
     * makes actor object of inputs
     * hashes inputs
     */

    public static void addActor(String name, int age, String gender, String nationality) {
        Actor newActor = new Actor(name, age, gender, nationality);
        int hName = Math.abs(name.hashCode());
        int hAge = age;
        int hGender = Math.abs(gender.hashCode());
        int hNat = Math.abs(nationality.hashCode());
        addHashlists(nameHashlist, hName, newActor);
        addHashlists(ageHashlist, hAge, newActor);
        addHashlists(genderHashlist, hGender, newActor);
        addHashlists(natHashlist, hNat, newActor);
        System.out.println("You've just added:" + newActor.toString());
    }

    /**
     * helper method for add actor
     * adds the actor object to the list inputted
     * at the hash provided
     */
    private static void addHashlists(LinkedList<Actor> hList[], int hash, Actor newActor) {
        int index = hash % hList.length;
        LinkedList<Actor> hashedList = hList[index];
        hashedList.add(newActor);

    }

    public static void removeActor(Actor actor) {
        //separates the object into its attributes
        int age = actor.getAge();
        String name = actor.getName();
        String nat = actor.getNationality();
        String gender = actor.getGender();
        //hashes each attribtute
        int nameHash = Math.abs(name.hashCode()) % nameHashlist.length;
        int natHash = Math.abs(nat.hashCode()) % natHashlist.length;
        int genderHash = Math.abs(gender.hashCode()) % genderHashlist.length;
        int ageHash = age % ageHashlist.length;
        //gets location of the linked list
        LinkedList<Actor> nameList = nameHashlist[nameHash];
        LinkedList<Actor> natList = natHashlist[natHash];
        LinkedList<Actor> genderList = genderHashlist[genderHash];
        LinkedList<Actor> ageList = ageHashlist[ageHash];
        //searches the linked list for the actor to remove
        natList.remove(actor);
        nameList.remove(actor);
        genderList.remove(actor);
        ageList.remove(actor);
    }

    public static void save() throws Exception {
        //creates the stream object
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out;
        //makes the xml file
        out = xstream.createObjectOutputStream(new FileWriter("name.xml"));
        //writes the object to the xml file
        out.writeObject(nameHashlist);
        out.close();
        //makes the xml file
        out = xstream.createObjectOutputStream(new FileWriter("nat.xml"));
        //writes the object to the xml file
        out.writeObject(natHashlist);
        out.close();
        //makes the xml file
        out = xstream.createObjectOutputStream(new FileWriter("gender.xml"));
        //writes the object to the xml file
        out.writeObject(genderHashlist);
        out.close();
        //makes the xml file
        out = xstream.createObjectOutputStream(new FileWriter("age.xml"));
        //writes the object to the xml file
        out.writeObject(ageHashlist);
        out.close();
    }

    public static void load() throws Exception {
        //creates the input stream
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is;
        //finds the xml file
        is = xstream.createObjectInputStream(new FileReader("name.xml"));
        //writes the file to the object
        nameHashlist = (LinkedList<Actor>[]) is.readObject();
        is.close();
        //finds the xml file
        is = xstream.createObjectInputStream(new FileReader("nat.xml"));
        //writes the file to the object
        natHashlist = (LinkedList<Actor>[]) is.readObject();
        is.close();
        //finds the xml file
        is = xstream.createObjectInputStream(new FileReader("gender.xml"));
        //writes the file to the object
        genderHashlist = (LinkedList<Actor>[]) is.readObject();
        is.close();
        //finds the xml file
        is = xstream.createObjectInputStream(new FileReader("age.xml"));
        //writes the file to the object
        ageHashlist = (LinkedList<Actor>[]) is.readObject();
        is.close();
    }
}




