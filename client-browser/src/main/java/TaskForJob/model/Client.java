package TaskForJob.model;
import javax.persistence.*;


@Entity
@Table(name = "Client")
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	@Column(name ="Name")
	private String name;
	@Column(name ="Surname")
	private String surname;
	@Column(name ="Mail")
	private String mail;
	@Column(name ="Address")
	private String address;
	@Column(name ="Phone")
	private String phone;
	@Column(name ="AnotherInformation")
	private String anotherInformation;
	
	
	
	public Client(Integer id, String name, String surname, String mail, String address, String phone,
			String anotherInformation) {
	
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.address = address;
		this.phone = phone;
		this.anotherInformation = anotherInformation;
	}
	
	public Client() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAnotherInformation() {
		return anotherInformation;
	}
	public void setAnotherInformation(String anotherInformation) {
		this.anotherInformation = anotherInformation;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", mail=" + mail + ", address="
				+ address + ", phone=" + phone + ", anotherInformation=" + anotherInformation + "]";
	}

	

}
