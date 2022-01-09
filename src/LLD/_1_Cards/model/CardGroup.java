package LLD._1_Cards.model;

public class CardGroup {
    private final int totalCard = 13;
    private CardColor color;
    private String name;

    public CardGroup(CardColor color, String name) {
        this.color = color;
        this.name = name;
    }

    public int getTotalCard() {
        return this.totalCard;
    }

    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
