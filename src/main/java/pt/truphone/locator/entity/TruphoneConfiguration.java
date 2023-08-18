package pt.truphone.locator.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApplicationScoped
@Entity
@Table(name = "configuration")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TruphoneConfiguration extends PanacheEntity {
    private Integer score;
    private String direction;
    private Integer bitrate;
}
