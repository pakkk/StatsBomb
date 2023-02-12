package es.iesjandula.statsbomb.competitions_rest.security.models;

import jakarta.persistence.*;

import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 12/02/2023
 */
@Entity
@Table(name = "rol")
public class RolModel
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "rol_id")
    private List<User> users;


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }
}
