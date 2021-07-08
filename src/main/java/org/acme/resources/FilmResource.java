package org.acme.resources;

import io.smallrye.graphql.api.Context;
import io.smallrye.graphql.api.Subscription;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.multi.processors.BroadcastProcessor;
import org.acme.entity.Film;
import org.acme.entity.Hero;
import org.acme.service.GalaxyService;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class FilmResource {

    @Inject
    GalaxyService service;

    @Inject
    Context context;

    BroadcastProcessor<Hero> processor = BroadcastProcessor.create();

    // Queries

    @Query("allFilms")
    @Description("Get all Films from a Galaxy far far away.")
    public List<Film> getAllFilms() {
        return service.getAllFilms();
    }

    @Query
    @Description("Get a Film from a Galaxy far far away")
    public Film getFilm(Context context, @Name("filmId") int id) {
        return service.getFilm(id);
    }

    @Query
    @Description("Get all Heroes with given Surname")
    public List<Hero> getHeroesBySurname(@DefaultValue("Skywalker") String surname) {
        return service.getHeroesBySurname(surname);
    }

    public List<List<Hero>> heroes(@Source List<Film> films) {
        return service.getHeroesForAllFilms(films);
    }

    // Mutations

    @Mutation
    public Hero createHero(Hero hero) {
        service.addHero(hero);
        processor.onNext(hero);
        return hero;
    }

    @Mutation
    public Hero deleteHero(int id) {
        return service.deleteHero(id);
    }

    // Subscription

    @Subscription
    public Multi<Hero> heroCreated(){
        return processor;
    }

    // DataFetching

//    DataFetchingEnvironment dfe = context.unwrap(DataFetchingEnvironment.class);

    // Adding own features

//    public GraphQLSchema.Builder addMyOwnEnum(@Observes GraphQLSchema.Builder builder) {
//
//        //Adding your own features directly. Example Emun
//        GraphQLEnumType myOwnEnum = GraphQLEnumType.newEnum()
//                                                    .name("MyNewEnum")
//                                                    .description("A new own Enum")
//                                                    .value("Value 1")
//                                                    .value("Value 2").build();
//
//        return builder.additionalType(myOwnEnum);
//    }
}