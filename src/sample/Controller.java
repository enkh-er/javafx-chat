package sample;

import javafx.stage.Stage;

public class Controller {
    protected Stage parentStage;
    protected Main owner;

    /**
     * Main объект үүсгэх метод
     * @param owner Main class-аас дамжуулах объект
     */
    public void setOwner(Main owner) { this.owner = owner; }

    /**
     * Эцэг stage утгыг оноож өгөх метод
     * @param parentStage эцэг буюу үүсгэсэн Stage
     */
    public void setParentStage(Stage parentStage) { this.parentStage = parentStage; }
}
