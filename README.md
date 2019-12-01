# How to run the app?

## 1. What you need before starting :
- jdk-11.0.1.jdk
- apache-tomcat-9.0.21
- apache-maven-3.6.1
- mysql-8.0.17

## 2. Fork or download the repository
https://github.com/MangooLife/projet7_OC

## 3. Prepare the database (with MySQLWorkbench)
- Run the script projetOC_7_Varadarasu.sql in MySQLWorkbench (per exemple)

## 4. Fork the configuration repository
https://github.com/MangooLife/projet7_OC_config.git

## 5. Configure application.properties in this configuration repository (mbook, mloanmanagement and mperson)
```java
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/db_projet7_OC?serverTimezone=EST5EDT&useUnicode=yes&characterEncoding=UTF-8
spring.datasource.username=
spring.datasource.password=
```

## 4. Generate a package for each service and deploy with tomcat
You have to generate a package for each service we need **(follow the order bellow)** 
1. Open your console
2. Go in the service file  
3. Do a : ./mvnw spring-boot:run **(for each service and follow the order bellow)**
5. Go in your tomcat file (here apache-tomcat-9.0.21) with your console, go in bin/ and do : bash startup.sh

**THE ORDER TO FOLLOW TO DEPLOY THE APPLICATION**

| Ordre  |   Microservice  | server.port |
| :----: | :------------- | :---------: |
|   1    | config-server   |    9101     |
|   2    | eureka-server   |    9102     |
|   3    | zuul-server     |    9004     |
|   4    | mbook           |    9090     |
|   5    | mloanmanagement |    9092     |
|   6    | mperson         |    9091     |
|   7    | client-ui       |    9089     |
|   8    | batch           |    9093     |

## Open the application and et voilà!
127.0.0.1:9089/
Enjoy! 