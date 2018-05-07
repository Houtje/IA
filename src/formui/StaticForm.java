package formui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaticForm {
    private JPanel FormView;
    private JLabel minPriceLabel;
    private JLabel bedroomsLabel;
    private JLabel minSizeLabel;
    private JLabel maxPriceLabel;
    private JLabel maxSizeLabel;
    private JFormattedTextField minSizeTextField;
    private JFormattedTextField bedroomsTextField;
    private JFormattedTextField minPriceTextField;
    private JFormattedTextField maxPriceTextField;
    private JButton submitButton;
    private JFormattedTextField maxSizeTextField;
    private JCheckBox transportationCheckBox;

    // Variables usefull for the agent
    public int minPrice;
    public int maxPrice;
    public int bedrooms;
    public int minSize;
    public int maxSize;
    public boolean transportation;


    public StaticForm() {

        // Read all the values from the form after submit is pressed
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                minSize = Integer.parseInt(minSizeTextField.getText());
                maxSize = Integer.parseInt(maxSizeTextField.getText());
                bedrooms = Integer.parseInt(bedroomsTextField.getText());
                minPrice = Integer.parseInt(minPriceTextField.getText());
                maxPrice = Integer.parseInt(maxPriceTextField.getText());

                transportation = transportationCheckBox.isSelected();
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
