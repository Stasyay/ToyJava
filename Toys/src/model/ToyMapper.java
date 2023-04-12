package model;

public class ToyMapper {
    public String map(Toy toy) {
        return String.format("%s;%s;%d;%d", toy.getIdGroupToy(), toy.getNameToy(), toy.getQuantityToy(), toy.getFrequencyWinner());
    }
    public Toy map(String line) {
        String[] lines = line.split(";");
        return new Toy(lines[0], lines[1], lines[2], lines[3]);
    }
}
