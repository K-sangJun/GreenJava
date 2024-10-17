package D20241010;

interface Printable{
    void print();
}

class Paper{
    private String comment;

    public Paper(String s){
        comment = s;
    }

    class Printer implements Printable{
        public void print(){
            System.out.println(comment);
        }
    }

    public Printable getPrinter(){
        return new Printer();
    }

    public Printable getPrintable(){
//        class Printer implements Printable{
//            public void print(){
//                System.out.println(comment);
//            }
//        }
//        return new Printer();
        return new Printable() { //익명내부클래스
            public void print() {
                System.out.println(comment);
            }
        };
    }
}

public class UseMemberInner {
    public static void main(String[] args) {
        Paper paper = new Paper("이건 종이랑께");
        paper.getPrinter().print();
    }
}
