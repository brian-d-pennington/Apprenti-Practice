package learn.unexplained;

import learn.unexplained.data.EncounterFileRepository;
import learn.unexplained.domain.EncounterService;
import learn.unexplained.models.Encounter;
import learn.unexplained.ui.Controller;
import learn.unexplained.ui.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
//        EncounterFileRepository repository = new EncounterFileRepository("./data/encounters.csv");
//        EncounterService encounterService = new EncounterService(repository);
//        View view = new View();
//        Controller controller = new Controller(encounterService, view);
        ApplicationContext context = new ClassPathXmlApplicationContext("dependency-configuration.xml");
        Controller controller = context.getBean(Controller.class);
        controller.run();
    }
}
