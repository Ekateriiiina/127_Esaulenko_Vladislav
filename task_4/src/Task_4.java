public class Task_4 implements Task_4_base {
    @Override
    public int[] subtask_1_arrays(int size, int a0, int d) {
        // сгенерировать и вернуть массив размера size, содержащий элементы
        // арифметической прогрессии с первым членом a0 и разностью d
        int[] progressArray = new int[size];
        progressArray[0] = a0;
        for (int i = 1; i < size; i++) {
            progressArray[i] = progressArray[i - 1] + d;
        }
        return progressArray;
    }

    @Override
    public int[] subtask_2_arrays(int size) {
        // сгенерировать и вернуть массив размера size, первые два элемента
        // которого равны единице, а каждый следующий - сумме всех предыдущих
        int[] numbers = new int[size];
        int sum = 2;
        for (int i = 0; i < size; i++) {
            if (i <= 1)
                numbers[i] = 1;
            else {
                numbers[i] = sum;
                sum += sum;
            }
        }
        return numbers;
    }

    @Override
    public int[] subtask_3_arrays(int size) {
        // сгенерировать и вернуть массив размера size, содержащий первые
        // size чисел последовательности фибоначчи.
        // https://ru.wikipedia.org/wiki/Числа_Фибоначчи
        int[] fibonacci = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == 0)
                fibonacci[i] = 0;
            else if (i == 1)
                fibonacci[i] = 1;
            else
                fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }
        return fibonacci;
    }

    @Override
    public int subtask_4_arrays(int[] data) {
        // Для данного массива вычислить максимальный элемент
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max)
                max = data[i];
        }
        return max;
    }

    @Override
    public int subtask_5_arrays(int[] data, int k) {
        // Для данного массива вычислить максимальный элемент
        // кратный k. Гарантируется, что как минумум один такой элемент
        // в массиве есть
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max && data[i] % k == 0)
                max = data[i];
        }
        return max;
    }

    // рекурсия для сортировки
    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int reference = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < reference) {
                i++;
            }

            while (array[j] > reference) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    @Override
    public int[] subtask_6_arrays(int[] arr1, int[] arr2) {
        // Даны два массива arr1, arr2.
        // Произвести слияние данных массивов в один отсортированный
        // по возрастанию массив.
        if (arr2.length == 0) {
            int low = 0;
            int high = arr1.length - 1;
            quickSort(arr1, low, high);

            return arr1;
        } else if (arr1.length == 0) {
            int low = 0;
            int high = arr2.length - 1;
            quickSort(arr2, low, high);

            return arr2;
        } else {
            int[] arr3 = new int[arr1.length + arr2.length];
            int count = 0;
            for (int i = 0; i < arr1.length; i++) {
                arr3[i] = arr1[i];
                count++;
            }
            for (int i = 0; i < arr2.length; i++) {
                arr3[count++] = arr2[i];
            }

            int low = 0;
            int high = arr3.length - 1;
            quickSort(arr3, low, high);

            return arr3;
        }
    }

    @Override
    public int[] subtask_7_arrays(int[] arr1, int[] arr2) {
        // Даны два отсортированных по возрастанию массива arr1, arr2.
        // Произвести слияние данных массивов в один также отсортированный
        // по возрастанию массив.
        // Используйте алгоритм, время работы которого будет пропорционально сумме
        // размеров arr1 и arr2, а не их произведению
        if (arr2.length == 0) {
            int low = 0;
            int high = arr1.length - 1;
            quickSort(arr1, low, high);

            return arr1;
        } else if (arr1.length == 0) {
            int low = 0;
            int high = arr2.length - 1;
            quickSort(arr2, low, high);

            return arr2;
        } else {
            int[] arr3 = new int[arr1.length + arr2.length];
            int count = 0;
            for (int i = 0; i < arr1.length; i++) {
                arr3[i] = arr1[i];
                count++;
            }
            for (int i = 0; i < arr2.length; i++) {
                arr3[count++] = arr2[i];
            }

            int low = 0;
            int high = arr3.length - 1;
            quickSort(arr3, low, high);

            return arr3;
        }
    }
}

