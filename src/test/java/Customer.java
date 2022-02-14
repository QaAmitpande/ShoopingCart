public class Customer {
    private static shoppingCart shoppingCart;
    private Ewallet ewallet;

    public Customer(Ewallet ewallet){
        this.ewallet=ewallet;
        shoppingCart=new shoppingCart();
    }
    public static void addToCart(Products products){
        shoppingCart.addProduct(products);
    }
    public void removeProductFromCart(Products product){
        shoppingCart.removeProduct(product);
    }
    public double getWalletBalance(){
        return ewallet.getWalletBalance();
    }
    public void addWalletBalance(double amount){
        ewallet.addWalletBalance(amount);
    }
}
