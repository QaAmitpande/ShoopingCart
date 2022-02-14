public class Ewallet implements Wallet{

    private double balance;
    public Ewallet(double amount){this.balance=amount;}

    @Override
    public double getWalletBalance() {
        return balance;
    }

    @Override
    public void addWalletBalance(double loadBalance) {
        balance += loadBalance;

    }

    @Override
    public void deductAmount(double amount) {
        if(balance>amount){
            this.balance -=amount;
        }
        else {
            System.out.println("insufficient balance please add balance to your Wallet");
        }

    }
    public boolean hasSufficientBalance(double totalAmount){
        return getWalletBalance()>totalAmount;
    }
}
