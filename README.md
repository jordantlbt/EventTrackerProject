# EventTrackerProject

## Overview

Night Owl is a Full Stack RESTFUL API project that allows you to track and plan movie nights. You can add in movies or TV shows that you have seen or want to see, the date you watched them or are planning on watching them. You can also search for certain movies/shows/snacks by id, keywords, titles and seasons.

### REST API

The first part of this project consisted of designing the database in MYSQL MySQLWorkbench. Then creating the entities and testing mapping with JUNIT. I then created Respositories, Services, ServiceImpls, and Controllers with CRUD operations. Finally I tested the REST API routes with Postman.

### HTML/JavaScript Front End

Using Javascript I created a front end for this website. I employed eventListeners and used XMLHttpRequests to create the functionality and talk with the back end controllers.

### Angular Front End

The last part of this project I used Angular TypeScript and Bootstrap to develop and design the front-end of this website. I created models, components, services and the html pages in VSCode.

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


## Technologies Used

Spring Tool Suit, Java, MySQL, MySQLWorkbench, JSON, Postman, Git, Github, Terminal, Gradle, Javascript, HTML, Angular, TypeScript, VSCode

## Lessons Learned

This project helped me solidify my knowledge of combining a JPA project with a REST project. I am becoming more comfortable with writing a controller, the REST API mappings, and HttpServletResponses. While testing my own controller mappings with Postman, I came across new Http Status Codes that I had to research and update my code to get the correct response.
