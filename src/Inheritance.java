import java.util.ArrayList;
import java.util.Random;

public class Inheritance {

    public void newBornTest(ArrayList<Person> people,int m,int f){
        boolean a = ((people.get(m).gender.equals(Gender.M) && people.get(f).gender.equals(Gender.F)) ||
                people.get(f).gender.equals(Gender.M) && people.get(m).gender.equals(Gender.F));
        boolean b = ((people.get(m).age >= people.get(m).maturity) && (people.get(f).age >= people.get(f).maturity));
        boolean c = people.get(f).feed > 1 || people.get(m).feed > 1;
        if (a && b && c){
            people.add(new Person(people.get(m), people.get(f)));
        }
    }
    public boolean newBorn(ArrayList<Person> people,int m,int f){
        if (((people.get(m).gender.equals(Gender.M) && people.get(f).gender.equals(Gender.F)) ||
                people.get(f).gender.equals(Gender.M) && people.get(m).gender.equals(Gender.F)) &&
                ((people.get(m).age >= people.get(m).maturity) && (people.get(f).age >= people.get(f).maturity)) &&
                (people.get(f).feed > 1 || people.get(m).feed > 1)){
            people.add(new Person(people.get(m),people.get(f)));
            return true;
        }
        return false;
    }

    public boolean newBorn(ArrayList<Person> people){
        Random random = new Random();
        return newBorn(people,random.nextInt(people.size()),random.nextInt(people.size()));
    }
}
