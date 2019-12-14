package com.tatumalenko.algorithms.util;

class Internet {
    boolean connect(String url) {
        return true;
    }
}

interface Request {
    // Constant variable
    int PORT = 1022; // Implicitly final (call using instance or class)

    // Abstract method depends on implementation
    int request();

    // Static method
    static boolean isConnected() {
        return new Internet().connect("someurl.com");
    }

    // Default method
    default void print() {
        System.out.println("Currently connected: " + isConnected());
        System.out.println("Identity: " + getClass());
    }

    // Default that depends on instance type, not as clean as just
    // implementing `request()` inside the appropriate implementing class
    default int conditionalDefaultRequest() {
        if (this instanceof NetworkRequest) {
            System.out.println("Identity: NetworkRequest (" + getClass() + ")");
            return 0;
        } else if (this instanceof FTPRequest) {
            System.out.println("Identity: FTPRequest (" + getClass() + ")");
            return 1;
        }
        return 2;
    }
}

class NetworkRequest implements Request {
    @Override
    public int request() {
        print();
        if (Request.isConnected())
            return 1;
        return 0;
    }
}

class FTPRequest implements Request {
    @Override
    public int request() {
        print();
        if (Request.isConnected())
            return 1;
        return 0;
    }
}

class Junk {
    public static void main(String[] args) {
        Request networkRequest = new NetworkRequest();
        System.out.println("Request return: " + networkRequest.request());
        System.out.println(networkRequest.conditionalDefaultRequest());

        System.out.println();

        Request ftpRequest = new FTPRequest();
        System.out.println("Request return: " + ftpRequest.request());
        System.out.println(ftpRequest.conditionalDefaultRequest());
    }
}