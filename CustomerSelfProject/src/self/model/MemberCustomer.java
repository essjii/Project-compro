package self.model;



public class MemberCustomer extends Customer {
    
    private double points;
    public static double discountRate;

    public MemberCustomer() {
    }

    public MemberCustomer(double points) {
        this.points = points;
    }

    public MemberCustomer(String name, String surname, double points) {
        super(name, surname);
        this.points = points;
    }

    public double getPoints() {
        return points;
    }
   
    @Override
    public double getDiscountRate(){
        MemberCustomer.discountRate = 20.0/100;
        return discountRate;
    }
    
    @Override
    public void setDiscountRate(double discountRate){
        MemberCustomer.discountRate = discountRate;
    }
    
    @Override
    public double redeemPoint2Cash(int usePoint){
        double returnSomething = 0;
        if(usePoint < 800){
            System.out.println("Your points are less than 800 points");
//            this.points = this.points;
            returnSomething = -2;
        }
        
        if(usePoint > this.points){
            System.out.println("Your points are not enough!");
            returnSomething = -1;
        }
        
        if(usePoint <= this.points && usePoint >= 800){
            returnSomething = (usePoint/800)*100.0;
            this.points = this.points - (usePoint/800)*800;
        }
        return returnSomething;
    }
    
    @Override
    public void addPointFromBuyingTotalPrice(double buyingPrice){
        if(buyingPrice >= 25){
            this.points += buyingPrice/25;
        } else {
            this.points = this.points;
        }
    }
  

}
