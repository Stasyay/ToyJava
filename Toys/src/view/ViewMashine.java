package view;

import controller.MachineController;
import model.Toy;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ViewMashine {

    private final MachineController machineController;

    public ViewMashine(MachineController machineController) {
        this.machineController = machineController;
    }

    public void run() {
        Commands com;

        while (true){
            String command = prompt("\nADD_TOYS - добавить игрушку \nPLAY - играть \nVIEW_TOYS - посмотреть загруженные игрушки \nВведите команду: \n");
                    try {
                        com = Commands.valueOf(command.toUpperCase());

                        if(com==Commands.EXIT) return;
                        switch (com) {
                            case ADD_TOYS:
                                addToys();
                                break;
                            case VIEW_TOYS:
                                listToys();
                                break;
                            case PLAY:
                                StartPlay();
                                break;
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
        }
    }

    private void addToys() throws Exception{
        machineController.controllerAddToy(inputToy());
    }

    private void listToys() throws Exception{
        List<Toy> ListToys = machineController.readAllToys();
        for (Toy toy : ListToys){
            System.out.println(toy);
        }

    }

    private void StartPlay() throws Exception{
        System.out.println("Start Game");
        machineController.controllerStartPlay();

    }

    private Toy inputToy(){
        String nameToy = prompt("Игрушка: ");
        int quantityToy = Integer.parseInt(prompt("Количество: "));
        int frequencyWinner = Integer.parseInt(prompt("Частота выигрыша: "));
        return new Toy(nameToy, quantityToy, frequencyWinner);
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
