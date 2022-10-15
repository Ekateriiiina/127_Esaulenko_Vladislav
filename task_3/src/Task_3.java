public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int count = 0;
        if(n1 < n2){
            for(; n1 <= n2; n1++){
                if(n1%a == 0 && n1%b !=0)
                    count++;
            }
        } else {
            for(; n2 <= n1; n2++){
                if(n2%a == 0 && n2%b !=0)
                    count++;
            }
        }
        return count;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        int count = 0, finalNumber = 0;
        for(int i = 1; i <= num; i++){
            count += i;
            if(count >= num){
                finalNumber = i;
                break;
            }
        }
        return finalNumber;
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        int lastMeaning = num, nextMeaning, sum = num;
        for(int i = 1; i < cnt; i++){
            nextMeaning = lastMeaning*d+1;
            sum += nextMeaning;
            lastMeaning = nextMeaning;
        }
        return sum;
    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        int sum = 0, interMeaning = 1;
        for(int i = 1; i <= n; i++){
            interMeaning *= i;
            sum += interMeaning;
        }
        return sum;
    }
}
