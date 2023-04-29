public enum DNA {
    T,A,G,C,X,Y;

    static public DNA getDNAbyint(int i){
        return DNA.values()[i];
    }
}
