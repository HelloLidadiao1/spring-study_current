import com.demo1.pojo.anotation.HumanByConstructor;
import com.demo1.pojo.anotation.HumanByField;
import com.demo1.pojo.anotation.HumanByResource;
import com.demo1.pojo.anotation.HumanBySet;
import com.demo1.pojo.noanotation.Human;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lihongjie
 * @date 2022/3/11
 */
public class TestDemo {
    private Human human = null;
    /**
     * 1、测试不使用自动注入的方式
     * 成功
     */
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Human human = context.getBean("human", Human.class);
        human.getCat().shout();
        human.getDog().shout();
    }

    /**
     * 1、测自动注入(不使用注解)，注意只有引用类型（不包含String）自动注入才有意义
     * byName：springIOC容器中需要有bean的id/name和需要注入对象属性set方法后面的值(估计会有一个反转驼峰的方法倒推出属性名如
     * setCatPet-》需要在容器中找到id/name为catPet的实例对象)
     * 保持一致【set方法命名需要保持规范，否则可能会找不到】，走的是set注入方法
     * 缺点：当找不到对应id/name的bean定义（对象实例）的时候会注入失败
     */
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire_beans.xml");
        Human human = context.getBean("humanAutowiredByName", Human.class);
        System.out.println(human.getCat());
        System.out.println(human.getDog());
        System.out.println(human.getName());
        System.out.println(human.getId());
        human.getCat().shout();
        human.getDog().shout();
    }

    /**
     * 2、测自动注入(不使用注解)，基本类型和String自动注入没有意义（因为哪怕你在容器中定义了<bean id="name" class="java.lang.String"></bean>
     * 也没法给他赋值）
     * byType：走的是set注入，会去容器中找和需要自动注入的对象中的属性类型相同的对象实例进行注入
     * 缺陷：当容器中出现两个相同类型的bean定义的时候，会报错
     * byName和byType对于String类型的值没有执行注入
     */
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire_beans.xml");
        Human human = context.getBean("humanAutowiredByType", Human.class);
        System.out.println(human.getCat());
        System.out.println(human.getDog());
        System.out.println(human.getName());
        System.out.println(human.getId());
        human.getCat().shout();
        human.getDog().shout();
    }

    /**
     * 3、测试autowire=default，默认值没有测试出效果，貌似并没有自动注入可能等价于autowire=no
     */
    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire_beans.xml");
        Human human = context.getBean("humanAutowiredDefault", Human.class);
        System.out.println(human.getCat());
        System.out.println(human.getDog());
        System.out.println(human.getName());
        System.out.println(human.getId());
        human.getCat().shout();
        human.getDog().shout();
    }

    /**
     * 4、测试autowire="constructor"   根据类型进行注入
     *    * 需要有对应需要注入属性的构造方法
     *    * 对于要注入的属性值，即使springIOC容器中存在的对应对象实例的id/name与构造方法形式参数的名称不一致也不影响
     *    * 对于要注入的属性值，即使springIOC容器中存在多个相同类型的值也不会报错，也能注入成功
     */
    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire_beans.xml");
        Human human = context.getBean("humanAutowiredConstruct", Human.class);
        System.out.println(human.getCat());
        System.out.println(human.getDog());
        System.out.println(human.getName());
        System.out.println(human.getId());
        human.getCat().shout();
        human.getDog().shout();
    }

    /**
     * 5.1、测试@Autowired标签加在属性上
     *   * @Autowired是通过类型去进行自动注入的，会去SpringIOC容器中寻找与需要注入对象的属性类型相同的bean，
     *   但是如果在容器中找不到相同类型的bean，会抛出异常org.springframework.beans.factory.UnsatisfiedDependencyException，
     *
     *   * @Autowired会先通过类型（如果类型不存在，会直接抛异常），（有多个类型相同的bean定义的时候）然后再通过名字去找，
     *   如果通过类型找找到多个，但是再根据属性名字找，这多个bean的id/name都和属性名不一样则会抛异常【总而言之要确定唯一的一个bean】。
     *   可以搭配@Qualifier("catPet")
     *   指定特定名字的bean（前提仍然是：IOC容器中必须存在相同类型的bean）。
     *
     *   * @Autowired直接加在属性上，不通过set也不通过构造方法进行注入,直接通过反射field.setValue()
     */
    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("anno_autowire_beans.xml");
        HumanByField human = context.getBean("humanByField", HumanByField.class);
        System.out.println(human.getCat());
        System.out.println(human.getDog());
        System.out.println(human.getName());
        System.out.println(human.getId());
        human.getCat().shout();
        human.getDog().shout();
    }

    /**
     * 5.2、测试@Autowired标签加在set方法上
     * 通过set方法进行自动注入，如果找到有多个类型相同的bean，则根据形参的名字去匹配（匹配不到报异常）。
     * @Autowired(required=false) 默认为true，若为true，找不到可以注入的bean则抛错。若为false，注入为null程序不抛错。
     * @Nullable 标签加在属性或方法的形参上面，允许属性或方法上的形参为空。配合@Autowired标签使用<==> @Autowired(required=false)
     */
    @Test
    public void test7(){
        ApplicationContext context = new ClassPathXmlApplicationContext("anno_autowire_beans.xml");
        HumanBySet human = context.getBean("humanBySet", HumanBySet.class);
        System.out.println(human.getCat());
        System.out.println(human.getDog());
        System.out.println(human.getName());
        System.out.println(human.getId());
        human.getCat().shout();
        //human.getDog().shout();
    }

    /**
     * 5.3、测试@Autowired标签加在构造方法上面
     * 通过对应的有参构造方法进行注入，会对构造方法中的所有形式参数进行注入。只要有一个形式参数，在IOC容器中找不到对应id/name的对象实例，
     * 则会注入失败。（required=false,则所有值为null。若为true，则直接抛错）
     */
    @Test
    public void test8(){
        ApplicationContext context = new ClassPathXmlApplicationContext("anno_autowire_beans.xml");
        HumanByConstructor human = context.getBean("humanByConstructor", HumanByConstructor.class);
        System.out.println(human.getCat());
        System.out.println(human.getDog());
        System.out.println(human.getName());
        System.out.println(human.getId());
        human.getCat().shout();
        //human.getDog().shout();
    }

    /**
     * 5.4、拓展：@Resource（这里只讨论标签加在属性上）
     * 先根据属性名字去IOC容器里找对应id/name相同的bean，若找不到则再根据类型去找（如果此时再找到多个满足条件的bean则会报错，需要指定唯一匹配的
     * 才能自动装配成功）
     */
    @Test
    public void test9(){
        ApplicationContext context = new ClassPathXmlApplicationContext("anno_autowire_beans.xml");
        HumanByResource human = context.getBean("humanByResource", HumanByResource.class);
        System.out.println(human.getCatPet3());
        System.out.println(human.getCatPet2());
        System.out.println(human.getDog());
        System.out.println(human.getName());
        System.out.println(human.getId());
        human.getCatPet3().shout();
        human.getDog().shout();
    }

    /**
     *内部类demo案例
     */
    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        TestDemo.InnerThread thread1 = testDemo.new InnerThread(testDemo.human);
        TestDemo.InnerThread thread2 = testDemo.new InnerThread(testDemo.human);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }

    class InnerThread extends Thread {
        private Human human;
        public InnerThread(Human human){
            this.human = human;
        }

        @Override
        public void run() {
            System.out.println("进入线程：" + Thread.currentThread().getName());
            synchronized (human){
                try {
                    System.out.println(Thread.currentThread().getName() + "开始休眠：3s");
                    Thread.sleep(1000 * 3);
                    System.out.println(human.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
