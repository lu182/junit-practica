package com.codoacodo.ejerciciojunit.classes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

    //Generamos nuestro Usuario:
    private Usuario usuario;

    //Definimos método setUp: nos permite asignar valores iniciales a las variables antes de la ejecución de c/test
    @Before
    public void setUp(){
        //Creamos un nuevo Usuario - Instanciamos:
        usuario = new Usuario("Juan", "Pérez"); //Le otorgamos nombre y apellido por defecto
    }

    //Tests unitarios:
    @Test
    public void testGetNombre(){
        //Corroborar que cuando cree un nuevo Usuario, el nombre sea Juan
        Assert.assertEquals("Juan", usuario.getNombre());
    }

    @Test
    public void testGetApellido(){
        Assert.assertEquals("Pérez", usuario.getApellido());
    }

    //Test que prueba el método toString de la clase real Usuario:
    @Test
    public void testToString(){
        Assert.assertEquals("Nombre: Juan, Apellido: Pérez", usuario.toString());
    }
}
