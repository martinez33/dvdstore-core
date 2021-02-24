package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultMovieService implements MovieServiceInterface{

    @Autowired
    private MovieRepositoryInterface movieRepositoryInterface;

    public MovieRepositoryInterface getMovieRepositoryInterface() {
        return movieRepositoryInterface;
    }

    public void setMovieRepositoryInterface(MovieRepositoryInterface movieRepositoryInterface) {
        this.movieRepositoryInterface = movieRepositoryInterface;
    }

    public Movie registerMovie(Movie movie){
        return movieRepositoryInterface.save(movie);
    }

    @Override
    public Iterable<Movie> getMovieList() {
        return movieRepositoryInterface.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepositoryInterface.findById(id).orElseThrow();
    }
}
