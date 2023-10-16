import java.util.*;
public class DateDemo1 {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the first day of class -> "); 
		String date=sc.nextLine();
		String[] dateSplit=date.split("/");
		String month = dateSplit[0];
		String day = dateSplit[1];
		String year = dateSplit[2];
		int month1 = Integer.parseInt(month);
		int day1 = Integer.parseInt(day);
		int year1 = Integer.parseInt(year);
		Date date1=new Date(month1,day1,year1);
		Date date2=new Date(date1);
		String[] monthName = new String[]{"January ", " February ", 
			"March ", "April ", "May ", "June ", "July ", "August ",
			"September ", "October ", "November ", "December "};
		String monthName1 = monthName[date1.getMonth() - 1]; //output
		String weekDay = findWeekDay(month1, day1, year1);		
		System.out.println("First day of class: "
				 + weekDay + monthName1 + date1.getDay() + "," + date1.getYear());
		System.out.println("Last day of class: " + weekDay + monthName1 + date2.getDay()+","
				+ date2.getYear());
		Scanner sc2=new Scanner(System.in);
		System.out.print("Enter the last day of class -> "); 
		String date2nd=sc2.nextLine();
		String[] date2ndSplit=date2nd.split("/");
		String month2 = date2ndSplit[0];
		String day2 = date2ndSplit[1];
		String year2 = date2ndSplit[2];
		int month2nd = Integer.parseInt(month2);
		int day2nd = Integer.parseInt(day2);
		int year2nd = Integer.parseInt(year2);
		date2.setDate(month2nd, day2nd, year2nd);
		String monthName2 = monthName[date2.getMonth() - 1]; 
		String weekDay2=findWeekDay(month2nd,day2nd,year2nd);
		System.out.printf("First day of class: " + weekDay + monthName1 + date1.getDay() +","
		+ date1.getYear());
		System.out.printf("%nLast day of class: " + weekDay2 + monthName2 + date2.getDay() +","
		+ date2.getYear());
		sc2.close();
		sc.close();
		
	}
	
	public static String findWeekDay(int month, int day, int year) {
		String[] weekDay = new String[] {"Sunday, " , "Monday, ", "Tuesday, ",
		"Wednesday, ", "Thursday ", "Friday, ", "Saturday, "};
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
