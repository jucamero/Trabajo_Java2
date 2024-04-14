package co.com.ps.C22JA.error;

import co.com.ps.C22JA.entity.Usuario;

public class UsuarioErrorMessage extends RuntimeException {

    UsuarioErrorMessage(String mensaje){
        super("Error en Usuario"+mensaje);
    }
}
