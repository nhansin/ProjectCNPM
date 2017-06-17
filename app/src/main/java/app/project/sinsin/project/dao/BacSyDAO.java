package app.project.sinsin.project.dao;

import java.util.ArrayList;

import app.project.sinsin.project.model.BacSy;

/**
 * Created by nhan-dev on 6/4/2017.
 */

public class BacSyDAO {

    public ArrayList<BacSy> listBacSy;

    public BacSyDAO() {
        listBacSy = new ArrayList<>();
        createDatabase();
    }

    private void createDatabase() {
        listBacSy.add(new BacSy("BacSy1", "0169 252 6508", "14130274@st.hcmuaf.edu.vn", "drawable/logo"));
        listBacSy.add(new BacSy("BacSy2", "01699552922", "jffffff@mgail", "drawable/logo"));
        listBacSy.add(new BacSy("BacSy3", "01225570944", "jffffff@mgail", "drawable/logo"));
        listBacSy.add(new BacSy("BacSy4", "0583640680", "jffffff@mgail", "drawable/logo"));
    }
}
