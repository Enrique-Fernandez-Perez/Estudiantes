package com.example.appBack.Comprobadores;

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
}
