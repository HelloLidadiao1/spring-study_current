package demo.pojo;

/**
 * @author lihongjie
 * @date 2022/2/13
 */
public class User {
    private String uName;
    private String classes;
    private Integer age;

    public User(String uName, Integer age) {
        System.out.println("Log_User 进入[uName,age]有参构造方法实例化User对象");
        this.uName = uName;
        this.age = age;
    }

    public User(String uName, String classes, Integer age) {
        System.out.println("Log_User 进入[uName,classes,age]有参构造方法实例化User对象");
        this.uName = uName;
        this.classes = classes;
        this.age = age;
    }

    public User(String uName, Integer age, String classes) {
        System.out.println("Log_User 进入[uName,age,classes]有参构造方法实例化User对象");
        this.uName = uName;
        this.classes = classes;
        this.age = age;
    }

    public User(int age) {
        System.out.println("Log_User 进入[age]有参构造方法实例化User对象");
        this.age = age;
    }

    public User(String uName) {
        System.out.println("Log_User 进入[uName]有参构造方法实例化User对象");
        this.uName = uName;
    }

    public User(){
        System.out.println("Log_User 进入无参构造方法实例化User对象");
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        System.out.println("执行[uName]set方法.....");
        this.uName = uName;
    }

    @Override
    public String toString() {
        return "User{" +
                "uName='" + uName + '\'' +
                ", classes='" + classes + '\'' +
                ", age=" + age +
                '}';
    }
}
