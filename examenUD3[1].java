import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class examenUD3 {
    public void Bingo(){
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();
        System.out.println("*** BIENVENIDO AL BINGO DEL CASINO CANTÁBRICO *** ");
        int numBolas= (int) (random.nextDouble() * 40 + 10);
        int[] numBolasarray = new int[numBolas];

        for(int i =0; i<numBolasarray.length;i++) {
            int bolas = (int) (random.nextDouble() * 90 + 1);
            numBolasarray[i] = bolas;
        }

        int bolasArray[] = Arrays.stream(numBolasarray).distinct().toArray();
        System.out.println(bolasArray.length + " bolas extraidas hasta ahora: " + Arrays.toString(bolasArray));
        System.out.println("*** Introduce los datos de tu cartón ***");

        int carton[][] = new int [3][3]; 
        bucle1:
        for(int i=0; i<carton.length; i++){
            System.out.print("Fila " +(i+1)+":");
            String input = entrada.next();

            if (!input.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}")){//Para comprobar el formato es correcto
                System.out.println("Error Introduce el formato correcto (N-N-N) ");
                break bucle1;
            }

            String[] input2 = input.split("-");
            for(int j=0; j<carton[i].length; j++){
                carton[i][j] = Integer.parseInt(input2[j]);
            }
        }

        for(int[] filas : carton){
            for(int columnas : filas){
                System.out.print(columnas + " ");
            }
            System.out.print("\n");
        }
        for (int i = 0; i < carton[i].length; i++) { //Comprobando si hay Bingo
            if(carton[i][i]==bolasArray[i]){
                System.out.println("HAY BINGO!!");
                return;
            }else{
                System.out.println("no hay BINGO.");
                for (int j = 0; i < carton[j].length; j++) { //Comprobando si hay Linea
                    System.out.println("Linea "+(j+1)+":");
                    if(carton[j][j]==bolasArray[j]){
                        System.out.println("Correcta!");
                        return;
                    }else{
                        System.out.println("NO");
                    }
                }

            }
        }





    }
}

