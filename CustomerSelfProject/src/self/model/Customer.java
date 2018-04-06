package self.model;


public abstract class Customer {
   private String name;
   private String surname;

    public Customer() {
    }

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
   
   public abstract double getDiscountRate();
   public abstract void setDiscountRate(double discountRate);
   public abstract double redeemPoint2Cash(int usePoint);
   public abstract void addPointFromBuyingTotalPrice(double buyingPrice);
   
}
