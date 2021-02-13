package gan.homeworks.Thread.HomeWork;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr;
    static float[] a1;
    static float[] a2;

    public static void main(String[] args) {

        arr = new float[SIZE];
        a1 = new float[HALF];
        a2 = new float[HALF];

        //1. Заполняем массив единицами
        for(int i = 0; i < SIZE;i++){
            arr[i] = 1;
        }

        //2. Первый вариант расчёта. Просто бежит по массиву arr и вычисляет значения.
        method1();

        /*3. Второй вариант расчёта. Массив делится на два массива, в двух потоках высчитывает
        новые значения и потом склеивает эти массивы обратно в один.*/
        method2();
    }

    public static void method1(){
        long a = System.currentTimeMillis();
        for(int i = 0;i < SIZE;i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Однопоточный режим: " + (System.currentTimeMillis() - a));
    }

    public static synchronized void method2(){
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr,HALF,a2,0,HALF);

        Thread thread = new Thread(() -> {
            for(int i = 0;i < HALF;i++){
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a1, 0, arr, HALF, HALF);
            System.out.println("Многопоточный режим(поток 1): " + (System.currentTimeMillis() - a));
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0;i < HALF;i++){
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a2, 0, arr, HALF, HALF);
            System.out.println("Многопоточный режим(поток 2): " + (System.currentTimeMillis() - a));
        });
        thread.start();
        thread2.start();
    }
}
