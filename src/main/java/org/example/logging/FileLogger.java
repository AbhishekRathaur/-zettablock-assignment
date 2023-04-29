package org.example.logging;

import java.io.*;

public class FileLogger {
    PrintWriter writer;

    protected FileLogger() throws IOException {
        writer = new PrintWriter(new FileOutputStream("output.txt", true));
    }

    public void log(String log) {
        writer.write(log);
        writer.write("\n");
        System.out.println(log);
    }
    public void close(){
        writer.close();
    }
}
