package algorithm;

public class MergeSort {

    public static void sort(int[] array, GraphPanel panel) {
        mergeSort(array, 0, array.length - 1, panel);
    }

    private static void mergeSort(int[] array, int left, int right, GraphPanel panel) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(array, left, middle, panel);
            mergeSort(array, middle + 1, right, panel);

            merge(array, left, middle, right, panel);
        }
    }

    private static void merge(int[] array, int left, int middle, int right, GraphPanel panel) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[middle + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
            panel.repaint();
            sleep();
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
            panel.repaint();
            sleep();
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
            panel.repaint();
            sleep();
        }
    }

    // i hate niggers
    private static void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}