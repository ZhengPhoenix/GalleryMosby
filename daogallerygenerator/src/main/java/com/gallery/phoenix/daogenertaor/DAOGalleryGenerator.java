package com.gallery.phoenix.daogenertaor;


import java.io.File;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DAOGalleryGenerator {

    public DAOGalleryGenerator() {

    }

    public static void main(String args[]) throws Exception {

        Schema schema = new Schema(1, "com.gallery.phoenix.daogallery");

        addAlbumEntity(schema);
        addPicEntity(schema);

        (new DaoGenerator()).generateAll(schema, "daogallery/src/main/java");
    }

    private static void addPicEntity(Schema schema) {
        Entity entity = schema.addEntity("PIC");

        entity.addIdProperty();
        entity.addIntProperty("album_id").notNull();
        entity.addStringProperty("date");
        entity.addIntProperty("gallery_id");
    }

    private static void addAlbumEntity(Schema schema) {
        Entity entity = schema.addEntity("ALBUM");

        entity.addIdProperty();

        entity.addStringProperty("CreatedDate").notNull();
        entity.addStringProperty("UpdateDate");
        entity.addStringProperty("Name").notNull();
    }
}
