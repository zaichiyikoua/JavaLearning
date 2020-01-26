package designPattern.pattern13.case1;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MySubject subject = new Cat();
        MyObserver dog = new Dog();

        subject.attach(dog);

        subject.cry();

//        cat show
//        dog show

    }

}
