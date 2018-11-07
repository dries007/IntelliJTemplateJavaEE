# IntelliJ Template project for Java EE

Required software:
- GlassFish 5.0.0.
- IntelliJ IDEA Ultimate Edition 

Useful links:
- https://www.jetbrains.com/help/idea/java-ee.html
    - https://www.jetbrains.com/help/idea/enabling-java-ee-application-support.html
    - https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-ee-application.html
- https://en.wikibooks.org/wiki/Java_Persistence

## Persistence

Before you start:

- This assumes you are running a MySQL server on `<hostname:port>` with a user `<user>` and `<password>` having access to database `<db>` So the URL would be: `jdbc:mysql://<hostname:port>/<db>`.
- **The password cannot be empty!** It's also stored in plain text, so make a special one just for this.
- Also be sure to give GlassFish the MySQL connector jar. (Put `lib/mysql-connector-java-*.jar` in `<glassfish_dir>/domains/<domain>/lib/ext/`)
- Enable `Java Persistence` on one of the project modules! (Probably either a new module or a library module, since you need access to the data types from everywhere.)
- **Enable the `JPA Descriptors` output in the EJB artifact** otherwise the `@PersistenceContext` will fail! (It must have `META-INF/persistence.xml` in the root.)


1. Run server (using GlassFish 5 here)
2. Connect to admin url <http://localhost:4848>
3. `Resources` -> `JDBC` -> `JDBC Connection Pools` -> `new`
    + 'Name': `MySQL_<name>`
    + 'Resource Type': `java.sql.Driver`
    + 'Database Driver Vendor': `MySql`
    + Do **not** check 'Introspect' Enabled!
4. `next`
    + It should have pre-filled Driver Classname with `com.mysql.jdbc.Driver`.
    + If not, make sure you read the instructions above this list and restart GlassFish.
    + Enable 'Ping'
    + Under 'Additional Properties':
        + 'password': `<password>`
        + 'user': `<user>`
        + 'URL': `jdbc:mysql://<hostname:port>/<db>`
5. `save`.
6. `Resources` -> `JDBC` -> `JDBC Resources` -> `new`
    + 'JNDI Name': `jdbc/mysql_<name>`
    + 'Pool Name': Select the name you just made.
7. `ok`
8. In the project's `persistence.xml` file should look like the file below.
9. IntelliJ magic
    1. Open the `Databases` tool window.
    2. +' -> `Data Source` -> `MySQL`
    3. Fill out DB details (and download drivers if required).
    4. `OK`
    5. Open the `Persistence` tool window.
    6. Right click on the name of the project
    7. `Assign Data Sources...`
    8. Pick the data source you just created.
10. Enjoy the full power of IntelliJ's autocomplete and everything else that makes every other IDE bad in comparison.

**BONUS ROUND**

11. Automatically generate `...Entity` classes:
    1. Open the `Persistence` tool window
    2. Right click on the persistence unit.
    3. `Generate Persistence Mapping ...` -> `By Database Schema`
    4. Check some boxes.
    5. Profit.

### Example `persistence.xml`
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2">
    <persistence-unit name="persistence-unit">
        <jta-data-source>jdbc/mysql_project</jta-data-source>
        <exclude-unlisted-classes>false</exclude-unlisted-classes>
    </persistence-unit>
</persistence>
```
