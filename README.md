# lhjz.portal
立衡脊柱门户网站(http://czs.github.io/lhjz.portal)

---

### 2015/3/28

Initial commit
>
1. maven build - version:3.2.1
2. spring tool suite(sts) - version:3.6.4.RELEASE
3. jdk-1.8
4. git
5. mysql-5.6
6. junit test

Dependency
>
1. spring boot starter
2. spring-boot-starter-actuator
3. spring-boot-starter-aop
4. spring-boot-starter-data-jpa
5. spring-boot-starter-web
6. mysql-connector-java
7. spring-boot-starter-tomcat
8. spring-boot-starter-test

### 2015/3/29

框架结构构建
>
1. reset web controller
2. service
3. jap repository
4. connect to real `mysql` instance
5. add `testng` test(replace default `junit` test)
6. add jpa transaction
7. add apache commons `dbcp` connection pool
8. add `json-path` lib dependency
9. add `apache commons-io|beanutils|lang|connections` lib dependency

### 2015/3/30

框架结构构建
>
1. add `dao|base|component|exception|pojo` package
2. split `domain` package to `entity` and `repository` package
3. add apache commons `dbutils` lib dependency

### 2015/3/31

框架结构构建
>
1. add `@PersistenceContext EntityManager`
2. change base test to `AbstractTransactionTestNGSpringContextTests`
3. rename base test class
4. test spring data `jpa transaction`
5. test `jdbcTemplate`
6. test `collection stream lambda`
7. add `i18n` support
8. add `logback.xml` configuration file
9. change i18n properties file to charset `ISO-8859-1`
10. append dir `log/` to .gitignore file
11. add history to `readme.md`

### 2015/4/1

框架结构构建
>
1. add lib dependency `spring-boot-starter-thymeleaf`
2. add view template `Thymeleaf 2.1.4`
3. add [thymeleaf eclipse plugin](https://github.com/thymeleaf/thymeleaf-extras-eclipse-plugin#adding-content-assist-for-your-dialect)
4. add test template view page `home.html`

### 2015/4/2

框架结构构建
>
1. seprate i18n properties file
2. add `doc\xhtml1-strict-thymeleaf-spring4-4.dtd` for `content assist` when thymeleaf page design
3. add base class for `controller&dao&service`
4. change in application.properties `spring.messages.encoding=ISO-8859-1`
5. add thymeleaf test template view `test.html`
6. add dev-framework related docs to dir `doc\`
7. use `external tomcat8` run webapp, add `<Context path="/" reloadable="true" docBase=".../webapp" />` to `Host` node of `conf/server.xml`
8. run maven command `mvn clean package -Dmaven.test.skip=true` to package project
9. thymeleaf expressions test `Link URL Expressions: @{...}`

# TODO
>
1. more thymeleaf `tags & expressions` test.

