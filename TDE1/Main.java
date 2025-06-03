import controller.AutomovelController;
import model.AutomovelRepository;
import view.AutomovelView;

public class Main {
    public static void main(String[] args) {
        AutomovelRepository repository = new AutomovelRepository();
        AutomovelView view = new AutomovelView();
        AutomovelController controller = new AutomovelController(repository, view);

        controller.iniciar();
    }
}
