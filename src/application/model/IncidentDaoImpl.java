package application.model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import application.database.ConnectionDb;


public class IncidentDaoImpl implements IncidentDao {
	@Override 
	public void inserer(Incident i) {
		ConnectionDb db = new ConnectionDb();
		PreparedStatement ps;
	
		try {
			String IncidentRef = i.getReference();
			String IncidentTime = i.getTime();
			String IncidentStatus = i.getStatus();
			String timeConverted = IncidentTime.toString();
			String Query = "INSERT INTO incidents (reference, time, status) VALUES (?, ?, ?)";
			ps  = db.getCon().prepareStatement(Query);
			ps.setString(1, IncidentRef);
			ps.setString(2, timeConverted);
			ps.setString(3, IncidentStatus);
			ps.execute();
			System.out.print("The Incident has been inserted into Database");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	@Override 
	public void inser(Set is) {
		for(Object i : is) {
			Incident incident = (Incident) i ;
			inserer(incident);
		}
		
	}
	
	}
