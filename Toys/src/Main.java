import controller.MachineController;
import model.FileOperation;
import model.FileOperationImpl;
import model.RepositoryImpl;
import model.Repository;
import view.ViewMashine;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("macshine.csv");
        Repository repository = new RepositoryImpl(fileOperation);
        MachineController controller = new MachineController(repository);
        ViewMashine view = new ViewMashine(controller);
        view.run();
    }
}