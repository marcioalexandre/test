package pt.truphone.locator.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApplicationScoped
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fog extends PanacheEntity {

    private Long id;
    private String region;
}
