package application.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import application.database.ConnectionDb;


public class MemberDaoImpl implements MemberDao{
	ConnectionDb db;
	@Override
	public void insere(Member m) {
		db = new ConnectionDb();
		PreparedStatement ps;
	
		try {
			int MemberId = m.getId();
			String MemberNom = m.getNom();
			String MemberPrenom = m.getPrenom();
			String MemberEmail = m.getEmail();
			String MemberPhone = m.getPhone();
			String Query = "INSERT INTO member (id, nom, prenom, email , phone) VALUES (?, ?, ?,?,?)";
			ps  = db.getCon().prepareStatement(Query);
			ps.setInt(1, MemberId);
			ps.setString(2, MemberNom);
			ps.setString(3, MemberPrenom);
			ps.setString(4, MemberEmail);
			ps.setString(5, MemberPhone);
			ps.execute();
			System.out.print("The Member  has been inserted into Database");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public Set<Incident> chargerListIncidents(){
		db = new ConnectionDb();
		Set<Incident> incidentList = new HashSet<>(); 
		String req = "Select * from incidents";
		ResultSet res;
		try {
			res = db.getSt().executeQuery(req);
			while(res.next()){
				incidentList.add(new Incident (res.getString("reference"), res.getString("time"), res.getString("status")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
		return incidentList;
	}
	
	@Override
	public Set<Member> chargerListMember(String nomFichier){
		Set<Member> memberList = new HashSet<Member>();
		String line = null;
		String memberInfo[];
		try {
		FileReader fr = new FileReader(nomFichier);
		BufferedReader bf = new BufferedReader(fr);
		
			while((line= bf.readLine())!= null) {
				Member member = new Member();
				memberInfo = line.split(",");
				member.setNom(memberInfo[0]);
				member.setPrenom(memberInfo[1]);
				member.setEmail(memberInfo[2]);
				member.setPhone(memberInfo[3]);
				memberList.add(member);
			  }
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return memberList;
	}
}
