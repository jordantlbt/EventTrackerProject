# EventTrackerProject

## Overview

Night Owl is a RESTFUL API project that allows you to track and plan movie nights. You can add in movies or TV shows that you have seen or want to see, the date you watched them or are planning on watching them and add in the snack you ate or are planning to eat. You can also search for certain movies/shows/snacks by id, keywords, titles and seasons.

### REST API

The first part of this project consisted of designing the database in MYSQL MySQLWorkbench. Then creating the entities and testing mapping with JUNIT. I then created Respositories, Services, ServiceImpls, and Controllers with CRUD operations. Finally I tested the REST API routes with Postman.

### HTML/JavaScript Front End

### Angular Front End

## REST API Reference
| Return Type    | HTTP Method | URI                                 | Request Body | Purpose  |
|----------------|-------------|-------------------------------------|--------------|----------|
| List \<Movie\> | GET         | /api/movies                         |              | List     |
| Movie          | GET         | /api/movies/{id}                    |              | Retrieve |
| Movie          | POST        | /api/movies                         | Movie JSON   | Create   |
| Movie          | PUT         | /api/movies/{id}                    | Movie JSON   | Update   |
| Void           | DELETE      | /api/movies/{id}                    |              | Delete   |
| Movie          | Get         | /api/movies/search/{keyword}        |              | Retrieve |
| Movie          | Get         | /api/movies/search/{title}/{season} |              | Retrieve |
| List \<Snack\> | GET         | /api/snacks                         |              | List     |
| Snack          | GET         | /api/snacks/{snackId}               |              | Retrieve |
| Snack          | POST        | /api/snacks                         | Snack JSON   | Create   |
| Void           | DELETE      | /api/snacks/{snackId}               |              | Delete   |
| Snack          | GET         | /api/snacks/{keyword}               |              | Retrieve |

## Technologies Used

Spring Tool Suit, Java, MySQL, MySQLWorkbench, JSON, Postman, Git, Github, Terminal, Gradle

## Lessons Learned

This project helped me solidify my knowledge of combining a JPA project with a REST project. I am becoming more comfortable with writing a controller, the REST API mappings, and HTTPServletResponses.
