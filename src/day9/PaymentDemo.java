package day9;

interface PaymentMethod {
    void pay(double amount);
}

class creditcard implements PaymentMethod {
    @Override
    public void pay(double amount) {
            System.out.println("Paid " + amount + " using Credit Card");
        }
    }

class debitcard implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Debit Card");
    }
}

class UPIpay implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentMethod credit = new creditcard();
        PaymentMethod debit = new debitcard();
        PaymentMethod upi = new UPIpay();

        credit.pay(100000);
        debit.pay(25000);
        upi.pay(1000);
    }
}
