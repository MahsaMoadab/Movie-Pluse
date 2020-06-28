package com.shariaty.movieplusetmdb.ui.home;

public class Movie {

    private String title;
    private String year;
    private String description;
    private String thumbnail;
    private String circlePhoto;
    private String coverPhoto;

    public Movie(String title, String year, String description, String thumbnail, String circlePhoto, String coverPhoto) {
        this.title = title;
        this.year = year;
        this.description = description;
        this.thumbnail = thumbnail;
        this.circlePhoto = circlePhoto;
        this.coverPhoto = coverPhoto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCirclePhoto() {
        return circlePhoto;
    }

    public void setCirclePhoto(String circlePhoto) {
        this.circlePhoto = circlePhoto;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }


}
