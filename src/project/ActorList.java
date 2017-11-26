package project;

import java.util.Iterator;

public class ActorList implements Iterable<Actor>{
    private int index;
    protected static LinkedList<Actor> actorList = new LinkedList<>();

    @Override
    public Iterator<Actor> iterator() {
        return actorList.iterator();
    }

    public void addActor(String name, int age, String gender, String nationality, LinkedList genre){
        Actor newActor = new Actor(name, age, gender, genre, nationality);
        actorList.addAtIndex(index,newActor);
        System.out.println("You've just added:" + newActor.toString());
        this.index ++;
    }

    public Actor findActorByCreds(String name, int age){
        for(Actor actor : this){
            if(actor.getName().equals(name)&& actor.getAge()==(age));
            return actor;
        }
        System.out.println(name + age + " not found.");
        return null;
    }
    public void removeActor(String name, int age){
        Actor removeThisActor = findActorByCreds(name,age);
        if (removeThisActor != null){
            actorList.remove(removeThisActor);
            System.out.println(name + age + " has been removed");

        }
    }




}
