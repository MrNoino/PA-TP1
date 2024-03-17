package tp1.controller;

import java.util.ArrayList;
import tp1.model.Note;

/**
 * A class to manage notes on the database
 */
public class ManageNotes {

    private ArrayList<Note> notes;

    public ManageNotes() {
        notes = new ArrayList<Note>();
    }

    /**
     *
     * @return Returns a list of notes
     */
    public ArrayList<Note> getNotes() {
        return this.notes;
    }

    /**
     * Adds a note
     *
     * @param note The note to add to the list
     * @return Confirms if a note was added successfully
     */
    public boolean addNote(Note note) {
        return true;
    }

    /**
     * Updates a note
     *
     * @param note The note to be updated
     * @return Confirms if a note was updated successfully
     */
    public boolean updateNote(Note note) {
        return true;
    }

    /**
     * Deletes a note
     *
     * @param note The note to be deleted
     * @return Confirms if a note was deleted successfully
     */
    public boolean deleteNote(Note note) {
        return true;
    }
}
