package com.itschool.jpa.otherstuff.designpatterns;


class DatabaseConnection {
    private static DatabaseConnection instance;
    private String connectionString;

    private DatabaseConnection() {
        connectionString = "jdbc:mysql://localhost:3306/db";
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null)
            instance = new DatabaseConnection();
        return instance;
    }

    public void connect() {
        System.out.println("Conecteaza la : " + connectionString);
    }


}

public class Singletone {
    public static void main(String... a) {
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connect();
        System.out.println(db);

        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println(db2);

    }
}
