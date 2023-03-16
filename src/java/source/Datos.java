package source;

/**
 * By Nicojrz
 */

import java.io.Serializable;

public class Datos implements Serializable {
    
    private String name;
    private float grade;

    public Datos() {}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
