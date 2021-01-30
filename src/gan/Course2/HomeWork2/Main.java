package gan.Course2.HomeWork2;

import gan.Course2.HomeWork2.Exception.MyArrayDataException;
import gan.Course2.HomeWork2.Exception.MyArraySizeException;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] array = {
                {"1","2","4","3"},
                {"1","10","1","3"},
                {"1","2","4","3"},
                {"1","2","4","3"}
        };
        arrayException(array);
    }

    static void arrayException(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length > 4 || arr[0].length > 4) {
            throw new MyArraySizeException("Задан массив превышающий указанные диапазоны");
        }else{
            int sumArrData = 0;
            for (int i = 0; i < arr.length; i++){
                for (int j = 0; j < arr[i].length; j++){
                    try{
                        sumArrData += parseInt(arr[i][j]);
                    }catch(NumberFormatException e) {
                        throw new MyArrayDataException("В ячейке:" + "[" + (i + 1) + "]"
                                + "[" + (j + 1) + "]" + " находится не число");
                    }
                }
            }
            System.out.println("Сумма чисел в массиве = " + sumArrData);
        }
    }

}
