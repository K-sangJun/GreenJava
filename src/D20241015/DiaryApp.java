package D20241015;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiaryApp {
    private static final String DIARY_FILE = "diary.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== 일기장 메뉴 ===");
            System.out.println("1. 새 일기 작성");
            System.out.println("2. 일기 보기");
            System.out.println("3. 일기 수정");
            System.out.println("4. 종료");
            System.out.print("원하는 작업을 선택하세요: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    writeEntry();
                    break;
                case 2:
                    viewEntries();
                    break;
                case 3:
                    editEntry();
                    break;
                case 4:
                    System.out.println("일기장을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    // 1. 새 일기 작성 후 파일에 저장
    private static void writeEntry() {
        System.out.println("\n--- 새 일기 작성 ---");
        System.out.print("일기 내용을 입력하세요: ");
        String entry = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DIARY_FILE, true))) {
            writer.write(entry);
            writer.newLine();
            System.out.println("일기가 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("일기를 저장하는 동안 오류가 발생했습니다.");
        }
    }

    // 2. 저장된 모든 일기 불러오기
    private static void viewEntries() {
        List<String> entries = loadEntries();
        if (entries.isEmpty()) {
            System.out.println("\n저장된 일기가 없습니다.");
            return;
        }

        System.out.println("\n--- 저장된 일기 목록 ---");
        for (int i = 0; i < entries.size(); i++) {
            System.out.println((i + 1) + ": " + entries.get(i));
        }
    }

    // 3. 일기 수정하기
    private static void editEntry() {
        List<String> entries = loadEntries();
        if (entries.isEmpty()) {
            System.out.println("\n수정할 일기가 없습니다.");
            return;
        }

        System.out.println("\n--- 수정할 일기 선택 ---");
        for (int i = 0; i < entries.size(); i++) {
            System.out.println((i + 1) + ": " + entries.get(i));
        }

        System.out.print("수정할 일기의 번호를 입력하세요: ");
        int entryNumber = Integer.parseInt(scanner.nextLine());

        if (entryNumber < 1 || entryNumber > entries.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        System.out.print("새로운 일기 내용을 입력하세요: ");
        String newContent = scanner.nextLine();
        entries.set(entryNumber - 1, newContent);

        // 수정된 내용을 파일에 다시 저장
        saveEntries(entries);
        System.out.println("일기가 수정되었습니다.");
    }

    // 파일에서 일기 목록을 불러오는 메서드
    private static List<String> loadEntries() {
        List<String> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DIARY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                entries.add(line);
            }
        } catch (IOException e) {
            System.out.println("일기를 불러오는 동안 오류가 발생했습니다.");
        }
        return entries;
    }

    // 수정된 일기 목록을 파일에 저장하는 메서드
    private static void saveEntries(List<String> entries) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DIARY_FILE))) {
            for (String entry : entries) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("일기를 저장하는 동안 오류가 발생했습니다.");
        }
    }
}
