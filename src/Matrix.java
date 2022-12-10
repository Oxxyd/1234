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
        int[][] matrix2T = new int[size][size];        // <-         ������������� ������ �������,
        for (int i = 0; i < size; i++) {               // <-       (������ ������ ������ �� �������, ����� �������, ��������������),
            for (int j = 0; j < size; j++) {           // <-       ����� ��� ��� ����, ��� �� ���� ����� �������� ��� ������� ���� �� �����.
                matrix2T[i][j] = matrix2[j][i];        // <-         ��� ��������� ������ ������� ������ ������ ������ ������� ���������� ��
            }                                                    //������ ������� ������� ������� ������ ������� � �� ��� ������������, ����� ������ ������ ������ �������
        }                                                        //���������� �� ������ ������� ������ �������, ����� �� ������... ����� ��� ������� ������
        var valuesOfFinalMatrix = new ArrayList<Integer>();      //������� �����������, ������ ������ ������ ������� �������� ������������� �� ���
        for(int q = 0; q < size; q++) {                          //������� ������ - �� ������, �� ������, �� ������ � �.�.
            Integer sum = 0;                                     //�� ���� � ����� �� �����������, ����� ���� �����,
            for (int i = 0; i < size; i++) {                     //����� ������ matrix2T ������� ������ �� �������� ������ �������.
                for (int j = 0; j < size; j++) {
                    sum += matrix1[q][j] * matrix2T[i][j];
                }                                                // �������� ��� �������� ��������� �������. �� ����, ������ �� ��� - ��� �����,
                valuesOfFinalMatrix.add(sum);                    //�� ��� ����� ��� ������� � ������ �� ��������.
                sum = 0;
            }
        }
        int numberInList = 0;
        for (int i = 0; i < size; i++) {                        //������ ��� �������� � ���� ��������� �������.
            for (int j = 0; j < size; j++) {
                finalMatrix[i][j] = valuesOfFinalMatrix.get(numberInList);
                numberInList++;
            }
        }
    }

    public void addition(){                                     //������ ���������� ��� �������� ������ � ������ �������. ������
        for (int i = 0; i < size; i++) {                        //������� ������ ������� � ��������� ������, ������� �� ��� �� �����.
            for (int j = 0; j < size; j++) {
                finalMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
    }
}
