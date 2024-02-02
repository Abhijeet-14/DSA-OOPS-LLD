package LLD.BookMyShow.model;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    private String id;
    private String name;
    private List<Screen> scrrens;

    public Theater(String id, String name){
        this.id = id;
        this.name = name;
        this.scrrens = new ArrayList<>();
    }

    public void addScreen(Screen screen){
        scrrens.add(screen);
    }

}
