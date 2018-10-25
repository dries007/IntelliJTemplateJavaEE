package net.dries007.jee.db;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Dries007
 */
@Entity
@Table(name = "owners", schema = "AA01")
public class OwnersEntity
{
    private int id;
    private String name;
    private Collection<CatsEntity> catsById;

    @Id
    @Column(name = "id")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnersEntity that = (OwnersEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ownersByOwner")
    public Collection<CatsEntity> getCatsById()
    {
        return catsById;
    }

    public void setCatsById(Collection<CatsEntity> catsById)
    {
        this.catsById = catsById;
    }
}
