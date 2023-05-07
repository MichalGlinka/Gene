import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int startpopulation = 0;
        Scanner scanner = new Scanner(System.in);
        Raport raport = new Raport();
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
                    raport.lastYear = 0;
                    System.out.println("How many?");
                    int howMany = scanner.nextInt();
                    people.clear();
                    for (int i = 0; i < howMany; i++) {
                        people.add(new Person());
                    }
                }
                case NEWYEAR -> {
                    Others.newYear(random,people,enviorment,inheritance);
                }
                case START -> {
                    System.out.println("How many years");
                    int y = scanner.nextInt();
                    System.out.println("How often");
                    int o = scanner.nextInt();
                    for (int i = 0; i < y; i++) {
                        Others.newYear(random,people,enviorment,inheritance);
                        if (i%o == 0){
                            System.out.println(statistic.getStats(people,enviorment));
                            System.out.println();
                        }
                    }
                }
                case ALL -> {
                    for (Person person : people) {
                        System.out.println(person.toString());
                    }
                }
                case EXT -> {
                    System.out.println("Interval");
                    int o = scanner.nextInt();
                    int i = 0;
                    do{
                        Others.newYear(random,people,enviorment,inheritance);
                        raport.addYear();
                        i++;
                        System.out.println(i);
                    }while (people.size() >= 1 && i < o);
                    if (people.size() == 0){
                        System.out.println(raport.toString());
                    }
                }
                case TEST -> {
                    people.clear();
                    System.out.println("Setup");
                    enviorment.food = 3000000;
                    for (int i = 0; i < 1000000; i++) {
                        people.add(new Person());
                    }
                    for (int i = 0; i < statistic.getAVGMat(people); i++) {
                        Others.newYear(random,people,enviorment,inheritance);
                    }
                    System.out.println("Execution");
                    long first = System.nanoTime();
                    Others.newYear(random,people,enviorment,inheritance);
                    long second = System.nanoTime();
                    System.out.print((second - first)/1000000);
                    System.out.println("ms");
                }
            }
        }while (run);
    }
}