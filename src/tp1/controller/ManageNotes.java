package tp1.controller;

import java.util.ArrayList;
import tp1.model.Note;

/**
 *
 * @author lighttigerXIV
 */
public class ManageNotes {

    private ArrayList<Note> notes;

    public ManageNotes() {
        notes = new ArrayList<Note>();
    }

    public ArrayList<Note> getNotes() {
        return this.notes;
    }

    public boolean addNote(Note note) {
        return true;
    }

    public boolean updateNote(Note note) {
        return true;
    }

    public boolean deleteNote(Note note) {
        return true;
    }
}
