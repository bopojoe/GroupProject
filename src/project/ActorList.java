package project;

import java.util.Iterator;

public class ActorList implements Iterable<Actor>{


    protected static LinkedList<Actor> hashlist[];

    static {
        hashlist = new LinkedList[50];
    }

    protected static LinkedList<Actor> actorlist = new LinkedList<>();

    @Override
    public Iterator<Actor> iterator() {
        return actorlist.iterator();
    }

    public static void addActor(String name, int age, String gender, String nationality){
        Actor newActor = new Actor(name, age, gender, nationality);
        int index = age;
        int hash = index % hashlist.length;
        LinkedList<Actor> hashedList = hashlist[index];
        if(hashedList == null)
            hashedList = new LinkedList<Actor>();
        hashedList.add(newActor);
        System.out.println("You've just added:" + newActor.toString());
    }

    // Kevin Power 2075681
    public void removeActor(Actor toRemove){
        LinkedList<Actor> internalList = hashlist[toRemove.hashCode()];
        if (internalList != null){
            internalList.remove(toRemove);
        }
    }




}
