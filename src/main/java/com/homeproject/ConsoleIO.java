package com.homeproject;

import java.util.Scanner;

public class ConsoleIO implements IO {

    public void println(String message) {
        System.out.println(message);
    }

    public int read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
