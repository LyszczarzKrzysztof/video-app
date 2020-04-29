package com.example.videoapp.api;

import com.example.videoapp.dao.entities.VideoCassette;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes")
public class VideoCassetteAPI {

    private List<VideoCassette> videoCassettes;

    public VideoCassetteAPI() {
        videoCassettes = new ArrayList<>();
        videoCassettes.add(new VideoCassette(1L, "Titanic", LocalDate.of(1995, 12, 12)));
        videoCassettes.add(new VideoCassette(2L, "Pulp Fiction", LocalDate.of(1990, 2, 2)));
    }

    @GetMapping("/all")
    public List<VideoCassette> getAll() {
        return videoCassettes;
    }

    @GetMapping()
    public VideoCassette getById(@RequestParam Long index) {
        Optional<VideoCassette> videoCassetteById = videoCassettes.stream().filter(element -> element.getId() == index).findFirst();
        return videoCassetteById.get();
    }

    @PostMapping
    public boolean postVideoCassette(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.add(videoCassette);
    }

    @PutMapping
    public boolean updateVideoCassette(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.add(videoCassette);
    }

    @DeleteMapping
    public boolean deleteVideoCassette(@RequestParam Long index) {
        return videoCassettes.removeIf(element -> element.getId() == index);
    }
}
