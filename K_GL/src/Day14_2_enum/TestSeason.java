package Day14_2_enum;

import javax.swing.Spring;

public class TestSeason {
public static void main(String[] args) {
	Season springSeason = Season.AUTUMN;
	System.out.println(springSeason);
	System.out.println(springSeason.getSeasonDesc());
}
}

// 枚举类
class Season {
	// 1.提供类的属性声明为private final
	private final String seasonName;
	private final String seasonDesc;

	// 2.声明为final的属性在构造器中初始化
	private Season(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	// 3.通过公共的方法来调用属性
	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}

	// 4.创建枚举类的对象:将类的对象声明为public static final
	public static final Season SPRING = new Season("Sping", "村暖花开");
	public static final Season SUMMER = new Season("summer", "夏日炎炎 ");
	public static final Season AUTUMN = new Season("autumn", "秋高气爽");
	public static final Season WINTER = new Season("winter", "白雪皑皑");

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}

	public void show() {
		System.out.println("这是一个季节");
	}

}