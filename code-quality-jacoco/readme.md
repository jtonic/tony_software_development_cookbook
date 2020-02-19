# Code quality module 

## How to get the jacoco code coverage report

- run
```shell script
mvn verify
```

> When the jacoco plugin is setup to fail if a code coverage threshold is not passed the result of the above command execution is:
```text
[WARNING] Rule violated for class ro.jtonic.recipes.model.Notification: lines covered ratio is 0.00, but expected minimum is 0.80
Rule violated for class ro.jtonic.recipes.model.Notification: lines covered ratio is 0.00, but expected minimum is 0.80
Rule violated for class ro.jtonic.recipes.model.Notification: branches covered ratio is 0.00, but expected minimum is 0.80
```

- to see the result open in browser the file `<module_path>/target/site/jacoco/index.html`
