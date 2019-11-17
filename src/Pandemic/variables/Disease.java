package Pandemic.variables;


/**
 * Write a description of class Disease here.
 */
public class Disease
{
    public String colour;
    public boolean cured;
    public boolean eliminated;


    /**
     * Constructor for objects of class Disease
     */
    public Disease(String diseaseColour)
    {
        colour = diseaseColour;
        cured = false;
        eliminated = false;
        
    }
    
    //GET-SET METHODS
    public boolean getCured()
    {
        return cured;
    }
    
    public void setCured(boolean toSet)
    {
        cured = toSet;
    }

    public void setColour(String newColour)
    {
        colour = newColour;
    }
    
    public String getColour()
    {
        return colour;
    }
    
    
}
