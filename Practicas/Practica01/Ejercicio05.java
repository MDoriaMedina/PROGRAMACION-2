package Practicas.Practica01;



import java.util.*;

public class Ejercicio05 {
    
    static int calculoNumero (int d, int m, int a)
    {
    int resultado = 0;
	int AuxRes = 0;
	int Aux = 0;
	int Aux2 = 0;
	int SumaDia = 0;
	int SumaMes = 0;
	int SumaAnho = 0;

	//Calculamos el día
	if(d>=10)
	{
		while(d>0)
		{
		Aux = d%10;
		d=d/10;
		SumaDia = SumaDia+Aux;
		}
		Aux = 0;
	}else
	{
		SumaDia = d;
	}
	
	//Calculamos el mes
	if(m>=10)
	{
		while(m>0)
		{
		Aux = m%10;
		m=m/10;
		SumaMes = SumaMes+Aux;
		}
		Aux = 0;
	}else
	{
		SumaMes = m;
	}
	
	//Calculamos el año
	while(a>0)
	{
		Aux = a%10;
		a=a/10;
		SumaAnho = SumaAnho+Aux;
	}
	Aux = 0;
	if(SumaAnho>=10)
	{
		while(SumaAnho>0)
		{
		Aux = SumaAnho%10;
		SumaAnho = SumaAnho/10;
		Aux2 = Aux2+Aux;
		}
		SumaAnho = Aux2;
		Aux2 = 0;
        Aux = 0;
	}

	//sumamos los valores para el resultado final
	resultado = SumaDia+SumaMes+SumaAnho;
	
	if(resultado>=10)
	{
		while(resultado>0)
		{
			Aux = resultado%10;
			resultado = resultado/10;
			AuxRes = AuxRes+Aux;
		}
		return AuxRes;
	}else{
		return resultado;
	}
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int dia, mes, anho, numero;

        System.out.println("Encuentra \\\"tu número\\\" segun tu fecha de nacimiento"); 
        System.out.println("Los datos seran leidos en el formato dd/mm/aaaa");
        System.out.println("Ingresa dia: ");
        while (!scanner.hasNextInt()) { //verifica si el proximo valor de entrada es un entero
            System.out.println("Error. Debes introducir un valor numerico entero. Inténtalo de nuevo:");
            scanner.next(); // Limpia el buffer de entrada antes de volver a pedir la entrada
        }
        dia = scanner.nextInt();
        
        System.out.println("Ingresa mes: ");
        while (!scanner.hasNextInt()) { 
            System.out.println("Error. Debes introducir un valor numerico entero. Inténtalo de nuevo:");
            scanner.next(); 
        }
        mes = scanner.nextInt();

        System.out.println("Ingresa año: ");
        while (!scanner.hasNextInt()) { 
            System.out.println("Error. Debes introducir un valor numerico entero. Inténtalo de nuevo:");
            scanner.next(); 
        }
        anho = scanner.nextInt();

        System.out.println("Fecha de nacimiento introducida: " + dia +"/"+ mes +"/"+anho);
        
        //llamamos a la funcion para retornar el numero
        numero = calculoNumero(dia, mes, anho);

        switch(numero){
            case 1:
                System.out.println("Tu número es el 1. Simboliza la unidad, el liderazgo, la individualidad.");
                break;
            case 2:
                System.out.println("Tu número es el 2. Comunión, división.");
                break;
            case 3:
                System.out.println("Tu número es el 3. Tres en uno, uno en tres.");
                break;
            case 4:
                System.out.println("Tu número es el 4. La estabilidad.");
                break;
            case 5:
                System.out.println("Tu número es el 5. El favor inmerecido.");
                break;
            case 6:
                System.out.println("Tu número es el 6. Representa la humanidad.");
                break;
            case 7:
                System.out.println("Tu número es el 7. Simboliza la perfección.");
                break;
            case 8:
                System.out.println("Tu número es el 8. Nuevo comienzo.");
                break;
            case 9:
                System.out.println("Tu número es el 9. Busca dar resultados positivos.");
                break;
                
        }
		
		scanner.close();

    }
}
