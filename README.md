# Getting Started
--------------------------------------------------------------------------------------------------------------------------
### To build the Project:

In order to build the project, you need to run Maven Clean, followed by Maven Install.

These are located underneath the StarWarsAPI > Lifecycle directory.

Running these commands will install all dependencies within the pom.xml file required for this project to run.

### Current status:

Currently, we are able to create a "People" repository using the WebClient, HttpGraphQlClient and a Mono,List> of people. 

We can retrieve the people in our query to the API.

### Current Issues:

I am unable to check if this documented list of people is being created correctly. 
From the logs, I am able to outprint the result set. I do not know if this is being created as yet.

--------------------------------------------------------------------------------------------------------------------------

### Reference Documentation:

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#using.devtools)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#data.sql.jdbc)
* [Spring for GraphQL](https://docs.spring.io/spring-boot/docs/3.1.1/reference/html/web.html#web.graphql)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)

### Guides:

The following guides illustrate how to use some features concretely:

* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Building a GraphQL service](https://spring.io/guides/gs/graphql-server/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
