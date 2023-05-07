import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.SortedMap;

public class Others {
    static public void newYear(Random random, ArrayList<Person> people, Enviorment enviorment, Inheritance inheritance){
        int dies = 0;
        int birth = 0;
        for (int i = 0; i < people.size(); i++) {
            birth += inheritance.newBorn(people) ? 1 : 0;
        }
        // Too slow
        for (Iterator<Person> iterator = people.iterator(); iterator.hasNext();){
            Person p = iterator.next();
            p.nextYear(enviorment);
            if (p.age > p.lifeSpan || p.feed == 0){
                iterator.remove();
                dies++;
            }
        }
        enviorment.growth();
        enviorment.year++;
        System.out.println("Births - " + birth);
        System.out.println("Dies - " + dies);
    }

}
