import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    private int size;
    private int[][] matrix1;
    private int[][] matrix2;
    public int[][] finalMatrix;

    public void setSize(int size) {
        this.size = size;
        matrix1 = new int[size][size];
        matrix2 = new int[size][size];
        finalMatrix = new int[size][size];
    }

    public int getSize(){
        return size;
    }

    public void initMatrix(int[][] matrix){
        Scanner a = new Scanner(System.in);
        for(int i = 0; i < size; i ++) {
            String[] box = new String[size];
            Integer[] intBox = new Integer[size];
            System.out.print(" -> ");
            box = a.nextLine().split(" ");
            for (int j = 0; j < box.length; j++) {
                intBox[j] = Integer.parseInt(box[j]);
            }
            for (int q = 0; q < intBox.length; q++) {
                matrix[i][q] = intBox[q];
            }
        }
    }

    public void initFirstMatrix(){
        System.out.println("Enter separated by a space numbers of first, second etc. strings of the second matrix ...");
        initMatrix(matrix1);
    }

    public void initSecondMatrix(){
        System.out.println("Enter separated by a space numbers of second, second etc. strings of the second matrix ...");
        initMatrix(matrix2);
    }


    public void multiplication(){
        int[][] matrix2T = new int[size][size];        // <-         Транспонируем вторую матрицу,
        for (int i = 0; i < size; i++) {               // <-       (просто меняем строки на столбцы, можно сказать, переворачиваем),
            for (int j = 0; j < size; j++) {           // <-       нужно это для того, что бы было легче умножать две матрицы друг на друга.
                matrix2T[i][j] = matrix2[j][i];        // <-         При умножении каждый элемент первой строки первой матрицы умножается на
            }                                                    //каждый элемент первого столбца второй матрицы и всё это складывается, далее первая строка первой матрицы
        }                                                        //умножается на второй столбец второй матрицы, потом на третий... Когда все столбцы второй
        var valuesOfFinalMatrix = new ArrayList<Integer>();      //матрицы закончились, вторая строка первой матрицы начинает перемножаться на все
        for(int q = 0; q < size; q++) {                          //столбцы второй - на первый, на второй, на третий и т.д.
            Integer sum = 0;                                     //За этим и нужно ее перевернуть, чтобы было легче,
            for (int i = 0; i < size; i++) {                     //чтобы массив matrix2T состоял именно из столбцов второй матрицы.
                for (int j = 0; j < size; j++) {
                    sum += matrix1[q][j] * matrix2T[i][j];
                }                                                // Получаем все элементы финальной матрицы. Не знаю, хорошо ли это - три цикла,
                valuesOfFinalMatrix.add(sum);                    //но как иначе это сделать я вообще не придумал.
                sum = 0;
            }
        }
        int numberInList = 0;
        for (int i = 0; i < size; i++) {                        //Пихаем все элементы в саму финальную матрицу.
            for (int j = 0; j < size; j++) {
                finalMatrix[i][j] = valuesOfFinalMatrix.get(numberInList);
                numberInList++;
            }
        }
    }

    public void addition(){                                     //Просто складываем все элементы первой и второй матрицы. Каждый
        for (int i = 0; i < size; i++) {                        //элемент первой матрицы с элементом второй, стоящем на том же месте.
            for (int j = 0; j < size; j++) {
                finalMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
    }
}
