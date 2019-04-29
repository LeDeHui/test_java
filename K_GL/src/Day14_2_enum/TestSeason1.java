package Day14_2_enum;

/*
 * 一，枚举类
 * 1.如何定义枚举类    -->TestSeason
 * 2.如何使用而怒骂关键字定义枚举类
 * 		>常用方法:values() ,valuesof(String name)
 * 		>如何让枚举类实现接口:可以让不同的枚举类对象调用被重写的抽象方法，执行的不同效果
 * 			相当于让每个对象重写抽象方法
 * */
public class TestSeason1 {
	public static void main(String[] args) {
		Season1 springSeason = Season1.SPRING;
		System.out.println(springSeason);
		springSeason.show();
		System.out.println(springSeason.getSeasonDesc());
		System.out.println();
		// 1.values()
		Season1[] season1s = Season1.values();
		for (int i = 0; i < season1s.length; i++) {
			System.out.println(season1s[i]);
		}
		// 2.valuesof(String name):要求传入的形参那么是枚举对象的名字；否则报错异常
		// java.lang.IllegalArgumentException:
		String string = "SUMMER";
		Season1 sea = Season1.valueOf(string);
		System.out.println(sea);
		System.out.println();

		Thread.State[] states = Thread.State.values();
		for (int i = 0; i < states.length; i++) {
			System.out.println(states[i]);
		}
	}
}

interface Info {
	void show();
}

// 枚举类
enum Season1 implements Info {
	//如何让枚举类实现接口
	SPRING("Sping", "村暖花开") {
		public void show() {
			System.out.println("春天");
		}
	},
	SUMMER("summer", "夏日炎炎 ") {
		public void show() {
			System.out.println("夏天");
		}
	},
	AUTUMN("autumn", "秋高气爽") {
		public void show() {
			System.out.println("秋天");
		}
	},
	WINTER("winter", "白雪皑皑") {
		public void show() {
			System.out.println("冬天");
		}
	};

	private final String seasonName;
	private final String seasonDesc;

	private Season1(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}

//	public void show() {
//		System.out.println("这是一个季节");
//	}

}