#Pedido E-Commerce 

Este Microservice tem a responsabilidade de lidar com as requisições de pedido

##Mantenedores
Turma TI16 da Fundatec, Isadora, Gabriel, Ronaldo Supervisionado por Marcos.
##Getting Started
Para inicializar a aplicação precisamos seguir os requisitos abaixo:
* Maven Project
* Java SDK
###Alguns comandos Maven de interesse:

* `./mvnw clean`: Clean build dir
* `./mvnw compile`: Compile all the project
* `./mvnw test`: Run unit tests
* `./mvnw package`: Create jar

To verify if the application started up successfully, just try the health check:

[http://localhost:8000/health](http://localhost:8000/health)