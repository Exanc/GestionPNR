package GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class Controller {
    
    @FXML
    private Text output;

    private String operator;
    private String a;

    @FXML
    private void processNumpad(ActionEvent event) {

        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        
        String value = ((Button)event.getSource()).getText();

        if (! value.equals("=")) {
            operator = value;

            if (! output.getText().equals("")) {
                a = output.getText();
                output.setText("");
            }
            
        } else {
            output.setText("" + Model.calculate(Long.parseLong(a), Long.parseLong(output.getText()), operator));
        }
    }
}
