package josefmayer;

import com.datastax.driver.core.*;


public class CassandraClient_1 {

    public static void main(String[] args) {
        Cluster cluster;
        Session session;

        // Connect to the cluster and keyspace "demo"
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("demo");

        createTable(session);
        insert(session);
        selectAll(session);

        //selectByName(session);
        update(session);
        selectAll(session);

        cluster.close();

    }

    static void createTable(Session session){
        session.execute("CREATE TABLE users (firstname text, lastname text, city text, PRIMARY KEY (firstname));");
    }

    static void insert(Session session){
        session.execute("INSERT INTO users (firstname, lastname, city) VALUES ('Lucia', 'Lake', 'Barcelona')");
        session.execute("INSERT INTO users (firstname, lastname, city) VALUES ('James', 'Austin', 'Singapur')");
        session.execute("INSERT INTO users (firstname, lastname, city) VALUES ('Sybill', 'Miller', 'Melbourne')");

    }

    static void selectByName(Session session){
        ResultSet results = session.execute("SELECT * FROM users WHERE firstname='James'");
        for (Row row : results) {
            System.out.println(row.getString("firstname") + " " + row.getString("lastname") + " " + row.getString("city"));
            //System.out.println("FirstName: " + row.getString("firstname") + " LastName: " + row.getString("lastname") + " " + row.getString("city"));
        }
    }

    static void selectAll(Session session){
        ResultSet results = session.execute("SELECT * FROM users ");
        for (Row row : results) {
            System.out.println(row.getString("firstname") + " " + row.getString("lastname") + " " + row.getString("city"));
        }
    }

    static void update(Session session){
        session.execute("UPDATE users SET city = 'Adelaide' WHERE firstname = 'Sybill'");
    }



}
