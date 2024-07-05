package Observer;

import Models.Person;

import java.util.EventObject;

public class ChangePerson extends EventObject {

    private Person person;
    /**
     * Constructs a prototypical Event.
     *
     * @param p the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ChangePerson(Person p) {
        super("p");
        this.person=p;
    }

    public Person getPerson() {return this.person;}
    public void setPerson (Person p) {this.person=p;}
}
