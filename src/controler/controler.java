/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.util.ArrayList;
import java.util.List;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class controler {

    List<SanPham> listSp = new ArrayList<>();

    public List<SanPham> fakeData() {
        listSp.add(new SanPham("SP1", "Ban", "2023", "5kg", "Ban nhap khau", 19, 1000000, 1200000));
        listSp.add(new SanPham("SP2", "Ghe", "2022", "2kg", "Ghe hang viet nam", 30, 100000, 120000));
        listSp.add(new SanPham("SP3", "Tu", "2021", "10kg", "Tu nhap khau", 21, 1000000, 1300000));
        listSp.add(new SanPham("SP4", "Tivi", "2023", "7kg", "Tivi sony nhap khau", 40, 26000000, 27999999));
        listSp.add(new SanPham("SP5", "Bep", "2023", "2kg", "Bep hang viet nam", 50, 2300000, 3000000));
        return listSp;
    }
}
