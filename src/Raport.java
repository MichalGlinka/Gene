public class Raport {
    int lastYear = 0;

    public Raport() {
    }

    public void addYear(){
        lastYear++;
    }

    @Override
    public String toString() {
        return "Raport : \n Last Year : " + lastYear;
    }
}
