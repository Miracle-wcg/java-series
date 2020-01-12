package com.DesignPattern.proxy;

public interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadRealImage(fileName);
    }

    private void loadRealImage(String fileName) {
        System.out.println("Loading..." + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying..." + fileName);
    }
}

class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}