#Base image
FROM  tomcat:9-jdk8
#Copy my war file into tomcat image war file location
ADD target/DockerWebEx1.war /usr/local/tomcat/webapps/DockerWebEx1.war
#Expose tomcat server on port 8080 of this container
EXPOSE 8080
#start tomcat
CMD ["catalina.sh", "run"]


