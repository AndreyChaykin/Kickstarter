package com.homeproject;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleIO {
    public ConsoleIO() {
    }

    void println(String message) {
        System.out.println(message);
    }

    int read() throws IOException {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}