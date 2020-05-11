package at.htl.workmanager.model;

public class Repository {

    private static Repository instance;

    private Repository() {
    }

    public static Repository getInstance() {
        if(instance == null) {
            instance = new Repository();
        }

        return instance;
    }


}
