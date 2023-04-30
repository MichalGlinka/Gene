public enum Color {
    WHITE(new Colour(255,255,230)),
    YELLOW(new Colour(255,255,20)),
    BROWN(new Colour(100,70,0)),
    BLACK(new Colour(20,20,0)),;

    Colour colour;

    Color(Colour colour) {
        this.colour = colour;
    }
}
