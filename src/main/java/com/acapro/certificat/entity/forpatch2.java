import com.acapro.certificat.enums.ApplicantStatusType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "forpatch2")
@Data
public class forpatch2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_type")
    private ApplicantStatusType statusType;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @JsonManagedReference
    private Course course;
}