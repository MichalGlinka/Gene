import java.util.Random;

public class Person {
    DNA [] dna = new DNA[100];

    String eyeColor;

    Random random = new Random();

    public Person(DNA[] dna) {
        for (int i = 0; i < dna.length; i++) {
            dna[i] = DNA.getDNAbyint(random.nextInt(4));
        }
    }

    private void setEyeColor(){
        String first;
        String second;
        DNA [] gene = {dna[2],dna[3]};
        if (gene[0].equals(DNA.A)){
            first = "593310"; //brązowy
        }else if (gene[0].equals(DNA.C)){
            first = "00430c"; //zielony
        }else if (gene[0].equals(DNA.G)){
            first = "0043ff"; //niebieski
        }else {
            first = "ff0000"; //czerwony
        }
    }

    private String getEyeColor(){
        return eyeColor;
    }
}
