package cl.global.logic.test.api.usuario.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TBL_USUARIO")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creado", "actualizado"},allowGetters = true)
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuario")
	private long idusuario;
	
	@NotBlank
	@Column(name="nombre")
	private String nombre;
	
	@NotBlank
	@Column(name="email")
	private String email;
	
	@NotBlank
	@Column(name="password")
	private String password;
	
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
	@Column(name="creado", nullable = false, updatable = false)
	private Date creado;
    
	@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name="actualizado", nullable = false)
	private Date actualizado;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
    @Column(name="lastlogin", nullable = false)
	private Date lastlogin;
	
	@Column(name="token")
	private String token;
	
	@Column(name="isactive", nullable = false)
	private boolean isactive;
	
	
	
	public Usuario() {}
	
	
	public Usuario(int idusuario, String nombre, String email, String password) {
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}

	


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "User [idusuario=" + idusuario + ", nombre=" + nombre + ", email=" + email + ", password=" + password + ", creado=" + creado
				+ ", actualizado=" + actualizado + "]";
	}


	public long getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(long idusuario) {
		this.idusuario = idusuario;
	}


	public Date getCreado() {
		return creado;
	}


	public void setCreado(Date creado) {
		this.creado = creado;
	}


	public Date getActualizado() {
		return actualizado;
	}


	public void setActualizado(Date actualizado) {
		this.actualizado = actualizado;
	}


	public Date getLastlogin() {
		return lastlogin;
	}


	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public boolean isIsactive() {
		return isactive;
	}


	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

}