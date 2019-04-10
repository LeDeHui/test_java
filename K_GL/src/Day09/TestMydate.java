package Day09;
/*
 * 
 * 
 */
public class TestMydate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mydate m1 = new Mydate(14,3,1976);
		Mydate m2 = new Mydate(14,3,1976);
		if (m1==m2) {
			System.out.println("m1=m2");
		}else {
			System.out.println("m1!=m2");
		}
		
		if (m1.equals(m2)) {
			System.out.println("m1 is equal to m2");
		}else {
			System.out.println("m1 is not equal to m2");
		}

	}

}
class Mydate{
	private int day;
	private int month;
	private int year;
	
	public Mydate() {
		super();
	}
	public Mydate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mydate other = (Mydate) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}else if (obj instanceof Mydate) {
//			Mydate m1 = (Mydate) obj;
//			return this.day == m1.day 
//					&& this.month == m1.month
//					&& this.year == m1.year;
//			 
//		} else {
//			return false;
//		}
//	}
	
	
}
