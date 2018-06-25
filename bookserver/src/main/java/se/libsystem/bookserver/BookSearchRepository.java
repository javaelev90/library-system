package se.libsystem.bookserver;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import javax.transaction.Transactional;

public interface BookSearchRepository extends ElasticsearchRepository<Book, Long> {
}
