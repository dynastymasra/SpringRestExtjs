package com.dynastymasra.spring.controller.api;

import com.dynastymasra.core.wrapper.PageJsonWrapper;
import com.dynastymasra.spring.domain.StudyClub;
import com.dynastymasra.spring.repository.StudyClubRepository;
import com.dynastymasra.spring.service.StudyClubService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

@Controller
@RequestMapping(value = "/api/studyClub")
public class StudyClubApiController {

    protected static Logger logger = Logger.getLogger("controller");
    @Autowired
    private StudyClubRepository studyClubRepository;
    @Autowired
    private StudyClubService studyClubService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody StudyClub studyClub) throws Exception {
        logger.debug("Received rest request to create java");


           return studyClubService.create(studyClub).toString();

    }

    @RequestMapping(params = {"id"}, method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestParam("id") Integer id, @RequestBody StudyClub studyClub) throws Exception {
        logger.debug("Received rest request to update java");

            return studyClubService.update(id, studyClub).toString();

    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String findAll(Pageable pageable, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("Received rest request  to get list java");
        Page<StudyClub> result = studyClubRepository.findAll(pageable);
        contentRangeBuilder(result, response);
        return new PageJsonWrapper<StudyClub>(result, StudyClub.class).toJsonString();

    }

    @RequestMapping(params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public String findById(@RequestParam("id") Integer id) {
        logger.debug("Received rest request to get data java");
        StudyClub studyClub = studyClubRepository.findOne(id);
        return studyClub.toString();
    }

    @RequestMapping(params = {"id"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String delete(@RequestParam("id") Integer id) {
        logger.debug("Received rest request to delete java");
        try {
            return studyClubService.destroy(id).toString();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }

    }

    protected void contentRangeBuilder(Page<StudyClub> result, HttpServletResponse response) {
        String contentRange = "items ";
        contentRange += (result.getNumber() * result.getSize());
        contentRange += "-" + ((result.getNumber() * result.getSize()) + result.getNumberOfElements());
        contentRange += "/" + result.getTotalElements();
        response.setHeader("Content-Range", contentRange);
    }

}
