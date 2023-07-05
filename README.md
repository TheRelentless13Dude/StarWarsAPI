# Getting Started
--------------------------------------------------------------------------------------------------------------------------
### To build the Project:

In order to build the project, you need to run Maven Clean, followed by Maven Install.

These are located underneath the StarWarsAPI > Lifecycle directory.

Running these commands will install all dependencies within the pom.xml file required for this project to run.

--------------------------------------------------------------------------------------------------------------------------

### Current status:

Currently, we are able to create a "People" repository using the WebClient, HttpGraphQlClient and a Mono,List> of people.

We can retrieve the people in our query to the API.

--------------------------------------------------------------------------------------------------------------------------

### Current Issues:

I am unable to check if this documented list of people is being created correctly.
From the logs, I am able to out-print the result set. I do not know if this is being created as yet.
I have tried my best to analyze and understand the issue, however, I am unable to figure this out as of yet.
I will require a more hands-on approach to this, as my language level of understanding from Java 6,8 and a bit of 11 are
entirely out of date for this type of project.

--------------------------------------------------------------------------------------------------------------------------

### Personal take-ways from this project:

 -  The Spring boot framework is a new and exciting experience for me. I am excited to explore more of this framework going
    forward, as well as implementing it in my development structure and procedures.
 -  I have both been incredibly impressed and frustrated with the Project Reactor library. This has been my first deep dive
    in using the library, and have realised that it will be a very handy library to use going forward once I have a more
    detailed understanding of it.
 -  GraphQL is an entirely new form of query language for me. I will need more time and hands-on usage to grasp the full
    functionality of this, as ORACLE SQL has been the only SQL language I have had much experience in.

--------------------------------------------------------------------------------------------------------------------------

### Reference Documentation:

For further reference, please consider the following sections:

@@ -12,7 +33,7 @@ For further reference, please consider the following sections:
* [Spring for GraphQL](https://docs.spring.io/spring-boot/docs/3.1.1/reference/html/web.html#web.graphql)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)

### Guides:

The following guides illustrate how to use some features concretely:

@@ -21,11 +42,3 @@ The following guides illustrate how to use some features concretely:
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)