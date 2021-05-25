package com.example.appBack.Comprobadores;

import java.util.Date;

public class ComprobarNulos {

    public static boolean comprobarString(String str) throws RuntimeException
    {
        /**if (str.trim().length() != 0 && str != null)
        {
            return true;
        }
        return false;*/
        try {
            if (str.trim().length() != 0 && str != null)
            {
                return true;
            }
        }catch (Exception e) { }
        return false;
    }

    public static boolean comprobarObjects(Object objeto) throws RuntimeException
    {
        /*if (objeto != null) {
            return true;
        }

        return false;*/
        try {
            if (objeto != null) {
                return true;
            }
        }catch(Exception e){ }
        return false;
    }

    public static boolean comprobarDistincString(Object object)
    {
        try
        {
            Double num = Double.parseDouble(object.toString());
            return true;
        }
        catch (Exception numeric){
            try{
                Boolean bol = Boolean.parseBoolean(object.toString());
                return true;
            }catch (Exception booleano){
                try {
                    Date fech = (Date) object;
                    return true;
                }catch (Exception fechas){
                    return false;
                }
            }
        }
    }
}
