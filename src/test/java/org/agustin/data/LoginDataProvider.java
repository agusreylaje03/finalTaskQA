package org.agustin.data;

import java.util.stream.Stream;

public class LoginDataProvider {
    public static Stream<Object[]> loginData() {
        return Stream.of(
                new Object[]{"UC_001", "standard_user", "secret_sauce", "SUCCESS", "Login exitoso"},
                new Object[]{"UC_002", "", "secret_sauce", "USERNAME_REQUIRED", "Usuario vacío"},
                new Object[]{"UC_003", "standard_user", "", "PASSWORD_REQUIRED", "Contraseña vacía"}
        );
    }
}


