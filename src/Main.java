public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        for (DNA dna : person.dna) {
            System.out.print(dna);
        }
        System.out.println();
        System.out.print(person);
    }
}