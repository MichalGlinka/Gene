import java.util.*;

public class Main {

    public static void main(String[] args) {
        int startpopulation = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Startpopulation : ");
        startpopulation = scanner.nextInt();
        Statistic statistic = new Statistic();
        Inheritance inheritance = new Inheritance();
        Random random = new Random();
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < startpopulation; i++) {
            people.add(new Person());
        }
        Enviorment enviorment = new Enviorment(people);
        boolean run = true;
        do{
            for (Menu value : Menu.values()) {
                System.out.println(value);
            }
            Menu menu = null;
            try {
                menu = Menu.getMenu(scanner.nextInt());
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.err.println("Not an option");
            }
            switch (menu){
                case EXIT -> run = false;
                case STAT -> System.out.println(statistic.getStats(people,enviorment));
                case RAND -> {
                    int r = random.nextInt(people.size());
                    System.out.println("Object " + r + "\n" + people.get(r).toString());
                }
                case EXACT -> {
                    System.out.println("Wich one?");
                    int obj = scanner.nextInt();
                    System.out.println(people.get(obj).toString());
                }
                case PAIR -> {
                    System.out.println("M:");
                    int m = scanner.nextInt();
                    System.out.println("F:");
                    int f = scanner.nextInt();
                    inheritance.newBorn(people,m,f);
                }
                case NEWGEN -> {
                    System.out.println("How many?");
                    int howMany = scanner.nextInt();
                    people.clear();
                    for (int i = 0; i < howMany; i++) {
                        people.add(new Person());
                    }
                }
                case NEWYEAR -> {
                    for (Iterator<Person> iterator = people.iterator(); iterator.hasNext();){
                        Person p = iterator.next();
                        p.nextYear();
                        if (p.age > p.lifeSpan){
                            iterator.remove();
                        }
                    }
                    enviorment.growth();
                }
                case START -> {

                }
            }
        }while (run);
    }
}