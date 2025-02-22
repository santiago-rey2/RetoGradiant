package pase.gradiant.com.RetoGradiant.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "documents")
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 2048)
    private String url;
    @ManyToOne
    @JoinColumn(name = "idTechnology")
    private Technology technology;
}
