## Testcontainers demo spring boot

docker run --name mysql57tc -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_DATABASE=tc2020 -d mysql/mysql-server:5.7

http://localhost:8080//api/v1/users

mvn verify -Pintegration-test -DdbVendor=mysql
