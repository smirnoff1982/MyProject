package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuItem;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Controller {
    @FXML
    private TextField tf;
    @FXML
    private TextArea ta;
    @FXML
    private MenuItem history;
    @FXML
    private MenuItem cHistory;

    Double result = Double.valueOf("0");
    Double number1;
    Double number2;
    String action;
    String action2;
    int counter = 0;
    String text="";
    Model model = new Model();


    @FXML
    void onButton(ActionEvent ev) {
        String number;
        if (tf.getText().equals("0")) {
            String button = ((Button) ev.getSource()).getText();
            number = button;
            tf.setText(number);
            text+=button;
            ta.setText(text);
        } else {
            String button = ((Button) ev.getSource()).getText();
            number = tf.getText() + button;
            tf.setText(number);
            text+=button;
            ta.setText(text);
        }
    }

    @FXML
    void onButtonAction(ActionEvent ev) throws Exception {
        if (counter == 0) {
            number1 = Double.valueOf(tf.getText());
            action = ((Button) ev.getSource()).getText();
            tf.setText("0");
            counter++;
            result = number1;
            action2=action;
            text+=action;
            ta.setText(text);
        } else {
            action = ((Button) ev.getSource()).getText();
            text+=action;
            ta.setText(text);
            if (action.equals("+")) {
                if (action2.equals("+")) {
                    number1 = result + Double.valueOf(tf.getText());
                    result = number1;
                    tf.setText("0");
                    action = ((Button) ev.getSource()).getText();
                    action2=action;

                } else if (action2.equals("-")) {
                    number1 = result - Double.valueOf(tf.getText());
                    result = number1;
                    tf.setText("0");
                    action2=action;

                } else if (action2.equals("*")) {
                    number1 = result * Double.valueOf(tf.getText());
                    result = number1;
                    tf.setText("0");
                    action2=action;

                } else if (action2.equals("/")) {
                    try {
                        number1 = result / Double.valueOf(tf.getText());
                    } catch (Exception e) {
                        tf.setText("ERROR");
                    }
                    result = number1;
                    tf.setText("0");
                    action2=action;
                }

            } else if (action.equals("-")) {
                if (action2.equals("+")) {
                    number1 = result + Double.valueOf(tf.getText());
                    result = number1;
                    tf.setText("0");
                    action = ((Button) ev.getSource()).getText();
                    action2=action;

                } else if (action2.equals("-")) {
                    number1 = result - Double.valueOf(tf.getText());
                    result = number1;
                    tf.setText("0");
                    action2=action;

                } else if (action2.equals("*")) {
                    number1 = result * Double.valueOf(tf.getText());
                    result = number1;
                    tf.setText("0");
                    action2=action;

                } else if (action2.equals("/")) {
                    try {
                        number1 = result / Double.valueOf(tf.getText());
                    } catch (Exception e) {
                        tf.setText("ERROR");
                    }
                    result = number1;
                    tf.setText("0");
                    action2=action;
                }

            } else if (action.equals("*")) {
                if (action2.equals("+")) {
                    number1 = result + Double.valueOf(tf.getText());
                    result = number1;
                    tf.setText("0");
                    action = ((Button) ev.getSource()).getText();
                    action2=action;

                } else if (action2.equals("-")) {
                    number1 = result - Double.valueOf(tf.getText());
                    result = number1;
                    tf.setText("0");
                    action2=action;

                } else if (action2.equals("*")) {
                    number1 = result * Double.valueOf(tf.getText());
                    result = number1;
                    tf.setText("0");
                    action2=action;

                } else if (action2.equals("/")) {
                    try {
                        number1 = result / Double.valueOf(tf.getText());
                    } catch (Exception e) {
                        tf.setText("ERROR");
                    }
                    result = number1;
                    tf.setText("0");
                    action2=action;
                }

            } else if (action.equals("/")) {
                try {
                    if (action2.equals("+")) {
                        number1 = result + Double.valueOf(tf.getText());
                        result = number1;
                        tf.setText("0");
                        action = ((Button) ev.getSource()).getText();
                        action2=action;

                    } else if (action2.equals("-")) {
                        number1 = result - Double.valueOf(tf.getText());
                        result = number1;
                        tf.setText("0");
                        action2=action;

                    } else if (action2.equals("*")) {
                        number1 = result * Double.valueOf(tf.getText());
                        result = number1;
                        tf.setText("0");
                        action2=action;

                    } else if (action2.equals("/")) {
                        try {
                            number1 = result / Double.valueOf(tf.getText());
                        } catch (Exception e) {
                            tf.setText("ERROR");
                        }
                        result = number1;
                        tf.setText("0");
                        action2=action;
                    }
                } catch (Exception e) {
                    tf.setText("ERROR");
                }
                result = number1;
                tf.setText("0");

            }

        }
    }


    @FXML
    void onButtonResult(ActionEvent ev) throws Exception {
        number2 = Double.valueOf(tf.getText());

        if (action.equals("+")) {
            result = number1 + number2;
            tf.setText(String.valueOf(result));
        } else if (action.equals("-")) {
            result = number1 - number2;
            tf.setText(String.valueOf(result));
        } else if (action.equals("*")) {
            result = number1 * number2;
            tf.setText(String.valueOf(result));
        } else if (action.equals("/")) {
            try {
                result = number1 / number2;
                tf.setText(String.valueOf(result));
            } catch (NullPointerException e) {
                tf.setText("ERROR");

            }
        }
        text+= "=" + result;
        ta.setText(text);
        model.addHistory(text);
        counter = 0;
        result = Double.valueOf("0");
    }

    @FXML
    void onButtonCancel(ActionEvent ev) {
        tf.setText("0");
        counter = 0;
        result = Double.valueOf("0");
        text = "";
        ta.setText(text);

    }

    @FXML
    void onButtonFinish(ActionEvent ev) {
        ta.setText("");
        Platform.exit();
        System.exit(0);

    }

    @FXML
    void showHistory(ActionEvent ev) throws IOException {
            text = model.showHistory();
            ta.setText(text);


        }

    @FXML
    void clearHistory(ActionEvent ev) {
        ta.setText("");
        model.clearHistory();

    }
}
