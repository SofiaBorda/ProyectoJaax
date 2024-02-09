package JPAJaax.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name="tbl_order")
public class Order {
	@Id
	@SequenceGenerator(name = "order_sequence",
						sequenceName = "order_sequence",
						allocationSize = 1)
	@GeneratedValue(generator = "order_sequence",
					strategy = GenerationType.SEQUENCE)
	private Long orderId;
	private String description;
	private double price;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="local_id",
				referencedColumnName = "localId")
	private Local local;
}
