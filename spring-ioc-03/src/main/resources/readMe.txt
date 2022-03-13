spring-ioc-03
    1：demo的功能是测试spring创建对象的2种方式
        * <property></property>    用的是set方法，这种情况下用到的构造方法是无参构造
        * <construct-arg></construct-arg>  这种方式走的是有参构造

    2：Bean命名空间xml中的配置
        * alias 给bean起别名
        * import 导入合并其它的xml文件，若遇到重复的配置会合并
        * bean 把类的对象的创建，使用，获取交给springIOC容器托管
        * beans 根标签
        * desciption 描述