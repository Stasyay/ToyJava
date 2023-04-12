package model;

import java.util.List;

public interface Repository {
    List<Toy> getAllToys();
    String AddGroupToy(Toy toy);
    void SaveToys(List<Toy> toys);

}
