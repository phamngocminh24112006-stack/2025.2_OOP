import java.util.Scanner;
public class MatrixSum {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner (System.in);
		System.out.print ("Enter rowNum: ");
		int row= keyboard.nextInt();
		System.out.print ("Enter colNum: ");
		int col= keyboard.nextInt();
		int [][]a = new int [row][col];
		int [][]b = new int [row][col];
		int [][]c = new int [row][col];
		for (int i=0;i<row;i++){
			for (int j=0;j<col;j++){
				a[i][j]= keyboard.nextInt();
			}
		}
		for (int i=0;i<row;i++){
			for (int j=0;j<col;j++){
				b[i][j]= keyboard.nextInt();
			}
		}
		for (int i=0;i<row;i++){
			for (int j=0;j<col;j++){
				c[i][j]= a[i][j]+b[i][j];
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
}
