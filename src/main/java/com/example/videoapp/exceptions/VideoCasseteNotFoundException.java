package com.example.videoapp.exceptions;

public class VideoCasseteNotFoundException extends Exception {
    public VideoCasseteNotFoundException() {
    }

    public VideoCasseteNotFoundException(String message){
        super(message);
    }
}
