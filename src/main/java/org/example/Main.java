package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Algoritmo que le pide al usuario ingresar numeros para sudoku
        //   Aqui se ingresarn los numeros en una matrix 9x9
        int[][] sudoku = new int[9][9];
        System.out.println("Solo se ingresan numero del 1 al 9");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                System.out.print("Ingrese el valor de la celda (" + (i+1) + "," + (j+1) + "): ");
                sudoku[i][j] = scanner.nextInt();
                if (sudoku[i][j] > 9){
                    System.out.println("Ingresaste un numero mayoy a 9 : [ ");
                    scanner.close();
                }
            }
        }

        if (esSudokuValido(sudoku)) {
            System.out.println("Si esta armado correctamente, es válido.");
        } else {
            System.out.println("No esta armado correctamente, es inválido.");
        }


    }

    // Función que valida si una matriz de sudoku es correcta o no y validar que cada fila tenga números únicos del 1 al 9
    public static boolean esSudokuValido(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            if (!esNumerosUnicos(sudoku[i])) {
                return false;
            }
        }

        // Validar que cada columna tenga números  del 1 al 9
        for (int j = 0; j < 9; j++) {
            int[] columna = new int[9];
            for (int i = 0; i < 9; i++) {
                columna[i] = sudoku[i][j];
            }
            if (!esNumerosUnicos(columna)) {
                return false;
            }
        }

        // Validar que cada submatriz de 3x3 tenga números del 1 al 9
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int[] submatriz = new int[9];
                int contador = 0;
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        submatriz[contador] = sudoku[x][y];
                        contador++;
                    }
                }
                if (!esNumerosUnicos(submatriz)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Función que verifica si un arreglo de enteros tiene números solo del 1 al 9
    public static boolean esNumerosUnicos(int[] arreglo) {
        Set<Integer> numerosUnicos = new HashSet<>();
        for (int i = 0; i < arreglo.length; i++) {
            int numero = arreglo[i];
            if (numero < 1 || numero > 9) {
                return false;
            }
            if (numerosUnicos.contains(numero)) {
                return false;
            }
            numerosUnicos.add(numero);
        }
        return true;
    }

}