@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/stats")
    public String getStats() {
        return "Données réservées à l'administrateur";
    }

    @PreAuthorize("hasAuthority('CLIENT_WRITE')")
    @PostMapping("/client")
    public String addClient() {
        return "Client ajouté avec succès";
    }
}
