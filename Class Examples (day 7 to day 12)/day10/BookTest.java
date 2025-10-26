package day10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookTest {
	public static void main(String[] args) {
		// 创建书本对象
		Book book1 = new Book("Lord of the Ring", "Tollking", 33.9);
		Book book2 = new Book("Rich dad poor dad", "Robert", 13.4);
		Book book3 = new Book("Harry Potter", "JK Rolling", 5.9);

		// 添加到列表
		List<Book> myData = new ArrayList<>();
		myData.add(book1);
		myData.add(book2);
		myData.add(book3);

		// 保存的文件路径（确保该路径存在）
		String filePath = "/Users/hallowelt/eclipse-workspace/TUB.project/src/data/bookData";

		// 1. 序列化（写入文件）
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
			out.writeObject(myData);
			System.out.println("✅ 图书列表成功写入到文件！");
		} catch (IOException e) {
			System.out.println("❌ 写入时发生错误：" + e.getMessage());
		}

		// 2. 反序列化（读取文件）
		System.out.println("\n📖 正在从文件读取数据：");
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
			List<Book> readData = (List<Book>) in.readObject();
			for (Book b : readData) {
				System.out.println("👉 " + b);
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("❌ 读取时发生错误：" + e.getMessage());
		}
	}
}
