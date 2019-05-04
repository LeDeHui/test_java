package Day15;
/* 
 * --->package  Day15_1_File 
 * --->TestFile
 * java.io.File类
 * 1.凡是与输入,输出相关的类,接口都定义在java.io包下
 * 2.File是一个类,可以有构造器创建其对象,此对象对应着一个文件( .txt .avi .doc 等等)或文件目录
 * 3.File 类对象是与平台无关的. 
 * 4.File中的方法  仅涉及到如何创建，删除，重命名等等，只要涉及文件内容的，File是无能为力的，必须又io流完成
 * 5.File类的对象常作为io流的具体类的构造器的形参。
 * 
 * */

/*
 * --->package Day15_2_IO
 * --->TestFileInOutputStream
 * --->TestFileReaderWriter
 * 1.流的分类
 *	按照数据流向的不同：输入流，输出流
 *	按照处理数据的单位不同：字节流	字符流（处理的文本文件）
 * 	按照角色的不同：节点流（直接作用于文件）	处理流
 *
 * 2.IO 的体系
 * 			抽象基类			节点流（文件流）			缓冲流
 *	非文本 	InputStream		FileInputStream		BufferedInputStream
 *	非文本	OutputStream	FileOutputStream	BufferedOutputStream
 * 	文本 		Reader			FileReader			BufferedReader
 *	文本		Writer			FileWriter			BufferedWriter
 *
 * */
public class day15 {

}
