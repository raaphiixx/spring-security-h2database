# Authentication API - Spring Security using H2 Database

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) 
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) 
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)


A little project used to learn some concepts about spring security. Each commit was a new challenger, I have to say thanks for this [video](https://www.youtube.com/watch?v=5w-YCcOjPD0&t=1083s&pp=ygUPc3ByaW5nIHNlY3VyaXR5), that's help me a lot, of course some information I need to search on Google, StackOverFlow, ChatGTP, ask a friend for a help and more.

## About the project
The project was built using the programming language Java, the framework Spring / SpringBoot, the dependency manager was Maven, JWT for generate tokens and H2 Database for data.

For creation products aren't necessary too much information, 'cause the main purpose was understanding how it works the Spring Security.

About the users, it is necessary to inform which role are they. There are not the best way to do this. In a real project the admin and other important roles are created first of all directly in Database.


## EndPoints
### Product
* **GET** -> http://localhost:8080/product
* **POST** -> http://localhost:8080/product/insert
```
{
    "name":"EXAMPLE",
    "price":"0.00"
}
```
### User
* **POST** -> http://localhost:8080/auth/register
```
{
    "login":"EXAMPLE",
    "password":"123Example456"
    "role":"USER"/"ADMIN"
}
```
* **POST** -> http://localhost:8080/auth/login
```
{
    "login":"EXAMPLE",
    "password":"123Example456"
}
```
