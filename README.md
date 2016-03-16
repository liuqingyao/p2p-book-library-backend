# p2p-book-library-backend
SpringBoot-based API service for p2p-book-library-frontend project, it is duplicated from example module of [SpringSide4](https://github.com/springside/springside4).

###  How to run (please ensure Java, Maven and git client installed first):

1. git clone https://github.com/springside/springside4.git
2. Go to springside4 folder and run "mvn install"
3. git clone https://github.com/wanhongfu/p2p-book-library-frontend.git
4. Go to p2p-book-library-frontend folder and run "mvn spring-boot:run"
5. The app run on localhost:8080

### Changes with original code 

1. Upgrade Spring Boot from 1.2.7.RELEASE to 1.3.2.RELEASE
2. Add CORS support to all API controller, see [WebConfiguration](https://github.com/wanhongfu/p2p-book-library-backend/blob/master/src%2Fmain%2Fjava%2Forg%2Fspringside%2Fexamples%2Fbootapi%2Fconfig%2FWebConfiguration.java)