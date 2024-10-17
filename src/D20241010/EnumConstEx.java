package D20241010;

enum Human{
    MAN(29), WOMAN(25);

    int age;

    private Human(){
        System.out.println("Human Constructor Called....");
    }

    private Human(int i){
        this.age = age;
    }

    @Override
    public String toString() {
        return "I am a Human.";
    }
}

public class EnumConstEx {

    public static void main(String[] args) {
        System.out.println(Human.MAN);
        System.out.println(Human.WOMAN);
    }

}
