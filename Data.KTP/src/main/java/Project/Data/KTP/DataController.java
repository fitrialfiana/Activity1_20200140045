/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Data.KTP;


import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.projectService;

/**
 *
 * @author fiezi
 */
@Controller

public class DataController {

    projectService serv = new projectService();
    
    
    @RequestMapping("/View")
    @ResponseBody

    public ArrayList<String> getDataUtil()
    {
        return serv.tabel();
    }


    @RequestMapping("/tampilkandata")
    public String tampil(Model kurir)
    {
        
        //Inisiliasi array list baru
        ArrayList<String> datainfo = new ArrayList();
        ArrayList<String> datainfo1 = new ArrayList();
        ArrayList<String> datainfo2 = new ArrayList();
        ArrayList<String> datainfo3 = new ArrayList();
       
        
        //Inisialisasi nama datainfo
        datainfo = serv.tabel();
        datainfo1 = serv.tabel1();
        datainfo2 = serv.tabel2();
        datainfo3 = serv.tabel3();
       

        //isi datainfo dari projectService
        kurir.addAttribute("ktp", datainfo); 
        kurir.addAttribute("ktp1", datainfo1); 
        kurir.addAttribute("ktp2", datainfo2); 
        kurir.addAttribute("ktp3", datainfo3); 
       
        return "viewData"; 
        
    }
}