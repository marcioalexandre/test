package pt.truphone.locator.entity;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApplicationScoped
public class SecurityAction {

    private Long frameworkId;
    private String fogRegion;
    private TruphoneConfiguration newConfiguration;
}
