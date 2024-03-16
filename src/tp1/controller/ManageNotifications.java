package tp1.controller;

import java.util.ArrayList;
import tp1.model.Notification;

/**
 *
 * @author lighttigerXIV
 */
public class ManageNotifications {

    private ArrayList<Notification> notifications;

    public ManageNotifications() {
        notifications = new ArrayList<Notification>();
    }

    public ArrayList<Notification> getNotifications() {
        return this.notifications;
    }

    public boolean addNotification(Notification notification) {
        return true;
    }

    public boolean updateNotification(Notification notification) {
        return true;
    }

    public boolean deleteNotification(Notification notification) {
        return true;
    }
}
