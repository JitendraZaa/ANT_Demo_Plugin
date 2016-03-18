/*
 * @Author  :   Jitendra Zaa
 * @Date    :   03/18/2016
 */
package com.jitendrazaa;
 
import java.util.Objects;

public class DemoEntry {
 
    String path ;    
    Boolean isFolderPath ;

    public DemoEntry(){}
    
    public DemoEntry(String path, Boolean isFolderPath) {
        this.path = path;
        this.isFolderPath = isFolderPath;
    } 

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getIsFolderPath() {
        return isFolderPath;
    }

    public void setIsFolderPath(Boolean isFolderPath) {
        this.isFolderPath = isFolderPath;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.path);
        hash = 71 * hash + Objects.hashCode(this.isFolderPath);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DemoEntry other = (DemoEntry) obj;
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.isFolderPath, other.isFolderPath)) {
            return false;
        }
        return true;
    }
    
    
}
