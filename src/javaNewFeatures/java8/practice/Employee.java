package javaNewFeatures.java8.practice;

/**
 * pojo实体类模拟
 *@author  zaichiyikoua
 *@time  2020年4月19日
 */

public class Employee {

    private Integer id;
    private String name;
    private Integer age;
    private Integer salary;

    public Employee() {
        super();
    }

    public Employee(Integer id, String name, Integer age, Integer salary) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

}
