package D20240925;

public class Quiz {

    private int qno;
    private String question;
    private String answer;

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return
                "번호: " + qno +
                ", 질문: " + question +
                ", 답: " + answer;
    }
}
