import java.util.ArrayList;
import java.util.Random;

public class Enviorment {
    int food;
    ArrayList<Person> people;

    Random random = new Random();
    public Enviorment(ArrayList<Person> people) {
        this.people = people;
        this.food = random.nextInt(random.nextInt(people.size()) + people.size());
    }

    public void growth(){
        food += people.size() + (random.nextInt(people.size()) - (people.size()/2));
    }
}
