package com.example.videoapp.manager;

import com.example.videoapp.dao.VideoCassetteRepository;
import com.example.videoapp.dao.entities.VideoCassette;
import com.example.videoapp.exceptions.VideoCasseteNotFoundException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VideoCassetteManager {

    private VideoCassetteRepository videoCassetteRepository;


    public VideoCassetteManager(VideoCassetteRepository videoCassetteRepository) {
        this.videoCassetteRepository = videoCassetteRepository;
    }

    public VideoCassette findById(Long id) throws VideoCasseteNotFoundException {
        return videoCassetteRepository.findById(id).orElseThrow(()->
                new VideoCasseteNotFoundException("Could not find VideoCassette with id"+id));
    }

    public Iterable<VideoCassette> findAll(){
        return videoCassetteRepository.findAll();
    }

    public VideoCassette saveVideoCassette(VideoCassette videoCassette){
        return videoCassetteRepository.save(videoCassette);
    }

    public void deleteById(Long id){
       videoCassetteRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        saveVideoCassette(new VideoCassette(1L, "Titanic", LocalDate.of(1995, 12, 12)));
        saveVideoCassette(new VideoCassette(2L, "Pulp Fiction", LocalDate.of(1990, 2, 2)));
    }
}
