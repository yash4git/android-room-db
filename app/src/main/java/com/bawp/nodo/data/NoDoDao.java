package com.bawp.nodo.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.bawp.nodo.model.NoDo;

import java.util.List;

@Dao
public interface NoDoDao {
    //CRUD
    @Insert
    void insert(NoDo noDo);

    @Query("DELETE FROM nodo_table")
    void deleteAll();

    @Query("DELETE FROM nodo_table WHERE id = :id")
    int deleteANoDo(int id);


    @Query("UPDATE nodo_table SET nodo_col = :nodoText WHERE id = :id")
    int updateNoDoItem(int id, String nodoText);

    @Query("SELECT * FROM nodo_table ORDER BY nodo_col DESC")
    LiveData<List<NoDo>> getAllNoDos();

}
