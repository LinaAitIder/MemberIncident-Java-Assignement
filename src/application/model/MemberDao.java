package application.model;
import java.util.Set;

public interface MemberDao {
	public void insere(Member m);
	public Set<Incident> chargerListIncidents();
	public Set<Member> chargerListMember(String nomFichier);
}
