package com.gallery.phoenix.daogallery;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "PIC".
 */
public class PIC {

    private Long id;
    private int album_id;
    private String date;
    private Integer gallery_id;

    public PIC() {
    }

    public PIC(Long id) {
        this.id = id;
    }

    public PIC(Long id, int album_id, String date, Integer gallery_id) {
        this.id = id;
        this.album_id = album_id;
        this.date = date;
        this.gallery_id = gallery_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getGallery_id() {
        return gallery_id;
    }

    public void setGallery_id(Integer gallery_id) {
        this.gallery_id = gallery_id;
    }

}
