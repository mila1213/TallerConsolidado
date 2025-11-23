package EleccionReinaQuito;

// Voto.java
import java.time.LocalDateTime;

public class Voto {
    private int idVoto;
    private int idCandidata;
    private LocalDateTime fechaHora;

    public Voto(int idVoto, int idCandidata) {
        this.idVoto = idVoto;
        this.idCandidata = idCandidata;
        this.fechaHora = LocalDateTime.now();
    }

    public int getIdVoto() {
        return idVoto;
    }
    public int getIdCandidata() {
        return idCandidata;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}

