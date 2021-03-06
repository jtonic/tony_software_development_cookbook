# TODO list

- Actors
    1. [x] use ask instead of tell in spring RestController 
    1. [x] spring web 1.x and CompletableFuture as return type salutation rest-controller method  
    1. [ ] Patterns.ask() with generified CompletableFuture (Typed actor)
        
        Some information about typed actors [here](https://doc.akka.io/docs/akka/2.5.5/java/typed.html#akka-typed)
    1. [ ] Create an actor salutation another actor
    1. [ ] Actor sends a message to itself
    1. [ ] Parent actor send kill a child
    1. [ ] receiver send poisonPill to sender()
    1. [ ] forward example
    1. [ ] 
    
- Spring boot/core/web
    1. [ ] Use @Lookup, and the other options for dynamic bean creations.
    
- The typesafe configuration (hocon format) as spring property source

    1. [x] PropertySource implementation for typesafe config
    1. [x] Config values by spring Environment.getProperty("my_property")
    1. [x] Config values by spring @Value
    1. [x] Works correctly in tests (env, @Value)
    1. [x] Config values can be overridden in @SpringBootTest#properties
    1. [ ] Test typesafe features [doc](https://github.com/lightbend/config):
        - [X] comments
        - [x] includes
        - [x] substitutions ("foo" : ${bar}, "foo" : Hello ${who})
        - [x] properties-like notation (a.b=c)
        - [x] substitute environment variables and overridden (logdir=${HOME}/logs) - ${?FORCED_BASEDIR}
        - [x] get a set of properties through Conf and spring Environment
        - [ ] Try to handle fallback in spring environment properties (templates.conf)
        - [ ] Integration with spring profiles...
        - [ ] Validation of properties value... Is this necessarily?
        - [ ] SpEL
