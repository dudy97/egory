package com.dudy.controller;

import com.dudy.entity.MountainGroup;
import com.dudy.entity.Point;
import com.dudy.entity.Region;
import com.dudy.entity.Route;
import com.dudy.repository.MountainGroupRepository;
import com.dudy.repository.PointRepository;
import com.dudy.repository.RegionRepository;
import com.dudy.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 12.12.2018.
 */
@Controller
@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private MountainGroupRepository mountainGroupRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/guide", method = RequestMethod.GET)
    public String showGuidePanel() {
        return "guide-panel";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String showCustomerPanel() {
        return "customer-panel";
    }

    @RequestMapping(value = "/new-point", method = RequestMethod.GET)
    public String newPoint(Model model) {
        Point thePoint = new Point();
        ArrayList<Region> regions = (ArrayList<Region>) regionRepository.findAll();
        model.addAttribute("regions", regions);
        model.addAttribute("point", thePoint);
        return "point-form";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        NumberFormatUtil.registerDoubleFormat(binder);
    }

    @RequestMapping(value = "/savePoint", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute Point point, BindingResult errors) {
        if (errors.hasErrors())
            return "point-form";
        pointRepository.save(point);
        return "redirect:/";
    }

    @RequestMapping(value = "/routes-page", method = RequestMethod.GET)
    public String showRoutesPage(Model model){
        ArrayList<MountainGroup> mountainGroups = (ArrayList<MountainGroup>) mountainGroupRepository.findAll();
        model.addAttribute("groups", mountainGroups);
        return "show-routes";
    }
    @RequestMapping(value = "/processGroup", method = RequestMethod.POST)
    public String processRouteForm(@RequestParam() String groupChosen, Model model){
        List<Route> routes = routeRepository.getRoutesByGroup(groupChosen);
        Set<Route> routeSet = new LinkedHashSet<>(routes);
        for(int i=0;i<routes.size();i++){
            ArrayList<Point> points = (ArrayList<Point>) pointRepository.getPointByRoute(routes.get(i).getId());
            routes.get(i).setPoints(points);
        }
        model.addAttribute("groupName", groupChosen);
        model.addAttribute("routes", routeSet);
        ArrayList<MountainGroup> mountainGroups = (ArrayList<MountainGroup>) mountainGroupRepository.findAll();
        model.addAttribute("groups", mountainGroups);
        return "show-routes";
    }


}
