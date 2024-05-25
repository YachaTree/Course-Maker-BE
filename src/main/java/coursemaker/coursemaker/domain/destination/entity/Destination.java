package coursemaker.coursemaker.domain.destination.entity;

import coursemaker.coursemaker.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
public class Destination extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "memberId")
//    private Member member;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "pictureLink", length = 300)
    private String pictureLink;

    @Column(name = "content", columnDefinition = "MEDIUMTEXT")
    private String content;

    @Column(name = "location", length = 50)
    private String location;

    @Column(name = "longitude", precision = 15, scale = 13)
    private BigDecimal longitude;

    @Column(name = "latitude", precision = 15, scale = 13)
    private BigDecimal latitude;

    //Todo: BaseEntity에 있는 createdAt 교체 해야함
//    @Column(name = "createdAt")
//    private Timestamp createdAt;
}
