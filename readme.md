H2 Console

> mvn spring-boot:run
> goto http://localhost:8088/h2/

DB clean
> mvn flyway:clean


Start in Docker:
> docker build . -t demotitle_image

> docker run -p8089:8088 --name demotitle_container demotitle_image
(use option -d for background)

runs springboot inside docker (exposed 8088, mapped from container to localhost as 8089)
> http://localhost:8089/api/demotitle
> http://localhost:8089/h2

Delete container
> docker rm demotitle_container


Next steps might be:
- add another service .. link multiple containers by docker-compose.yml    
