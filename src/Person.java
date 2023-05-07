import java.util.Arrays;
import java.util.Random;

public class Person {
    int age;
    DNA [] dna = new DNA[100];

    int feed;

    Colour eyeColor;
    Gender gender;

    Colour skinColor;

    int lifeSpan;
    int maturity;

    int strenght;

    boolean agression;

    Random random = new Random();

    public Person() {
        for (int i = 0; i < dna.length; i++) {
            if (i == 0) {
                dna[i] = DNA.getDNAbyint(random.nextInt(2) + 4);
            } else {
                dna[i] = DNA.getDNAbyint(random.nextInt(4));
            }
        }
        setupFenotype();
        age = 1;
        feed = 2;
    }

    public Person(Person m,Person f){
        for (int i = 0;i < dna.length;i++){
            DNA [] rna = {m.dna[i],f.dna[i]};
            dna[i] = rna[random.nextInt(rna.length)];
        }
        setupFenotype();
        age = 1;
        feed = 2;
    }

    public void pickupFood(Enviorment enviorment){
        int modifier = dna[46].ordinal() + dna[47].ordinal();
        int pickup = random.nextInt(modifier + 1);
        if (enviorment.food > 1){
            if (enviorment.food < pickup){
                this.feed += enviorment.food;
                enviorment.food = 0;
            }else {
                this.feed += pickup;
                enviorment.food -= pickup;
            }
        }
    }

    public void nextYear(Enviorment enviorment){
        age++;
        feed--;
        pickupFood(enviorment);
    }
    private void setupFenotype(){
        eyeColor = setEyeColor();
        setGender();
        lifeSpan = Age.Lifespan(Arrays.copyOfRange(dna,5,15));
        maturity = Age.Maturity(Arrays.copyOfRange(dna,17,21));
        setupStrenght();
        setSkinColor();
    }
    private void setSkinColor(){
        if (dna[42].equals(DNA.A)){
            skinColor = Color.WHITE.colour;
        }else if (dna[42].equals(DNA.C)){
            skinColor = Color.YELLOW.colour;
        }else if (dna[42].equals(DNA.G)){
            skinColor = Color.BROWN.colour;
        }else {
            skinColor = Color.BLACK.colour;
        }
    }


    //#robiomrePopijakumkurtwa
    private void setupStrenght(){
        int strenght = 0;
        for (int i = 23; i < 40; i++) {
            strenght += (dna[i]).ordinal();
        }
        this.strenght = strenght;
    }

    private void setGender(){
        if (dna[0].equals(DNA.X)){
            gender = Gender.F;
        }else {
            gender = Gender.M;
        }
    }

    //Fenotyp koloru oczu
    private Colour setEyeColor(){
        Colour first;
        Colour second;
        DNA [] gene = {dna[2],dna[3]};
        first = setupColor(gene[0]);
        second = setupColor(gene[1]);

        return gene[0].equals(gene[1]) ? first : first.addColour(second);
    }

    private Colour setupColor(DNA gene){
        if (gene.equals(DNA.A)){
            return new Colour(100,70,0); //brązowy
        }else if (gene.equals(DNA.C)){
            return new Colour(0,255,0); //zielony
        }else if (gene.equals(DNA.G)){
            return new Colour(0,0,255); //niebieski
        }else {
            return new Colour(255,0,0); //czerwony
        }
    }

    public Colour getEyeColor(){
        return eyeColor;
    }

    @Override
    public String toString() {
        return "\u001B[38;2;" + eyeColor.toString() + "\u25c9\u001B[0m" + "\n "
                + gender.getSymbol() + "\n "
                + "Lifespan : " + lifeSpan + "\n y Maturity : " + maturity + "\n y Strength : " + strenght + "\n "
                + "\u001B[38;2;" + skinColor.toString() + "\u25a0\u001b[0m " + "\nFeed : " + feed + "\nAge : " + age;
    }
}
