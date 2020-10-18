package edu.intech.intflix.controller;

import edu.intech.intflix.model.Season;
import edu.intech.intflix.model.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
public class SeasonController {
    @Autowired  // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private SeasonRepository seasonRepository;

    @PostMapping(path = "/season") // Map ONLY POST Requests
    public @ResponseBody
    void addNewSeries(@RequestBody Season season) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        seasonRepository.save(season);
    }

    @GetMapping(path = "/season")
    public @ResponseBody
    Iterable<Season> getAllSeries() {
        // This returns a JSON or XML with the users
        return seasonRepository.findAll();
    }

    @DeleteMapping(path = "/season")
    public @ResponseBody
    void deleteUser(@RequestParam Long id) {
        Optional<Season> series = seasonRepository.findById(id);
        series.ifPresent(seasonRepository::delete);
    }
}