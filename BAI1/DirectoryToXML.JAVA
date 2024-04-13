package bai1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirectoryToXML {
    public static void main(String[] args) {
        String path;
        if (args.length > 0) {
            path = args[0];
        } else {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Nhập đường dẫn của thư mục: ");
            path = scanner.nextLine();
            scanner.close();
        }
        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Thư mục không tồn tại hoặc không hợp lệ.");
            return;
        }
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlBuilder.append("<directory>\n");
        listFilesAndDirectories(directory, xmlBuilder);

        xmlBuilder.append("</directory>");
        try {
            FileWriter writer = new FileWriter("directory.xml");
            writer.write(xmlBuilder.toString());
            writer.close();
            System.out.println("Cây thư mục đã được lưu vào file directory.xml");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file XML: " + e.getMessage());
        }
    }
    private static void listFilesAndDirectories(File directory, StringBuilder xmlBuilder) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    xmlBuilder.append("<").append(file.getName()).append(">\n");
                    listFilesAndDirectories(file, xmlBuilder);
                    xmlBuilder.append("</").append(file.getName()).append(">\n");
                } else {
                    xmlBuilder.append("<file>").append(file.getName()).append("</file>\n");
                }
            }
        }
    }
}
