# HOME BANKING

#### _Maven_

build project

`mvn clean package `

deploy in Azure

`mvn azure-webapp:deploy`

#### _Docker_

build image

`docker build -t @username/home-banking .`

run image

`docker run -p 8080:8080 @username/home-bankinng`






**(Optional) push image**

`docker push @username/home-banking`