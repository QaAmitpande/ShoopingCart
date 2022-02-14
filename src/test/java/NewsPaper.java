import jdk.jfr.Category;

public class NewsPaper implements Products{
    private String name;
    private double price;
    private int quantity;

    public NewsPaper(String name,double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
