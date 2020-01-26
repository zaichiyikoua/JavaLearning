package designPattern.pattern12.case1;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NameRepository nameRepository = new NameRepository();
        for (Iterator iter = nameRepository.getIterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("name=" + name);
        }

//        name=hello
//        name=world
//        name=nihao
//        name=shijie
    }

}
