
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lenovo
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;


public class IO {
    public String getI(String filename){
        try{
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String c;
            String ret = "";
            while((c = in.readLine()) != null){
                ret += c;
            }
            in.close();
            return ret;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new String();
        }
    }
    
    public void writeO(String filename,String output){
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filename);
            for(int c: output.toCharArray()){
                out.write((char)c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //00111000
    //00000000/0000000/000000/00000
    public void writeBinary(String filename , String s , int sz){
        FileOutputStream out = null;
        byte data[] = new byte[(sz + 7) / 8];
        for(int i = 0; i < sz; ++i)
            if(s.charAt(i) == '1') data[i / 8] |= (1 << (7 - i % 8));
        try {
            out = new FileOutputStream(filename);
            out.write(sz);
            out.close();
            out = new FileOutputStream(filename , true);
            out.write(data, 0, data.length);
            out.flush();        
            out.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    //00111000
    //001
    public String readBinary(String filename){
        File inputFile = new File(filename);
        String res = "";
        FileInputStream r = null;
        try{
            r = new FileInputStream(inputFile);
            int sz = r.read()+1;
            byte[] data = new byte[(sz + 7)/8];
            r.read(data, 0, data.length);
            r.close();
            for (int i = 0; i < sz; ++i) {
                res += (char) ('0' + ((data[i / 8] >> (7 - i % 8)) & 1));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return res;
    }
    
}

// 000101 & 000001
