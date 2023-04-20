public class RadixSort {

    // метод для получения максимального значения в массиве
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // метод для сортировки массива по указанному разряду
    private static void countSort(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];

        // считаем количество элементов, оканчивающихся на указанный разряд
        for (int i = 0; i < arr.length; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // суммируем количество элементов до текущего разряда
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // переносим элементы в выходной массив в правильном порядке
        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // копируем отсортированный массив в исходный
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    // метод для выполнения поразрядной сортировки
    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        // выполняем сортировку для каждого разряда, начиная с младшего
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}