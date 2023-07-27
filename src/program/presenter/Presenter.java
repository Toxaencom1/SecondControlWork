package program.presenter;

import program.model.SimpleService;
import program.ScannerS;
import program.Validator;
import program.view.View;
public class Presenter {
    private View view;
    private SimpleService service;
    private Validator validator;


    public Presenter(View view, SimpleService service) {
        this.view = view;
        this.service = service;
        this.validator = new Validator();
        view.setPresenter(this);
    }



    public void exit(){
        view.setFlag(false);
    }

    public void addAnimal() {
        view.getTypeMenu().showTypeMenu();
        int choice = view.whichOne();
        view.print("Enter Animal name");
        String name = view.params();
        view.print("Enter Animal birth date (dd.mm.yy)");
        String dayOfBirth = view.params();
        view.print("Enter Animal commands have (Delimiter is \";\"). GO/FORWARD and STOP have by DEFAULT");
        String commands = view.params().toUpperCase();
        if (!service.addAnimal(choice,name,dayOfBirth,commands))
            addAnimal();
    }
    public void showCommands(){
        view.print("Choose animal id from the list");
        view.print(service.animalListToString());
        int choice = view.scan();
        view.print("\n"+service.showCommands(choice));
    }

    public void addCommandToAnimal() {
        view.print("Choose animal id from the list");
        view.print(service.animalListToString());
        int choice = view.scan();
        view.print("List of commands: GO STOP SIT STAND LAY VOICE WALK FORWARD");
        view.print("Enter command (Delimiter is \";\")");
        String command = view.params();
        view.print(service.addCommandToAnimal(choice,command));
    }

    public void deleteAnimal() {
        view.print("Choose animal id from the list");
        view.print(service.animalListToString());
        int choice = view.scan();
        view.print(service.deleteAnimal(choice));
    }

    public void showAnimals() {
        view.print(service.animalListToString());
        view.print("\nEnter to continue");
        validator.emergency_exit(ScannerS.getScanner().nextLine());
    }
}
