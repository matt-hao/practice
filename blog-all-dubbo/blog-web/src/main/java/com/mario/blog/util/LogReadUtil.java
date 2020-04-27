package com.mario.blog.util;

import java.io.*;

public class LogReadUtil {

	public static void readFileByBytes(String fileName) {
		File file = new File(fileName);
		InputStream in = null;

		try {
			// 一次读一个字节
			in = new FileInputStream(file);
			int tempbyte;
			while ((tempbyte = in.read()) != -1) {
				System.out.write(tempbyte);
				// System.out.write('\n');
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		try {
			// 一次读多个字节
			byte[] tempbytes = new byte[100];
			int byteread = 0;
			in = new FileInputStream(fileName);
			LogReadUtil.showAvailableBytes(in);
			// 读入多个字节到字节数组中，byteread为一次读入的字节数
			while ((byteread = in.read(tempbytes)) != -1) {
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public static void readFileByChars(String fileName) {
		File file = new File(fileName);
		Reader reader = null;

		try {
			// 一次读一个字符
			reader = new InputStreamReader(new FileInputStream(file));
			int tempchar;
			while ((tempchar = reader.read()) != -1) {
				// 对于windows下，\r\n这两个字符在一起时，表示一个换行。
				// 但如果这两个字符分开显示时，会换两次行。
				// 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
				if (((char) tempchar) != '\r') {
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// 一次读多个字符
			char[] tempchars = new char[30];
			int charread = 0;
			reader = new InputStreamReader(new FileInputStream(fileName));
			// 读入多个字符到字符数组中，charread为一次读取字符数
			while ((charread = reader.read(tempchars)) != -1) {
				// 同样屏蔽掉\r不显示
				if ((charread == tempchars.length)
						&& (tempchars[tempchars.length - 1] != '\r')) {
				} else {
					for (int i = 0; i < charread; i++) {
						if (tempchars[i] == '\r') {
							continue;
						} else {
						}
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public static String readFileByRandomAccess(int m) {
		String result = null;
		RandomAccessFile randomFile = null;
		try {

			// 打开一个随机访问文件流，按只读方式
			switch (m) {
			case 0:
				randomFile = new RandomAccessFile(
						"/applog/log4j/futureLife/app.log", "r");
				break;

			case 1:
				randomFile = new RandomAccessFile(
						"E://var/app.log",
						"r");
				break;
			default:
				randomFile = new RandomAccessFile(
						"/www//applog/uphone.3g.tianya.cn/mobile_impl_test.txt",
						"r");
				break;
			}

			// randomFile = new
			// RandomAccessFile("/www/applog/tianya_message_component/app.log.2013-07-03",
			// "r");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 读文件的起始位置
			// int beginIndex = (fileLength > 4) ? 4 : 0;
			// 将读文件的开始位置移到beginIndex位置。
			randomFile.seek(fileLength - 50000 < 0 ? 0 : fileLength - 50000);
			byte[] bytes = new byte[50000];
			int byteread = 0;
			String a = null;
			// 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
			// 将一次读取的字节数赋给byteread

			if ((byteread = randomFile.read(bytes)) != -1) {
				result = new String(bytes, "utf-8");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (IOException e1) {
				}
			}
		}
		return result;
	}

	private static void showAvailableBytes(InputStream in) {
		try {
			System.out.println("当前字节输入流中的字节数为:" + in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
