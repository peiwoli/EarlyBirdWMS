/**
 * 
 */
package com.earlybird.wms.base.repository;

import org.springframework.stereotype.Repository;

import com.earlybird.wms.base.entity.User;

/**
 * @author Peili Zhou
 *
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {

	
}
