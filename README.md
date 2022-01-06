# DockerWebEx1

This application uses two images. One for mysql and another one for web application.

Get mysql image  -> docker pull mysql

Running a mysql container -> docker container run --name app-db -d -e MYSQL_ROOT_PASSWORD=root123 mysql

Then log into this mysql container and  execute the  sql commands in db.sql. 
(docker container exec -it dfcf4a6c396c sh)
Here dfcf4a6c396c means mysql docker container id

Create the  web application image ->docker image build -t my-web-app:v1 .

Running the web application container -> docker container run --name web-app -d  -p 8081:8080  web-app:v1
(In above command 8081 means host machine port. 8080 means container port)

Then we need to create a seperate network for communicate among above two containers.
Let's create a bridge network (docker default network type) .We can use  this newly created network for communicating among containers. -> docker network create app-network

Connect web application container to app-network ->docker network connect app-network web-app

Connect mysql container to app-network > docker network connect app-network app-db

http://localhost:8081/DockerWebEx1/ -> Access our web application in web browser.


