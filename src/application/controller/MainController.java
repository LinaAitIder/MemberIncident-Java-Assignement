package application.controller;
import application.model.Member;
import application.model.MemberDaoImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class MainController {
	@FXML
	private Button insertBtn;
	@FXML
	private TextField nom;
	@FXML
	private TextField prenom;
	@FXML
	private TextField email;
	@FXML
	private TextField phone;
	@FXML
	public void InsertMember() {
		Member member = new Member();
		member.setEmail(email.getText());
		member.setNom(nom.getText());
		member.setPrenom(prenom.getText());
		member.setPhone(phone.getText());
		MemberDaoImpl mdi = new MemberDaoImpl();
		mdi.insere(member);
	}

}
