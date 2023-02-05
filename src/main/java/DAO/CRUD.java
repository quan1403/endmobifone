package DAO;

import java.awt.print.Pageable;
import java.util.List;

public interface CRUD<E> {
    public List<E> getAll();
    public boolean create(E e);
    public boolean edit(int id,E e);
    public boolean delete(int id);
    public E findById(int id);
    public List<E> pagingAccount(int index);
    public boolean lock(int id ,String status);


}
