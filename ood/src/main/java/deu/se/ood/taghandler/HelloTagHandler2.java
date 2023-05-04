/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package deu.se.ood.taghandler;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * Author     : tjdckscert
 */
@Slf4j
public class HelloTagHandler2 extends SimpleTagSupport {

    @Setter
    private String user;
    @Setter
    private int count = 1;
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            for (int i = 0; i < count; i++) {
                out.println(String.format("%s님, 안녕하십니까 <br>", user));
            }
        } catch (IOException e) {
            log.error("HelloTagHandler: 예외 = {}", e.getMessage());
        }
        
    }


}
