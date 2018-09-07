/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radixsort;

/**
 *
 * @author Estudiantes
 */	
import java.util.Random;
import java.util.Scanner;
 
class RadixSort 
{
    static int sort( int[] a)
    {
        int i, c, m = a[0], exp = 1, n = a.length;
        int[] b = new int[n];
        c=1;
        for (i = 1; i < n; i++){
            c=+5;
            if (a[i] > m)
                m = a[i];
        }
            
        
        while (m / exp > 0)
        {
            c=c+3;
            int[] matriz = new int[n];
           
            for (i = 0; i < n; i++){
                matriz[(a[i] / exp) % 10]++;
                c=c+6;
            }   
            for (i = 1; i < n; i++){
                matriz[i] += matriz[i - 1];
                c=c+6;
            }                
            for (i = n - 1; i >= 0; i--){
                b[--matriz[(a[i] / exp) % 10]] = a[i];
                c=c+7;
            }               
            for (i = 0; i < n; i++){
                a[i] = b[i];
                c=c+4;
            }         
            exp *= 10;     
            c=c+2;
        }
        
        return c;
    }    
    
    public static void main(String[] args) 
    {
        Random random = new Random();
        Scanner scan = new Scanner( System.in );        
        System.out.println("Radix Sort");
        
        int n, i;
        System.out.print("Ingrese el tamaño del arreglo: ");
        
        n = scan.nextInt();
        int arr[] = new int[ n ];
        
        System.out.print("Arreglo sin ordenar: ");
        for (i = 0; i < n; i++) {
            arr[i] = random.nextInt(999) + 1;
            System.out.print(arr[i]+" ");
        }
        
        
        sort(arr);
        
        System.out.print("\nArreglo ordenado: ");        
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");            
        
        float formula = 3 * ((15 * n) + (10 * n) + n + 3);
        System.out.println("por formula es:" + formula);
        System.out.println("por contador es:" + sort(arr));
                    
    }    
}
