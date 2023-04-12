package controller;

import model.Repository;
import model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MachineController {
    private final Repository repository;

    public MachineController(Repository repository) {
        this.repository = repository;
    }

    public List<Toy> readAllToys() {
        return repository.getAllToys();
    }

    public void controllerAddToy(Toy toy){
        repository.AddGroupToy(toy);
    }

    public Toy controllerStartPlay(){
        List<Toy> toys = repository.getAllToys();
        List toysForGame = controllerChoiceToysForGame(toys);
        controllerChoiceWinnerToy(toysForGame);
        return null;
    }

    private Toy controllerChoiceWinnerToy(List<Toy> toysForWinner){
        Random rnd = new Random();
        int RandomForWinnerToy = rnd.nextInt(toysForWinner.size());

        for (Toy toyForWinner: toysForWinner){
            if (toysForWinner.indexOf(toyForWinner) == RandomForWinnerToy){
                System.out.println("Поздравляю! Вы выиграли: " + toyForWinner.getNameToy());
                controllerDeleteWinnerToyFromMachine(toyForWinner);
                return toyForWinner;
            }
        }
        return null;
    }

    public void controllerDeleteWinnerToyFromMachine(Toy Toy){
        List<Toy> allToy = repository.getAllToys();

        for (Toy toy: allToy){
            if(toy.getIdGroupToy().equals(Toy.getIdGroupToy())){
                if (toy.getQuantityToy()>1){
                    int result = toy.getQuantityToy()-1;
                    toy.setQuantityToy(result);
                }
                else {
                    allToy.remove(toy);
                }
                repository.SaveToys(allToy);
            }
        }
    }

    private List controllerChoiceToysForGame(List<Toy> toys){
        int maxFrequencyWinner = controllerFoundMaxFrequencyWinner(toys);
        Random rnd = new Random();
        int probabilityNotToWin = rnd.nextInt(100);
//        int probabilityNotToWin = 7;
        System.out.println("Вероятность выигрыша: "+ (100-probabilityNotToWin));
        List<Toy> toysForGame = new ArrayList<>();
        if (maxFrequencyWinner > probabilityNotToWin) {

            for (Toy toy : toys) {
                if (toy.getFrequencyWinner() >= probabilityNotToWin) {
                    toysForGame.add(toy);

                }
            }
        }
        System.out.println(toysForGame);
        return toysForGame;
    }

    private int controllerFoundMaxFrequencyWinner(List<Toy> toys){
        int maxFrequencyWinner = 0;
        for(Toy toy : toys){
            int frequencyWinner = toy.getFrequencyWinner();
            if (frequencyWinner > maxFrequencyWinner){
                maxFrequencyWinner = frequencyWinner;
            }
        }
        return maxFrequencyWinner;
    }
}
