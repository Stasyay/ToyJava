package model;

public class Toy {

    private String idGroupToy = "";
    private String nameToy = "";
    private int quantityToy = 0;
    private int frequencyWinner = 0;



    public Toy(String nameToy, int quantityToy, int frequencyWinner) {
        this.nameToy = nameToy;
        this.quantityToy = quantityToy;
        this.frequencyWinner = frequencyWinner;
    }

    public Toy(String idToy, String nameToy, String quantityToy, String frequencyWinner){
        this(nameToy, Integer.parseInt(quantityToy), Integer.parseInt(frequencyWinner));
        this.idGroupToy = idToy;
    }

    public String getIdGroupToy() {
        return idGroupToy;
    }

    public void setIdGroupToy(String idToy) {
        this.idGroupToy = idToy;
    }

    public String getNameToy() {
        return nameToy;
    }

    public void setNameToy(String nameToy) {
        this.nameToy = nameToy;
    }

    public int getQuantityToy() {
        return quantityToy;
    }

    public void setQuantityToy(int quantityToy) {
        this.quantityToy = quantityToy;
    }

    public int getFrequencyWinner() {
        return frequencyWinner;
    }

    public void setFrequencyWinner(int frequencyWinner) {
        this.frequencyWinner = frequencyWinner;
    }
    @Override
    public String toString() {
        return String.format("Номер группы игрушек: %s Игрушка: %s  Количество в автомате: %d Вероятность выигрыша: %d", idGroupToy, nameToy, quantityToy, frequencyWinner);
    }
}
