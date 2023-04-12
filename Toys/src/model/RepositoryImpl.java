package model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository{
    private ToyMapper mapper = new ToyMapper();
    private FileOperation fileOperation;

    public RepositoryImpl(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Toy> getAllToys() {
        List<String> lines = fileOperation.readAllLines();
        List<Toy> toys = new ArrayList<>();
        for (String line : lines) {
            toys.add(mapper.map(line));
        }
        return toys;
    }

    @Override
    public String AddGroupToy(Toy toy) {
        List<Toy> toys = getAllToys();
        int max = 0;
        for (Toy item : toys) {
            int id = Integer.parseInt(item.getIdGroupToy());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        toy.setIdGroupToy(id);
        toys.add(toy);
        SaveToys(toys);
        return id;
    }

    @Override
    public void SaveToys(List<Toy> toys) {
        List<String> lines = new ArrayList<>();
        for (Toy item: toys) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }
}
