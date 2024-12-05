package com.itschool.jpa.otherstuff.solid;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DPrincipleAfter {
    public static void main(String... a) {
        Logger consoleLogger = new ConsoleLogger1();
        Logger fileLogger = new FileLogger1();

        LoggingService fLoggerService = new LoggingService(fileLogger);

        fLoggerService.processLog("Log to file");
    }
}

interface Logger {
    void log(String message);
}

class ConsoleLogger1 implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

class FileLogger1 implements Logger {
    public void log(String message) {
        File logFile = new File("filename.log");
        try (FileWriter fw = new FileWriter(logFile, true)) {
            fw.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class LoggingService {
    private Logger logger;

    public LoggingService(Logger logger) {
        this.logger = logger;
    }

    public void processLog(String message) {
        logger.log(message);
    }
}