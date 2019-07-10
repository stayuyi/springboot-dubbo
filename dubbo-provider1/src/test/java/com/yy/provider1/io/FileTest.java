package com.yy.provider1.io;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.google.common.base.Utf8;
import com.google.common.collect.Maps;
import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.codehaus.plexus.util.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.util.*;
import sun.rmi.runtime.Log;

import javax.validation.constraints.Size;
import java.io.*;
import java.nio.file.Path;
import java.util.*;

/**
 * TODO 2019/3/17
 *
 * @author yuyi
 */
@Slf4j
public class FileTest {
	private String addZeroForNum(int num, int index) {
		return String.format(String.valueOf(new StringBuilder("%0").append(index).append("d")), num);
	}

	private static final String PATH = "/io/file/ioFile.txt";

	/*
	  写文件, 注意要判断path指定的file是否存在
	*/
	@Test
	public void test1() throws IOException {
		File file = new File(PATH);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		String context = "啦啦啦,啦啦啦";
		FileWriter fw = new FileWriter(PATH, true);
		int row = 1;
		BufferedWriter bfw = new BufferedWriter(fw);
		bfw.write("key1,key2,key3,key4,key5\n");
		while (row <= 1000) {
			bfw.write(new StringBuilder("划船不用桨,一生全靠浪").append(",").append(addZeroForNum(row, 16)).append(",").append(context).append("\n").toString());
//			fw.flush();
			row++;
		}
		bfw.close();
//		bfw.close(); 这里关闭流了,下面的 bfw1会报错 java.io.IOException: Stream closed

//		write()只是把数据写入缓冲区
//		flush()把缓冲区的数据写入文件,不关闭流,流还能继续使用
//		close 关闭流, 关闭前会把数据写入文件
//		多层流关闭,只需关闭最外层的流,既能关闭相关的内层流
//		从java7开始 实现AutoCloseable接口的类的对象可以通过声明在try代码中自动关闭,可以无需手动关闭,如下:
		/*
		try (BufferedWriter bfw1=new BufferedWriter(fw)){
			bfw1.write(new StringBuilder("划船不用桨,一生全靠浪").append(",").append(addZeroForNum(row, 16)).append(",").append(context).append("\n").toString());
		}
*/
/*
		try (BufferedWriter bfw1=new BufferedWriter(fw)){
			bfw1.write(new StringBuilder("划船不用桨,一生全靠浪").append(",").append(addZeroForNum(row, 16)).append(",").append(context).append("\n").toString());
		}catch (Exception e){
			log.info("there is an exception,because the stream is closed");
			log.info("there is an exception,because the stream is closed");
			log.info("there is an exception,because the stream is closed");
			e.printStackTrace();
		}
		//从上可以看到 try(流){}   在流运行完成后可以自动关闭流

		*/
	}

	/*
		读取文件
	 */
	@Test
	public void test2() throws IOException {
		FileReader fr = new FileReader(PATH);
		char[] buf = new char[1024];
		int num;
		//读取文件并把它存入buf中，用num返回读到字符的个数，一直读到结尾
		while ((num = fr.read(buf)) != -1) {
			//字符数组里仍有空白没有读入的位置，所以不要了
			//new String(字符串，开始位置，结尾位置)
			log.info(new String(buf, 0, num));
		}
		fr.close();
	}

	/*
		读取文件,按字段和分割符,存入map, 文本文件第一行为字段,之后全为数据
	 */
	@Test
	public void test3() throws IOException {
		List list = readText(10, 2);
	}


	/**
	 * @param rows 从第多少条数据开始读,不包括key这行
	 * @param size 读取多少行数
	 * @return
	 * @throws IOException
	 */
	public static List readText(int rows, int size) throws IOException {
//		FileReader fr=new FileReader(PATH);  这个不能指定encoding,源码建议用 inputStreamRead 来指定编码
		InputStreamReader isr = new InputStreamReader(new FileInputStream(PATH), "UTF-8");
		BufferedReader bfr = new BufferedReader(isr);
		int point = 0;//当前行数
		String firstLine = bfr.readLine();
		String[] keys = firstLine.split(",");
		String values = null;
		List<Map<String, String>> list = new ArrayList<>(size);
		rows--;
		while (null != (values = bfr.readLine())) {
			point++;
			if (point > rows) {
				String[] oneLine = values.split(",");
				Map<String, String> map = Maps.newHashMap();
				for (int i = 0; i < keys.length; i++) {
					map.put(keys[i], oneLine[i]);
				}
				list.add(map);
				System.out.println(map);
			}
			if (point - rows == size) {
				rows = point;
				break;
			}
		}
		log.info(list.toString());
		return list;
	}

	@Test
	public void readText123() {
		File file = null;
		try {
			file = ResourceUtils.getFile(PATH);
			String s = FileUtils.fileRead(file, "utf-8");
			log.info(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		IdGenerator idGenerator1 = new SimpleIdGenerator();
		IdGenerator idGenerator12 = new AlternativeJdkIdGenerator();
		IdGenerator idGenerator13 = new JdkIdGenerator();

		for (int i = 0; i < 1000; i++) {
			System.out.println(idGenerator1.generateId());
			System.out.println(idGenerator12.generateId());
			System.out.println(idGenerator13.generateId());
		}
	}
}


