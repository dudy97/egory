package com.dudy.controller;

import com.dudy.entity.Point;
import com.dudy.entity.Region;
import com.dudy.repository.PointRepository;
import com.dudy.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by admin on 12.12.2018.
 */
@Controller
@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private RegionRepository regionRepository;
//    @GetMapping(path = "/add")
//    public @ResponseBody
//    String addNewUser () {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//
//        Point p = new Point();
//        p.setName("Tarnica");
//        p.setHeight(1346);
//        p.setLatitude(49.04);
//        p.setLongitude(22.43);
//        p.setDescription("Najwyższy szczyt Bieszczad");
//        pointRepository.save(p);
//        return "Saved";
//    }
@GetMapping
@RequestMapping(value = "/", method = RequestMethod.GET)
public String index()
{
    return "index";
}
@GetMapping
@RequestMapping(value = "/new-point", method = RequestMethod.GET)
public String newPoint(Model model)
{
    Point thePoint = new Point();
    ArrayList<Region> regions = (ArrayList<Region>) regionRepository.findAll();
    model.addAttribute("regions", regions);
    model.addAttribute("point", thePoint);
    return "point-form";
}
    @RequestMapping(value = "/savePoint", method = RequestMethod.POST)
    public String processForm(@ModelAttribute Point point, BindingResult errors, Model model){
        pointRepository.save(point);
        return "index";
    }

}
