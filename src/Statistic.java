import java.util.ArrayList;
import java.util.function.Function;

public class Statistic {
    public String getStats(ArrayList<Person> people){
        return getGenderData(people) + "\n" + getAvg(people,"life") + "\n" + getAvg(people,"mature");
    }

    private String getGenderData(ArrayList<Person> people){
        int m = 0;
        int f = 0;
        for (Person person : people) {
            if (person.gender.equals(Gender.M)){
                m++;
            }else {
                f++;
            }
        }
        return "Genders : \n" + Gender.M.getSymbol() + " -> " + m + "\n" + Gender.F.getSymbol() + " -> " + f;
    }

    //Modes : life , mature
    private String getAvg(ArrayList<Person> people, String mode){
        int cumulativeValue = 0;
        for (Person person : people) {
            if (mode.equals("life")) {
                cumulativeValue += person.lifeSpan;
            }else if (mode.equals("mature")){
                cumulativeValue += person.maturity;
            }
        }
        int avg = cumulativeValue/people.size();
        String result = null;
        if (mode.equals("mature")){
            result = "AVG Maturity :";
        } else if (mode.equals("life")) {
            result = "AVG LifeSpan : ";
        }
        return result + avg;
    }
}
