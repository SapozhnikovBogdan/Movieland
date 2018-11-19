package com.sapozhnikov.movieland.entity;

public class Movie {

    private int id;
    private String nameRussian;
    private String nameNative;
    private String yearOfRelease;
    private Double rating;
    private Double price;
    private String picturePath;

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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (!nameRussian.equals(movie.nameRussian)) return false;
        if (!nameNative.equals(movie.nameNative)) return false;
        if (!yearOfRelease.equals(movie.yearOfRelease)) return false;
        if (!rating.equals(movie.rating)) return false;
        if (!price.equals(movie.price)) return false;
        return picturePath != null ? picturePath.equals(movie.picturePath) : movie.picturePath == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nameRussian.hashCode();
        result = 31 * result + nameNative.hashCode();
        result = 31 * result + yearOfRelease.hashCode();
        result = 31 * result + rating.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
