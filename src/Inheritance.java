import java.util.ArrayList;
import java.util.Random;

public class Inheritance {
    public void newBorn(ArrayList<Person> people,int m,int f){
        if (((people.get(m).gender.equals(Gender.M) && people.get(f).gender.equals(Gender.F)) ||
                people.get(f).gender.equals(Gender.M) && people.get(m).gender.equals(Gender.F)) &&
                ((people.get(m).age >= people.get(m).maturity) && (people.get(f).age >= people.get(f).maturity))){
            people.add(new Person(people.get(m),people.get(f)));
        }
    }

    public void newBorn(ArrayList<Person> people){
        Random random = new Random();
        newBorn(people,random.nextInt(people.size()),random.nextInt(people.size()));
    }
}
