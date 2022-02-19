package com.wilsonevs.utilidades;

public class Constantes {

    public static class BD {
        public static final String base_datos = "BD_CRUD";
    }

    public static class VALIDACION_NEGOCIO {
        public static final String INCOMPLETOS= "DATOS INCOMPLETOS, ¡FALTA POR DEFINIR!";
        public static final String VACIO= "DATOS INCOMPLETOS, ¡NO EXISTE!";

    }


    public static class MENSAJES_PETICION {
        public static final String NOMBRE= "¡POR FAVOR!, INTRODUZCA UN NOMBRE.";
        public static final String TELEFONO= "¡POR FAVOR!, INTRODUZCA UN TELÉFONO.";
        public static final String NUMERO= "¡POR FAVOR!, INGRESAR SOLO NÚMEROS.";
        public static final String CORREO= "¡POR FAVOR!, INTRODUZCA UNA DIRRECIÓN DE CORREO ELECTRÓNICO.";
        public static final String DIRECCIÓN= "¡POR FAVOR!, INTRODUZCA UNA DIRECCIÓN.";
    }


    public static class MENSAJES_CONFIRMACION {
        public static final String NOMBRE= "¡POR FAVOR!, INTRODUZCA UN NOMBRE VÁLIDO.";
        public static final String TELEFONO= "¡POR FAVOR!, INTRODUZCA UN TELÉFONO VÁLIDO.";
        public static final String NUMERO= "¡POR FAVOR!, INGRESAR SOLO NÚMEROS.";
        public static final String CORREO= "¡POR FAVOR!, INTRODUZCA UNA DIRRECIÓN DE CORREO ELECTRÓNICO VÁLIDO.";
        public static final String DIRECCIÓN= "¡POR FAVOR!, INTRODUZCA UNA DIRECCIÓN VÁLIDO.";
    }

    public static class Estados {

        public static final Integer BORRADO = 99;
        public static final Integer INACTIVO = 0;
        public static final Integer ACTIVO = 1;
        public static final Integer EN_USO = 2;
        public static final Integer DISPONIBLE = 3;
        public static final Integer NO_DISPONIBLE = 4;
        public static final Integer POR_PROCESAR = 5;
        public static final Integer PROCESADA = 6;
        public static final Integer EN_PROCESO = 7;
        public static final Integer ERROR = 8;
        public static final Integer ANULADA = 9;

    }

}
