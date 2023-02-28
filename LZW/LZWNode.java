/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LZW;

/**
 *
 * @author kagan
 */
public class LZWNode {
    public String string;
    public Integer encode;
    public LZWNode(String string, Integer encode) {
        this.string = string;
        this.encode = encode;
    }
}
