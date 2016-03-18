/*
 * @Author  :   Jitendra Zaa
 * @Date    :   03/18/2016
 */
package com.jitendrazaa;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.tools.ant.Task;

public class DemoTask extends Task {

    HashSet<DemoEntry> demoEntryList = new HashSet<DemoEntry>();
    String description ;
    
    /**
     * print Stacktrace from Exception
     * @param e
     * @return 
     */
    private String getExceptionMessage(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    /**
     * Create Method needed by Ant reflection
     *
     * @return
     */
    public DemoEntry createDemoEntry() {
        DemoEntry item = new DemoEntry();
        demoEntryList.add(item);
        return item;
    }

    /**
     * We cannot use original "demoEntryList" because it is created with blank
     * value and using java reflection values are populated. Hashset method is
     * computed during constructor and any change in value after constructor
     * will not change Hashset.
     *
     * @return HashSet<DemoEntry>
     */
    private HashSet<DemoEntry> cloneIgnoreSet() {
        HashSet<DemoEntry> newSet = new HashSet<DemoEntry>();
        for (Iterator<DemoEntry> it = demoEntryList.iterator(); it.hasNext();) {
            DemoEntry item = it.next();
            DemoEntry newItem = new DemoEntry(item.getPath(), item.getIsFolderPath());
            newSet.add(newItem);
            log("Path - "+item.getPath());
            log("Is Folder Path - "+item.getIsFolderPath());
        }
        return newSet;
    }

    public void execute() {
        try {
            log("Description - "+getDescription());
            //Read set of tags from ANT Build script
            HashSet<DemoEntry> setDemo = cloneIgnoreSet();
        } catch (Exception e) {
            log(getExceptionMessage(e));
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
