package app.first.sandy.databaseassignment4.beans;

/**
 * Created by manjula on 09-02-2017.
 */

public class Beans {

    int id;
    String first_name;
    String last_name;

//    public Beans(int id) {
//        this.id = id;
//    }

//    public Beans(String first_name, String last_name) {
//
//        this.first_name = first_name;
//        this.last_name = last_name;
//
//    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
