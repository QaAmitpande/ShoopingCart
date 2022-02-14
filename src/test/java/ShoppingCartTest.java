import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShoppingCartTest {
    Ewallet wallet;
    @BeforeTest
    public void intialize(){wallet=new Ewallet(500);}

    @Test
    public void verifyItemAvailability(){
        shoppingCart shoppingCart=new shoppingCart();
        Customer customer=new Customer(wallet);
        Apple apple=new Apple("Apple",10,10);
        Customer.addToCart(apple);
        boolean checkItemAvailability=shoppingCart.isItemAvailable(apple.getName());
        System.out.println("Item Available ?"+checkItemAvailability);
        Assert.assertEquals(checkItemAvailability,false);

        Milk milk=new Milk("Milk",10,10);
        customer.addToCart(milk);
        boolean checkItemAvailability1=shoppingCart.isItemAvailable(milk.getName());
        System.out.println("Item available ?"+checkItemAvailability1);
        Assert.assertEquals(checkItemAvailability1,false);

        NewsPaper newsPaper=new NewsPaper("Newspaper",5,10);
        Customer.addToCart(newsPaper);
        boolean checkItemAvailability2=shoppingCart.isItemAvailable(newsPaper.getName());
        System.out.println("Item Available ?"+checkItemAvailability2);
        Assert.assertEquals(checkItemAvailability2,false);
    }
    @Test
    public void verifySubtotalForEachItem(){
        shoppingCart shoppingCart=new shoppingCart();
        Customer customer=new Customer(wallet);
        Apple apple=new Apple("apple",10,10);
        customer.addToCart(apple);
        System.out.println(shoppingCart.getSubTotal(apple));

        Milk milk=new Milk("milk",10,10);
        customer.addToCart(milk);
        System.out.println(shoppingCart.getSubTotal(milk));

        NewsPaper newsPaper=new NewsPaper("newspaper",5,10);
        customer.addToCart(newsPaper);
        System.out.println(shoppingCart.getSubTotal(newsPaper));
    }
    @Test
    public void VerifyTotalAmount(){
        shoppingCart shoppingCart=new shoppingCart();
        Customer customer=new Customer(wallet);
        Apple apple=new Apple("apple",10,10);
        customer.addToCart(apple);
        shoppingCart.addProduct(apple);

        Milk milk=new Milk("milk",10,10);
        customer.addToCart(milk);
        shoppingCart.addProduct(milk);

        NewsPaper newsPaper=new NewsPaper("newspaper",5,10);
        customer.addToCart(newsPaper);
        shoppingCart.addProduct(newsPaper);

        double totalAmount=shoppingCart.getTotalAmount();
        System.out.println("Total amount payable is"+totalAmount);
        Assert.assertEquals(totalAmount,250);

    }
    @Test
    public void verifyPaymentStatusViaEwallet(){
        Customer customer=new Customer(wallet);
        shoppingCart shoppingCart=new shoppingCart();
        Apple apple=new Apple("apple",10,10);
        shoppingCart.addProduct(apple);
        customer.addToCart(apple);


        Milk milk=new Milk("milk",10,10);
        shoppingCart.addProduct(milk);
        customer.addToCart(milk);


        NewsPaper newsPaper=new NewsPaper("newspaper",5,10);
        shoppingCart.addProduct(newsPaper);
        customer.addToCart(newsPaper);


        double totalAmount=shoppingCart.getTotalAmount();
        System.out.println("Total amount payable is"+totalAmount);

        boolean paymentStatus=wallet.hasSufficientBalance(totalAmount);
        wallet.deductAmount(totalAmount);
        System.out.println("Payment status from eWallet is :"+paymentStatus);
        Assert.assertEquals(paymentStatus,true);

    }

    @Test
    public void verifyAddWalletBalance(){
        Customer customer=new Customer(wallet);
        customer.addWalletBalance(500);
        System.out.println("Balance in wallet after adding amount :"+customer.getWalletBalance());
        Assert.assertEquals(1000,customer.getWalletBalance());
    }
}
