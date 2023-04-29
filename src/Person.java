import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Person {
    DNA [] dna = new DNA[100];

    Colour eyeColor;
    Gender gender;

    int lifeSpan;
    int maturity;

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
    }

    public Person(Person m,Person f){
        for (int i = 0;i < dna.length;i++){
            DNA [] rna = {m.dna[i],f.dna[i]};
            dna[i] = rna[random.nextInt(rna.length)];
        }
        setupFenotype();
    }

    private void setupFenotype(){
        eyeColor = setEyeColor();
        setGender();
        lifeSpan = Age.Lifespan(Arrays.copyOfRange(dna,5,15));
        maturity = Age.Maturity(Arrays.copyOfRange(dna,17,21));
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
        String result = "\u001B[38;2;" + eyeColor.toString() + "\u25c9" + "\u001B[0m" + " ";
        result = result + gender.getSymbol() + " ";
        result = result + "Lifespan : " + lifeSpan + " y Maturity : " + maturity + " y ";
        return result;
    }
}
