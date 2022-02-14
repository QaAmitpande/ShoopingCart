import java.util.ArrayList;
import java.util.List;

public class shoppingCart {
    public List<Products> products;

    public shoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Products product) {
        products.add(product);
    }

    public List<Products> getProducts() {
        return products;
    }

    public void removeProduct(Products product) {
        products.remove(product);
    }

    public double getSubTotal(Products product) {
        return product.getPrice()*product.getQuantity();
    }
    public double getTotalAmount(){
        double Total=0;
        for (Products product:getProducts()){
            Total+=getSubTotal(product);
        }
        return Total;
    }

    public boolean isItemAvailable(String item){
        int stock=8;
        return getProducts().stream().anyMatch((s)->s.getName().equals(item)
                &&s.getQuantity()<=stock);
    }

}
