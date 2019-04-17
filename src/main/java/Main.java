
public class Main {


    public static void main(String[] args) {
        System.out.println();
        Main main = new Main();
    }

    /*
    some concept：

    EJB: Enterprise JavaBean 企业级JavaBean
    POJO: Plain Old Java Object 简单老式Java对象
    JDO: Java Data Object Java数据对象
    AOP: Aspect-Oriented Programming 面向切面编程
    DAO: Data Access Object 数据访问对象
    ORM: Object-Relation Mapping 对象关系映射
    JMS: Java Message Service
    MVC: Model-View-Controller
    RMI: Remote Method Invocation
    JPA: Java Persistence API Java持久化API
    JNDI: Java Naming and Directory Interface Java命名与目录接口
    JDO: Java Data Object Java 数据对象
     */


    /*
    1.配置数据源的方式
        1.1通过JDBC驱动程序定义的数据源
        1.2通过JNDI查找的数据源
        1.3连接池的数据源


     */

    /*
    数据库中物理分页和逻辑分页和内存分页：
    物理分页：物理分页依赖的是某一物理实体, 这个物理实体就是数据库, 比如MySQL数据库提供了limit关键字,
            程序员只需要编写带有limit关键字的SQL语句, 数据库返回的就是分页结果.
    内存分页：逻辑分页依赖的是程序员编写的代码.数据库返回的不是分页结果, 而是全部数据, 然后再由程序员通过代码获取分页数据,
            常用的操作是一次性从数据库中查询出全部数据并存储到List集合中, 因为List集合有序, 再根据索引获取指定范围的数据。
    逻辑分页：就是内存分页

     */

    /*
    Mybatis本身支持了内存分页
     */
}


