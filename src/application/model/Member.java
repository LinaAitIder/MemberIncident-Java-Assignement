package application.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Member {
	private int id ;
	private String nom;
	private String prenom;
	private String email;
	private String phone;
	List<Incident> incidentList ;
	
	public Member(){
		incidentList = new ArrayList<>();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == this) return true;
		
	    if (obj == null || getClass() != obj.getClass()) {
	            return false;
	     }
	    
		Member other = (Member) obj;
	    return (this.id == other.getId());

	}
	
	//Redefining the method hashcode 
	@Override
	public int hashCode() {
		return Objects.hash(id, nom , prenom , email , phone , incidentList);
		
	}
}
