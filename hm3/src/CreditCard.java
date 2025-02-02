public class CreditCard
{

  private String customer;
  private String bank;
  private String account;
  private int limit;        // credit limit (the maximum you may owe)   
  protected double balance; // current balance (the amount you owe)    


  public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
    customer = cust;
    bank = bk;
    account = acnt;
    limit = lim;
    balance = initialBal;
    if (initialBal>lim) {throw new IllegalArgumentException("Initial balance out of domain");}
    if (lim<0) {throw new IllegalArgumentException("Credit limit out of domain");}
  }


  public CreditCard(String cust, String bk, String acnt, int lim) {

    // call the previous constructor, but with an initial a balance of zero as default
    this(cust, bk, acnt, lim, 0);
  }


  // develop get/access methods for each attribute defined above (total 5)
  public String getCustomer() { return customer; }
  public String getBank() { return bank; }
  public String getAccount() { return account; }
  public int getLimit() { return limit; }
  public double getBalance() { return balance; }
  // Charges the given price to the card, assuming sufficient credit limit.
  public boolean charge(double price)
  {
    // return false, i.e. refuse the charge, if charge surpasses the limit
    if (price<0) {
      throw new IllegalArgumentException("Cannot charge negative price");
    }
    else if (price + balance > limit) {
      return false;
    }
    // Return true otherwise (the charge is successful).
    else {
      balance += price;
      return true;
    }
  }


  // Processes customer payment that reduces balance.
  public void makePayment(double amount)
  {
    if (amount<0){
      throw new IllegalArgumentException("Cannot make negative payment");
    } else {
      balance -= amount;
    }
  }

  // Print a card's information
  public void printSummary() {
    System.out.println("Customer = " + customer);
    System.out.println("Bank = " + bank);
    System.out.println("Account = " + account);
    System.out.println("Balance = " + balance);
    System.out.println("Limit = " + limit);
  }

  public static void main(String[] args) {

    // define and initialize an array of CreditCard with 3 elements
    CreditCard[] cc = new CreditCard[3];

    // create 3 instances of CreditCard with different information
    // and add them into the array above
    try {
      cc[0] = new CreditCard("User1", "Bank1", "111111", 5000);
      cc[1] = new CreditCard("User2", "Bank2", "222222", 10000, 1000);
      cc[2] = new CreditCard("User3", "Bank3", "222222", 2500, 400);
      // for each element (card), charge them different prices
      if (cc[0].charge(10000)) {
        System.out.println("For"+cc[0].getCustomer()+": charge successful, balance after charge: " + cc[0].getBalance());
      } else {
        System.out.println("For"+cc[0].getCustomer()+": charge failed, charge surpasses the limit");
      }
      if (cc[1].charge(5000)) {
        System.out.println("For"+cc[1].getCustomer()+": charge successful, balance after charge: " + cc[1].getBalance());
      } else {
        System.out.println("For"+cc[1].getCustomer()+": charge failed, charge surpasses the limit");
      }
      if (cc[2].charge(1000)) {
        System.out.println("For"+cc[2].getCustomer()+": charge successful, balance after charge: " + cc[2].getBalance());
      } else {
        System.out.println("For"+cc[2].getCustomer()+": charge failed, charge surpasses the limit");
      }

      // using new for loop to
      // (1) print out each card's information
      // (2) for each card, continuously makePayment '200' so long as the balance is greater than 200
      //     and print out the balance correspondingly
      for (CreditCard i : cc) {
        i.printSummary();
      }
      for (CreditCard i : cc) {
        while (i.getBalance() > 200) {
          i.makePayment(200);
          System.out.println("Balance after payment: " + i.getBalance());
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Exception thrown: " + e);
    }
  }
}

