package Day16;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class TestExer {
	// 使用字符流内容的输出
	@Test
	public void test2() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("test1.txt"));
			String str = "反倒是伏尔泰认为问题二哥和地方干活地方换个\n" + "好突然黑寡妇东方大厦好同时归属感说过话是非观生个给你\n" + "好吗同时黑鬼u骄傲收购和Aug安徽省打工议案嘎嘎地个爱u干哈\n"
					+ "复合钢板夸ifs爱过阿斯顿iucn";
			bw.write(str);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 使用字节流内容的输出
	@Test
	public void test1() {
		BufferedOutputStream bos = null;

		try {
			FileOutputStream fos = new FileOutputStream(new File("test.txt"));
			bos = new BufferedOutputStream(fos);

			String str = "反倒是伏尔泰认为问题二哥和地方干活地方换个" + "好突然黑寡妇东方大厦好同时归属感说过话是非观生个给你" + "好吗同时黑鬼u骄傲收购和Aug安徽省打工议案嘎嘎地个爱u干哈"
					+ "复合钢板夸ifs爱过阿斯顿iucn";
			bos.write(str.getBytes());
			bos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
