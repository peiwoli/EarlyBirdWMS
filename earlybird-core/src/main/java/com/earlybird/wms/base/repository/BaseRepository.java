/**
 * 
 */
package com.earlybird.wms.base.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.earlybird.wms.base.entity.BaseEntity;

/**
 * @author Peili Zhou
 *
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID> extends CrudRepository<T, ID>, PagingAndSortingRepository<T, ID> {

	Optional<T> findById(String id);
}
