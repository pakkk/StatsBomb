package es.iesjandula.statsbomb.competitions_rest.security.models;

import jakarta.persistence.*;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 12/02/2023
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class User
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    private String password;

    @ManyToOne
    public RolModel rol;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public RolModel getRol()
    {
        return rol;
    }

    public void setRol(RolModel rol)
    {
        this.rol = rol;
    }
}
