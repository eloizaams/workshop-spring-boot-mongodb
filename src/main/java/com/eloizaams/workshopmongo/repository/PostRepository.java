package com.eloizaams.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.eloizaams.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{ title: { $regex: ?0, $options: 'i' } }") //?0 - primeiro parametro, "i" - insensitive case
	List<Post> searchTitle (String text);

	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
