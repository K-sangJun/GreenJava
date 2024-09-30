package D20240930;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class MyVIPMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MyVIPDAO dao = new MyVIPDAO();
        ArrayList<MyVIPDTO> arr = dao.select();

        for (MyVIPDTO dto : arr) {
            System.out.println(dto.toString());
        }

        MyVIPDTO dto = new MyVIPDTO();

        System.out.println("이름을 입력하세요");
        dto.setName(sc.next());
        System.out.println("날짜를 입력하세요");
        dto.setBirth(Date.valueOf(sc.next()));

        int result = dao.insert(dto);
        System.out.println(result);
    }

}
