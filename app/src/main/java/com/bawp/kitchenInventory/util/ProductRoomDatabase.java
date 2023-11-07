package com.bawp.kitchenInventory.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.bawp.kitchenInventory.data.ProductDao;
import com.bawp.kitchenInventory.model.Product;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Product.class}, version = 1, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class ProductRoomDatabase extends RoomDatabase {
    public static final int NUMBER_OF_THREADS = 4;
    private static final String DATABASE_NAME = "kitchenInventory_database";
    private static volatile ProductRoomDatabase INSTANCE;
    public static final ExecutorService databaseWriterExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static final RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    databaseWriterExecutor.execute(()-> {
                        // invoke Dao and write
                        ProductDao productDao = INSTANCE.productDao();
                        productDao.deleteAll();

                        //writing to out table
                    });
                }
            };

    public static ProductRoomDatabase getDatabase(final Context Context) {
        if(INSTANCE==null) {
            synchronized (ProductRoomDatabase.class) {
                if(INSTANCE==null) {
                    INSTANCE = Room.databaseBuilder(Context.getApplicationContext(),
                            ProductRoomDatabase.class,DATABASE_NAME)
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract ProductDao productDao();
}
