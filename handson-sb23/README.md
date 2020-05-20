# How to create and run a springboot application in docker container with springboot 2.3

**Note:** The steps have been verified on macos

## Steps
---

1. build the layered springboot application jar file.

    ```shell script
    ./gradlew build
    ```

1. build the image

    ```shell script
    docker build --tag=handson-sb23 .
    ```

1. run the image in a docker container

    ```shell script
    docker run -it -p8080:8080 handson-sb23:latest
    ```

1. test the application

    ```shell script
     curl http://localhost:8080/hello
    ```
