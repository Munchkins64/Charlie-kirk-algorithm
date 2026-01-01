import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.*;
import org.w3c.dom.Text;
import static javax.swing.GroupLayout.Alignment.*;
import java.awt.event.*;

public class Window {

    public static void NiggerWindow() {

        JFrame frame = new JFrame("Charlie kirk Algorithinm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400, 100);

        frame.setLayout(new FlowLayout());

        JLabel nga = new JLabel("Charlie kirk Algorithinm");
        JLabel textPlease = new JLabel("Enter you gyat damn number seperated by commas");
        JLabel FuckahhOutput = new JLabel("Result nigga");

        JTextArea resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        JTextField field1 = new JTextField(10);

        JButton button = new JButton("Submit");

        /*
         * 
         * GroupLayout layout = new GroupLayout(frame.getContentPane());
         * 
         * frame.getContentPane().setLayout(layout);
         * 
         * layout.setAutoCreateGaps(true);
         * layout.setAutoCreateContainerGaps(true);
         */

        button.setBounds(150, 200, 220, 50);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse input
                    String input = field1.getText();
                    String[] parts = input.split(",");
                    int[] array = new int[parts.length];

                    for (int i = 0; i < parts.length; i++) {
                        array[i] = Integer.parseInt(parts[i].trim());
                    }

                    // Call BubbleSort
                    BubbleSort.sort(array);

                    // Display result column-wise
                    StringBuilder result = new StringBuilder("Sorted (Ascending):\n");
                    for (int num : array) {
                        result.append(num).append("\n");
                    }
                    resultArea.setText(result.toString());

                } catch (NumberFormatException ex) {
                    resultArea.setText("Error: Please enter valid numbers!");
                }
            }
        });

        frame.add(nga);
        frame.add(textPlease);
        frame.add(field1);
        frame.add(button);
        frame.add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                NiggerWindow();
            }
        });
    }
}
