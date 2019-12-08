package com.ddastudio.mrmr.profile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/08
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService service;

    @PostMapping
    public ResponseEntity<ProfileDTO> addProfile(@RequestBody ProfileDTO profileDTO, int id) throws Exception {
        return ResponseEntity.ok(service.addProfile(profileDTO, id));
    }

    @PutMapping
    public ResponseEntity<ProfileDTO> modifyProfile(@RequestBody ProfileDTO profileDTO, int id) throws Exception {
        return ResponseEntity.ok(service.addProfile(profileDTO, id));
    }

    @DeleteMapping
    public ResponseEntity deleteProfile(@PathVariable int id) throws Exception {
        service.deleteProfile(id);
        return ResponseEntity.ok("Success");
    }

}
