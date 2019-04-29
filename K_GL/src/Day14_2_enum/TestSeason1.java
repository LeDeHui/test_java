package Day14_2_enum;

/*
 * һ��ö����
 * 1.��ζ���ö����    -->TestSeason
 * 2.���ʹ��enum�ؼ��ֶ���ö����
 * 		>���÷���:values() ,valuesof(String name)
 * 		>�����ö����ʵ�ֽӿ�:�����ò�ͬ��ö���������ñ���д�ĳ��󷽷���ִ�еĲ�ͬЧ��
 * 			�൱����ÿ��������д���󷽷�
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
		// 2.valuesof(String name):Ҫ������β���ô��ö�ٶ�������֣����򱨴��쳣
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

// ö����
enum Season1 implements Info {
	//�����ö����ʵ�ֽӿ�
	SPRING("Sping", "��ů����") {
		public void show() {
			System.out.println("����");
		}
	},
	SUMMER("summer", "�������� ") {
		public void show() {
			System.out.println("����");
		}
	},
	AUTUMN("autumn", "�����ˬ") {
		public void show() {
			System.out.println("����");
		}
	},
	WINTER("winter", "��ѩ����") {
		public void show() {
			System.out.println("����");
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
//		System.out.println("����һ������");
//	}

}