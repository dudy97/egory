package com.dudy.controller;

import com.dudy.entity.*;
import com.dudy.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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
    EntityServiceImpl entityService;

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
        ArrayList<Region> regions = (ArrayList<Region>) entityService.findAllRegions();
        model.addAttribute("regions", regions);
        model.addAttribute("point", thePoint);
        return "point-form";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        NumberFormatUtil.registerDoubleFormat(binder);
    }

    @RequestMapping(value = "/savePoint", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute Point point, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "point-form";
        }
        model.addAttribute("statement", new Statement("Powodzenie",Statement.CONFIRMATION));
        entityService.savePoint(point);
        return "guide-panel";
    }

    @RequestMapping(value = "/routes-page", method = RequestMethod.GET)
    public String showRoutesPage(Model model){
        ArrayList<MountainGroup> mountainGroups = (ArrayList<MountainGroup>) entityService.findAllMountainGroups();
        model.addAttribute("groups", mountainGroups);
        return "show-routes";
    }
    @RequestMapping(value = "/processGroup", method = RequestMethod.POST)
    public String processRouteForm(@RequestParam() String groupChosen, Model model){
        List<Route> routes = entityService.getRouteByGroup(groupChosen);
        Set<Route> routeSet = new LinkedHashSet<>(routes);
        for(int i=0;i<routes.size();i++){
            ArrayList<Point> points = (ArrayList<Point>) entityService.getPointsByRoute(routes.get(i).getId());
            routes.get(i).setPoints(points);
        }
        model.addAttribute("groupName", groupChosen);
        model.addAttribute("routes", routeSet);
        ArrayList<MountainGroup> mountainGroups = (ArrayList<MountainGroup>) entityService.findAllMountainGroups();
        model.addAttribute("groups", mountainGroups);
        return "show-routes";
    }


}
