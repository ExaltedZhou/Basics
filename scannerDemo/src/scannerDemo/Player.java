package scannerDemo;

public class Player {
	private int numPlayers;
	private static int num = 0;
	private int x1;
	private int y1;
	private int z1; 
	private int direct;
	private int health;
	private String name1;

	public Player() {
		x1 = 0;
		y1 = 0;
		z1 = 0;
		health = 20;
		direct = 1;
		num++;
		numPlayers = num;
		name1 = "p" + numPlayers;
	}

	public Player(String name, int x, int y, int z) {
		this(name, x, y, z, 20, 1);
		num++;
		numPlayers = num;
	}

	public Player(String name, int x, int y, int z, int hp, int direction) {
		name1 = name;
		x1 = x;
		y1 = y;
		z1 = z;
 
		if (hp >= 0) 
			health = hp;
		else 
			health = 0;
		if (direction >= 1 && direction <= 6) 
			direct = direction;	
		else 
			direct = 1;
		num++;
		numPlayers = num;
	}

//Accessors
	public static int getNumPlayers()	{
		return num;
	}
	public String getName()	{
		return name1;
	}
	public int getX()	{
		return x1;
	}
	public int getY()	{
		return y1;
	}
	public int getZ()	{
		return z1;
	}
	public int getHp()	{
		return health;
	}
	public int getDirection()	{
		return direct;
	}
	public String toString()	{
		return "Name: " + name1 + "\nHealth: " + health + "\nCoordinates: X " + x1 + " Y " + y1 + " Z " + z1 + "\nDirection: " + direct;
	}

// Mutators
	public void setHp(int hp)	{
		if (hp > 0)
			health = hp;
		else
			health = 0;
	}
	public void setDirection(int direction)	{
		if (direction >= 1 && direction <= 6)
			direct = direction;
}

	public void move(int direction, int units)	{
		if (direction == 1)
			x1+=units;
		if (direction == 2)
			x1-=units;
		if (direction == 3)
			y1+=units; 
		if (direction == 4)
			y1-=units;
		if (direction == 5)
			z1+=units;
		if (direction == 6)
			z1-=units;
}

	public void teleport(int x, int y, int z){
		x1 = x;
		y1 = y;
		z1 = z;
	}

	public void teleport(Player player)	{
		x1 = player.getX();
		y1 = player.getY();
		z1 = player.getZ();
	}

	public void attack(Player player, int damage)	{
		this.health += (damage/2);
		player.setHp(player.getHp() - damage);
		if (player.getHp() < 0)
			player.setHp(0);
	}
// Distance methods
	public double getDistance(int x, int y, int z)	{
		return Math.sqrt(Math.pow((x - x1), 2) + Math.pow((y - y1), 2) + 
			   Math.pow((z - z1), 2));
	}
	public double getDistance(Player player){
		return Math.sqrt(Math.pow((player.getX() - x1), 2) 
			 + Math.pow((player.getY() - y1), 2) + Math.pow((player.getZ() - z1), 2));
	}
}