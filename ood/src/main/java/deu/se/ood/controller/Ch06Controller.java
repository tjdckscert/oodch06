/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.controller;

import deu.se.ood.model.ch06.AddBookManager;
import deu.se.ood.model.ch06.AddBookRow;
import deu.se.ood.model.ch06.HikariConfiguration;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * Author     : tjdckscert
 */
@Controller
@Slf4j
@PropertySource("classpath:/config.properties")
public class Ch06Controller {

    @Value("${mysql.server.ip}")
    private String mysqlServerIp;
    @Value("${mysql.server.port}")
    private String mysqlServerPort;
    private final Environment env; 
    private final HikariConfiguration dbConfig;
    public Ch06Controller(Environment env, HikariConfiguration dbConfig) {
        this.env = env;
        this.dbConfig = dbConfig;
    }

    @GetMapping("/ch06/showtable1")
    public String showTable1(Model model) {
        model.addAttribute("mysql_server_ip", this.mysqlServerIp);
        model.addAttribute("mysql_server_port", this.mysqlServerPort);
        log.info("mysql_server.ip = {}, mysql_server.port = {}", this.mysqlServerIp, this.mysqlServerPort);
        return "ch06/showtable1/index";
    }

    @GetMapping("/ch06/showtable2")
    public String showTable2(Model model) {
        log.debug("showtable2: server = {}, port = {}", mysqlServerIp, mysqlServerPort);
        model.addAttribute("mysql_server_ip", mysqlServerIp);
        model.addAttribute("mysql_server_port", mysqlServerPort);
        return "ch06/showtable2/index";
    }

    @GetMapping("/ch06/insert_addrbook")
    public String insertAddressBook() {
        return "ch06/inserttable/insert_addrbook";
    }

    @GetMapping("/ch06/inserttable")
    public String insertTable(Model model) {
        String userName = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String jdbcDriver = env.getProperty("spring.datasource.driver-class-name");
        log.debug("ip = {}, port = {}", this.mysqlServerIp, this.mysqlServerPort);
        AddBookManager manager = new AddBookManager(mysqlServerIp, mysqlServerPort, userName, password, jdbcDriver);
        List<AddBookRow> dataRows = manager.getAllRows();
        model.addAttribute("dataRows", dataRows);
        return "ch06/inserttable/index";
    }
//
    @PostMapping("/ch06/insert.do")
    public String insertAddressBook(@RequestParam String email, @RequestParam String name, @RequestParam String phone, Model model) {
        String userName = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String jdbcDriver = env.getProperty("spring.datasource.driver-class-name");
        AddBookManager manager = new AddBookManager(mysqlServerIp, mysqlServerPort, userName, password, jdbcDriver);
        manager.addRow(email, name, phone);
        List<AddBookRow> dataRows = manager.getAllRows();
        model.addAttribute("dataRows", dataRows);
        return "redirect:/ch06/inserttable";  
    }

    @GetMapping("ch06/hikari_cp")
    public String hikariCP(Model model) {
        model.addAttribute("dbConfig", dbConfig);
        return "ch06/hikari_cp/index";
    }
}
