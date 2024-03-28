package tp1.controller;

import java.util.ArrayList;
import tp1.model.Notification;

/**
 * A class to manage notifications on the database
 */
public class ManageNotifications {

    private ArrayList<Notification> notifications;

    /**
     * Class constructor initializing the ArrayList
     */
    public ManageNotifications() {
        notifications = new ArrayList<Notification>();
    }

    /**
     * 
     * @return Returns a list of notifications
     */
    public ArrayList<Notification> getNotifications() {
        return this.notifications;
    }

    /**
     * Adds a notification
     *
     * @param notification The notification to add to the list
     * @return Confirms if a notification was added successfully
     */
    public boolean addNotification(Notification notification) {
        return true;
    }

    /**
     * Updates a notification
     *
     * @param notification The notification to be updated
     * @return Confirms if a notification was updated successfully
     */
    public boolean updateNotification(Notification notification) {
        return true;
    }

    /**
     * Deletes a notification
     *
     * @param notification The notification to be deleted
     * @return Confirms if a notification was deleted successfully
     */
    public boolean deleteNotification(Notification notification) {
        return true;
    }
}
