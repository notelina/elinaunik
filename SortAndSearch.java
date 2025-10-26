import java.util.Arrays;

public class DataOrganizer {
    
    private static class SegmentCombiner {
        public static void organizeSegments(int[] data, int start, int end) {
            if (start < end) {
                int midpoint = start + (end - start) / 2;
                organizeSegments(data, start, midpoint);
                organizeSegments(data, midpoint + 1, end);
                combineSegments(data, start, midpoint, end);
            }
        }
        
        private static void combineSegments(int[] data, int start, int mid, int end) {
            int leftSize = mid - start + 1;
            int rightSize = end - mid;
            
            int[] leftSegment = new int[leftSize];
            int[] rightSegment = new int[rightSize];
            
            System.arraycopy(data, start, leftSegment, 0, leftSize);
            System.arraycopy(data, mid + 1, rightSegment, 0, rightSize);
            
            int leftIdx = 0, rightIdx = 0;
            int mergedIdx = start;
            
            while (leftIdx < leftSize && rightIdx < rightSize) {
                if (leftSegment[leftIdx] <= rightSegment[rightIdx]) {
                    data[mergedIdx++] = leftSegment[leftIdx++];
                } else {
                    data[mergedIdx++] = rightSegment[rightIdx++];
                }
            }
            
            while (leftIdx < leftSize) {
                data[mergedIdx++] = leftSegment[leftIdx++];
            }
            
            while (rightIdx < rightSize) {
                data[mergedIdx++] = rightSegment[rightIdx++];
            }
        }
    }
    
    private static class GapSorter {
        public static void sortWithReducingGaps(int[] data) {
            int length = data.length;
            
            for (int interval = length / 2; interval > 0; interval /= 2) {
                for (int current = interval; current < length; current++) {
                    int currentValue = data[current];
                    int position = current;
                    
                    while (position >= interval && data[position - interval] > currentValue) {
                        data[position] = data[position - interval];
                        position -= interval;
                    }
                    data[position] = currentValue;
                }
            }
        }
    }
    
    public static void displayArray(String message, int[] array) {
        System.out.println(message);
        Arrays.stream(array).forEach(val -> System.out.print(val + " "));
        System.out.println("\n");
    }
    
    public static void main(String[] args) {
        // Тестирование комбинирования сегментов
        int[] testData1 = {38, 27, 43, 3, 9, 82, 10};
        displayArray("Исходные данные для сегментного комбинирования:", testData1);
        SegmentCombiner.organizeSegments(testData1, 0, testData1.length - 1);
        displayArray("Данные после сегментного комбинирования:", testData1);
        
        // Тестирование сортировки с уменьшающимися интервалами
        int[] testData2 = {23, 12, 1, 8, 34, 54, 2, 3};
        displayArray("Исходные данные для интервальной сортировки:", testData2);
        GapSorter.sortWithReducingGaps(testData2);
        displayArray("Данные после интервальной сортировки:", testData2);
        
        // Дополнительный тест с другим набором данных
        int[] testData3 = {15, 7, 42, 19, 33, 28, 6, 51};
        displayArray("Дополнительные исходные данные:", testData3);
        GapSorter.sortWithReducingGaps(testData3);
        displayArray("Результат интервальной сортировки:", testData3);
    }
}
