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

        addPicUri(schema);

        (new DaoGenerator()).generateAll(schema, "daogallery/src/main/java");
    }

    private static void addPicUri(Schema schema) {
        Entity entity = schema.addEntity("PIC");

        entity.addIdProperty();
        entity.addStringProperty("Uri").notNull();
    }
}
