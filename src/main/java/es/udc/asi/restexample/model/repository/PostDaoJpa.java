package es.udc.asi.restexample.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.udc.asi.restexample.model.domain.Post;
import es.udc.asi.restexample.model.repository.util.GenericDaoJpa;

@Repository
public class PostDaoJpa extends GenericDaoJpa implements PostDao {

  @Override
  public List<Post> findAll() {
    return entityManager.createQuery("from Post", Post.class).getResultList();
  }

  @Override
  public Post findById(Long id) {
    return entityManager.find(Post.class, id);
  }

  @Override
  public void create(Post post) {
    entityManager.persist(post);
  }

  @Override
  public void update(Post post) {
    entityManager.merge(post);
  }

  private void delete(Post post) {
    entityManager.remove(post);
  }

  @Override
  public void deleteById(Long id) {
    Post post = findById(id);
    delete(post);
  }
}
