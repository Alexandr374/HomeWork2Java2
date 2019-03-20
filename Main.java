package ru.geekbrains.lesson1_J2;
//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
//      при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
//      Если в каком-то элементе массива преобразование не удалось
//      (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException,
//      с детализацией в какой именно ячейке лежат неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
//      MyArrayDataException, и вывести результат расчета.

public class Main {

    public static void main(String[] args) {
//        String[][] array = {{"2", "30", "4", "4"}, {"5", "6", "4", "2"}, {"5", "4", "7", "8"}, {"4", "5", "6", "7"}};
//        String[][] array = {{"2","30","4","i"},{"5","6","7","5"},{"5","4","7","8"},{"5","4","7","8"}};
//        String[][] array = {{"2","30","4","4"},{"5","6","7"},{"5","4","7","8"},{"5","6","7","4"}};
        String[][] array = {{"2","30","4","4"},{"5","6","7","4"},{"5","4","7","8"}};
          int sum = convertArray(array);
          System.out.println("Сумма массива: " + sum);
    }

    private static int convertArray(String[][] strArray) {
        int sum = 0;
        if (strArray.length == 4) {
            for (int i = 0; i < 4; i++) {
                if (strArray[i].length != 4) {
                    throw new MyArraySizeException("Есть строки количесвто элементов в которых не равно 4");
                }
            }
        } else throw new MyArraySizeException("Количество строк не равно 4");

        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray.length; j++) {
                try {
                    sum += Integer.parseInt(strArray[i][j]);
                } catch (RuntimeException e) {
                    throw new MyArrayDataException("в ячейке [" + i + "],[" + j + "] находится тип отличный от int.");
                }
            }
        }
        return sum;
    }
}











