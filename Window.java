import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;
import java.awt.event.*;

public class Window {

    public static void initWindow() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Algorithm Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(600, 500); 

        JLabel titleLabel = new JLabel("Sorting Algorithm");
        JLabel textPlease = new JLabel("Enter numbers separated by commas (e.g. 50,10,100):");

        GraphPanel graphPanel = new GraphPanel();

        JTextField field1 = new JTextField(10);
        JButton button = new JButton("Submit");

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = field1.getText();
                    String[] parts = input.split(",");
                    int[] array = new int[parts.length];

                    for (int i = 0; i < parts.length; i++) {
                        array[i] = Integer.parseInt(parts[i].trim());
                    }

                    graphPanel.setArray(array);

                    new Thread(() -> {
                        BubbleSort.sort(array, graphPanel);
                    }).start();

                } catch (NumberFormatException ex) {
                    System.out.println("Error: Please enter valid numbers!");
                }
            }
        });

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(titleLabel)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(textPlease)
                                        .addComponent(field1)
                                        .addComponent(button)
                        )
                        .addComponent(graphPanel) // oh yeah i changed this
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGroup(
                                layout.createParallelGroup(BASELINE)
                                        .addComponent(textPlease)
                                        .addComponent(field1)
                                        .addComponent(button)
                        )
                        .addComponent(graphPanel)
        );

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initWindow();
            }
        });
    }
}