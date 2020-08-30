# JavaEE项目的三层架构

![image-20200813141743349](javaEE.assets\image-20200813141743349.png)

分层的美与敌就是为了解耦。解耦就是为了降低代码的耦合度，方便项目后期的维护和升级。

| web层        | com.zh.web/servlet/controller  |                   |
| ------------ | ------------------------------ | ----------------- |
| service层    | com.zh.service                 | Service接口包     |
|              | com.zh.service.impl            | Service接口实现类 |
| dao持久层    | com.zh.dao                     | Dao接口包         |
|              | com.zh.dao.impl                | Dao接口实现类     |
| 实体bean对象 | com.zh.pojo/entity/domain/bean | JavaBean类        |
| 测试包       | com.zh.text/junit              |                   |
| 工具类       | com.zh.utils                   |                   |

## 先创建书城需要的数据库和表。

```sql
drop database if exists book;

create database book;

use book;

create table t_user(
	id int primary key auto_increment,
	username varchar(20) not null unique,
	password varchar(32) not null,
	email varchar(200)
);


insert into t_user(username, password, email) values('admin', 'admin', 'admin@zh.com');

select * from t_user;
```

## 编写数据库表对应的JavaBean对象

## 编写工具类JDBCUtils

### 导入需要的jar包（数据库和连接池需要）

+ druid-1.1.9.jar
+ mysql-connector-java-5.1.7-bin.jar
+ 以下是测试需要：👇
+ homcrest-core-1.3.jar
+ junit-4.12.jar

### 在src源码目录下编写jdbc.properties属性配置文件

```properties
username=root
password=root
url=jdbc:mysql://localhost:3306/book
driverClassName=com.mysql.jdbc.Driver
initialSize=5
maxActive=10
```

### 编写JdbcUtils工具类

```java
public class JdbcUtils {

    private static DruidDataSource dataSource;

    static {

        try {
            Properties properties = new Properties();
            // 读取jdbc.properties属性配置文件
            InputStream resourceAsStream = com.alibaba.druid.util.JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(resourceAsStream);
            // 创建了数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null，说明获取链接失败，有值就是获取连接成功
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭连接，放回数据库连接池
     * @param connection
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### JdbcUtils测试

```java
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
}
```

## 编写BaseDao

导入commons-dbutils-1.3.jar

```java
public abstract class BaseDao {
    // 使用DBUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 方法用来执行：insert/update/delete语句
     *
     * @param sql  执行的sql语句
     * @param args sql对应的参数
     * @return 如果返回-1，说明执行失败；返回其他表示影响的函数
     */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询返回一个JavaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数
     * @param <T>  返回类型的泛型
     * @return 查询到的一个对象
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回多个JavaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数
     * @param <T>  返回类型的泛型
     * @return 查询到的一个对象
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @return 返回查询的一个值
     */
    public Object queryForSingValue(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

}
```

## 编写UserDao

### UserDao接口

```java
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null，说明没有这个用户，反之亦然
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 如果返回null，说明用户名或者密码错误，反之亦然
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user 用户信息
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveUser(User user);

}
```

### UserDaoImpl实现类

```java
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id, username, password, email from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id, username, password, email from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username, password, email) values(?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
```

### UserDaoTest

```java
public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        String username = "admin";
        if (userDao.queryUserByUsername(username) == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("admin", "admin");
        if (user == null) {
            System.out.println("用户名或者密码错误，登陆失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"asdf", "123456", "wew@qq.com")));
    }
}
```

## 编写UserService和测试

### UserService接口

```java
public interface UserService {

    /**
     * 注册用户
     * @param user 用户信息
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user 用户信息
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username 用户名
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public Boolean existsUsername(String username);

}
```

### UserServiceImpl实现类

```java
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public Boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            // 等于null说名没有查到
            return false;
        }
        return true;
    }
}
```

### UserService测试

```java
public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"cds","12414","afsdhfjk@qq.com"));
        userService.registerUser(new User(null,"cads","12414","afsdhfjk@qq.com"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"admin","admin",null)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("fasd")) {
            System.out.println("用户名存在");
        } else {
            System.out.println("用户名可用");
        }
    }
}
```

## 编写web层

### 实现用户的注册功能

#### 图解注册流程

![image-20200813184115483](javaEE.assets\image-20200813184115483.png)

#### 修改regist.html和regist_success.html页面

![image-20200813184217938](javaEE.assets\image-20200813184217938.png)

#### 编写RegisterServlet程序

```java
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        // 2. 检查验证码是否正确 === 写死，要求验证码为：abcde
        if ("abcde".equalsIgnoreCase(code)) {
            // 正确
            // 3. 检查用户名是否可用
            if (userService.existsUsername(username)) {
                // 用户名不可用
                System.out.println("用户名【" + username + "】已存在！");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            } else {
                // 用户名可用
                // 调用共service保存到数据库
                userService.registerUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }
        } else {
            // 不正确
            // 跳回注册页面
            System.out.println("验证码【" + code + "】错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }


    }
}
```

### 用户登录功能的实现

#### 图解用户登录

![image-20200813184452871](javaEE.assets\image-20200813184452871.png)

#### 修改login.html和login_success.html页面

![image-20200813185916902](javaEE.assets\image-20200813185916902.png)

![image-20200813185923579](javaEE.assets\image-20200813185923579.png)

#### LoginServlet程序

```java
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            // 登录失败
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        } else {
            // 登录成功
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
        }
    }
}
```



