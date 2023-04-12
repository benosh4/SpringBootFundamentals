package ttl.larku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ttl.larku.domain.Track;
import ttl.larku.service.TrackService;

import java.util.List;

/**
 * @author whynot
 */

@RestController
@RequestMapping("/track")
public class TrackController {

//    @Autowired
    private TrackService trackService;

    //Autowiring happening here.
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public List<Track> getAllTracks() {
        List<Track> tracks = trackService.getAllTracks();
        return tracks;
    }

    @GetMapping("/{id}")
    public Track getTracks(@PathVariable("id") int id) {
        Track track = trackService.getTrack(id);
        return track;
    }

    @PostMapping
    public Track createTrack(@RequestBody Track track) {
        Track newTrack = trackService.createTrack(track);
        return newTrack;
    }



}
