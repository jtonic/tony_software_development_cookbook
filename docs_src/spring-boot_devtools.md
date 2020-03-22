# **Recipe 1:** Streamline the springboot application development with spring-boot devtools

---

## Description

  Spring boot devtools goal is to make the spring boot application development more efficient.

  It provides application reload, live reload, remote reload, disables cache and more.

  For me (as a daily backend developer) the most important feature of devtools is the spring application reload.
  In fact devtools doesn't reload entire application context.
  It has 2 class loaders, one of them is the one responsible for loading the project classes and resources.
  This way the spring application reload is quicker.

  For further information about the spring-boot devtools go to the [links below](#References).

## Context (prerequisites)

- spring-boot application
- [optional] IntelliJ Idea

## Benefits

- quicker changes reload (configuration and classes) in a running spring-boot application

- no longer restart the application after each and every config/classes changes

## Steps

- Add the following dependency to spring boot (maven based) application

  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
  </dependency>
  ```

- configure the trigger file in `application.yaml`

  ```yaml
  spring:
      devtools:
          restart:
              trigger-file: .reloadtrigger
  ```

  > This is useful because we don't want to trigger a spring application reload whenever we modified a java type or resource

- create the file `.reloadtrigger` in the folder `/${PRJ_HOME}/src/main/resources`

- start springboot application

- modify the code (java types or some configuration files)

- change the file `.reloadtrigger` and save it.

  > spring restarts the application in a very short time (see the explanation above with the custom classloader)

- Starting with spring-boot version 2.2 all the application beans could be configured as lazy through an application configuration (no code changes).

  It is debatable if this is useful for production but for development/tests this is definitely very handy.

  Configure all application beans as lazy.

  ```yaml
  spring:
    main:
      lazy-initialization: true
  ```

### Configure IntelliJ Idea spring application to use devtools

IntelliJ Idea simplify further its integration with spring.

It is no longer needed to update and save the `.reloadtrigger` file. IntelliJ Idea do it for us.

__Steps:__

- create a spring application run configuration.
  The easy way of doing this is to run the application using the green arrow in the editor gutter.

  See ![Run spring app|427 × 246,50%](./images/spring/run&#32;spring&#32;application.png "Run spring app")

- configure the update and frame deactivation actions.
  The configuration should be as shown in the image below

  ![Config run application](./images/spring/run&#32;debug&#32;configuration.png)

- Run the application.

  > Hint:I really like the new Services tool window.

  ![Run spring boot application](./images/spring/../spring/Run&#32;springboot&#32;application.png)

  > When debugging application hot swap kicks in. If it fails it falls back to update spring application based on trigger file.
  >
  > When running the application and hot swap makes no sense the spring application gets reloaded based on trigger file.

- Do some modification in the code (say rest controller java class)

- Update spring boot application and keep an eye on the console to see how spring reload the changes in the application context

  ![Reload spring boot application](./images/spring/refresh&#32;application.png)

- See below how quick this whole spring context reload is. It really impressive.

  ![How quick the spring application reload is](./images/spring/fast&#32;app&#32;reload.png)

  > In IntelliJ Idea `debug mode`
  >   - first how swap kick in,
  >   - if it fails it falls back to update spring app using trigger file
  >
  > In `run mode` the spring app update based on trigger fires.

> Spring boot devtools have more useful features for local and remote development.
>
> Please be aware that the spring-boot-devtools must not be included in the prod deliverable.
>
> In case of `using the exploded springboot application - folder structure`, very useful in case of docker/kubernetes cloud solution  resource consumption efficiency the `spring-boot-devtools` is included. ***In this case it has to be removed during the build.***

## Take away

- The local development efficiency can be improved through usage of spring devtools.

- Through a easy configuration of the spring-boot application and (optionally) IntelliJ Idea IDE, the  `run/debug | test | code/config changes` loop can be reduced to maximum one second or two, depending of the project size.

## References

- [medium article](https://www.vojtechruzicka.com/spring-boot-devtools/)
- [official documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-devtools)
- [spring-boot devtools by baeldung](https://www.baeldung.com/spring-boot-devtools)
