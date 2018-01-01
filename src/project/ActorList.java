package project;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

public class ActorList implements Iterable<Actor>{


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

    public static void addActor(String name, int age, String gender, String nationality){
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

    private static void addHashlists(LinkedList<Actor> hList[], int hash, Actor newActor){
        int index = hash % hList.length;
        LinkedList<Actor> hashedList = hList[index];
        hashedList.add(newActor);

    }

    public static void removeActor(Actor actor){
        int age = actor.getAge();
        String name = actor.getName();
        String nat = actor.getNationality();
        String gender = actor.getGender();
        int nameHash = Math.abs(name.hashCode())%nameHashlist.length;
        int natHash = Math.abs(nat.hashCode())%natHashlist.length;
        int genderHash =Math.abs(gender.hashCode())%genderHashlist.length;
        int ageHash = age % ageHashlist.length;
        LinkedList<Actor> nameList = nameHashlist[nameHash];
        LinkedList<Actor> natList = natHashlist[natHash];
        LinkedList<Actor> genderList = genderHashlist[genderHash];
        LinkedList<Actor> ageList = ageHashlist[ageHash];
        natList.remove(actor);
        nameList.remove(actor);
        genderList.remove(actor);
        ageList.remove(actor);
    }

    public static void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out;
        out = xstream.createObjectOutputStream(new FileWriter("name.xml"));
        out.writeObject(nameHashlist);
        out.close();
        out = xstream.createObjectOutputStream(new FileWriter("nat.xml"));
        out.writeObject(natHashlist);
        out.close();
        out = xstream.createObjectOutputStream(new FileWriter("gender.xml"));
        out.writeObject(genderHashlist);
        out.close();
        out = xstream.createObjectOutputStream(new FileWriter("age.xml"));
        out.writeObject(ageHashlist);
        out.close();
    }

    public static void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is;
        is = xstream.createObjectInputStream(new FileReader("name.xml"));
        nameHashlist =(LinkedList<Actor>[]) is.readObject();
        is.close();
        is = xstream.createObjectInputStream(new FileReader("nat.xml"));
        natHashlist =(LinkedList<Actor>[]) is.readObject();
        is.close();
        is = xstream.createObjectInputStream(new FileReader("gender.xml"));
        genderHashlist =(LinkedList<Actor>[]) is.readObject();
        is.close();
        is = xstream.createObjectInputStream(new FileReader("age.xml"));
        ageHashlist =(LinkedList<Actor>[]) is.readObject();
        is.close();
    }
}




