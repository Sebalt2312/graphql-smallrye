package org.acme.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Film {

    @Getter
    @Setter
    public String title;

    @Getter
    @Setter
    public Integer episodeID;

    @Getter
    @Setter
    public String director;

    @Getter
    @Setter
    public LocalDate releaseDate;
}
