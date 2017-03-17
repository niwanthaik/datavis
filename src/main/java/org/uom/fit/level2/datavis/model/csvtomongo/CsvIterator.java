package org.uom.fit.level2.datavis.model.csvtomongo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by niwantha on 3/9/17.
 */
public class CsvIterator {

    private BufferedReader fileHandle;
    private String instance;
    private String filename;
    private String [] fields;
    private int current;
    private static final String delimeter  = ",";

    public CsvIterator(String filename) throws IOException {
        setInstanceVariables(filename);
    }

    private void setInstanceVariables(String filename) throws IOException {
        this.filename = filename;
        this.fileHandle = openFile(filename);
        this.current = 1;

        this.fields =  fileHandle.readLine().split(delimeter);
        this.instance = fileHandle.readLine();
    }

    private BufferedReader openFile(String filename) throws IOException {
        return new BufferedReader(new FileReader(filename));
    }

    public String[] getFields() {
        return this.fields;
    }

    private void readNextLine() throws IOException {
        this.instance = this.fileHandle.readLine();
        setLineNumber();
    }

    private void setLineNumber() {
        this.current += 1;
    }

    public boolean hasNext() {
        return (this.instance != null);
    }

    public int getLineNumber() {
        return this.current;
    }

    public String[] next() throws IOException {
        String[] row = this.instance.split(delimeter);
        if (this.hasNext()) {
            this.readNextLine();
        }
        return row;
    }

    public void close() throws IOException {
        fileHandle.close();
    }

}
