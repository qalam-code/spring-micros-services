package com.qalamcode.gateway_proxy.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackRestController {

    @GetMapping("/fallback/muslimsalat")
    public ResponseEntity<String> muslimsalatFallback() {
        return ResponseEntity.ok("MuslimSalat API indisponible, veuillez réessayer plus tard.");
    }

    @GetMapping("/fallback/thescountries")
    public ResponseEntity<String> thescountriesFallback() {
        return ResponseEntity.ok("thescountries API indisponible, veuillez réessayer plus tard.");
    }

}
