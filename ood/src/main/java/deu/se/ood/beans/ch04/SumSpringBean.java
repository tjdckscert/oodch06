/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.beans.ch04;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * Author     : tjdckscert
 */
@Component
@Slf4j
public class SumSpringBean {
    @Getter
    @Setter
    private int n;
    
    @Getter
    private int result;
    
    public SumSpringBean() {
        log.debug("The instance SumSpringBean created...");
        result = 0;
    }
    
    public void cal() {
        result = n * (n+1) / 2;
    }
    
}
