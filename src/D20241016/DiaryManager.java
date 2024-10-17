package D20241016;

import java.io.*;
import java.util.ArrayList;

public class DiaryManager implements FileManagable {

    private static final String dir = "C:\\KSJ\\WS\\Java\\dbCon\\src\\D20241016\\diary";


    @Override
    public void regist(Diary diary) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir + "/" + diary.getFileName() + ".txt", true))) {
            writer.write(diary.getToday().toString());
            writer.newLine();
            writer.write(diary.getComment().toString());
            System.out.println("일기가 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("일기를 저장하는 동안 오류가 발생했습니다.");
        }
    }

    @Override
    public String get(String fileName) {

        String result = "";
        String data = "";
        try {
            FileReader fr = new FileReader(dir + "/" + fileName);
            BufferedReader br = new BufferedReader(fr);
            while ((data = br.readLine()) != null){
                result += "\n" + data;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();

        File[] files = new File(dir).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                list.add(file.getName());
            }
        }
        return list;
    }
}
