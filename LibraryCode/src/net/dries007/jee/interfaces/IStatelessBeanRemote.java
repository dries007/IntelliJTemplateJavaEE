package net.dries007.jee.interfaces;

import javax.ejb.Remote;

/**
 * @author Dries007
 */
@Remote
public interface IStatelessBeanRemote
{
    int getRandomNumber();

    Iterable<String> getCatsOwnedBy(int ownerId);
}
