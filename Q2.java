import java.util.Scanner;
import java.util.Random;
public class Q2 {

	
	public int[][] shuffles(int[][] arr) {
		Random r = new Random();
		
		for(int i=0; i< arr.length; i++) {
			for(int j=0; j <arr[0].length; j++) {
				int a = r.nextInt(arr.length);
				int b = r.nextInt(arr[0].length);
				int temp = arr[i][j];
				arr[i][j] = arr[a][b];
				arr[a][b] = temp;
		
			}
		}
		return arr;
		
		
	}
	public static void main(String[] args) {
		
		Q2 p = new Q2();
		boolean run = true;
		int[][] chart1 = new int[][] {
			{1,2,2,7},
			{5,1,6,8},
			{3,4,3,8},
			{6,5,7,4}
		};
		
		String[][] chart2 = new String[][] {
			{"*","*","*","*"},
			{"*","*","*","*"},
			{"*","*","*","*"},
			{"*","*","*","*"}
		};
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("This is a memory matching game!!");
		System.out.println("You need to select two card.");
		System.out.println("Do not forget coordinates are from 1 to 4.");
		
		System.out.println("The cards places is: ");
		for(int i=0; i< chart2.length ; i++) {
			for(int j=0; j < chart1[0].length ; j++) {
				System.out.print(chart2[i][j] + " ");
			}
			System.out.println();
		}
			
		chart1 = p.shuffles(chart1);
		
		
		do {	
		System.out.println("Please enter coordinates of your first card. (Such as 1 3) (Row) (Column)");
		int coordinatex1 = scan.nextInt();
		int coordinatex2 = scan.nextInt();
		System.out.println("Please enter coordinates of your second card. (Such as 4 2) (Row) (Column)");
		int coordinatey1 = scan.nextInt();
		int coordinatey2 = scan.nextInt();
		
		
		
		String aString = Integer.toString(chart1[coordinatex1-1][coordinatex2-1]);
		String aString2 = Integer.toString(chart1[coordinatey1-1][coordinatey2-1]);
		
		if(!chart2[coordinatex1-1][coordinatex2-1].equals("*")||!chart2[coordinatey1-1][coordinatey2-1].equals("*")) {
			System.out.println("You cannot choose a card that already face up!!");
			System.out.println("Try another card.");
			continue;
		}
		chart2[coordinatex1-1][coordinatex2-1] = aString;
		chart2[coordinatey1-1][coordinatey2-1] = aString2;
		
		System.out.println("The cards are: ");
		for(int i=0; i< chart2.length ; i++) {
			for(int j=0; j < chart1[0].length ; j++) {
				System.out.print(chart2[i][j] + " ");
			}
			System.out.println();
		}
		
		if(aString.equals(aString2)) {
			System.out.println("You have a match!!");
			System.out.println("Let's try another match.");
			
		}else {
			System.out.println("You don't have a match!!");
			System.out.println("Let's try another match.");
			chart2[coordinatex1-1][coordinatex2-1] = "*";
			chart2[coordinatey1-1][coordinatey2-1] = "*";
		}
		for(int i=0; i< chart2.length; i++) {
			for(int j=0; j< chart1[0].length; j++) {
				if(chart2[i][j].equals("*")) {
					run = true;
				}
				else {
					run = false;
				}
			}
		}
		}while(run);
		
		System.out.println("Congrats you find all of the cards");
		for(int i=0; i< chart2.length ; i++) {
			for(int j=0; j < chart1[0].length ; j++) {
				System.out.print(chart1[i][j] + " ");
			}
			System.out.println();
		}

		

	}

}
