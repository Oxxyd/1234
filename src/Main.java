import java.util.Scanner;

public class Main {
    static Matrix matrix = new Matrix();
    public static void main(String[] args) throws InterruptedException {
        initialization();
        mathOperation();
        matrixOutput();

    }
    public static void initialization() throws InterruptedException {
        System.out.println(" - Welcome to the Square Matrix Calculator 2.0 - ");
        System.out.println();
        Thread.sleep(500);
        Scanner matrices = new Scanner(System.in);
        System.out.print(" Enter the order(size) of two square matrices -> ");
        int matrixSize = matrices.nextInt();
        System.out.println();
        matrix.setSize(matrixSize);
        matrix.initialisationFirstMatrix();
        System.out.println();
        matrix.initialisationSecondMatrix();
        System.out.println();
    }

    public static void mathOperation(){
        Scanner matrices = new Scanner(System.in);
        System.out.println("What do u want to do with this matrix?");
        System.out.println("1. Add");
        System.out.println("2. Multiply");
        System.out.print(" -> ");
        int choice = matrices.nextInt();
        if(choice == 1)
            matrix.addition();
        else
            matrix.multiplication();
    }
    public static void matrixOutput() throws InterruptedException {
        System.out.println();
        System.out.println();
        Thread.sleep(700);
        int a = 0;
        System.out.println(" - Your matrix is ->  ");
        System.out.println();
        for (int i = 0; i < matrix.getSize(); i++) {
            System.out.print(" ");
            for (int j = 0; j < matrix.getSize(); j++) {
                if(a != matrix.getSize()){
                    System.out.print(matrix.finalMatrix[i][j] + " ");
                    a++;
                }else{
                    System.out.println();
                    System.out.print(" " + matrix.finalMatrix[i][j] + " ");
                    a = 1;
                }
            }
        }
        System.out.println();
    }
}
