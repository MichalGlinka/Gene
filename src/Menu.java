public enum Menu {
    EXIT("Exit"),STAT("Statistic"),RAND("Random"),EXACT("Exact Object"),PAIR("Pair Objects"),
    NEWGEN("Generate new population"),NEWYEAR("New year"),START("Start simulation");

    private String desc;
    Menu(String desc) {
        this.desc = desc;
    }

    static public Menu getMenu(int i){
        Menu menu = null;
        try {
            menu = Menu.values()[i];
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Not an option");
        }
        return menu;
    }

    @Override
    public String toString() {
        return ordinal() + " - " + desc;
    }
}
