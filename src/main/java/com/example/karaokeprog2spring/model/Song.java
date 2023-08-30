package com.example.karaokeprog2spring.model;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Setter
public class Song {
    private int id_songs;
    private String title;
    private String artist;
    private int genreId;
    private int year;
    private String lyrics;
}
