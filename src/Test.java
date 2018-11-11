class father{
    public father() {
        System.out.println("This is Father");
    }
}

class son extends father{
    public son() {
        System.out.println("This is Son");
    }
    public void say() {
        System.out.println("父类调用子类成员函数");
    }
}

public class Test {
    public static void main(String[] args){
        father f = new son();
    }
}
