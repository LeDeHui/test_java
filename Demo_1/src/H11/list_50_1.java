package H11;
/*
 * ×Ö·û´®Óë×Ö·ûÊı×é
 * */
public class list_50_1 {

	public static void main(String[] args) {
//		String string = "helloorld";
//		char [] result = string.toCharArray();
//		 
//		for (int i = 0; i < result.length; i++) {
//			result[i] -= 32;  
//		}
//		String newstrString = new  String(result);
//		System.out.println(newstrString);
//		System.out.println(new String(result,0,5));
		
		System.out.println(isNumber("123456"));
	}
	public static boolean isNumber(String str) {
		char [] result = str.toCharArray(); 
		for (int i = 0; i < result.length ; i++) {
			 if (result[i]  <  '0' || result[i] > '9') {
				 return false;
			 }
		}
		return true;
	}

}
