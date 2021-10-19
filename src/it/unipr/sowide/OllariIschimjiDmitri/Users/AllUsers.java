package it.unipr.sowide.OllariIschimjiDmitri.Users;

import java.util.ArrayList;

public class AllUsers {
    private final ArrayList<NormalUser> normalUsers = new ArrayList<>();
    private final ArrayList<WorkerUser> workerUsers = new ArrayList<>();

    public ArrayList<NormalUser> getNormalUsers() {
        return normalUsers;
    }

    public ArrayList<WorkerUser> getWorkerUsers() {
        return workerUsers;
    }
    public void addToNormal(NormalUser normalUser){
        normalUsers.add(normalUser);
    }

    public void addToWorker(WorkerUser workerUser){
        workerUsers.add(workerUser);
    }
}
