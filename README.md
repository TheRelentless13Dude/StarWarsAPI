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

@@ -12,7 +33,7 @@ For further reference, please consider the following sections:
* [Spring for GraphQL](https://docs.spring.io/spring-boot/docs/3.1.1/reference/html/web.html#web.graphql)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)

### Guides:

The following guides illustrate how to use some features concretely:

@@ -21,11 +42,3 @@ The following guides illustrate how to use some features concretely:
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)