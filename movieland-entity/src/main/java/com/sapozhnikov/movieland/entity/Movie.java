package com.sapozhnikov.movieland.entity;

import java.util.Arrays;
import java.util.List;

public class Movie {
    private int id;
    private String nameRussian;
    private String nameNative;
    private String yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;
    private String description;
    private List<Country> countries;
    private List<Genre> genres;
    private List<Review> reviews;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRussian() {
        return nameRussian;
    }

    public void setNameRussian(String nameRussian) {
        this.nameRussian = nameRussian;
    }

    public String getNameNative() {
        return nameNative;
    }

    public void setNameNative(String nameNative) {
        this.nameNative = nameNative;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", nameRussian='" + nameRussian + '\'' +
                ", nameNative='" + nameNative + '\'' +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", picturePath='" + picturePath + '\'' +
                ", description='" + description + '\'' +
                ", countries=" + countries +
                ", genres=" + genres +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (Double.compare(movie.rating, rating) != 0) return false;
        if (Double.compare(movie.price, price) != 0) return false;
        if (!nameRussian.equals(movie.nameRussian)) return false;
        if (!nameNative.equals(movie.nameNative)) return false;
        if (!yearOfRelease.equals(movie.yearOfRelease)) return false;
        if (picturePath != null ? !picturePath.equals(movie.picturePath) : movie.picturePath != null) return false;
        if (description != null ? !description.equals(movie.description) : movie.description != null) return false;
        if (countries != null ? !countries.equals(movie.countries) : movie.countries != null) return false;
        if (genres != null ? !genres.equals(movie.genres) : movie.genres != null) return false;
        return reviews != null ? reviews.equals(movie.reviews) : movie.reviews == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + nameRussian.hashCode();
        result = 31 * result + nameNative.hashCode();
        result = 31 * result + yearOfRelease.hashCode();
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (picturePath != null ? picturePath.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (countries != null ? countries.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + (reviews != null ? reviews.hashCode() : 0);
        return result;
    }
}
