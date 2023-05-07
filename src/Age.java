public class Age {
    static public int Lifespan(DNA [] gene){
        int life = 0;
        for (DNA dna : gene) {
            life = life + dna.ordinal();
        }
        return life;
    }

    static public int Maturity(DNA [] gene){
        int maturity = 0;
        for (DNA dna : gene){
            maturity = maturity + (dna.ordinal());
        }
        return maturity > 0 ? maturity : 1;
    }
}
