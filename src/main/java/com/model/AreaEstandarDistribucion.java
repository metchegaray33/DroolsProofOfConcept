package com.model;

public enum AreaEstandarDistribucion {

	NACIONAL ( 1, "NACIONAL"), //Separamos con comas

    REGIONAL (2, "REGIONAL");
    
    
    //Campos tipo constante      

    /**
    * CAMPOS TIPO CONSTANTE
     */
    private final int id;    
    private final String descripcion; 
	
     /**
      * Constructor
      * @param id
      * @param descripcion
      */
    AreaEstandarDistribucion ( int id, String descripcion) { 

        this.id = id;

        this.descripcion = descripcion;

    } //Cierre del constructor
	
   
    /**Métodos de la clase tipo Enum     * 
     * 
     */
    

    public int getId() { return id; }

    public String getDescripcion() { return descripcion; }
    
}
