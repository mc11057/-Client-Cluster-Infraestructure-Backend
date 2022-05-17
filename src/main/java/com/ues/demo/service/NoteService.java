package com.ues.demo.service;


import com.ues.demo.model.Note;

public interface NoteService {

    void storeFile(Note note) throws Exception;
    void getFiles() throws Exception;
    void storeInDatabase(Note note) throws Exception;
    void getFromDatabase() throws Exception;

}
