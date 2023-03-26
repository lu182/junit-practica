package com.codoacodo.ejerciciojunit.classes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CuentaBancariaTest {

    private CuentaBancaria cuenta;
    private Usuario titularCuenta;

    //Genero un segundo titular para el testSetUser:
    private Usuario titularCuenta2;

    private final double SALDO_AGREGADO = 500.0;

    @Before
    public void setUp(){
        titularCuenta = new Usuario();
            titularCuenta.setNombre("Carlos");
            titularCuenta.setApellido("Páez");

        //Genero un segundo titular para el testSetUser:
        titularCuenta2 = new Usuario("Luciana", "Fernandez");

        //Para que el Usuario sea igual que el titular, debo pasarle el titular en lugar de un new Usuario:
        //cuenta = new CuentaBancaria(new Usuario("Carlos", "Páez"));
        cuenta = new CuentaBancaria(titularCuenta);
    }

    //Probamos si puedo Obtener el Usuario de la Cuenta:
    @Test
    public void testGetUser(){
        //Para ello tengo que validar si el Usuario titular de esa Cuenta (expected) es igual al Usuario obtenido de la Cuenta
        Assert.assertEquals(titularCuenta, cuenta.getUsuario());
    }

    //Probamos que a la CuentaBancaria le podemos cambiar el Usuario principal:
    @Test
    public void testSetUser(){
        //Le agrego/seteo a la cuenta un segundo titular:
        cuenta.setUsuario(titularCuenta2);
        //Valido que el resultado esperado corresponda al titularCuenta2
        Assert.assertEquals(titularCuenta2, cuenta.getUsuario());
    }

    //Probamos setear un saldo:
    @Test
    public void testSetSaldo(){
        cuenta.setSaldo(SALDO_AGREGADO);
        Assert.assertEquals(SALDO_AGREGADO, cuenta.getSaldo(), 0.01);
    }

    //Probamos poder depositarle a la cuenta $500
    @Test
    public void testDepositar(){
        cuenta.depositar(500.0);
        //Dentro de la cuenta yo debo tener un saldo.
        //Ese saldo deberia ser igual al saldo que tenía hasta el momento + los $500 que deposité
        //Validamos que funcione el depósito - Cuando consulte el saldo de mi cuenta deberia esperarse que sean $500:
        Assert.assertEquals(500.0, cuenta.getSaldo(), 0.01);
    }

    //Probamos si podemos depositarle un valor negativo.
    //Al colocar esto, el Test va a pasar xq significa q la validación con IllegalArgumentException en clase real, funciona ok
    @Test(expected = IllegalArgumentException.class)
    public void testDepositarCantidadNegativa(){
        cuenta.depositar(-500.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetirarDinero(){
        //cuenta.depositar(50.0);
        //cuenta.retirar(70.0);
        cuenta.retirar(70.0);
    }
}
