import java.util.*;
public class DateDemo3 {
	public static void main(String[]args) {
		System.out.print("Enter the first day of class -> ");
		Scanner sc = new Scanner(System.in);
		String date = sc.nextLine();
		String month = date.split("/")[0];
		String day = date.split("/")[1];
		String year = date.split("/")[2];
		int month1 = Integer.parseInt(month);
		int day1 = Integer.parseInt(day);
		int year1 = Integer.parseInt(year);		
		Date date1 = new Date(month1, day1, year1);
		Date date2 = new Date(date1);
		String[] monthName = new String[]{"January ", " February ", 
			"March ", "April ", "May ", "June ", "July ", "August ",
			"September ", "October ", "November ", "December "};
		String monthName1 = monthName[date1.getMonth() - 1]; 
		String weekDay = findWeekDay(month1, day1, year1);		
		System.out.printf("%nFirst day of class: %s%s%d, %d " , weekDay , monthName1 
						   , date1.getDay() , date1.getYear());
		System.out.printf("%nLast day of class: %s%s%d, %d " , weekDay , monthName1 
						   , date2.getDay() , date2.getYear());	
		System.out.printf("%n%nEnter the last day of class -> ");
		String date4 = sc.nextLine();
		String month2 = date4.split("/")[0];
		String day2 = date4.split("/")[1];
		String year2 = date4.split("/")[2];
		int month3 = Integer.parseInt(month2);
		int day3 = Integer.parseInt(day2);
		int year3 = Integer.parseInt(year2);
		date2 = new Date(month3, day3, year3);
		String monthName2 = monthName[date2.getMonth() - 1];
		System.out.printf("%nFirst day of class: %s%s%d, %d " , weekDay , monthName1 
				   , date1.getDay() , date1.getYear());
		weekDay = findWeekDay(month3, day3, year3);	
		System.out.printf("%nLast day of class: %s%s%d, %d " , weekDay , monthName2 
				   , date2.getDay() , date2.getYear());		
	}
	public static String findWeekDay(int month, int day, int year) {
		String[] weekDay = new String[] {"Sunday, " , "Monday, ", "Tuesday, ",
		"Wednesday, ", "Thursday, ", "Friday, ", "Saturday, "};
		int[] monthx = {0, 0, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
		if(year % 4 == 0 && year % 100 != 0|| year % 400 == 0) { 
			monthx[0] = 6;
			monthx[1] = 2;
		}		
		else {
			monthx[0] = 0;
			monthx[1] = 3;
		}
		int century = year / 100;
		int v = year % 100;
		int w, x, y;
		int u = 2*(3-(century % 4));
		w = v / 4;
		x = monthx[month - 1];
		y = (u + v + w + x + day) % 7;
		String weekDay1 = weekDay[y];
		return weekDay1;	
	}
}



