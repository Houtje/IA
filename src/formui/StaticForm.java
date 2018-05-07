package formui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class StaticForm {
    private JPanel FormView;
    private JLabel minPriceLabel;
    private JLabel bedroomsLabel;
    private JLabel sizeLabel;
    private JLabel maxPriceLabel;
    private JFormattedTextField sizeTextField;
    private JFormattedTextField bedroomsTextField;
    private JFormattedTextField minPriceTextField;
    private JFormattedTextField maxPriceTextField;
    private JButton submitButton;

    // Variables usefull for the agent
    public int minPrice;
    public int maxPrice;
    public int bedrooms;
    public int size;


    public StaticForm() {

        // Read all the values from the form after submit is pressed
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size = Integer.parseInt(sizeTextField.getText());
                bedrooms = Integer.parseInt(bedroomsTextField.getText());
                minPrice = Integer.parseInt(minPriceTextField.getText());
                maxPrice = Integer.parseInt(maxPriceTextField.getText());
            }
        });

    }

    // Initialize the form
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("StaticForm");
        frame.setContentPane(new StaticForm().FormView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
