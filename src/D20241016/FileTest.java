package D20241016;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File d = new File(args[0]);

        if (d.isDirectory() || !d.exists()) {
            System.out.println(args[0] + "은 디렉토리가 아닙니다.");
            System.exit(0);
        }

        File[] files = d.listFiles();

        for (int i = 0; i < files.length; i++) {
            System.out.println("파일이름 = " + files[i].getName());
            System.out.println("파일경로 = " + files[i].getPath());
            System.out.println("절대경로 = " + files[i].getAbsolutePath());
            System.out.println("디렉토리 = " + files[i].getParentFile());
            System.out.println("읽기가능 = " + files[i].canRead());
            System.out.println("쓰기가능 = " + files[i].canWrite());
            System.out.println("파일크기 = " + files[i].length());
            System.out.println();
        }
    }
}
