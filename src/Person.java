import java.util.Random;

public class Person {
    DNA [] dna = new DNA[100];

    int eyeColor;

    Random random = new Random();

    public Person() {
        for (int i = 0; i < dna.length; i++) {
            if (i == 0) {
                dna[i] = DNA.getDNAbyint(random.nextInt(2) + 4);
            } else {
                dna[i] = DNA.getDNAbyint(random.nextInt(4));
            }
        }
        eyeColor = setEyeColor();
    }

    //Fenotyp koloru oczu
    private int setEyeColor(){
        int first;
        int second;
        DNA [] gene = {dna[2],dna[3]};
        first = setupColor(gene[0]);
        second = setupColor(gene[1]);

        return gene[0].equals(gene[1]) ? first : first + second;
    }

    private int setupColor(DNA gene){
        if (gene.equals(DNA.A)){
            return 0x593310; //brązowy
        }else if (gene.equals(DNA.C)){
            return 0x00430c; //zielony
        }else if (gene.equals(DNA.G)){
            return 0x0043ff; //niebieski
        }else {
            return 0xff0000; //czerwony
        }
    }

    public int getEyeColor(){
        return eyeColor;
    }
}
