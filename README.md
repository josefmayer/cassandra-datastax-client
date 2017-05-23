## Cassandra, Datastax Client
Cassandra database example with Datastax client driver <br />


### Technologies
Cassandra, CQL, Datastax client driver <br />


### Steps:
#### Start Cassandra 
cd /etc/init.d/ <br />
cassandra start <br /> 


#### Create keyspace
cqlsh < src/main/resources/create_keyspace.cql <br />


#### Compile, build jar
*mvn clean compile package* <br />
 

#### Run Appliation
*java -jar target/jar_name.jar* <br />






