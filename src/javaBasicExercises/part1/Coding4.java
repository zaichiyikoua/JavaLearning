package javaBasicExercises.part1;

/*
*	javaSE专项练习4
*	2019年12月11日
*/

public class Coding4 {

    class Vehicle {
        @SuppressWarnings("unused") // 去掉警告
        private final void run() {
            System.out.println("Vehicle");
        }
    }

    class Car extends Vehicle {
//		原题如下 存在警告
//		public static void main(String[] args) {
//			new Car().run();
//		}
        public void main(String[] args) {
            new Car().run();
        }

        private final void run() {
            System.out.println("Car");
        }
    }

    // final申明的方法不能被覆盖 但是这里并不错误
    // 因为方法是private 也就是子类没有继承父类的run方法
    // new Car().run()是调用子类自己的方法
}
