package D20241016;

import java.util.ArrayList;

public interface FileManagable {

//    파일등록
    void regist(Diary diary);

//    파일조회
    String get(String fileName);

//    파일목록

    ArrayList getList();

}
