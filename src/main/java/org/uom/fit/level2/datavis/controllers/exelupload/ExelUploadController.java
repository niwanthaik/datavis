package org.uom.fit.level2.datavis.controllers.exelupload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.uom.fit.level2.datavis.DataVisApplication;

@Controller
public class ExelUploadController {

    private static final Logger log = LoggerFactory.getLogger(ExelUploadController.class);

    // The Environment object will be used to read parameters from the
    // application.properties configuration file
    @Autowired
    private Environment env;

    /**
     * POST /uploadFile -> receive and locally save a file.
     *
     * @param uploadfile The uploaded file as Multipart file parameter in the
     *                   HTTP request. The RequestParam name must be the same of the attribute
     *                   "name" in the input tag with type file.
     * @return An http OK status in case of success, an http 4xx status in case
     * of errors.
     */
    @RequestMapping(value = "/exel/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestParam("uploadfile") MultipartFile uploadfile) {

        try {
            // Get the filename and build the local file path
            String filename = uploadfile.getOriginalFilename();
            String directory = env.getProperty("org.uom.fit.level2.exel.file.upload.path");
            String filepath = Paths.get(directory, filename).toString();

            // Save the file locally
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(uploadfile.getBytes());
            stream.close();
            log.info("file upload successful");
        } catch (Exception e) {
            log.error("exception during file upload", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    } // method uploadFile

} // class MainController

