package com.bieganski.ox;

interface UserInterface extends BoardListener {
    void println(Object object);

    String askForInput();
}
