package D20240925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuizDAO {

    Connection conn = null;

    public QuizDAO() {
        try {
            this.conn = DBCon.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertQuiz(Quiz quiz) {

        try {
            String qry = "INSERT INTO quiz(question, answer) VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, quiz.getQuestion());
            pstmt.setString(2, quiz.getAnswer());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Quiz> selectQuiz() {

        ArrayList<Quiz> quizList = new ArrayList<>();
        ResultSet rs = null;

        try {
            String qry = "SELECT * FROM quiz";
            PreparedStatement pstmt = conn.prepareStatement(qry);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setQuestion(rs.getString("question"));
                quiz.setAnswer(rs.getString("answer"));
                quizList.add(quiz);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return quizList;
    }



}
