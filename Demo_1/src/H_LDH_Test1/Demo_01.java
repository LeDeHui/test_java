package H_LDH_Test1;
 

class Person {
	private String nameString;
	private int ageInt;

	public Person(String nameString, int ageInt) {
		this.nameString = nameString;
		this.ageInt = ageInt;
	}

	public void show() {
		System.out.println("name : " + nameString + " age : " + ageInt);
	}
}
class ArrayUtil{
	public static void sort(int date[]) {
		for (int x = 0 ; x<date.length;x++) {
			for (int y = x+1 ; y<date.length;y++) {
				if (date[x] <   date[y]) {
					date[x] = date[x]^date[y];
					date[y] = date[x]^date[y];
					date[x] =date[x]^date[y];
				}
			}
		}
		 
		 
	}
	
	public static void reveres(int date[]) {
		int center = date.length ;
		for (int i = 0; i < center/2; i++) {
			date[i] = date[i]^date[center-1-i];
			date[center-1-i] = date[i]^date[center-1-i];
			date[i] = date[i]^date[center-1-i];
			
		}
		 
	}
	public static void printArray(int date[]) {
		for (int i : date) {
			System.out.print (i + " ");
		}
	}
}

public class Demo_01 {
	public static void main(String[] ages) {
		int date [] = new  int [] {1,7,4,8,9,23,56,11,0};
		ArrayUtil.sort(date); 
		ArrayUtil.printArray(date);
		System.out.println();
		ArrayUtil.reveres(date);
		ArrayUtil.printArray(date);
		 
		
//		Person person1 = new Person("ÍõÎå", 23) ;
//		person1.show();
		
//		int i[] = new int[] {1,2,3,4,5,6,117,8};
//		for (int j : i) {
//			System.out.println(i);
//			System.out.println(j);
//		}
//		int date1[][] = new int[][] { { 1, 2, 3, 4, 5 }, { 1, 3, 5, 7 }, { 6, 7, 8, 9, 0 } };
//		for (int[] js : date1) {
//			for (int is : js) {
//				System.out.print(is + " ");
//			}
//			System.out.println();
//		}

	}

}
