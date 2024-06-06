/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author datld7
 */
public class FileUpload {
    private String file_path;
    private String file_name;
    
    public FileUpload(String file_path, String file_name) {
        this.file_path = file_path;
        this.file_name = file_name;
    }
    
    public String getFilePath() {
        return file_path;
    }
    
    public void setFilePath(String file_path) {
        this.file_path = file_path;
    }
    
    public String getFileName() {
        return file_name;
    }
    
    public void setFileName(String file_name) {
        this.file_name = file_name;
    }
}
