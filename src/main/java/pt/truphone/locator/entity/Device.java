package pt.truphone.locator.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@ApplicationScoped
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device extends PanacheEntity {

    private Long id;
    @Column(name = "id_model")
    private UUID modelId;
    @Column(name = "id_framework")
    private Long frameworkId;
    @Column(name = "id_fog")
    private Long fogId;
}
