package pt.truphone.reputation.domain;

import java.util.UUID;

public class UntrustedDevice {
    private UUID idModel;
    private int score;

    public UUID getIdModel() {
        return idModel;
    }

    public void setIdModel(UUID idModel) {
        this.idModel = idModel;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "UntrustedDevice{" +
                "idModel=" + idModel +
                ", score=" + score +
                '}';
    }
}
