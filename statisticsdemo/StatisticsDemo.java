package statisticsdemo;

import java.util.Arrays;

public class StatisticsDemo 
{
    public static void main(String[] args) 
    {
        Student[] students = new Student[6];        
        students[0] = new Student("Mary ", 85, 93, 97);
        students[1] = new Student("Bob  ", 67, 77, 71);
        students[2] = new Student("Tom  ", 85, 91, 89);
        students[3] = new Student("Anna ", 79, 72, 80);
        students[4] = new Student("Hal  ", 96, 88, 99);
        students[5] = new Student("Gina ", 89, 91, 82);
        System.out.println("Students:  "+ Arrays.toString(students)+"\n");
        double avg[] = averages(students);
        System.out.printf("Average Exam 1 Grade = %.2f\n", avg[0]);
        System.out.printf("Average Exam 2 Grade = %.2f\n", avg[1]);
        System.out.printf("Average Final Exam Grade = %.2f\n", avg[2]);
        System.out.printf("Average Course Grade = %.2f\n", avg[3]);
        Arrays.sort(students);
        System.out.println("\nAfter sorting students by course grade,\nStudents:  " + 
        				   Arrays.toString(students));
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Sara ", 68, 19, 5473);
        employees[1] = new Employee("Sam  ", 51, 18, 5829);
        employees[2] = new Employee("Lisa ", 47, 16, 3892);
        employees[3] = new Employee("Jim  ", 33, 21, 4857);
        employees[4] = new Employee("Judy ", 39, 23, 4295);
        System.out.println("\nEmployees:  " + Arrays.toString(employees));
        double avg1[] = averages(employees);
        System.out.printf("\nAverage Hours = %.2f\n", avg1[0]);
        System.out.printf("Average Rate = %.2f\n", avg1[1]);
        System.out.printf("Average Sales = %.2f\n", avg1[2]);
        System.out.printf("Average Net Pay = %.2f\n", avg1[3]);
        Arrays.sort(employees);
        System.out.println("\nAfter sorting employees by net pay,\nEmployees:  " + 
        				   Arrays.toString(employees));
    }
    public static double[] averages(Measureable[] objects)
    {
    double sum = 0;
    double sum1 = 0;
    double sum2 = 0;
    double sum3 = 0;
    double[]avg = new double[4];
    int n = objects.length;
   for(int i = 0;i < n;i++){
        sum += objects[i].getFirstInt();
        avg[0] = sum/n; }
    for(int i = 0;i < n;i++){
        sum1 += objects[i].getSecondInt();
        avg[1] = sum1/n; }
     for(int i = 0;i < n;i++){
        sum2 += objects[i].getThirdInt();
        avg[2] = sum2/n; }
    for(int i = 0;i < n;i++){
        sum3 += objects[i].getDouble();
        avg[3] = sum3/n; }
    return (avg);
    }
}

