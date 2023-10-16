package statisticsdemo;

public class Employee implements Measureable, Comparable{
    private String name;
    private int hours;
    private int rate;
    private int sales;
    private double netPay;
    public Employee(String name, int hours, int rate, int sales){
        this.name = name;
        this.hours = hours;
        this.rate = rate;
        this.sales = sales;
        double wages = 0;
        if(hours <= 40)
            wages = rate*hours;
        else if(hours <= 60 && hours > 40)
            wages = rate*40 + (1.5*rate)*(hours-40);
        else if(hours > 60)
            wages = rate*40 + (1.5*rate*20) + (2*rate)*(hours-60);
        double com = .15*sales;
        double gros = wages + com;
        double tax = .18*gros;
        netPay = gros-tax;
    }
    public int getFirstInt(){
        return hours;
    }
    public int getSecondInt(){
        return rate;
    }
    public double getDouble(){
        return netPay;
    }
    public int getThirdInt() {
		return sales;
	}    
    public int compareTo(Object otherObject) {
        Employee other = (Employee)otherObject;
        if(this.netPay < other.netPay)
            return -1;
         else if(this.netPay > other.netPay)
            return 1;
        else
            return 0;
    }
    public String toString(){
    	return String.format("%n(%sHours=%d,Rate=%d,Sales=%d,netPay=%.2f)", name, hours, rate, 
         		sales, netPay);
        
    }
}