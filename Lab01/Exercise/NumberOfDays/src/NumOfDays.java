import java.util.Scanner;
public class NumOfDays {
	public static int getMonths (String s) {
		switch (s) {
		case "1": case "Jan": case "January": return 1;
		case "2": case "Feb": case "February": return 2;
		case "3": case "Mar": case "March": return 3;
		case "4": case "Apr": case "April": return 4;
		case "5": case "May": return 5;
		case "6": case "Jun": case "June": return 6;
		case "7": case "Jul": case "July": return 7;
		case "8": case "Aug": case "August": return 8;
		case "9": case "Sep": case "September": return 9;
		case "10": case "Oct": case "October": return 10;
		case "11": case "Nov": case "November": return 11;
		case "12": case "Dec": case "December": return 12;
		default: return -1;
		}
	}
	public static int getDays (int month, int year) {
		boolean checkLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
		case 4: case 6: case 9: case 11: return 30;
		case 2: return checkLeap ? 29: 28;
		default: return -1;
		}
	}
	public static void main (String[] args) {
		Scanner keyboard = new Scanner (System.in);
		int month, year;
		while (true) {
			System.out.print("Enter year: ");
			year= keyboard.nextInt();
			if (year >=0) break;
			System.out.println("Invalid year. Try again");
		}
		
		keyboard.nextLine();
		
		while (true) {
			System.out.print("Enter month: ");
			String m = keyboard.nextLine();
			month = getMonths (m);
			if (month != -1) break;
			System.out.println ("Invalid month. Try again");
		}
		int day= getDays (month, year);
		System.out.println ("Number of days: " + day);
	}
}
