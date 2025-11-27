package org.agustin.data;



import java.util.stream.Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class LoginDataProvider {

    // ANTES: public static Object[][] loginData()
    public static Stream<Object[]> loginData() {  // ← CAMBIO
        return Stream.of(  // ← CAMBIO
                new Object[]{"UC_001", "standard_user", "secret_sauce", "SUCCESS", "Login exitoso"},
                new Object[]{"UC_002", "", "secret_sauce", "USERNAME_REQUIRED", "Usuario vacío"},
                new Object[]{"UC_003", "standard_user", "", "PASSWORD_REQUIRED", "Contraseña vacía"}
        );
    }
}


