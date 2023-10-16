//class prints first and last day of class
//name
//csc 1351 - 02
//azhou2
//1/15/2021
import java.util.*;
public class DateDemo {
	public static void main(String[]args) {
		int y = 0;
		int day1 = 0;
		int year1 = 0;
		String date;
		String weekDay = "";
		String monthName1 = "";
		for(int i = 0; i < 2; i++) {
		if (y == 0) { 
			System.out.print("Enter the first day of class -> "); 
			Scanner sc = new Scanner(System.in);
			date = sc.nextLine();
		}
		else {
			System.out.print("Enter the last day of class -> ");
			Scanner sc = new Scanner(System.in);
			date = sc.nextLine();
			System.out.println("First day of class: " + weekDay + monthName1 
					   + day1 + ", " + year1);
		}
		String month = date.split("/")[0];
		String day = date.split("/")[1];
		String year = date.split("/")[2];
		int month1 = Integer.parseInt(month);
		day1 = Integer.parseInt(day);
		year1 = Integer.parseInt(year);	
		String month2 = date.split("/")[0];
		String day2 = date.split("/")[1];
		String year2 = date.split("/")[2];
		int month3 = Integer.parseInt(month2);
		int day3 = Integer.parseInt(day2);
		int year3 = Integer.parseInt(year2);			
		Date date1 = new Date(month1, day1, year1);
		Date date2 = new Date(date1);
		String[] monthName = new String[]{"January ", " February ", 
			"March ", "April ", "May ", "June ", "July ", "August ",
			"September ", "October ", "November ", "December "};
		monthName1 = monthName[date1.getMonth() - 1]; //output
		weekDay = findWeekDay(month1, day1, year1);		
		if(y == 0) {
		System.out.println("First day of class: " + weekDay + monthName1 
						   + date1.getDay() + ", " + date1.getYear());
		y += 1;
		}
		System.out.println("Last day of class: " + weekDay + monthName1 
						   + date2.getDay() + ", " + date2.getYear());
		}
	}
	public static String findWeekDay(int month, int day, int year) {
		String[] weekDay = new String[] {"Sunday, " , "Monday, ", "Tuesday, ",
		"Wednesday, ", "Thursday ", "Friday, ", "Saturday, "};
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



