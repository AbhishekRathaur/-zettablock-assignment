package org.example.logging;

import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger {
    Logger logger = Logger.getLogger("MyLog");
    FileHandler fh;

    protected FileLogger() throws IOException {
        fh = new FileHandler("output.txt");
        System.setProperty("java.util.logging.SimpleFormatter.format","%n");
        logger.addHandler(fh);
//        SimpleFormatter formatter = new SimpleFormatter();
//        fh.setFormatter(formatter);
    }

    public void log(String log) {
        logger.info(log);
    }
}
