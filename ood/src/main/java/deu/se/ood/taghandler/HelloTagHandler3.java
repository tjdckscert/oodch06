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
import lombok.extern.slf4j.Slf4j;

/**
 *
 *Author     : tjdckscert
 */
@Slf4j
public class HelloTagHandler3 extends SimpleTagSupport {

    private String user;
    private int count=1;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            for (int i = 0; i < count; i++) {
                out.println(String.format("%s님, 안녕하십니까<br>", user));
            }
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }


        } catch (IOException e) {
            log.error("HelloTagHandler: 예외 = {}", e.getMessage());
        }
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
