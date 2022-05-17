package com.ues.demo.controller;


import com.ues.demo.model.Note;
import com.ues.demo.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/app/v1/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/storeFile")
    public ResponseEntity<String> storeFile(@RequestBody Note note) {
        try{
            noteService.storeFile(note);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @GetMapping("/getFiles")
    public ResponseEntity<String> getFiles() {
        try{
            noteService.getFiles();
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @PostMapping("/storeDatabase")
    public ResponseEntity<String> storeDatabase(@RequestBody Note note) {
        try{
            noteService.storeInDatabase(new Note());
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @GetMapping("/getFromDatabase")
    public ResponseEntity<String> getFromDatabase() {
        try{
            noteService.getFromDatabase();
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
