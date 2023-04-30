import java.util.ArrayList;

public class Inheritance {
    public void newBorn(ArrayList<Person> people,int m,int f){
        if ((people.get(m).gender.equals(Gender.M) && people.get(f).gender.equals(Gender.F)) ||
                people.get(f).gender.equals(Gender.M) && people.get(m).gender.equals(Gender.F)){
            people.add(new Person(people.get(m),people.get(f)));
        }
    }

    public void newBornRandom(ArrayList<Person> people){

    }
}
