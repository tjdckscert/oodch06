/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.beans.ch04;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Author     : tjdckscert
 */
@Slf4j
public class SumBean {
    //private Logger log = LoggerFactory.getLogger(getClass());
    private int n;
    private int result;
    
    public SumBean() {
        log.debug("The instance SumBean created...");
        result = 0;
    }
    
    public void calculate() {
        result = n * (n+1) / 2;
    }
    public int getN() {
        return n;
    }
    public void setN(int n)
    {
        this.n = n;
    }
    public int getResult(){
        return result;
    }
}
