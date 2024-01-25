package oops._3_Concepts._17_Associaction_HAS_A;


/*
    - Stronger form of Association
    - 2 entities are highly dependent on each other
    e.g.,
    car w/o engine
    man w/o heart
 */


class House{
    private Kitchen kitchen;


    public House(){
        kitchen = new Kitchen();
        kitchen.setFood("Pizza");

        // we can say HOUSE has-a Kitchen...
        // if kitchen won't there -> then No house
    }

    public String getFood(){
        return kitchen.getFood();
    }
}

class Kitchen{
    private String food;
    public void setFood(String food){
        this.food = food;
    }

    public String getFood() {
        return food;
    }
}

public class Composition {
    public static void main(String[] args) {
        House house = new House();

        System.out.println(house.getFood());
    }

}
