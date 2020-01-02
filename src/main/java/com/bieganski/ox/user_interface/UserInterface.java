package com.bieganski.ox.user_interface;

import com.bieganski.ox.BoardListener;

public interface UserInterface extends BoardListener {
    void println(Object object);

    String askForInput();
}
