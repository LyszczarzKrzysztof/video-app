package com.example.videoapp.api;

import com.example.videoapp.dao.entities.VideoCassette;
import com.example.videoapp.exceptions.TaskNotFoundException;
import com.example.videoapp.exceptions.VideoCasseteNotFoundException;
import com.example.videoapp.manager.VideoCassetteManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes")
public class VideoCassetteAPI {


    private VideoCassetteManager videoCassetteManager;

    public VideoCassetteAPI(VideoCassetteManager videoCassetteManager) {
        this.videoCassetteManager = videoCassetteManager;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<VideoCassette>> getAll() {
        return ResponseEntity.ok(videoCassetteManager.findAll());
    }

    @GetMapping()
    public ResponseEntity<VideoCassette> getById(@RequestParam Long index) throws VideoCasseteNotFoundException {
        return ResponseEntity.ok(videoCassetteManager.findById(index));
    }

    @PostMapping
    public ResponseEntity<VideoCassette> postVideoCassette(@RequestBody VideoCassette videoCassette) {
        return new ResponseEntity(videoCassetteManager.saveVideoCassette(videoCassette), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<VideoCassette> updateVideoCassette(@RequestBody VideoCassette videoCassette) {
        return new ResponseEntity(videoCassetteManager.saveVideoCassette(videoCassette), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<VideoCassette> deleteVideoCassette(@RequestParam Long index) throws VideoCasseteNotFoundException {
        Optional<VideoCassette> videoCassette = Optional.ofNullable(videoCassetteManager.findById(index));
        if (videoCassette.isPresent()){
            videoCassetteManager.deleteById(index);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
