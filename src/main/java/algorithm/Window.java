package algorithm;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class Window {
    private static boolean FileEntered = false;
    private static boolean bsort = true;
    private static boolean msort = false;


    public static void initWindow() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Algorithm Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(700, 500);

        JLabel titleLabel = new JLabel("Sorting Algorithm");
        JLabel textPlease = new JLabel("Enter numbers separated by commas (e.g. 50,10,100):");

        // fucking select your algorithm
        String[] algorithms = {"Bubble Sort", "Merge Sort"};
        JComboBox<String> algorithmSelector = new JComboBox<>(algorithms);

        //new stuff

        JMenuBar mb = new JMenuBar();
        JMenu x  = new JMenu("Open");
        JMenu h  = new JMenu("Help");
        JMenu sa = new JMenu("Sorting Algorithm");
        JMenu m = new JMenu("Mode");
        JMenu U = new JMenu("Uninstall");
        JMenuItem Files = new JMenuItem("Use a File");
        JMenuItem hm = new JMenuItem("Help me");
        JMenuItem ua = new JMenuItem("Uninstall App");
        JMenuItem dm = new JMenuItem("Use Demo file");
        JRadioButtonMenuItem bs = new JRadioButtonMenuItem("Bubble Sort");
        JRadioButtonMenuItem ms = new JRadioButtonMenuItem("Merge Sort");
        //JRadioButtonMenuItem l = new JRadioButtonMenuItem("Light Mode");
        JRadioButtonMenuItem d = new JRadioButtonMenuItem("Dark Mode");

        Files.setIcon(ImageImport.pngimport("/plus.png"));
        dm.setIcon(ImageImport.pngimport_s("/dfile.png", 16, 16));

        ButtonGroup sorting_s = new ButtonGroup();
        ButtonGroup mode = new ButtonGroup();

        sorting_s.add(bs);
        sorting_s.add(ms);

        //mode.add(l);
        mode.add(d);

        bs.setSelected(true);

        //l.setSelected(true);

        x.add(Files);
        x.add(dm);

        h.add(hm);

        U.add(ua);

        sa.add(bs);
        sa.add(ms);

        //m.add(l);
        m.add(d);

        mb.add(x);
        mb.add(h);
        mb.add(sa);
        mb.add(m);
        mb.add(U);

        frame.setJMenuBar(mb);

        GraphPanel graphPanel = new GraphPanel();

        JTextField[] field1 = {new JTextField(10)};
        JButton button = new JButton("Submit");

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        Runnable runSelectedAlgorithm = () -> {};

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = field1[0].getText();
                    String[] parts = input.split(",");
                    int[] array = new int[parts.length];

                    for (int i = 0; i < parts.length; i++) {
                        array[i] = Integer.parseInt(parts[i].trim());
                    }

                    graphPanel.setArray(array);

                    // === RUN SELECTED ALGORITHM ===
                    String selected = (String) algorithmSelector.getSelectedItem();
                    new Thread(() -> {
                        /*if (selected.equals("Bubble Sort")) {
                            BubbleSort.sort(array, graphPanel);
                        } else if (selected.equals("Merge Sort")) {
                            MergeSort.sort(array, graphPanel);
                        }*/
                        if (bsort){
                            BubbleSort.sort(array, graphPanel);
                        } else if (msort) {
                            MergeSort.sort(array, graphPanel);
                        }
                    }).start();

                } catch (NumberFormatException ex) {
                    System.out.println("Error: Please enter valid numbers!");
                }
            }
        });

        Files.addActionListener(e -> {
            field1[0].setText("File Entered");
            field1[0].setEditable(false);
            FileEntered = true;
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION){
                File ChosenFile = fileChooser.getSelectedFile();

                try(BufferedReader nreader = new BufferedReader(new FileReader(ChosenFile))) {
                    String input = nreader.readLine();
                    String[] parts = input.split(",");
                    int[] array = new int[parts.length];

                    for (int i = 0; i < parts.length; i++) {
                        array[i] = Integer.parseInt(parts[i].trim());
                    }

                    graphPanel.setArray(array);

                    // FUcking run the thing nigg-
                    //String selected = (String) algorithmSelector.getSelectedItem();
                    new Thread(() -> {
                        /*if (selected.equals("Bubble Sort")) {
                            BubbleSort.sort(array, graphPanel);
                        } else if (selected.equals("Merge Sort")) {
                            MergeSort.sort(array, graphPanel);
                        }*/

                        if (bsort){
                            BubbleSort.sort(array, graphPanel);
                        } else if (msort) {
                            MergeSort.sort(array, graphPanel);
                        }

                    }).start();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        dm.addActionListener(e -> {
            field1[0].setText("File Entered");
            field1[0].setEditable(false);
            FileEntered = true;

            try(BufferedReader nreader = new BufferedReader(new FileReader("Hi.txt"))) {
                String input = nreader.readLine();
                String[] parts = input.split(",");
                int[] array = new int[parts.length];

                for (int i = 0; i < parts.length; i++) {
                    array[i] = Integer.parseInt(parts[i].trim());
                }

                graphPanel.setArray(array);

                // running the algoritm ur gooner ass want
                String selected = (String) algorithmSelector.getSelectedItem();
                new Thread(() -> {
                    /*if (selected.equals("Bubble Sort")) {
                        BubbleSort.sort(array, graphPanel);
                    } else if (selected.equals("Merge Sort")) {
                        MergeSort.sort(array, graphPanel);
                    }*/
                    if (bsort){
                        BubbleSort.sort(array, graphPanel);
                    } else if (msort) {
                        MergeSort.sort(array, graphPanel);
                    }
                }).start();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        hm.addActionListener(e -> {
            try {
                Desktop pc = Desktop.getDesktop();
                URI uri = new URI("https://www.youtube.com/watch?v=N0Wkod3L45Q");
                pc.browse(uri);
            }catch (IOException | URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        });

        ua.addActionListener(e -> {
            try {
                Desktop pc = Desktop.getDesktop();
                URI uri = new URI("https://www.youtube.com/watch?v=E_qy2XYPJBo");
                pc.browse(uri);
            }catch (IOException | URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        });

        bs.addActionListener(e -> {
            if (msort){
                bsort = true;
                msort = false;
            }
        });

        ms.addActionListener(e -> {
            if (bsort){
                msort = true;
                bsort = false;
            }
        });

        d.addActionListener(e -> {
            Color bg = new Color(45, 45, 45);
            Color fg = new Color(220, 220, 220);

            frame.getContentPane().setBackground(bg);

            button.setBackground(new Color(70, 70, 70));
            button.setForeground(fg);
            titleLabel.setForeground(fg);
            textPlease.setForeground(fg);
            field1[0].setBackground(new Color(60, 60, 60));
            field1[0].setForeground(fg);
            field1[0].setCaretColor(fg);


            mb.setBackground(bg);
            mb.setForeground(fg);
            // idek wht the thing belowme is
            for (MenuElement me : mb.getSubElements()) {
                if (me instanceof JMenu) {
                    JMenu menu = (JMenu) me;
                    menu.setOpaque(true);
                    menu.setBackground(bg);
                    menu.setForeground(fg);
                    for (Component comp : menu.getMenuComponents()) {
                        if (comp instanceof JMenuItem) {
                            JMenuItem item = (JMenuItem) comp;
                            item.setOpaque(true);
                            item.setBackground(bg);
                            item.setForeground(fg);
                        }
                    }
                }
            }

            SwingUtilities.updateComponentTreeUI(frame);
        });



        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(titleLabel)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(textPlease)
                                        .addComponent(field1[0])
                                        //.addComponent(algorithmSelector)  // ADDED
                                        .addComponent(button)
                        )
                        .addComponent(graphPanel)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGroup(
                                layout.createParallelGroup(BASELINE)
                                        .addComponent(textPlease)
                                        .addComponent(field1[0])
                                        //.addComponent(algorithmSelector)
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