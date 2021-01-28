# Bug reproduction project

* start postgresql: `docker run -p5432:5432 -e POSTGRES_PASSWORD=secret -d postgres:9.5`
* start the demo app: `./mvnw clean compile quarkus:dev`
* open http://localhost:8082 

Trigger the bug [http://localhost:8082/test]()

Check the console for more info- an update stmt is executed after select, setting fields of User to null

Same select but Without TX works [http://localhost:8082/test/withoutTx]()

**Weird part:**

Try commenting out `User#roles` attribute and try again - should work

Try commenting out `BaseEntity#createdOn` and `BaseEntity#updatedOn` attribute and try again - should work


