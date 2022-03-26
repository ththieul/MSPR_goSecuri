package fr.epsi.mspr;

import org.mindrot.jbcrypt.BCrypt;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionTest {

    @org.junit.jupiter.api.Test
    void stringShouldBeHashedInBcryptEncryption() {
        assertTrue(BCrypt.checkpw("1Fche7EgsZ73v", "$2a$12$X19bLpfyDfsQhrDQWN6bZ.opHj02azC0tUq.U71UWdxkw5/BMndQW"));
    }
}