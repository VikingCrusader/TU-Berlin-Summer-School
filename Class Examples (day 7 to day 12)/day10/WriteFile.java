package day10;
import java.io.*;

public class WriteFile {
    public static void main(String[] args) {
        String filePath = "/Users/hallowelt/eclipse-workspace/TUB.project/src/data/data1"; // 文件路径

        // 写入文件
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Hello, this is a file write demo.\n");
            writer.write("Java makes file I/O easy.\n");
            System.out.println("✅ 写入成功！");
        } catch (IOException e) {
            System.out.println("❌ 写入时出错：" + e.getMessage());
        }

        // 读取文件
        System.out.println("📖 开始读取文件内容：");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("👉 " + line);
            }
        } catch (IOException e) {
            System.out.println("❌ 读取时出错：" + e.getMessage());
        }
    }
}
