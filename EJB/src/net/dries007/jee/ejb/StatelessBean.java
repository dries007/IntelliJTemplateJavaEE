package net.dries007.jee.ejb;

import net.dries007.jee.db.CatsEntity;
import net.dries007.jee.db.OwnersEntity;
import net.dries007.jee.interfaces.IStatelessBeanRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Dries007
 */
@Stateless
public class StatelessBean implements IStatelessBeanRemote
{
    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager entityManager;

    /**
     * Gets a random number as per xkcd 221. (https://xkcd.com/221/)
     */
    @Override
    public int getRandomNumber()
    {
        return 2;
    }

    @Override
    public Iterable<String> getCatsOwnedBy(int ownerId)
    {
        OwnersEntity owner = entityManager.find(OwnersEntity.class, ownerId);
        if (owner == null) return Collections.emptyList();
        Collection<CatsEntity> cats = owner.getCatsById();
        ArrayList<String> names = new ArrayList<>();
        for (CatsEntity catsEntity : cats)
        {
            names.add(catsEntity.getName());
        }
        return names;
    }
}
