package com.dynastymasra.spring.controller.api;

import com.dynastymasra.core.wrapper.PageJsonWrapper;
import com.dynastymasra.spring.domain.Mahasiswa;
import com.dynastymasra.spring.domain.StudyClub;
import com.dynastymasra.spring.repository.MahasiswaRepository;
import com.dynastymasra.spring.service.MahasiswaService;
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
@RequestMapping(value = "/api/mahasiswa")
public class MahasiswaApiController {

    protected static Logger logger = Logger.getLogger("controller");
    @Autowired
    private MahasiswaService mahasiswaService;
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Mahasiswa mahasiswa) {
        logger.debug("Received rest request to create mahasiswa");
        Mahasiswa m = null;
        try {
            m = mahasiswaService.create(mahasiswa);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return m.toString();
    }

    @RequestMapping(params = {"id"}, method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestParam("id") Integer id, @RequestBody Mahasiswa mahasiswa) {
        logger.debug("Received rest request to update mahasiswa");
        Mahasiswa m = null;
        try {
            m = mahasiswaService.update(id, mahasiswa);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return m.toString();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String findAll(Pageable pageable, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("Received rest request  to get list mahasiswa");
        Page<Mahasiswa> result = mahasiswaRepository.findAll(pageable);
       contentRangeBuilder(result, response);
        return new PageJsonWrapper<Mahasiswa>(result, Mahasiswa.class).toJsonString();
    }

    @RequestMapping(params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public String findById(@RequestParam("id") Integer id) {
        logger.debug("Received rest request to get data mahasiswa");
        Mahasiswa mahasiswa = mahasiswaRepository.findOne(id);

        return mahasiswa.toString();
    }

    @RequestMapping(params = {"id"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String delete(@RequestParam("id") Integer id) {
        logger.debug("Received rest request to delete mahasiswa");
        Mahasiswa m = null;
        try {
            mahasiswaService.destroy(id).toString();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return m.toString();
    }

    protected void contentRangeBuilder(Page<Mahasiswa> result, HttpServletResponse response) {
        String contentRange = "items ";
        contentRange += (result.getNumber() * result.getSize());
        contentRange += "-" + ((result.getNumber() * result.getSize()) + result.getNumberOfElements());
        contentRange += "/" + result.getTotalElements();
        response.setHeader("Content-Range", contentRange);
    }
}
