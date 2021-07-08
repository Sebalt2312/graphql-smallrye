package org.acme.resources;

import org.acme.entity.Film;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

class FilmResourceTest {

    @Test
    void getAllFilms() {
        given().when()
                .queryParam("allFilms {\n" +
                        "    title\n" +
                        "    releaseDate\n" +
                        "  }")
                .then()
                .statusCode(200);
    }

    @Test
    void getFilm() {
        Film film = new Film();
        film.title = "A New Hope";
        film.releaseDate = LocalDate.of(1977, Month.MAY, 25);
        film.episodeID = 4;
        film.director = "George Lucas";

        given().when()
                .queryParam("film(filmId: 1) {\n" +
                        "    title\n" +
                        "    director\n" +
                        "    releaseDate\n" +
                        "    episodeID\n" +
                        "  }")
                .then()
                .statusCode(200)
                .body(is(film));
    }

    @Test
    void getHeroesBySurname() {
    }

    @Test
    void heroes() {
    }

    @Test
    void createHero() {
        given().when()
                .queryParam("createHero(hero: {\n" +
                        "      name: \"Han\",\n" +
                        "      surname: \"Solo\"\n" +
                        "      height: 1.85\n" +
                        "      mass: 80\n" +
                        "      darkSide: false\n" +
                        "      episodeIds: [4, 5, 6]\n" +
                        "  \t}\n" +
                        "  )")
                .then()
                .statusCode(200)
                .body(contains("name: "));
    }

    @Test
    void deleteHero() {
//        given().when()
//                .queryParam()
    }

    @Test
    void heroCreated() {
    }
}