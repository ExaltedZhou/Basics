
public class USMoney 
{
    private int dollars;
    private int cents;
    
    public USMoney()
    {
        dollars = 0;
        cents = 1;
    }
    
    public USMoney(int dollars, int cents)
    {
        this.dollars = dollars;
        this.cents = cents;
    }
    
    public USMoney(USMoney m)
    {
        dollars = m.dollars;
        cents = m.cents;
    }
    
    public int getDollars()
    {
        return dollars;
    }
    
    public int getCents()
    {
        return cents;
    }
    
    public void setMoney(int dollars, int cents)
    {
        this.dollars = dollars;
        this.cents = cents;
    }}