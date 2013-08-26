package javaone.con3638.fileupload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author mertcaliskan
 */
@Named(value = "fileUploadBean")
@RequestScoped
public class FileUploadBean {

    private Part file1;
    private Part file2;
    private Part file3;
    private UploadedFile file4;
    
    public void uploadSimple() {
        try {
          String fileContent = new Scanner(file1.getInputStream()).useDelimiter("\\A").next();
          // do some crazy stuff on content
        } 
        catch (IOException e) {
            System.err.print(e);
        }
    }
    
    public void uploadAjax() {
        try {
            String fileContent = new Scanner(file2.getInputStream()).useDelimiter("\\A").next();
            // do some crazy stuff on content
        } 
        catch (IOException e) {
            System.err.print(e);
        }
    }
    
    public void uploadValidated() {
        try {
          String fileContent = new Scanner(file3.getInputStream()).useDelimiter("\\A").next();
          // do some crazy stuff on content
        } 
        catch (IOException e) {
            System.err.print(e);
        }
    }
    
    public void uploadPrime(FileUploadEvent event) {
         UploadedFile file = event.getFile();
    }
        
    public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
        List<FacesMessage> msgs = new ArrayList<FacesMessage>();
        Part file = (Part)value;

        if (file.getSize() > 1024) {
          msgs.add(new FacesMessage("file too big"));
        }

        if (!msgs.isEmpty()) {
          throw new ValidatorException(msgs);
        }
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    public Part getFile3() {
        return file3;
    }

    public void setFile3(Part file3) {
        this.file3 = file3;
    }

    public UploadedFile getFile4() {
        return file4;
    }

    public void setFile4(UploadedFile file4) {
        this.file4 = file4;
    }
}