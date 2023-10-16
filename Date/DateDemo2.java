import java.util.Scanner;
public class DateDemo2 {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the first day of class -> "); 
		String date=sc.nextLine();
		Date date1st=findDate(date);
		Date date2nd=new Date(date1st);
		String[] monthName = new String[]{"January ", " February ", 
			"March ", "April ", "May ", "June ", "July ", "August ",
			"September ", "October ", "November ", "December "};
		String monthName1 = monthName[date1st.getMonth() - 1]; //output
		
		String weekDay = findWeekDay(date1st.getMonth(), date1st.getDay(), date1st.getYear());		
		System.out.printf("First day of class: %s%s%d, %d", weekDay , monthName1 , date1st.getDay() 
				, date1st.getYear());
				System.out.printf("%nLast day of class: %s%s%d, %d" , weekDay , monthName1 , date2nd.getDay() 
				, date2nd.getYear());
		Scanner sc2=new Scanner(System.in);
		System.out.printf("%nEnter the last day of class -> "); 
		String date1=sc2.nextLine();
		Date date2=findDate(date1);
		date2nd.setDate(date2.getMonth(), date2.getDay(), date2.getYear());
		String monthName2 = monthName[date2nd.getMonth() - 1]; 
		String weekDay2=findWeekDay(date2nd.getMonth(), date2nd.getDay(), date2nd.getYear());
		System.out.printf("First day of class: %s%s%d, %d" , weekDay , monthName1 , date1st.getDay() 
		, date1st.getYear());
		System.out.printf("%nLast day of class: %s%s%d, %d" , weekDay2 , monthName2 , date2nd.getDay() 
		, date2nd.getYear());
		sc2.close();
		sc.close();		
	}
	public static Date findDate(String s) {
		String x=s.split("/")[0];
		String y=s.split("/")[1];
		String z=s.split("/")[2];
		int x1=Integer.parseInt(x);
		int y1=Integer.parseInt(y);
		int z1=Integer.parseInt(z);
		Date date=new Date(x1,y1,z1);
		return date;				
	}
	public static String findWeekDay(int month, int day, int year) {
		String[] weekDay = new String[] {"Sunday, " , "Monday, ", "Tuesday, ",
		"Wednesday, ", "Thursday, ", "Friday, ", "Saturday, "};
		int[] monthx = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
		if(year % 400 == 0) { 
			monthx[0] = 6;
			monthx[1] = 2;
		}		
		else {
			monthx[0] = 0;
			monthx[1] = 3;
		}
		int century = year/100;
		int w, x, y;
		int u = 2*(3-(century % 4));
		int v = year%100;
		w = v / 4;
		x = monthx[month - 1];
		y = (u + v + w + x + day) % 7;
		String weekDay1 = weekDay[y];
		return weekDay1;		
	}
}
