# Market1
1.Поднимаем базу данных в application properties
необходимо для этого
имя,пароль,url
запускаем приложение  с гит
используем реляционную базу данных postgres sql и команду
POSTGRES_PASSWORD=postgres -d postgres

2.используем Postman он нам нужен для  созданий коллекций с запросами к вашему API 
в проекте как пример я использовал Customer и Product c их  различными свойствами

 пример  curl 
вызываем customer c id-2


curl --location --request PUT 'http://localhost:8080/customer/2' \
--header 'Content-Type: application/json' \
--data '{
"name": "Alexey"

так же пример использования curl 
curl --location 'http://localhost:8080/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Alexey",
"email": "@post",
"gender": "mail",
"number": 37529,
"products": [
{
"servicelife": 5,
"productname": "Iphone",
"capacity": "256",
"price": 1000
},
{
"servicelife": 10,
"productname": "Mac",
"capacity": "512",
"price": 3000
}
]
}

}'

3.зависимости которые я использовал  в пом xml
1)lombok(нужен для сокращения шаблонного кода )
2)spring-boot-starter-data-jpa(что бы начать использовать Spring и JPA для доступа к базе данных, включите зависимость spring-boot-starter-data-jpa в свой проект.)
3)Spring Boot Maven Plugin - это плагин Maven, который позволяет вам упаковывать исполняемые jar-файлы или war-архивы и запускать приложение на месте. Он предоставляет ряд функций, полезных при разработке приложений Spring Boot, таких как возможность упаковывать исполняемые файлы jar или war,
4)Если вам нужны веб-возможности, такие как spring-mvc, для вашего проекта, вам нужно использовать spring-boot-starter-web.
