import java.util.ArrayList;

public class Statistic {
    public String getStats(ArrayList<Person> people,Enviorment enviorment){
        try {
            return "Population : " + people.size() + "\n" + getGenderData(people) + "\n" + getAvg(people,"life") +
                    "\n" + getAvg(people,"mature") + "\n" + getSkinColor(people) +
                    "\nEnviorment :\nfood : " + enviorment.food;
        }catch (ArithmeticException e){
            return "Population 0" + "\nEnviorment :\nfood : " + enviorment.food;
        }
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

    private String getSkinColor(ArrayList<Person> people){
        int white = 0;
        int yellow = 0;
        int brown = 0;
        int black = 0;
        for (Person person : people) {
            if (person.skinColor.equals(Color.WHITE.colour)){
                white++;
            }else if (person.skinColor.equals(Color.YELLOW.colour)){
                yellow++;
            }else if (person.skinColor.equals(Color.BROWN.colour)){
                brown++;
            }else {
                black++;
            }
        }
        return "\u001B[38;2;" + Color.WHITE.colour.toString() +  "\u25a0\u001b[0m" + " - " + white + "\n\u001B[38;2;" +
                Color.YELLOW.colour.toString() + "\u25a0\u001b[0m" + " - " + yellow + "\n\u001B[38;2;" +
                Color.BROWN.colour.toString() + "\u25a0\u001b[0m" +  " - " + brown + "\n\u001B[38;2;" +
                Color.BLACK.colour.toString() + "\u25a0\u001b[0m" + " - " + black;

    }
}
