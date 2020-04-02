# TODO list

- Actors
    1. [x] use ask instead of tell in spring RestController 
    1. [x] spring web 1.x and CompletableFuture as return type from rest-controller method  
    1. [ ] Patterns.ask() with generified CompletableFuture (Typed actor)
        
        Some information about typed actors [here](https://doc.akka.io/docs/akka/2.5.5/java/typed.html#akka-typed)
    1. [ ] Create an actor from another actor
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
        - comments
        - includes
        - substitutions ("foo" : ${bar}, "foo" : Hello ${who})
        - properties-like notation (a.b=c)
        - substitute environment variables (logdir=${HOME}/logs) - ${?FORCED_BASEDIR}
    1. [ ] Integration with spring profiles...
    1. [ ] Validation of properties value... Is this necessarily?
    1. [ ] SpEL
