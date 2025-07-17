MTSB System
===========
Codebase
--------
git repository: https://github.com/cerrochoclo/mtbs

How to Run
----------
The root of the project contains a docker-compose.yml file.
Please make sure Docker and docker-compose are both installed locally.
the docker compose conatain 4 services:
- Movies service (image is in docker hub as per reference in the docker-compose file)
- UserManagement service (image is in docker hub as per reference in the docker-compose file)
- postgres-movies (postgres:15 image)
- postgres-users (postgres:15 image)

all images will be pulled automatically when running docker compose

how to run docker-compose:
in command line run the following command: 'docker compose up'
make sure you are in the the same folder as the docker-compose.yml file
Please allow for all services to finish their initializations before testing

Important note
--------------
All 4 services are pre-assigned to specific ports
movies service (localhost:8081)
usermanagement service (localhost:8082)
postgres-movies(localhost:5432)
postgres-users(localhost:5433)

If any of these ports are locally busy you will have to change them in the docker-compose.yml in order to allow them to run properly


Data
----
Each database(Movies and Users) are pre-set with the table schema and initial data when running docker compose. 
There's no need to do anything else in terms of db setup.
There are two files that docker compose use to populate the databases (in the root folder):
db_init_cinema.sql
db_init_users.sql
Please don't make changes to those files

Data Schema
-----------
Will be attached in the email as a separate file

Postman
-------
A postman collection file is attached to the email.
the urls point to localhost:8081 and localhost:8082 respectively
movies-service endpoints are protected using Spring Security and need to get a Bearer token in each call.
To create a token:
1. in postman collection call: Users/register with a new user (please note that roleId=1 is USER and roleId=2 is ADMIN)
2. in postman collection call: Users/login using the credentials you chose on #1
3. copy the token you get in response
4. use it as a Bearer token under Authorization for each call you make in movies-service

Swagger
-------
swagger pages for both movies api and usermanagement api are both available after running the services:
movies: http://localhost:8081/swagger-ui/index.html
usermanagement: http://localhost:8082/swagger-ui/index.html


Thank you and Enjoy :)