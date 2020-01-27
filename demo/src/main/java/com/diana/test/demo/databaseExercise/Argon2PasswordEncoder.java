package com.diana.test.demo.databaseExercise;

import org.springframework.security.crypto.password.PasswordEncoder;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Argon2PasswordEncoder implements PasswordEncoder {

    private static final Argon2 ARGON2 = Argon2Factory.create();
    private static final int ITERATIONS = 40;
    private static final int MEMORY= 128000;
    private static final int PARALLELISM = 4;

    @Override
    public String encode(CharSequence rawPassword) {
        final String hash = ARGON2.hash(ITERATIONS, MEMORY, PARALLELISM, rawPassword.toString());
        return hash;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return ARGON2.verify(encodedPassword, rawPassword.toString());
    }

}
