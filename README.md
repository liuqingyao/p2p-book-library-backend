# p2p-book-library-backend
SpringBoot-based API service for p2p-book-library-frontend project, it is duplicated from example module of [SpringSide4](https://github.com/springside/springside4).

###  How to run (please ensure Java, Maven and git client installed first):

1. git clone https://github.com/springside/springside4.git
2. Go to springside4/modules folder and run "mvn install"
3. git clone https://github.com/wanhongfu/p2p-book-library-backend.git
4. Go to p2p-book-library-backend folder and run "mvn spring-boot:run"
5. The app run on localhost:8080

### Changes with original code 

1. Upgrade Spring Boot from 1.2.7.RELEASE to 1.3.2.RELEASE
2. Add CORS support to all API controller, see [WebConfiguration](https://github.com/wanhongfu/p2p-book-library-backend/blob/master/src%2Fmain%2Fjava%2Forg%2Fspringside%2Fexamples%2Fbootapi%2Fconfig%2FWebConfiguration.java)
3. Refactored BookEndpoint for Pagination 

### 主要用例 (From [SpringSide4](https://github.com/springside/springside4))

	
全部示例以一个P2P图书馆展开，P2P图书馆避免了中央式图书馆所需的场地和图书管理员，大家把图书登记在应用里互相借阅。

>**1. 图书借阅流程**
>
>1.1 用户浏览图书

>1.2 用户发起借阅请求，也可以取消借阅请求

>1.3 图书拥有者在交接图书后确认借阅，也可以拒绝借阅请求

>1.4 图书拥有者在收回图书后确认归还
>
>**2. 图书管理流程**
>
>2.1 用户可以自行上传，修改，删除自己的图书。
>
>**3. 用户管理流程**
>
>3.1 用户可以注册，登录与注销。

