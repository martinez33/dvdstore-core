package com.mycompany.dvdstore.repository.memory;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

    private List<Movie> movies = new ArrayList<>();
    private static Long id = 0l;

    public Movie add(Movie movie){
        movie.setId(++id);
        movies.add(movie);
        System.out.println("The movie " + movie.getTitle() + " has been added.");
        return movie;
    }

    @Override
    public List<Movie> list() {
        return movies;
    }

    @Override
    public Movie getById(long id) {
        return movies.stream().
                filter(m -> m.getId()==id).
                findFirst().get();
    }
}
