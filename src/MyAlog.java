import java.util.ArrayList;

/**
 * Created by wangss on 2015/3/13.
 * email:genhaoai@gmail.com
 */
public class MyAlog {
    public static void main(String[] args) {
        Integer unsorted[] = new Integer[]{2, 1, 3, 1, 5, 6, 2, 1, 6, 23, 6, 31, 64, 64, 3, 125, 7, 686, 2};
//        Sort.QuickSort(unsorted, 0, unsorted.length-1);
//        Sort.BubbleSort(unsorted);
        Sort.CocktailSort(unsorted);
        for (Integer integer : unsorted) {
            System.out.print(integer + ", ");
        }
    }


    public static int Partition(Integer unsorted[], int low, int high) {
        int temp = unsorted[low];
        while (low < high) {
            while (low < high && unsorted[high] >= temp) {
                high--;
            }
            unsorted[low] = unsorted[high];
            while (low < high && unsorted[low] < temp) {
                low++;
            }
            unsorted[high] = unsorted[low];
        }
        unsorted[low] = temp;
        return low;
    }
}

class Sort {
    /*快速排序*/
    public static void QuickSort(Integer unsorted[], int low, int high) {
        if (low < high) {
            int partition = MyAlog.Partition(unsorted, low, high);
            QuickSort(unsorted, low, partition);
            QuickSort(unsorted, partition + 1, high);
        }
    }

    /*冒泡排序*/
    public static void BubbleSort(Integer unsorted[]) {
        for (int i = 0; i < unsorted.length; i++) {
            for (int j = i; j < unsorted.length; j++) {
                if (unsorted[i] > unsorted[j]) {
                    int temp = unsorted[i];
                    unsorted[i] = unsorted[j];
                    unsorted[j] = temp;
                }
            }
        }
    }

    /*鸡尾酒排序法*/
    public static void CocktailSort(Integer unsorted[]) {
        boolean swapped = false;
        do {
            for (int i = 0; i < unsorted.length - 1; i++) {
                if (unsorted[i] > unsorted[i + 1]) {
                    int temp = unsorted[i];
                    unsorted[i] = unsorted[i + 1];
                    unsorted[i + 1] = temp;
                    swapped = true;
                }
            }

            swapped = false;
            for (int j = unsorted.length-1; j > 1; j--) {
                if (unsorted[j] < unsorted[j - 1]) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j - 1];
                    unsorted[j - 1] = temp;
                    swapped = true;
                }
            }

        } while (swapped);
    }
}