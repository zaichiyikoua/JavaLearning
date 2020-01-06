package designPattern.pattern1.case1;

public class TVFactory {
    public static TV getTV(String TVName) {
        if (TVName.equalsIgnoreCase("Haier")) {
            System.out.println("生产了海尔");
            return new HaierTV();
        } else if (TVName.equalsIgnoreCase("Hisense")) {
            System.out.println("生产了海信");
            return new HisenseTV();
        } else {
            System.out.println("暂时没有");
            return null;
        }
    }
}
