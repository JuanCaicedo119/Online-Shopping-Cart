# Coffee Grind - Online Shopping Service

## About The Project

Coffee Grind is a web-based application that enable the creation, search and removal of customers, orders, order details, categories, and products in a database. The code is written in Java. In particular, the Spring Boot framework is used for backend. The database of choice is MySQL.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Built With

- **Programming Languages**: Java
- **Frameworks**: Spring Boot
- **DBMS**: MySQL
- **Messaging**: Kafka
- **Testing**: JUnit, Mockito
- **Build**: Maven
- **CI/CD**: Jenkins CI

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED-->
## Getting Started

## Steps to Setup

**1. Clone the application**

```bash
https://github.com/EASIPMAugust2022/EAS-IPM-Project-Fall-22.git
```

**2. Create Mysql database**
+ open `EAS-IPM-Project-Fall-22/init.sql`
+ run script `init.sql` in MySQL Workbench

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

+ repeat the steps above for each service

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/coffee-grind-server-0.0.1-SNAPSHOT.jar

```
The app will start running at <http://localhost:8761>.

Follow same procedure to start the below services

- Customer-service - <http://localhost:8081> 
- order-service - <http://localhost:8082>
- order-detail-service - <http://localhost:8083>
- products-service - <http://localhost:8084>
- categories-service <http://localhost:8085>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Explore Rest APIs

The app defines following CRUD APIs -
For example, from <http://localhost:8081> 

    GET /jpa/customers
    
    POST /jpa/customers
    
    GET /jpa/customers/{customerId}
    
    DELETE /jpa/customers/{customerId}

## Usage
**GET /jpa/customers**
+ in browser, navigate to `http://localhost:8081/jpa/customers`

**GET  /jpa/customers/{customerId}**
+ in browser, navigate to `http://localhost:8081/jpa/customers/{customerId}`

**POST /jpa/customers**
+ open Talend API Tester (chrome extension)
+ Select method "POST" for `http://localhost:8081/jpa/customers`
+ input body as:
```bash
{
    "firstName": "Carlos",
    "lastName": "Sanz",
    "phoneNumber": "4701236168"
}
```
**DELETE  /jpa/customers/{customerId}**
+ open Talend API Tester (chrome extension)
+ Select method "DELETE" for `http://localhost:8081/jpa/customers/{customerId}`

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [x] Identify entities and relationships through E-R Diagram
- [x] Create classes for identified entities
- [x] Create repositories for classes
- [x] Create controllers with CRUD operations mapping to endpoints for classes
    - [x] Implement TDD for Customer
    - [x] Implement Error-Handling for Customer
- [x] Create a server
- [x] Separate entities and related files into services
- [ ] Establish CI/CD with Jenkins
- [ ] Establish communication between two services with Kafka

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

- Juan Caicedo - juan.caicedo@cognizant.com
- Nasir Jones - nasir.jones@cognizant.com
- Shecory'N Porter - shecory'n.porter@cognizant.com
- Calvin Quach - calvin.quach@cognizant.com
- Tri Quach - tri.quach@cognizant.com
- Hassaan Sheikh - hassaan.sheikh@cognizant.com



Project Link: [https://github.com/EASIPMAugust2022/EAS-IPM-Project-Fall-22](https://github.com/EASIPMAugust2022/EAS-IPM-Project-Fall-22)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [in28minutes Spring Web Services](https://github.com/in28minutes/spring-web-services)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

