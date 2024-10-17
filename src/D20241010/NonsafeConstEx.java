package D20241010;

//interface Animal{
//    int DOG = 1;
//    int CAT = 2;
//}
//
//interface Person{
//    int MAN = 1;
//    int WOMAN = 2;
//}

enum Animal{
    DOG, CAT
}

enum Person{
    MAN, WOMAN
}

public class NonsafeConstEx {
    public static void main(String[] args) {
        who(Person.MAN);
    }

    public static void who(Person person){
        switch (person){
            case MAN:
                System.out.println("남자다잉~");
                break;
            case WOMAN:
                System.out.println("여자네잉~");
                break;
            default:
                System.out.println("없죠잉?~");
                break;
        }
    }
}
