package D20241016;

import java.io.*;

public class FileTest2 {
    public static void main(String[] args) {
//        지정된 두개의 디렉토리를 파일객체로 만든다.
        String dir1 = "C:/KSJ/fileTest";
        String dir2 = "C:/KSJ/fileTest2";

        File source = new File(dir1);
        File destination = new File(dir2);

//        2개의 파일객체에서 경로명만 추출한다.
        String spath = source.getPath();
        String dpath = destination.getPath();

//        원본 디렉토리의 파일 이름들을 문자열 배열에 저장하고, 사본 디렉토리를 만든다.
        String[] fileNames = source.list();

        destination.mkdir();

        int fileData = 0;
        for (int i = 0; i < fileNames.length; i++) {
//            경로와 fileName 배열에 있는 파일 이름을 결합해서
//            파일을 읽고, 기록할 수 있는 fileReader와 FileWriter 객체를 만든다.
            try {
                FileReader fr = new FileReader(spath + "/" + fileNames[i]);
                FileWriter fw = new FileWriter(dpath + "/" + fileNames[i]);

//                원본 디렉토리의 파일의 내용을 읽어서 사본 디렉토리에 기록한다.
                while ((fileData = fr.read()) != -1) {
                    fw.write(fileData);
                }
                System.out.println("copied file : " + fileNames[i]);
                fr.close();
                fw.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
