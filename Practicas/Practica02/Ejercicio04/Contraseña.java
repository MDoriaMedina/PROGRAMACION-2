package Practicas.Practica02.Ejercicio04;

public class Contraseña {
    
    public String contraseña;

    public Contraseña(String contraseña){
        this.contraseña = contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean controlContraseña(){
        
        int contadorMinusculas = 0, contadorCaracterEspecial = 0, contadorNumero = 0, contadorMayuscula = 0;
        boolean flag = false;
        if(getContraseña().length()<10){
            System.out.println("La contraseña debe tener al menos 10 caracteres! ");
            flag = false;
        }else{
            for (char c : getContraseña().toCharArray()) {
                if (Character.isLowerCase(c)) {
                    contadorMinusculas++;
                } else{ if (c == '&' || c == '%' || c == '*' || c == '$' || c == '/') {
                   contadorCaracterEspecial++;
                }else{
                    if (Character.isDigit(c)) {
                        contadorNumero++;
                    }else{
                        if (Character.isUpperCase(c)){
                            contadorMayuscula++;
                        }
                    }
                }
            }
            }
        }
        
        if(contadorCaracterEspecial<1){
            System.out.println("La contraseña debe tener al menos un caracter especial! ");
        }else{
            if(contadorMinusculas<2){
            System.out.println("La contraseña debe tener al menos dos letras minúsculas! ");
            }else{
                if(contadorNumero<1){
                    System.out.println("La contraseña debe tener al menos un número! ");
                }else{
                    if(contadorMayuscula<1){
                        System.out.println("La contraseña debe tener al menos una letra mayuscula! ");
                    }else{
                        flag = true;
                    }
                }
            }
        
        }
        return flag;
    }

}
