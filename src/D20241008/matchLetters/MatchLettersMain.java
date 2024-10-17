package D20241008.matchLetters;

import java.util.Scanner;

public class MatchLettersMain {

    public static void main(String[] args) {

        MatchLetters ml = new MatchLetters();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("단어 : " + ml.getCurLetter());
            System.out.println("뜻 : " + ml.getMean());
            System.out.println("문자를 하나 입력하세요");
            char c = sc.next().charAt(0);

            int res = ml.chkLetter(c);
            if (res == 0){
                System.out.println("");
                System.out.println("존재하는 문자열입니다. 문자열에 추가합니다.");
            }else if (res == -1){
                System.out.println("");
                System.out.println("존재하는 않는 문자열입니다.");
            }else{
                System.out.println("");
                System.out.println("문자를 모두 맞추었습니다. 종료합니다.");
                System.out.println(ml.getCnt() + "회 진행하여 맞추었습니다.");
                break;
            }

        }
        
    }
}
