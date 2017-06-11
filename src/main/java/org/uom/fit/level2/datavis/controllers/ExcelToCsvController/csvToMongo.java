package org.uom.fit.level2.datavis.controllers.ExcelToCsvController;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.uom.fit.level2.datavis.controllers.fileUploader.FileUploadController;


import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * Created by asiri on 3/17/17.
 */
public class csvToMongo {

    public static void convertCsv(File file) {

        Runtime r = Runtime.getRuntime();
        Process p = null;
        String command = "mongoimport --db datarepo --collection rawdata --type csv --file /home/charith/Downloads/testxlproject_real.csv --headerline";
        try {
            p = r.exec(command);
            System.out.println("Reading csv into Database");
            String command2="db.rawdata.find().forEach(function(element){\n" +
                    "  element.BOOKING_CREATED_DATE = ISODate(element.BOOKING_CREATED_DATE);\n" +
                    "  db.rawdata.save(element);\n" +
                    "})";
            //date string to ISO date

        } catch (Exception e) {
            System.out.println("Error executing " + command + e.toString());
        }finally {


             try {
                 FileUtils.cleanDirectory(new File("src/main/resources/static/publics/uplodFile"));
             }catch (IOException io){
                 System.out.print(io);
             }
        }


    }

    public static void convertElsCsv(String fileName) {
        try {
            File inputFile = new File(FileUploadController.ROOT+"/"+fileName);
           // File outputFile = new File(FileUploadController.ROOT+"/"+"data.csv");
           // xlsx(inputFile, outputFile);
            csvToMongo.convertCsv(inputFile);

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void watcherDerectory() {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get(FileUploadController.ROOT);
            dir.register(watcher, ENTRY_CREATE);

            System.out.println("Watch Service registered for dir: " + dir.getFileName());

            while (true) {
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (InterruptedException ex) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path fileName = ev.context();

                    System.out.println(kind.name() + ": " + fileName);
                    if (kind.name().toString()=="ENTRY_CREATE"){

                        convertElsCsv(fileName.getFileName().toString());
                    }

                    if (kind == ENTRY_MODIFY &&
                            fileName.toString().equals("DirectoryWatchDemo.java")) {
                        System.out.println("My source file has changed!!!");
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }


}



