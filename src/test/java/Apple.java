import jdk.jfr.Category;

public class Apple implements Products {

    private int quantity;
    private double amount;
    private String name;
   // private Category type;

    public Apple(String name,int quantity,double amount){
        this.name=name;
        this.quantity=quantity;
        this.amount=amount;
       // this.type=type;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getPrice() {
        return amount;
    }

    @Override
    public String getName() {
        return name;
    }
}
