package com.codoacodo.ejerciciojunit.classes;

public class CuentaBancaria {

    private Usuario titular;
    private double saldo;

    //Método constructor que recibe un Usuario:
    public CuentaBancaria(Usuario usuario){
        titular = usuario;
    }

    //Getter de Usuario(titular) - Método que necesita mi test para obtener el usuario de la cuenta:
    public Usuario getUsuario() { //le ponemos getUsuario para que coincida con el método q necesita mi test
        //return new Usuario(); //devolvemos un usuario creado vacío - Tmb podria devolver null
        return titular; //refactor
    }

    //Getter de saldo - Método que necesita mi test para obtener el saldo de la cuenta bancaria:
    public double getSaldo() {
        //return 0.0; //Le coloco 0.0 para que en un primer momento al obtener el saldo, esté en 0.
        return saldo;
    }

    //Agrego Setters:
    public void setUsuario(Usuario titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Método depositar:
    public void depositar(double saldoADepositar){
        //Validaciones:
        if(saldoADepositar <= 0){
            //Atrapamos el error con una excepción para q no se rompa nuestro sistema y continúe:
            throw new IllegalArgumentException("La cantidad a depositar debe ser mayor que 0");
        }
        this.saldo += saldoADepositar; //el saldo que ya teniamos se le va a acumular al saldo que depositamos $500
    }

    //Método retirar dinero:
    public void retirar(double saldoARetirar){
        if(this.saldo < saldoARetirar){
            throw new IllegalArgumentException("No cuenta con fondos suficientes");
        }
        this.saldo -= saldoARetirar;
    }
}
