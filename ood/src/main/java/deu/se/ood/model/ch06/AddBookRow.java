/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.model.ch06;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 *
 * Author     : tjdckscert
 */
@AllArgsConstructor
@Builder
public class AddBookRow {
    @Getter
    private String email;
    @Getter
    private String name;
    @Getter
    private String phone;
}


