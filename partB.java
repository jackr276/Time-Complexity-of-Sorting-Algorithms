import java.util.Arrays;
import java.util.Random;

public class partB {
    public static void main(String[] args){
        int[] randarr1 = createRandArr(100);
        System.out.println(Arrays.toString(randarr1));
        System.out.println(Arrays.toString(mergeSort(randarr1.clone(), 0, randarr1.length-1)));


    }


    private static int[] createRandArr(int arraySize){
        Random rand = new Random();
        int[] randArr = new int[arraySize];
        int i = 0;
        while (i < arraySize){
            randArr[i] = rand.nextInt(-10000, 10000);
            i++;
        }
        return randArr;
    }

    private static int[] BubbleSort(int[] unsortedArr){
        int[] internalArr = unsortedArr.clone();
        boolean sorted = false;
        int temp;

        for (int i = 1; (i<internalArr.length) && !sorted; i++){
            sorted = true;
            for (int j = 0; j<internalArr.length-i; j++){
                if (internalArr[j] > internalArr[j+1]){
                    int temp2 = internalArr[j];
                    internalArr[j] = internalArr[j+1];
                    internalArr[j+1] = temp2;
                    sorted = false;
                }
            }
        }
        return internalArr;
    }

    private static int[] insertionSort(int[] unsortedArr){
        int[] internalArr = unsortedArr.clone();
        for (int unsorted = 1; unsorted < internalArr.length; unsorted++){
            int nextItem = internalArr[unsorted];
            int location = unsorted;
            while ((location > 0) && (internalArr[location-1] > nextItem)) {
                internalArr[location] = internalArr[location-1];
                location--;
            }
            internalArr[location] = nextItem;
        }
        return  internalArr;
    }


    private static int[] selectionSort(int[] unsortedArr){
        int[] internalArr = unsortedArr.clone();
        for (int i = 0; i < internalArr.length; i++){
            int minIndex = i;
            int minValue = unsortedArr[i];

            for (int j = i+1; j < internalArr.length; j++){
                if (minValue > internalArr[j]){
                    minValue = internalArr[j];
                    minIndex = j;
                }
            }
            int temp = internalArr[i];
            internalArr[i] = internalArr[minIndex];
            internalArr[minIndex] = temp;
        }
        return internalArr;
    }

    private static int[] mergeSort(int[] internalArr, int first, int last){

        if (first < last){
            int mid = (first + last)/2;

            mergeSort(internalArr, first, mid);
            mergeSort(internalArr, mid+1, last);

            merge(internalArr, first, mid, last);
        }
        return internalArr;
    }


    private static void merge(int[] internalArr, int first, int mid, int last) {
      int size1 = mid - first + 1;
      int size2 = last - mid;

      //Create temp arrays
      int[] leftArr = new int[size1];
      int[] rightArr = new int[size2];

      for (int i = 0; i < size1; i++){
          leftArr[i] = internalArr[first+i];
      }
      for (int j = 0; j < size2; j++){
          rightArr[j] = internalArr[mid + 1 + j];
      }

      int i = 0, j = 0;

      int k = first;
      while((i < size1) && (j < size2)){
          if (leftArr[i] <= rightArr[j]){
              internalArr[k] = leftArr[i];
              i++;
          } else {
              internalArr[k] = rightArr[j];
              j++;
          }
          k++;
      }

      while (i < size1){
          internalArr[k] = leftArr[i];
          i++;
          k++;
      }

      while (j < size2){
          internalArr[k] = rightArr[j];
          j++;
          k++;
      }
    }
}



