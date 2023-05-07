import java.util.ArrayList;
import java.util.Random;

public class Enviorment {
    int food;

    int year;
    ArrayList<Person> people;

    Random random = new Random();
    public Enviorment(ArrayList<Person> people) {
        this.people = people;
        this.food = random.nextInt(people.size()) + people.size();
        this.year = 1;
    }

    public void growth(){
        food =+ people.size() * 2;
    }
}
