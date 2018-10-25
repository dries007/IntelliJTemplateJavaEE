package net.dries007.jee.db;

import javax.persistence.*;

/**
 * @author Dries007
 */
@Entity
@Table(name = "cats", schema = "AA01")
public class CatsEntity
{
    private int id;
    private String name;
    private String color;
    private OwnersEntity ownersByOwner;

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

    @Basic
    @Column(name = "color")
    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatsEntity that = (CatsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    public OwnersEntity getOwnersByOwner()
    {
        return ownersByOwner;
    }

    public void setOwnersByOwner(OwnersEntity ownersByOwner)
    {
        this.ownersByOwner = ownersByOwner;
    }
}
