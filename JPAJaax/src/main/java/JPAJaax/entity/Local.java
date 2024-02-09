package JPAJaax.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "manager")
public class Local {
	@Id
	@SequenceGenerator(name = "local_sequence",
						sequenceName="local_sequence",
						allocationSize=1)
	@GeneratedValue(generator="local_sequence",
					strategy = GenerationType.SEQUENCE)
	private Long localId;
	private String name;
	private String floor;
	
	@OneToOne(cascade = CascadeType.PERSIST,
			fetch = FetchType.LAZY)
	@JoinColumn(name="manager_id",
				referencedColumnName = "managerId")
	private Manager manager;
	
	@ManyToMany(cascade = CascadeType.ALL,
				fetch = FetchType.EAGER)
	@JoinTable(name = "local_customer_map",
				joinColumns = @JoinColumn(name="local_id",
										  referencedColumnName = "LocalId"),
				inverseJoinColumns = @JoinColumn(name="customer_id",
												  referencedColumnName = "customerId"))
	private List<Customer> customerList;
	/*@OneToMany(cascade = CascadeType.ALL,
				fetch = FetchType.EAGER)
	@JoinColumn(name="local_id",
				referencedColumnName = "localId")
	private List<Order> orderList;*/
}
