package D20240930.Board.VIEW.Admin;

import D20240930.Board.DAO.BoardDAO;
import D20240930.Board.DAO.CommentDAO;
import D20240930.Board.DTO.BoardDTO;
import D20240930.Board.DTO.CommentDTO;
import D20240930.Board.DTO.UserDTO;
import D20240930.Board.VIEW.ViewUtill;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardAdminView {

    private static final String[] menuList = {"게시글조회", "게시글작성", "상세보기"};
    private static final String[] detailMenuList = {"게시글수정", "게시글삭제", "댓글작성"};
    private static final Scanner sc = new Scanner(System.in);
    private static UserDTO userDTO = new UserDTO();
    private static BoardDAO boardDAO = new BoardDAO();
    private static CommentDAO commentDAO = new CommentDAO();

    public void start(UserDTO user) {

        boolean flag = true;
        userDTO = user;

        while (flag) {
            String menuChoice = getMenuNum();
            flag = menuAct(menuChoice);
        }
    }

    private String getMenuNum() {
        String text = ViewUtill.makeString(menuList);

        return ViewUtill.scan(text);
    }

    private boolean menuAct(String menuChoice) {

        boolean result = true;
        if (Integer.parseInt(menuChoice) < menuList.length) ViewUtill.titleMsg(menuList[Integer.parseInt(menuChoice)]);


        switch (menuChoice) {
            case "0":
                selectBoard();
                break;
            case "1":
                insertBoard();
                break;
            case "2":
                readBoard();
                break;
            default:
                result = false;
                break;
        }

        return result;
    }

    private void insertBoard(){

        String[] columns = {"게시판구분", "제목", "내용"};

        BoardDTO boardDTO = new BoardDTO();

        for (int i = 0; i < columns.length; i++) {
            String msg = "작성할 " + columns[i] + "을(를) 입력하세요.";
            switch (i) {
                case 0:
                    boardDTO.setBGbn(ViewUtill.setGbnCd("b_gbn"));
                    break;
                case 1:
                    boardDTO.setTitle(ViewUtill.scan(msg));
                    break;
                case 2:
                    boardDTO.setDetail(ViewUtill.scan(msg));
                    break;
                default:
                    break;
            }
        }

        boardDTO.setInstId(userDTO.getId());
        boardDTO.setUpdtId(userDTO.getId());

        int result = boardDAO.insertBoard(boardDTO);
        if (result == -1) {
            ViewUtill.errMsg("게시판 작성에 실패 하였습니다.");
        }else{
            ViewUtill.sucMsg("게시판 작성에 성공 하였습니다.");
        }

    }

    private void selectBoard(){
        ArrayList<BoardDTO> boardList = boardDAO.selectAllBoard();
        for (BoardDTO board : boardList) {
            System.out.println(board.toString());
        }
    }
    
    private void readBoard(){
        selectBoard();
        int b_no = Integer.parseInt(ViewUtill.scan("내용을 볼 게시판을 선택해 주세요"));
        BoardDTO board = boardDAO.readBoard(b_no);
        System.out.println(board.toString());

        for (CommentDTO comment : board.getComments()) {
            System.out.println(comment.toString());
        }

        detailMenu(board);
    }

    private void detailMenu(BoardDTO board){
        
        String menuChoice = getdetailMenu();

        switch (menuChoice) {
            case "0":
                editBoard(board);
                break;
            case "1":
                deleteBoard(board);
                break;
            case "2":
                insertComment(board);
                break;
            default:
                break;
        }

    }

    private String getdetailMenu() {
        String text = ViewUtill.makeString(detailMenuList);
        return ViewUtill.scan(text);
    }

    private void editBoard(BoardDTO board){

        if (board.getInstId().equals(userDTO.getId())) {

            String[] columns = {"게시판구분", "제목", "내용"};

            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setBNo(board.getBNo());
            for (int i = 0; i < columns.length; i++) {
                String msg = "수정할 " + columns[i] + "을(를) 입력하세요.";
                switch (i) {
                    case 0:
                        boardDTO.setBGbn(ViewUtill.setGbnCd("b_gbn"));
                        break;
                    case 1:
                        boardDTO.setTitle(ViewUtill.scan(msg));
                        break;
                    case 2:
                        boardDTO.setDetail(ViewUtill.scan(msg));
                        break;
                    default:
                        break;
                }
            }

            boardDTO.setUpdtId(userDTO.getId());

            int result = boardDAO.updateBoard(boardDTO);
            if (result == -1) {
                ViewUtill.errMsg("게시판 수정에 실패 하였습니다.");
            } else {
                ViewUtill.sucMsg("게시판 수정에 성공 하였습니다.");
            }
        }else{
            ViewUtill.errMsg("동일한 작성자만 수정 할 수 있습니다.");
        }
    }

    private void deleteBoard(BoardDTO board){

        if (board.getInstId().equals(userDTO.getId())) {

            int result = boardDAO.deleteBoard(board);

            if (result == -1) {
                ViewUtill.errMsg("게시판 수정에 실패 하였습니다.");
            } else {
                ViewUtill.sucMsg("게시판 수정에 성공 하였습니다.");
            }
        }else{
            ViewUtill.errMsg("동일한 작성자만 수정 할 수 있습니다.");
        }

    }

    private void insertComment(BoardDTO board){

        String[] columns = {"댓글내용"};

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setBNo(board.getBNo());
        for (int i = 0; i < columns.length; i++) {
            String msg = "작성할 " + columns[i] + "을(를) 입력하세요.";
            switch (i) {
                case 0:
                    commentDTO.setCDetail(ViewUtill.scan(msg));
                    break;
                default:
                    break;
            }
        }

        commentDTO.setInstId(userDTO.getId());
        commentDTO.setUpdtId(userDTO.getId());

        int result = commentDAO.insertComment(commentDTO);
        if (result == -1) {
            ViewUtill.errMsg("댓글 작성에 실패 하였습니다.");
        } else {
            ViewUtill.sucMsg("댓글 작성에 성공 하였습니다.");
        }

    }

}
