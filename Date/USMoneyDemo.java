
public class USMoneyDemo {
	    public static void main(String[] args)
	    {
	        USMoney penny = new USMoney();
	        USMoney fiveFifty = new USMoney(5, 50);
	        USMoney fiftyFive = new USMoney(fiveFifty);
	        System.out.printf("first amount: $%d.%02d\n",
	                penny.getDollars(), penny.getCents());
	        System.out.printf("second amount: $%d.%02d\n",
	                fiveFifty.getDollars(), fiveFifty.getCents());
	        System.out.printf("third amount: $%d.%02d\n",
	                fiftyFive.getDollars(), fiftyFive.getCents());
	        fiftyFive.setMoney(fiveFifty.getCents(), fiveFifty.getDollars());
	        System.out.println();
	        System.out.println("After modifying the third amount:");
	        System.out.printf("first amount: $%d.%02d\n",
	                penny.getDollars(), penny.getCents());
	        System.out.printf("second amount: $%d.%02d\n",
	                fiveFifty.getDollars(), fiveFifty.getCents());
	        System.out.printf("third amount: $%d.%02d\n",
	                fiftyFive.getDollars(), fiftyFive.getCents());                
	    }
}
