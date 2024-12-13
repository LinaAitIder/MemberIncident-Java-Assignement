package application.model;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor


public class Incident {
	private String reference;
	private String time;
	private String status;

}
