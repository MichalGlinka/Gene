import java.util.Random;

public class Person {
    DNA [] dna = new DNA[100];

    String eyeColor;

    Random random = new Random();

    public Person() {
        for (int i = 0; i < dna.length; i++) {
            if (i == 0) {
                dna[i] = DNA.getDNAbyint(random.nextInt(2) + 4);
            } else {
                dna[i] = DNA.getDNAbyint(random.nextInt(4));
            }
        }
        String tempColor = String.format("%06x",setEyeColor());
        eyeColor = tempColor.length() > 6 ? tempColor.substring(1) : tempColor;
        eyeColor = eyeColor.substring(0,2) + ";" + eyeColor.substring(2,4) + ";" + eyeColor.substring(4) + "m";
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

    public String getEyeColor(){
        return eyeColor;
    }

    @Override
    public String toString() {
        return "\u001B[38;2;" + eyeColor + "O" + "\u001B[0m";
    }
}
