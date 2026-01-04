package algorithm;

public class BubbleSort {

    public static void sort(int[] array, GraphPanel panel) {
        int length = array.length;
        int temp;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {

                    // The Swap
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    panel.repaint();

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}