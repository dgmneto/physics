/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgmn.physics.util;

import java.io.File;

/**
 *
 * @author dgmneto
 */
public class Util {
    
    public static String getValidName(String name, String extension){
        String resposta = name + extension;
        File f = new File(resposta);
        
        for(int i = 1; f.exists() && !f.isDirectory(); i++){
            resposta = name + "_" + i + extension;
            f = new File(resposta);
        }
        
        return resposta;
    }
    
}
